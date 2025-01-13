package com.example.imdbookstore

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.imdbookstore.db.*

class ExclusaoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exclusao_book)

        val editTextISBN: EditText = findViewById(R.id.editTextISBN)
        val buttonExcluir: Button = findViewById(R.id.buttonExcluir)

        val dbHelper = LivrariaDatabaseHelper(this)

        buttonExcluir.setOnClickListener {
            val isbn = editTextISBN.text.toString()
            if (isbn.isEmpty()) {
                Toast.makeText(this, "Informe o ISBN para excluir o livro.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val db = dbHelper.writableDatabase
            val rowsDeleted = db.delete(
                LivrariaDatabaseHelper.TABLE_LIVROS,
                "${LivrariaDatabaseHelper.COLUMN_ISBN} = ?",
                arrayOf(isbn)
            )

            if (rowsDeleted > 0) {
                Toast.makeText(this, "Livro excluído com sucesso!", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "Livro não encontrado.", Toast.LENGTH_SHORT).show()
            }

            db.close()
        }
    }
}