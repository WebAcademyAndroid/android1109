package com.example.student.android4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Activity5 extends AppCompatActivity {

    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_5);

        mListView = findViewById(R.id.listView);
        //mListView.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);
        mListView.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE);

        String[] items = new String[]{"q", "w", "e", "r", "t", "y", "u", "i", "o", "p"};
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_multiple_choice,
                android.R.id.text1,
                items
        );

        mListView.setAdapter(adapter);

        findViewById(R.id.button11).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //int position = mListView.getCheckedItemPosition();
                //Toast.makeText(Activity5.this, String.valueOf(position), Toast.LENGTH_LONG).show();

                StringBuilder builder = new StringBuilder();
                SparseBooleanArray array = mListView.getCheckedItemPositions();
                for (int i = 0; i < array.size(); i++) {
                    if (array.get(i)) {
                        builder.append(i + " ");
                    }
                }

                Toast.makeText(Activity5.this, builder.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
