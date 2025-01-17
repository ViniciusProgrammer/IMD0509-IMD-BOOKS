package com.example.imd_book

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ResetPasswordActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_password)

        val editTextUsername: EditText = findViewById(R.id.editTextUsername)
        val editTextNewPassword: EditText = findViewById(R.id.editTextNewPassword)
        val buttonResetPassword: Button = findViewById(R.id.buttonResetPassword)

        buttonResetPassword.setOnClickListener {
            val username = editTextUsername.text.toString()
            val newPassword = editTextNewPassword.text.toString()

            if (username.isEmpty() || newPassword.isEmpty()) {
                Toast.makeText(this, "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show()
            } else {
                val sharedPreferences = getSharedPreferences("LoginPrefs", MODE_PRIVATE)
                val editor = sharedPreferences.edit()
                editor.putString(username, newPassword)
                editor.apply()

                Toast.makeText(this, "Senha redefinida com sucesso!", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, MainActivity::class.java))
            }
        }
    }
}