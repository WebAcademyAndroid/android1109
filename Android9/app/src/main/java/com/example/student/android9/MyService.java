package com.example.student.android9;

import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Binder;
import android.os.IBinder;

public class MyService extends Service {

    private boolean isSaveing;
    private ServiceInterface mInterface;

    @Override
    public IBinder onBind(Intent intent) {
        return new MyBinder();
    }

    public class MyBinder extends Binder {
        public MyService getService() {
            return MyService.this;
        }
    }

    public boolean isSaveing() {
        return isSaveing;
    }

    public void setListener(ServiceInterface serviceInterface){
        mInterface = serviceInterface;
    }

    public void save(Student student, ServiceInterface serviceInterface) {
        isSaveing = true;
        mInterface = serviceInterface;

        new SaveTask().execute(student);
    }

    public class SaveTask extends AsyncTask<Student, Void, Long> {

        @Override
        protected Long doInBackground(Student... students) {
            return new DataBaseHelper(MyService.this).insert(students[0]);
        }

        @Override
        protected void onPostExecute(Long aLong) {
            if(mInterface != null){
                mInterface.saved();
            }

            isSaveing = false;
        }
    }

    public interface ServiceInterface{
        void saved();
    }
}
