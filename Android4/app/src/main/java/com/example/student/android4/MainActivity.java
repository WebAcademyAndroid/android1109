package com.example.student.android4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        String[] items = new String[]{"q", "w", "e", "r", "t", "y", "u", "i", "o", "p"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                R.layout.student,
                R.id.textViewFirstName,
                items
        );

        Spinner spinner = findViewById(R.id.spinner);
        spinner.setAdapter(adapter);
    }

    public void OnClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                startActivity(new Intent(this, Activity2.class));
                break;
            case R.id.button2:
                startActivity(new Intent(this, Activity3.class));
                break;
            case R.id.button3:
                startActivity(new Intent(this, Activity4.class));
                break;
            case R.id.button4:
                startActivity(new Intent(this, Activity5.class));
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

}
