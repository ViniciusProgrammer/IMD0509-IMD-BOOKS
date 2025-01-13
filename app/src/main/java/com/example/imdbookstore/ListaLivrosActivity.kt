package com.example.imdbookstore

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.imdbookstore.model.*
import com.example.imdbookstore.db.*
import com.example.imdbookstore.adapter.*

class ListaLivrosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_books)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerViewLivros)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val dbHelper = LivrariaDatabaseHelper(this)
        val db = dbHelper.readableDatabase

        val cursor = db.query(
            LivrariaDatabaseHelper.TABLE_LIVROS,
            null,
            null,
            null,
            null,
            null,
            null
        )

        val livros = mutableListOf<Livro>()

        while (cursor.moveToNext()) {
            val id = cursor.getInt(cursor.getColumnIndexOrThrow(LivrariaDatabaseHelper.COLUMN_ID))
            val titulo = cursor.getString(cursor.getColumnIndexOrThrow(LivrariaDatabaseHelper.COLUMN_TITULO))
            val autor = cursor.getString(cursor.getColumnIndexOrThrow(LivrariaDatabaseHelper.COLUMN_AUTOR))
            val editora = cursor.getString(cursor.getColumnIndexOrThrow(LivrariaDatabaseHelper.COLUMN_EDITORA))
            val isbn = cursor.getString(cursor.getColumnIndexOrThrow(LivrariaDatabaseHelper.COLUMN_ISBN))
            val descricao = cursor.getString(cursor.getColumnIndexOrThrow(LivrariaDatabaseHelper.COLUMN_DESCRICAO))
            val imagemUrl = cursor.getString(cursor.getColumnIndexOrThrow(LivrariaDatabaseHelper.COLUMN_IMAGEM_URL))

            livros.add(Livro(id, titulo, autor, editora, isbn, descricao, imagemUrl))
        }

        cursor.close()
        db.close()

        val adapter = LivroAdapter(livros) { livro ->
            val intent = Intent(this, DetalhesLivroActivity::class.java)
            intent.putExtra("livro_id", livro.id)
            startActivity(intent)
        }

        recyclerView.adapter = adapter
    }
}


