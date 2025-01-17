package com.example.imd_book

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class GerenciamentoLivrosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gerenciamento_books)

        val buttonCadastro: Button = findViewById(R.id.buttonCadastro)
        val buttonListagem: Button = findViewById(R.id.buttonListagem)
        val buttonAlteracao: Button = findViewById(R.id.buttonAlteracao)
        val buttonExclusao: Button = findViewById(R.id.buttonExclusao)

        buttonCadastro.setOnClickListener {
            startActivity(Intent(this, CadastroLivroActivity::class.java))
        }

        buttonListagem.setOnClickListener {
            startActivity(Intent(this, ListaLivrosActivity::class.java))
        }

        buttonAlteracao.setOnClickListener {
            startActivity(Intent(this, AlteracaoLivroActivity::class.java))
        }

        buttonExclusao.setOnClickListener {
            startActivity(Intent(this, ExclusaoActivity::class.java))
        }
    }
}