package com.example.zadaniebazadanych;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Admin on 04/06/2018.
 */

class MyDBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "studentDB.db";

    public static final String TABLE_STUDENTS = "students";
    public static final String COLUMN_ID = "StudentID";
    public static final String COLUMN_NAME = "StudentName";
    public static final String COLUMN_NAME2 = "VV3";


    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version)
    {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_STUDENT_TABLE =
                "CREATE TABLE " + TABLE_STUDENTS + "(" + COLUMN_ID + " INTEGER PRIMARY KEY," +
                        COLUMN_NAME + " TEXT, " +  COLUMN_NAME2 + " TEXT2 " + ")";
        db.execSQL(CREATE_STUDENT_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion,
                          int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_STUDENTS);
        onCreate(db);

    }


    public void addHandler(Student student) {
        ContentValues values = new ContentValues();

        values.put(COLUMN_ID, student.getID());
        values.put(COLUMN_NAME, student.getStudentName());
        values.put(COLUMN_NAME2, student.getVV3());

        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_STUDENTS, null, values);
        db.close();
    }



    public String loadHandler() {
        String result = "";
        String query = "Select*FROM " + TABLE_STUDENTS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        while (cursor.moveToNext()) {
            int result_0 = cursor.getInt(0);
            String result_1 = cursor.getString(1);
            String result_2 = cursor.getString(2);
            result += String.valueOf(result_0) + " " + result_1 + " " + result_2 +
                    System.getProperty("line.separator");
        }
        cursor.close();
        db.close();
        return result;
    }

    public boolean deleteHandler(int ID) {


        boolean result = false;
        String query = "Select*FROM " + TABLE_STUDENTS + " WHERE " + COLUMN_ID + " = '" + String.valueOf(ID) + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        Student student = new Student();
        if (cursor.moveToFirst()) {
            student.setID(Integer.parseInt(cursor.getString(0)));
            db.delete(TABLE_STUDENTS, COLUMN_ID + "=?",
                    new String[] {
                            String.valueOf(student.getID())
                    });
            cursor.close();
            result = true;
        }
        db.close();
        return result;
    }

    public boolean updateHandler(int ID, String name, String v3) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues args = new ContentValues();
        args.put(COLUMN_ID, ID);
        args.put(COLUMN_NAME, name);
        args.put(COLUMN_NAME2, v3);
        return db.update(TABLE_STUDENTS, args, COLUMN_ID + "=" + ID, null) > 0;
    }

}