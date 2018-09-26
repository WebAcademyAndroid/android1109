package com.example.student.android1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = findViewById(R.id.textView);

        /*findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextView.setText("AAAAAAAAAAAAAAA");
            }
        });*/
    }


    public void OnClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                mTextView.setText("AAAAAAAAAAAAAAA");
                break;
            case R.id.button2:
                mTextView.setText("BBBBBBBBBBBBBBB");
                break;
        }
    }
}
