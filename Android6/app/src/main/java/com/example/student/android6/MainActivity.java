package com.example.student.android6;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;
    private ArrayList<Student> mStudents = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = findViewById(R.id.listView);
        initList();
    }

    private void initList() {
        DataBaseHelper helper = new DataBaseHelper(this);
        ArrayList<Student> students = helper.getStudents();

        mStudents.clear();
        mStudents.addAll(students);

        ArrayAdapter<Student> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1, mStudents);
        mListView.setAdapter(adapter);
    }

    public void OnClick(View v) {
        DataBaseHelper helper = new DataBaseHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();

        switch (v.getId()) {
            case R.id.button: {
                long id = helper.insert(new Student("Ivan", "Ivanov", 33));
                Toast.makeText(this, String.valueOf(id), Toast.LENGTH_LONG).show();

                initList();
            }
            break;
            case R.id.button2: {
                ContentValues values = new ContentValues();
                values.put("Age", 33);

                int count = db.update("Students", values, "_id > 1", null);
                Toast.makeText(this, String.valueOf(count), Toast.LENGTH_LONG).show();
            }
            break;
            case R.id.button3:
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
}
