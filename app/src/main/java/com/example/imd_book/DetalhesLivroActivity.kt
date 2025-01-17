package com.example.imd_book

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.imd_book.db.*

class DetalhesLivroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhes_book)

        val textViewTitulo: TextView = findViewById(R.id.textViewTitulo)
        val textViewAutor: TextView = findViewById(R.id.textViewAutor)
        val textViewEditora: TextView = findViewById(R.id.textViewEditora)
        val textViewISBN: TextView = findViewById(R.id.textViewISBN)
        val textViewDescricao: TextView = findViewById(R.id.textViewDescricao)
        val imageViewCapa: ImageView = findViewById(R.id.imageViewCapa)

        val livroId = intent.getIntExtra("livro_id", -1)

        val dbHelper = LivrariaDatabaseHelper(this)
        val db = dbHelper.readableDatabase

        val cursor = db.query(
            LivrariaDatabaseHelper.TABLE_LIVROS,
            null,
            "${LivrariaDatabaseHelper.COLUMN_ID} = ?",
            arrayOf(livroId.toString()),
            null,
            null,
            null
        )

        if (cursor.moveToFirst()) {
            val titulo = cursor.getString(cursor.getColumnIndexOrThrow(LivrariaDatabaseHelper.COLUMN_TITULO))
            val autor = cursor.getString(cursor.getColumnIndexOrThrow(LivrariaDatabaseHelper.COLUMN_AUTOR))
            val editora = cursor.getString(cursor.getColumnIndexOrThrow(LivrariaDatabaseHelper.COLUMN_EDITORA))
            val isbn = cursor.getString(cursor.getColumnIndexOrThrow(LivrariaDatabaseHelper.COLUMN_ISBN))
            val descricao = cursor.getString(cursor.getColumnIndexOrThrow(LivrariaDatabaseHelper.COLUMN_DESCRICAO))
            val imagemUrl = cursor.getString(cursor.getColumnIndexOrThrow(LivrariaDatabaseHelper.COLUMN_IMAGEM_URL))

            textViewTitulo.text = titulo
            textViewAutor.text = autor
            textViewEditora.text = editora
            textViewISBN.text = isbn
            textViewDescricao.text = descricao

            Glide.with(this).load(imagemUrl).into(imageViewCapa)
        }

        cursor.close()
        db.close()
    }
}