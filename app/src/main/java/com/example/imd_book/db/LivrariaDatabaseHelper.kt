package com.example.imd_book.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class LivrariaDatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        const val DATABASE_NAME = "livraria.db"
        const val DATABASE_VERSION = 1

        // Nome da tabela
        const val TABLE_LIVROS = "livros"

        // Colunas
        const val COLUMN_ID = "id"
        const val COLUMN_TITULO = "titulo"
        const val COLUMN_AUTOR = "autor"
        const val COLUMN_EDITORA = "editora"
        const val COLUMN_ISBN = "isbn"
        const val COLUMN_DESCRICAO = "descricao"
        const val COLUMN_IMAGEM_URL = "imagem_url"

        // Comando SQL para criar a tabela
        const val CREATE_TABLE_LIVROS = "CREATE TABLE " + TABLE_LIVROS + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_TITULO + " TEXT NOT NULL, " +
                COLUMN_AUTOR + " TEXT NOT NULL, " +
                COLUMN_EDITORA + " TEXT, " +
                COLUMN_ISBN + " TEXT UNIQUE, " +
                COLUMN_DESCRICAO + " TEXT, " +
                COLUMN_IMAGEM_URL + " TEXT)"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(CREATE_TABLE_LIVROS)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_LIVROS")
        onCreate(db)
    }
}