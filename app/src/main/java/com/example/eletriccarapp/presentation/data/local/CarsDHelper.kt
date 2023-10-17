package com.example.eletriccarapp.presentation.data.local

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.eletriccarapp.presentation.data.local.CarrosContract.SQL_DELETE_ENTRIES
import com.example.eletriccarapp.presentation.data.local.CarrosContract.TABLE_CAR

class CarsDHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NOME, null, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(TABLE_CAR)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL(SQL_DELETE_ENTRIES)
        onCreate(db)
    }

    override fun onDowngrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        onUpgrade(db, oldVersion, newVersion)
    }

    companion object {
        const val DATABASE_VERSION = 1
        const val DATABASE_NOME = "DbCar.db"
    }
}