package com.example.student.android8;

import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private MyService mService;
    private ListView mListView;
    private ProgressDialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = findViewById(R.id.listView);

        getStudents();
    }

    private void getStudents() {


        MyIntentService.getStudents(this);
    }

    public void OnClick(View v) {
        switch (v.getId()) {
            case R.id.button: {
                Intent intent = new Intent(this, MyService.class);
                PendingIntent pendingIntent = createPendingResult(1, intent, 0);

                intent.putExtra("Pending", pendingIntent);
                intent.putExtra("Text", "Some text");

                startService(intent);
            }
            break;
            case R.id.button2:
                if (mService == null) {
                    ServiceConnection connection = new ServiceConnection() {
                        @Override
                        public void onServiceConnected(ComponentName name, IBinder service) {
                            mService = ((MyService.MyBinder) service).getService();
                        }

                        @Override
                        public void onServiceDisconnected(ComponentName name) {

                        }
                    };

                    Intent intent = new Intent(this, MyService.class);
                    bindService(intent, connection, BIND_AUTO_CREATE);
                }
                if (mService != null) {
                    String text = mService.doSomething();
                    Toast.makeText(this, text, Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.button3:
                mDialog = new ProgressDialog(this);
                mDialog.setMessage("Wait...");
                mDialog.setCancelable(false);
                mDialog.show();

                MyIntentService.saveStudent(this, new Student("Petro","Petrov",44));
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                String text = data.getStringExtra("Result");
                Toast.makeText(this, text, Toast.LENGTH_LONG).show();
            }
        } else if (requestCode == MyIntentService.REQUEST_CODE_GET_STUDENTS) {
            if (resultCode == RESULT_OK) {
                ArrayList<Student> students = data.getParcelableArrayListExtra(MyIntentService.EXTRA_STUDENTS);

                ArrayAdapter<Student> adapter = new ArrayAdapter<>(
                        this,
                        android.R.layout.simple_list_item_1,
                        android.R.id.text1,
                        students);

                mListView.setAdapter(adapter);


            }
        }else if (requestCode == MyIntentService.REQUEST_CODE_SAVE_STUDENT) {
            if (resultCode == RESULT_OK) {
                long id = data.getLongExtra(MyIntentService.EXTRA_ID, 0);
                Toast.makeText(this, String.valueOf(id), Toast.LENGTH_LONG).show();

                if(mDialog != null && mDialog.isShowing()){
                    mDialog.dismiss();
                }

                getStudents();
            }
        }
    }
}
