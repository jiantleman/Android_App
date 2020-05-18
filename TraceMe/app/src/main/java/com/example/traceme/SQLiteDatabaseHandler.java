package com.example.traceme;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.LinkedList;
import java.util.List;

public class SQLiteDatabaseHandler extends SQLiteOpenHelper {

    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "RecordDB";
    private static final String TABLE_NAME = "records";
    private static final String KEY_ID = "id";
    private static final String KEY_DATE = "date";
    private static final String KEY_TIME = "time";
    private static final String KEY_TEMP = "temperature";
    private static final String KEY_WELL = "wellness";
    private static final String KEY_SIGNS = "signs";
    private static final String[] COLUMNS = {KEY_ID, KEY_DATE, KEY_TIME, KEY_TEMP, KEY_WELL, KEY_SIGNS};

    public SQLiteDatabaseHandler(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "(" + KEY_ID +
                " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_DATE + " TEXT, " +
                KEY_TIME + " TEXT, " + KEY_TEMP + " FLOAT, " + KEY_WELL + " INTEGER, " +
                KEY_SIGNS + " TEXT) ";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        this.onCreate(db);
    }

    public void deleteOne(Record record) {
        // Get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, "id = ?", new String[] { String.valueOf(record.getId()) });
        db.close();
    }

    public Record getRecord(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, // a. table
                COLUMNS, // b. column names
                " id = ?", // c. selections
                new String[] { String.valueOf(id) }, // d. selections args
                null, // e. group by
                null, // f. having
                null, // g. order by
                null); // h. limit

        if (cursor != null)
            cursor.moveToFirst();

        Record record = new Record();
        record.setId(Integer.parseInt(cursor.getString(0)));
        record.setDate(cursor.getString(1));
        record.setTime(cursor.getString(2));
        record.setTemperature(Float.parseFloat(cursor.getString(3)));
        record.setWellness(Integer.parseInt(cursor.getString(4)));
        record.setSigns(cursor.getString(5));

        return record;
    }

    public List<Record> allRecords() {

        List<Record> recordsList = new LinkedList<Record>();
        String query = "SELECT  * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        Record record = null;

        if (cursor.moveToFirst()) {
            do {
                record = new Record();
                record.setId(Integer.parseInt(cursor.getString(0)));
                record.setDate(cursor.getString(1));
                record.setTime(cursor.getString(2));
                record.setTemperature(Float.parseFloat(cursor.getString(3)));
                record.setWellness(Integer.parseInt(cursor.getString(4)));
                record.setSigns(cursor.getString(5));
                recordsList.add(record);
            } while (cursor.moveToNext());
        }

        return recordsList;
    }

    public void addRecord(Record record) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_DATE, record.getDate());
        values.put(KEY_TIME, record.getTime());
        values.put(KEY_TEMP, record.getTemperature());
        values.put(KEY_WELL, record.getWellness());
        values.put(KEY_SIGNS, record.getSigns());
        // insert
        db.insert(TABLE_NAME,null, values);
        db.close();
    }


}
