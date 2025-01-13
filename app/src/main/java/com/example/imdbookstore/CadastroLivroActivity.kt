package com.example.imdbookstore

import android.content.ContentValues
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.imdbookstore.db.*

class CadastroLivroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_book)

        val editTextTitulo: EditText = findViewById(R.id.editTextTitulo)
        val editTextAutor: EditText = findViewById(R.id.editTextAutor)
        val editTextEditora: EditText = findViewById(R.id.editTextEditora)
        val editTextISBN: EditText = findViewById(R.id.editTextISBN)
        val editTextDescricao: EditText = findViewById(R.id.editTextDescricao)
        val editTextImagemUrl: EditText = findViewById(R.id.editTextImagemUrl)
        val buttonSalvar: Button = findViewById(R.id.buttonSalvar)

        buttonSalvar.setOnClickListener {
            val titulo = editTextTitulo.text.toString()
            val autor = editTextAutor.text.toString()
            val editora = editTextEditora.text.toString()
            val isbn = editTextISBN.text.toString()
            val descricao = editTextDescricao.text.toString()
            val imagemUrl = editTextImagemUrl.text.toString()

            if (titulo.isEmpty() || autor.isEmpty() || isbn.isEmpty()) {
                Toast.makeText(this, "Por favor, preencha todos os campos obrigatórios.", Toast.LENGTH_SHORT).show()
            } else {
                val dbHelper = LivrariaDatabaseHelper(this)
                val db = dbHelper.writableDatabase

                val values = ContentValues().apply {
                    put(LivrariaDatabaseHelper.COLUMN_TITULO, titulo)
                    put(LivrariaDatabaseHelper.COLUMN_AUTOR, autor)
                    put(LivrariaDatabaseHelper.COLUMN_EDITORA, editora)
                    put(LivrariaDatabaseHelper.COLUMN_ISBN, isbn)
                    put(LivrariaDatabaseHelper.COLUMN_DESCRICAO, descricao)
                    put(LivrariaDatabaseHelper.COLUMN_IMAGEM_URL, imagemUrl)
                }

                val newRowId = db.insert(LivrariaDatabaseHelper.TABLE_LIVROS, null, values)

                if (newRowId != -1L) {
                    Toast.makeText(this, "Livro cadastrado com sucesso!", Toast.LENGTH_SHORT).show()
                    finish()
                } else {
                    Toast.makeText(this, "Erro ao cadastrar o livro.", Toast.LENGTH_SHORT).show()
                }
                db.close()
            }
        }
    }
}