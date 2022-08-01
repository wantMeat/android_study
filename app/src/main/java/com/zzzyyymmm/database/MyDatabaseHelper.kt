package com.zzzyyymmm.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.zzzyyymmm.ToastUtil

class MyDatabaseHelper(val context: Context, val dbName: String, val version: Int) :
    SQLiteOpenHelper(context, dbName, null, version) {

    private val createBookTableStr = "create table book(" +
            " id integer primary key autoincrement," +
            "author text," +
            "price real," +
            "pages integer," +
            "name text)"


    private val createCategoryTableStr = "create table category (" +
            "id integer primary key autoincrement," +
            "category_name text," +
            "category_code integer)"


    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(createBookTableStr)
        db.execSQL(createCategoryTableStr)
        ToastUtil.shortToast(this.context, "创建book数据库成功")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        if (oldVersion < 2) {
            db.execSQL(createCategoryTableStr)
        }
    }
}