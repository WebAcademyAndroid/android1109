package com.example.student.android9;

import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.AsyncTask;
import android.os.IBinder;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<ArrayList<Student>> {

    private SaveTask mSaveTask;
    private SaveManyTask mSaveManyTask;
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = findViewById(R.id.listView);

        getSupportLoaderManager().initLoader(0, null, this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (mSaveTask != null) {
            mSaveTask.cancel(true);
        }
        if (mSaveManyTask != null) {
            mSaveManyTask.cancel(true);
        }
    }

    public void OnClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                mSaveTask = new SaveTask();
                mSaveTask.execute(new Student("Ivan", "Ivanov", 33));
                break;
            case R.id.button2:
                mSaveManyTask = new SaveManyTask();
                mSaveManyTask.execute(new Student("Ivan", "Ivanov", 33),
                        new Student("Ivan", "Ivanov", 33),
                        new Student("Ivan", "Ivanov", 33),
                        new Student("Ivan", "Ivanov", 33),
                        new Student("Ivan", "Ivanov", 33),
                        new Student("Ivan", "Ivanov", 33),
                        new Student("Ivan", "Ivanov", 33),
                        new Student("Ivan", "Ivanov", 33));
                break;
            case R.id.button3:
                ServiceConnection connection = new ServiceConnection() {
                    @Override
                    public void onServiceConnected(ComponentName name, IBinder service) {
                        MyService myService = ((MyService.MyBinder) service).getService();

                        /*myService.save(new Student("Ivan", "Ivan", 33), new MyService.ServiceInterface() {
                            @Override
                            public void saved() {
                                Toast.makeText(MainActivity.this, "Saved", Toast.LENGTH_LONG).show();
                            }
                        });*/

                        if (myService.isSaveing()) {
                            myService.setListener(new MyService.ServiceInterface() {
                                @Override
                                public void saved() {

                                }
                            });
                        }
                    }

                    @Override
                    public void onServiceDisconnected(ComponentName name) {

                    }
                };

                Intent intent = new Intent(this, MyService.class);
                bindService(intent, connection, BIND_AUTO_CREATE);
                break;
            case R.id.button4:
                break;
            case R.id.button5:
                break;
            case R.id.button6:
                break;
            case R.id.button7:
                break;
            case R.id.button8:
                break;
            case R.id.button9:
                break;
            case R.id.button10:
                break;
        }
    }

    @NonNull
    @Override
    public Loader<ArrayList<Student>> onCreateLoader(int i, @Nullable Bundle bundle) {
        return new StudentsLoader(this);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<ArrayList<Student>> loader, ArrayList<Student> students) {
        ArrayAdapter<Student> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                students);
        mListView.setAdapter(adapter);
    }

    @Override
    public void onLoaderReset(@NonNull Loader<ArrayList<Student>> loader) {

    }


    public class SaveTask extends AsyncTask<Student, Void, Long> {

        private ProgressDialog mDialog;

        @Override
        protected void onPreExecute() {
            mDialog = new ProgressDialog(MainActivity.this);
            mDialog.setMessage("Wait...");
            mDialog.setCancelable(false);
            mDialog.show();
        }

        @Override
        protected Long doInBackground(Student... students) {
            try {
                TimeUnit.SECONDS.sleep(6);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Student student = students[0];
            DataBaseHelper helper = new DataBaseHelper(MainActivity.this);

            return helper.insert(student);
        }

        @Override
        protected void onPostExecute(Long aLong) {
            //Toast.makeText(MainActivity.this, String.valueOf(aLong), Toast.LENGTH_LONG).show();
            ((Button) findViewById(R.id.button)).setText(String.valueOf(aLong));

            if (mDialog != null && mDialog.isShowing()) {
                mDialog.dismiss();
            }

            getSupportLoaderManager().restartLoader(0, null, MainActivity.this);
        }
    }

    public class SaveManyTask extends AsyncTask<Student, Integer, Void> {
        private ProgressDialog mDialog;

        @Override
        protected void onPreExecute() {
            mDialog = new ProgressDialog(MainActivity.this);
            mDialog.setMessage("Wait...");
            mDialog.setCancelable(false);
            mDialog.show();
        }

        @Override
        protected Void doInBackground(Student... students) {
            DataBaseHelper helper = new DataBaseHelper(MainActivity.this);

            int count = 0;
            for (Student student : students) {
                helper.insert(student);

                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                count++;
                publishProgress(count, students.length);
            }

            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            String str = String.format("Saved %d from %d students", values[0], values[1]);
            mDialog.setMessage(str);
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            mDialog.dismiss();
        }
    }
}
