package com.example.contacts21.model

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBOpenHelper(context : Context, factory: SQLiteDatabase.CursorFactory?) :
    SQLiteOpenHelper(context, DATABASE_NAME, factory, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase) {
        val contactsTable = ("CREATE TABLE $TABLE_NAME($COLUMN_ID INTEGER PRIMARY KEY, $COLUMN_FIRSTNAME TEXT," +
                "$COLUMN_LASTNAME TEXT, $COLUMN_MOBILE TEXT, $COLUMN_EMAIL TEXT)")
        db.execSQL(contactsTable)
    }

    override fun onUpgrade(db: SQLiteDatabase, p1: Int, p2: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun addContact(contact : Contact) {
        val values = ContentValues()
        values.put(COLUMN_FIRSTNAME, contact.firstName)
        values.put(COLUMN_LASTNAME, contact.lastName)
        values.put(COLUMN_MOBILE, contact.mobile)
        values.put(COLUMN_EMAIL, contact.email)
        val db = this.writableDatabase
        db.insert(TABLE_NAME, null, values)
        db.close()
    }

    fun getContact() : Cursor? {
        val db = this.readableDatabase
        return db.rawQuery("SELECT * FROM $TABLE_NAME", null)
    }

    fun updateContact(contact: Contact) {
        val values = ContentValues()
        values.put(COLUMN_FIRSTNAME, contact.firstName)
        values.put(COLUMN_LASTNAME, contact.lastName)
        values.put(COLUMN_MOBILE, contact.mobile)
        values.put(COLUMN_EMAIL, contact.email)
        val db = this.writableDatabase
        //db.update(TABLE_NAME, values, "_id = $id", null)
    }

    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "contacts.db"
        const val TABLE_NAME = "contacts"
        const val COLUMN_ID = "_id"
        const val COLUMN_FIRSTNAME = "firstname"
        const val COLUMN_LASTNAME = "lastname"
        const val COLUMN_MOBILE = "mobile"
        const val COLUMN_EMAIL = "email"
    }
}