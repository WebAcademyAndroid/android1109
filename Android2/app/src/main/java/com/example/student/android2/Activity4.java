package com.example.student.android2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Activity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);

        findViewById(R.id.button11).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra(MainActivity.EXTRA_TEXT, "Hello result");
                setResult(RESULT_OK, intent);
                finish();
                //startActivity(new Intent(Activity4.this, MainActivity.class));

                EditText editText = new EditText(Activity4.this);
                editText.setText("");
                String name = editText.getText().toString();
            }
        });
    }
}
