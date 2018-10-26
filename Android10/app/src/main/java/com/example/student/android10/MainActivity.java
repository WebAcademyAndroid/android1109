package com.example.student.android10;

import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<ArrayList<Student>> {

    private SaveTask mSaveTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportLoaderManager().initLoader(0, null, this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (mSaveTask != null) {
            mSaveTask.cancel(true);
        }
    }

    public void OnClick(View v) {
        switch (v.getId()) {
            case R.id.button1: {
                editStudent(new Student());
            }
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
        showStudents(students);
    }

    private void showStudents(ArrayList<Student> students) {
        Fragment1 fragment = Fragment1.newInstance(students);
        fragment.setActionListener(new Fragment1.ActionListener() {
            @Override
            public void onClick(Student student) {
                editStudent(student);
            }
        });

        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentView, fragment).commit();
    }

    private void editStudent(Student student) {
        final Fragment2 fragment = Fragment2.newInstance(student);
        fragment.setActionListener(new Fragment2.ActionListener() {
            @Override
            public void save(Student student) {
                mSaveTask = new SaveTask();
                mSaveTask.execute(student);
            }

            @Override
            public void cancel() {
                //getSupportLoaderManager().initLoader(0, null, MainActivity.this);
                fragment.dismiss();
            }
        });

        //getSupportFragmentManager().beginTransaction().replace(R.id.fragmentView, fragment).commit();
        fragment.show(getSupportFragmentManager(), "dialog");
    }

    @Override
    public void onLoaderReset(@NonNull Loader<ArrayList<Student>> loader) {

    }

    private class SaveTask extends AsyncTask<Student, Void, Boolean> {

        @Override
        protected Boolean doInBackground(Student... students) {
            return new DataBaseHelper(MainActivity.this).save(students[0]);
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            getSupportLoaderManager().restartLoader(0, null, MainActivity.this);
        }
    }
}
