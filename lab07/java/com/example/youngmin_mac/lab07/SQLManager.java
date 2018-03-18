package com.example.youngmin_mac.lab07;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by youngmin-mac on 2018. 3. 17..
 */

public class SQLManager extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "lab07.db";
    private static final String TABLE_NAME = "LABTABLE";
    private static final String ID = "id";
    private static final String T1 = "col1";
    private static final String T2 = "col2";
    private static final String T3 = "col3";
    private static final String GREEN = "green";

    public SQLManager(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        SQLiteDatabase db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        System.out.println("onCreate called");
        String CREATE_TABLE_LAB =
                "CREATE TABLE " + TABLE_NAME + "(" +
                        ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        T1 + " TEXT," +
                        T2 + " TEXT," +
                        T3 + " TEXT," +
                        GREEN + " TEXT"+
                        ");";
        System.out.println(CREATE_TABLE_LAB);
        db.execSQL(CREATE_TABLE_LAB);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public void add(DataModel d)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        String[] val = d.getLine();

        values.put(T1, val[0]);
        values.put(T2, val[1]);
        values.put(T3, val[2]);
        values.put(GREEN, d.getGreen());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

//    public List<DataModel> view(String id)
//    {
//
//    }

    public List<DataModel> viewAll(String G)
    {
        String SelectAll = "SELECT * FROM " + TABLE_NAME + " WHERE "+GREEN+" = '"+G+"'";
        System.out.println(SelectAll);
        SQLiteDatabase db = this.getWritableDatabase();
        List<DataModel> ret = new ArrayList<>();

        Cursor cursor = db.rawQuery(SelectAll, null);

        if (cursor.moveToFirst()) {
            while(!cursor.isAfterLast()) {
                DataModel s = new DataModel(cursor.getString(cursor.getColumnIndex(T1)) ,cursor.getString(cursor.getColumnIndex(T2)),cursor.getString(cursor.getColumnIndex(T3)),cursor.getString(cursor.getColumnIndex(GREEN)));
                ret.add(s);
                //System.out.println(cursor.getString(cursor.getColumnIndex(ID))+cursor.getString(cursor.getColumnIndex(TITLE_NAME))+cursor.getString(cursor.getColumnIndex(Grade))+cursor.getString(cursor.getColumnIndex(Dummy)));
                cursor.moveToNext();

            }
        }

        return ret;
    }

//    public void delete(String id)
//    {
//
//    }

    public void dropTable()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
    }
}
