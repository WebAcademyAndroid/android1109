package com.example.student.android4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Activity4 extends AppCompatActivity {

    private ListView mListView;
    ArrayList<Student> mStudents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);

        mListView = findViewById(R.id.listView);

        mStudents = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            mStudents.add(new Student("Ivan" + i, "Ivanov" + i, i));
        }

        final StudentAdapter adapter = new StudentAdapter(this, R.layout.student, mStudents);

        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Student student = mStudents.get(position);
                Toast.makeText(Activity4.this, student.toString(), Toast.LENGTH_LONG).show();
            }
        });
        mListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                mStudents.remove(position);
                adapter.notifyDataSetChanged();
                return true;
            }
        });
    }
}
