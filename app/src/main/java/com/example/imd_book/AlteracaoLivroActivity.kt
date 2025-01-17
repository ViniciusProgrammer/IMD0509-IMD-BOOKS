package com.example.imd_book

import android.content.ContentValues
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.imd_book.db.*

class AlteracaoLivroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alteracao_book)

        val editTextISBN: EditText = findViewById(R.id.editTextISBN)
        val editTextTitulo: EditText = findViewById(R.id.editTextTitulo)
        val editTextAutor: EditText = findViewById(R.id.editTextAutor)
        val editTextEditora: EditText = findViewById(R.id.editTextEditora)
        val editTextDescricao: EditText = findViewById(R.id.editTextDescricao)
        val editTextImagemUrl: EditText = findViewById(R.id.editTextImagemUrl)
        val buttonBuscar: Button = findViewById(R.id.buttonBuscar)
        val buttonSalvar: Button = findViewById(R.id.buttonSalvar)

        val dbHelper = LivrariaDatabaseHelper(this)

        buttonBuscar.setOnClickListener {
            val isbn = editTextISBN.text.toString()
            if (isbn.isEmpty()) {
                Toast.makeText(this, "Informe o ISBN para buscar o livro.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val db = dbHelper.readableDatabase
            val cursor = db.query(
                LivrariaDatabaseHelper.TABLE_LIVROS,
                null,
                "${LivrariaDatabaseHelper.COLUMN_ISBN} = ?",
                arrayOf(isbn),
                null,
                null,
                null
            )

            if (cursor.moveToFirst()) {
                editTextTitulo.setText(cursor.getString(cursor.getColumnIndexOrThrow(LivrariaDatabaseHelper.COLUMN_TITULO)))
                editTextAutor.setText(cursor.getString(cursor.getColumnIndexOrThrow(LivrariaDatabaseHelper.COLUMN_AUTOR)))
                editTextEditora.setText(cursor.getString(cursor.getColumnIndexOrThrow(LivrariaDatabaseHelper.COLUMN_EDITORA)))
                editTextDescricao.setText(cursor.getString(cursor.getColumnIndexOrThrow(LivrariaDatabaseHelper.COLUMN_DESCRICAO)))
                editTextImagemUrl.setText(cursor.getString(cursor.getColumnIndexOrThrow(LivrariaDatabaseHelper.COLUMN_IMAGEM_URL)))
                Toast.makeText(this, "Livro encontrado.", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Livro não encontrado.", Toast.LENGTH_SHORT).show()
            }

            cursor.close()
            db.close()
        }

        buttonSalvar.setOnClickListener {
            val isbn = editTextISBN.text.toString()
            val titulo = editTextTitulo.text.toString()
            val autor = editTextAutor.text.toString()
            val editora = editTextEditora.text.toString()
            val descricao = editTextDescricao.text.toString()
            val imagemUrl = editTextImagemUrl.text.toString()

            if (isbn.isEmpty() || titulo.isEmpty() || autor.isEmpty()) {
                Toast.makeText(this, "Campos obrigatórios não preenchidos.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val db = dbHelper.writableDatabase
            val values = ContentValues().apply {
                put(LivrariaDatabaseHelper.COLUMN_TITULO, titulo)
                put(LivrariaDatabaseHelper.COLUMN_AUTOR, autor)
                put(LivrariaDatabaseHelper.COLUMN_EDITORA, editora)
                put(LivrariaDatabaseHelper.COLUMN_DESCRICAO, descricao)
                put(LivrariaDatabaseHelper.COLUMN_IMAGEM_URL, imagemUrl)
            }

            val rowsAffected = db.update(
                LivrariaDatabaseHelper.TABLE_LIVROS,
                values,
                "${LivrariaDatabaseHelper.COLUMN_ISBN} = ?",
                arrayOf(isbn)
            )

            if (rowsAffected > 0) {
                Toast.makeText(this, "Livro atualizado com sucesso!", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "Erro ao atualizar o livro.", Toast.LENGTH_SHORT).show()
            }

            db.close()
        }
    }
}