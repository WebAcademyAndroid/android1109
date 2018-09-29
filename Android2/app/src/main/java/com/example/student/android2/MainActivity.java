package com.example.student.android2;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_TEXT = "com.example.student.android2.extra.TEXT";
    public static final String EXTRA_NUMBER = "com.example.student.android2.extra.NUMBER";
    public static final String EXTRA_STUDENT = "com.example.student.android2.extra.STUDENT";

    public static Student mStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void OnClick(View v) {
        switch (v.getId()) {
            case R.id.button: {
                Intent intent = new Intent(this, Activity2.class);
                intent.putExtra(EXTRA_TEXT, "Hello activity!");
                intent.putExtra(EXTRA_NUMBER, 22);
                startActivity(intent);
            }
            break;
            case R.id.button2: {
                //mStudent = new Student("Ivan", "Ivanov", 22);

                Intent intent = new Intent(this, Activity3.class);
                intent.putExtra(EXTRA_STUDENT, new Student("Ivan", "Ivanov", 22));
                startActivity(intent);
            }
            break;
            case R.id.button3:
                startActivityForResult(new Intent(this, Activity4.class), 1);
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
        if(requestCode == 1){
            if(resultCode == RESULT_OK){
                String text = data.getStringExtra(EXTRA_TEXT);
                ((Button)findViewById(R.id.button3)).setText(text);
            }
        }
    }
}
