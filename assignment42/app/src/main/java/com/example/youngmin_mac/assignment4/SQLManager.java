package com.example.youngmin_mac.assignment4;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by youngmin-mac on 2018. 3. 24..
 */



public class SQLManager extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "assignment3.db";
    private static final String TABLE_NAME = "TEAMTABLE";
    private static final String ID = "id";
    private static final String T1 = "CITY";
    private static final String T2 = "NAME";
    private static final String T3 = "SPORT";
    private static final String T4 = "MVP";
    private static final String T5 = "IMAGE";

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
                        T4 + " TEXT,"+
                        T5 + " TEXT"+
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

        values.put(T1, d.getCity());
        values.put(T2, d.getName());
        values.put(T3, d.getSport());
        values.put(T4, d.getMvp());
        values.put(T5, d.getImage());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

//    public List<DataModel> view(String id)
//    {
//
//    }

    public List<DataModel> viewAll()
    {
        String SelectAll = "SELECT * FROM " + TABLE_NAME;
        System.out.println(SelectAll);
        SQLiteDatabase db = this.getWritableDatabase();
        List<DataModel> ret = new ArrayList<>();

        Cursor cursor = db.rawQuery(SelectAll, null);

        if (cursor.moveToFirst()) {
            while(!cursor.isAfterLast()) {
                DataModel s = new DataModel(Integer.parseInt(cursor.getString(cursor.getColumnIndex(ID))),
                        cursor.getString(cursor.getColumnIndex(T1)) ,
                        cursor.getString(cursor.getColumnIndex(T2)),
                        cursor.getString(cursor.getColumnIndex(T3)),
                        cursor.getString(cursor.getColumnIndex(T4)),
                        cursor.getString(cursor.getColumnIndex(T5)));
                ret.add(s);
                //System.out.println(cursor.getString(cursor.getColumnIndex(ID))+cursor.getString(cursor.getColumnIndex(TITLE_NAME))+cursor.getString(cursor.getColumnIndex(Grade))+cursor.getString(cursor.getColumnIndex(Dummy)));
                cursor.moveToNext();

            }
        }

        return ret;
    }

    public DataModel getData(int id)
    {
        String SelectAll = "SELECT * FROM " + TABLE_NAME+" WHERE ID = "+id;
        System.out.println(SelectAll);
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(SelectAll, null);
        DataModel s=null;
        if(cursor.moveToFirst())
        {
            s = new DataModel(Integer.parseInt(cursor.getString(cursor.getColumnIndex(ID))),
                    cursor.getString(cursor.getColumnIndex(T1)) ,
                    cursor.getString(cursor.getColumnIndex(T2)),
                    cursor.getString(cursor.getColumnIndex(T3)),
                    cursor.getString(cursor.getColumnIndex(T4)),
                    cursor.getString(cursor.getColumnIndex(T5)));
        }
        return s;
    }

    public void update(DataModel d , int id)
    {
        String update = "UPDATE "+TABLE_NAME +" SET " +
                T1 +" = '"+d.getCity()+"', "+
                T2 +" = '"+d.getName()+"', "+
                T3 +" = '"+d.getSport()+"', "+
                T4 +" = '"+d.getMvp()+"', "+
                T5 +" = '"+d.getImage()+"' "
                +" WHERE "+ID+" = "+id;
        System.out.println(update);
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(update);
    }

    public void delete(int id)
    {
        String delete = "DELETE FROM "+TABLE_NAME+" WHERE ID = " +id;
        System.out.println(delete);
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(delete);
    }

    public void dropTable()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
    }
}
