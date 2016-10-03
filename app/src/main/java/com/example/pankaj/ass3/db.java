package com.example.pankaj.ass3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class db extends SQLiteOpenHelper

{
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "shopsInfo";
    private static final String TABLE_SHOPS = "shops";
    private static final String KEY_ID = "_id";
    private static final String KEY_NAME = "name";
    private static final String KEY_SH_ADDR = "shop_address";
    private static final String KEY_O= "owner";



    public db(Context context)
    {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_SHOPS + "("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ," +KEY_NAME + " TEXT,"+ KEY_O + " TEXT,"
                + KEY_SH_ADDR + " TEXT" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SHOPS);
        onCreate(db);
    }
    public void addShop(shop shop)

    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, shop.getName());
        values.put(KEY_O, shop.getOwner());
        values.put(KEY_SH_ADDR, shop.getAddress());
        db.insert(TABLE_SHOPS, null, values);
        db.close();

    }

    public shop getShop(int id)
    {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_SHOPS, new String[] { KEY_ID,
                        KEY_NAME,KEY_O, KEY_SH_ADDR }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null,null, null);
        if (cursor != null)
            cursor.moveToFirst();
        shop contact = new shop(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1),cursor.getString(2), cursor.getString(3));

        return contact;
    }

    public List<shop> getAllShops()
    {
        List<shop> shopList = new ArrayList<shop>();
        String selectQuery = "SELECT * FROM " + TABLE_SHOPS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst())
        {
            do {
                shop shop = new shop();
                shop.setId(cursor.getInt(0));
                shop.setName(cursor.getString(1));
                shop.setOwner(cursor.getString(2));
                shop.setAddress(cursor.getString(3));
                shopList.add(shop);
            } while (cursor.moveToNext());
        }
        return shopList;
    }

    public int updateShop(shop shop)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, shop.getName());
        values.put(KEY_O, shop.getOwner());
        values.put(KEY_SH_ADDR, shop.getAddress());
        return db.update(TABLE_SHOPS, values, KEY_ID + " = ?",
                new String[]{String.valueOf(shop.getId())});
    }

    public void deleteShop(shop shop)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_SHOPS, KEY_ID + " = ?",
                new String[] { String.valueOf(shop.getId()) });
        db.close();
    }
    public void delall()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from "+ TABLE_SHOPS);

    }
}


