package org.example.app.ui.auth

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.*
import org.example.app.R
import org.example.app.ui.home.HomeActivity

// PUBLIC_INTERFACE
class LoginActivity : Activity() {
    /** Handles user login UI and authentication logic. */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val editPhone = findViewById<EditText>(R.id.editPhone)
        val editPassword = findViewById<EditText>(R.id.editPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val tvRegister = findViewById<TextView>(R.id.tvRegister)

        btnLogin.setOnClickListener {
            // TODO: Replace with real authentication logic
            val phone = editPhone.text.toString()
            val pass = editPassword.text.toString()
            if (phone.isNotBlank() && pass.isNotBlank()) {
                // Simulate login success
                startActivity(Intent(this, HomeActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, "Enter phone and password", Toast.LENGTH_SHORT).show()
            }
        }

        tvRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }
}
