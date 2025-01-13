package com.example.imdbookstore

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextUsername: EditText = findViewById(R.id.editTextUsername)
        val editTextPassword: EditText = findViewById(R.id.editTextPassword)
        val buttonLogin: Button = findViewById(R.id.buttonLogin)
        val buttonSignUp: Button = findViewById(R.id.buttonSignUp)
        val buttonResetPassword: Button = findViewById(R.id.buttonResetPassword)

        buttonLogin.setOnClickListener {
            val username = editTextUsername.text.toString()
            val password = editTextPassword.text.toString()

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show()
            } else {
                // Simulação de login
                val sharedPreferences = getSharedPreferences("LoginPrefs", MODE_PRIVATE)
                val savedPassword = sharedPreferences.getString(username, null)

                if (savedPassword == password) {
                    Toast.makeText(this, "Login bem-sucedido!", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, GerenciamentoLivrosActivity::class.java))
                } else {
                    Toast.makeText(this, "Usuário ou senha incorretos.", Toast.LENGTH_SHORT).show()
                }
            }
        }

        buttonSignUp.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        }

        buttonResetPassword.setOnClickListener {
            startActivity(Intent(this, ResetPasswordActivity::class.java))
        }
    }
}