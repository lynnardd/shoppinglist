package com.lynnard.kotlinproject.helpers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Button;

import com.lynnard.kotlinproject.dataClasses.ShoppingItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gerard on 6/6/2017.
 */

public class DatabaseHandler extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "shopping";

    // Contacts table name
    private static final String TABLE_ITEMS = "shopping_list";

    // Contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "item";
    private static final String KEY_QUANTITY = "quantity";
    private static final String KEY_LABEL = "label";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_ITEMS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_QUANTITY + " TEXT," + KEY_LABEL + " TEXT" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ITEMS);
        // Create tables again
        onCreate(db);
    }


    public void addItem(ShoppingItem item){
        SQLiteDatabase database = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, item.getName());
        values.put(KEY_QUANTITY, item.getQuantity());
        values.put(KEY_LABEL, item.getLabel());

        database.insert(TABLE_ITEMS, null, values);
    }

    public void deleteItem(ShoppingItem item) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_ITEMS, KEY_NAME + " = ?",
                new String[] { String.valueOf(item.getName()) });
        db.close();
    }

    public List<ShoppingItem> getAllItems() {
        List<ShoppingItem> contactList = new ArrayList<>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_ITEMS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                ShoppingItem item = new ShoppingItem(cursor.getString(1), cursor.getString(2), cursor.getString(3));
                // Adding contact to list
                contactList.add(item);
            } while (cursor.moveToNext());
        }

        // return contact list
        return contactList;
    }

}