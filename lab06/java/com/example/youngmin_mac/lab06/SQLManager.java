package com.example.youngmin_mac.lab06;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by youngmin-mac on 2018. 3. 10..
 */

public class SQLManager extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "student.db";
    private static final String TABLE_NAME = "STUDENTTABLE";
    private static final String ID = "id";
    private static final String TITLE_NAME = "name";
    private static final String Grade = "grade";
    private static final String Dummy = "dummy";

    public SQLManager(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_STUDENT =
                "CREATE TABLE " + TABLE_NAME + "(" +
                        ID + " TEXT, " +
                        TITLE_NAME + " TEXT," +
                        Grade + " TEXT," +
                        Dummy + " TEXT" +
                        ");";
        db.execSQL(CREATE_TABLE_STUDENT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public void add(Student s)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(ID, s.getID());
        values.put(TITLE_NAME, s.getName());
        values.put(Grade, s.getGrade());
        values.put(Dummy, s.getID().equals("") ? "nonID" : "dummy");

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public List<Student> view(String id)
    {
        List<Student> ret = new ArrayList<>();
        String SELECT_ALL = "SELECT * FROM " + TABLE_NAME +" WHERE " + (id.equals("") ? "DUMMY = 'nonID'" : "ID = "+id);
        //System.out.println(SELECT_ALL);
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(SELECT_ALL, null);

        if (cursor.moveToFirst()) {
            while(!cursor.isAfterLast()) {
                Student s = new Student(cursor.getString(cursor.getColumnIndex(ID)),cursor.getString(cursor.getColumnIndex(TITLE_NAME)),cursor.getString(cursor.getColumnIndex(Grade)));
                ret.add(s);
                System.out.println(cursor.getString(cursor.getColumnIndex(Dummy)));
                cursor.moveToNext();

            }
        }
        return ret;
    }

    public List<Student> viewAll()
    {
        String SelectAll = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        List<Student> ret = new ArrayList<>();

        Cursor cursor = db.rawQuery(SelectAll, null);

        if (cursor.moveToFirst()) {
            while(!cursor.isAfterLast()) {
                Student s = new Student(cursor.getString(cursor.getColumnIndex(ID)) ,cursor.getString(cursor.getColumnIndex(TITLE_NAME)),cursor.getString(cursor.getColumnIndex(Grade)));
                ret.add(s);
                //System.out.println(cursor.getString(cursor.getColumnIndex(ID))+cursor.getString(cursor.getColumnIndex(TITLE_NAME))+cursor.getString(cursor.getColumnIndex(Grade))+cursor.getString(cursor.getColumnIndex(Dummy)));
                cursor.moveToNext();

            }
        }

        return ret;
    }

    public void delete(String id)
    {
        String sql;
        if(id.equals(""))
            sql = "DELETE FROM "+ TABLE_NAME + " WHERE DUMMY = 'nonID'";
        else
            sql = "DELETE FROM "+ TABLE_NAME + " WHERE ID = " +id;
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(sql);
    }
}
