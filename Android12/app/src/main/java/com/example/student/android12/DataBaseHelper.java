package com.example.student.android12;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DataBaseHelper extends SQLiteOpenHelper {

    public DataBaseHelper(Context context) {
        super(context, "MyDB.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + Student.TABLE_NAME + " ("
                + Student.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + Student.COLUMN_FIRST_NAME + " TEXT NOT NULL,"
                + Student.COLUMN_LAST_NAME + " TEXT NOT NULL,"
                + Student.COLUMN_AGE + " INTEGER NOT NULL)");

        db.execSQL("CREATE TABLE " + Widget.TABLE_NAME + " ("
                + Widget.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + Widget.COLUMN_ID_STUDENT + " INTEGER NOT NULL,"
                + Widget.COLUMN_ID_WIDGET + " INTEGER NOT NULL)");

        for (int i = 0; i < 50; i++) {
            insert(new Student("Ivan" + i, "Ivanov" + i, i), db);
        }
    }

    private long insert(Student student) {
        return insert(student, getWritableDatabase());
    }

    private long insert(Student student, SQLiteDatabase db) {
        long id = 0;

        try {
            ContentValues values = new ContentValues();
            values.put(Student.COLUMN_FIRST_NAME, student.firstName);
            values.put(Student.COLUMN_LAST_NAME, student.lastName);
            values.put(Student.COLUMN_AGE, student.age);

            id = db.insert(Student.TABLE_NAME, null, values);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return id;
    }

    public boolean save(Student student) {
        if (student.id == 0) {
            return insert(student) > 0;
        } else {
            return update(student) == 1;
        }
    }

    private int update(Student student) {
        int count = 0;
        SQLiteDatabase db = getWritableDatabase();

        try {
            ContentValues values = new ContentValues();
            values.put(Student.COLUMN_FIRST_NAME, student.firstName);
            values.put(Student.COLUMN_LAST_NAME, student.lastName);
            values.put(Student.COLUMN_AGE, student.age);

            count = db.update(Student.TABLE_NAME, values, Student.COLUMN_ID + "=" + student.id, null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return count;
    }

    public Student getStudent(long id) {
        SQLiteDatabase db = getWritableDatabase();
        Student student = null;
        Cursor cursor = null;

        try {
            cursor = db.query(Student.TABLE_NAME, null, Student.COLUMN_ID + "=" + id, null, null, null, null);
            if (cursor.moveToFirst()) {
                student = new Student();

                student.id = cursor.getLong(cursor.getColumnIndex(Student.COLUMN_ID));
                student.firstName = cursor.getString(cursor.getColumnIndex(Student.COLUMN_FIRST_NAME));
                student.lastName = cursor.getString(cursor.getColumnIndex(Student.COLUMN_LAST_NAME));
                student.age = cursor.getInt(cursor.getColumnIndex(Student.COLUMN_AGE));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }

        return student;
    }

    public ArrayList<Student> getStudents() {
        SQLiteDatabase db = getWritableDatabase();
        ArrayList<Student> students = new ArrayList<>();
        Cursor cursor = null;

        try {
            cursor = db.query(Student.TABLE_NAME, null, null, null, null, null, null);
            if (cursor.moveToFirst()) {
                while (!cursor.isAfterLast()) {
                    Student student = new Student();

                    student.id = cursor.getLong(cursor.getColumnIndex(Student.COLUMN_ID));
                    student.firstName = cursor.getString(cursor.getColumnIndex(Student.COLUMN_FIRST_NAME));
                    student.lastName = cursor.getString(cursor.getColumnIndex(Student.COLUMN_LAST_NAME));
                    student.age = cursor.getInt(cursor.getColumnIndex(Student.COLUMN_AGE));

                    students.add(student);
                    cursor.moveToNext();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }

        return students;
    }


    public long insert(Widget widget) {
        long id = 0;
        SQLiteDatabase db = getWritableDatabase();

        try {
            ContentValues values = new ContentValues();
            values.put(Widget.COLUMN_ID_STUDENT, widget.idStudent);
            values.put(Widget.COLUMN_ID_WIDGET, widget.idWidget);

            id = db.insert(Widget.TABLE_NAME, null, values);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return id;
    }

    public Widget getWidget(int id) {
        SQLiteDatabase db = getWritableDatabase();
        Widget widget = null;
        Cursor cursor = null;

        try {
            cursor = db.query(Widget.TABLE_NAME, null, Widget.COLUMN_ID_WIDGET + "=" + id, null, null, null, null);
            if (cursor.moveToFirst()) {
                widget = new Widget();

                widget.id = cursor.getLong(cursor.getColumnIndex(Widget.COLUMN_ID));
                widget.idStudent = cursor.getLong(cursor.getColumnIndex(Widget.COLUMN_ID_STUDENT));
                widget.idWidget = cursor.getInt(cursor.getColumnIndex(Widget.COLUMN_ID_WIDGET));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }

        return widget;
    }

    public int deleteWidget(int id) {
        int count = 0;
        SQLiteDatabase db = getWritableDatabase();

        try {
            count = db.delete(Widget.TABLE_NAME, Widget.COLUMN_ID_WIDGET + "=" + id, null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return count;
    }

    public ArrayList<Widget> getWidgets(long id) {
        SQLiteDatabase db = getWritableDatabase();
        ArrayList<Widget> widgets = new ArrayList<>();
        Cursor cursor = null;

        try {
            cursor = db.query(Widget.TABLE_NAME, null, Widget.COLUMN_ID_STUDENT + "=" + id, null, null, null, null);
            if (cursor.moveToFirst()) {
                while (!cursor.isAfterLast()) {
                    Widget widget = new Widget();

                    widget.id = cursor.getLong(cursor.getColumnIndex(Widget.COLUMN_ID));
                    widget.idStudent = cursor.getLong(cursor.getColumnIndex(Widget.COLUMN_ID_STUDENT));
                    widget.idWidget = cursor.getInt(cursor.getColumnIndex(Widget.COLUMN_ID_WIDGET));

                    widgets.add(widget);
                    cursor.moveToNext();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }

        return widgets;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
