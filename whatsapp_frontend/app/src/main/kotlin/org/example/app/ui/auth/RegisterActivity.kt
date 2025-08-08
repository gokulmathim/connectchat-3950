package org.example.app.ui.auth

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.*
import org.example.app.R
import org.example.app.ui.home.HomeActivity

// PUBLIC_INTERFACE
class RegisterActivity : Activity() {
    /** Handles user registration UI and sign-up logic. */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val editName = findViewById<EditText>(R.id.editRegName)
        val editPhone = findViewById<EditText>(R.id.editRegPhone)
        val editPassword = findViewById<EditText>(R.id.editRegPassword)
        val btnRegister = findViewById<Button>(R.id.btnDoRegister)

        btnRegister.setOnClickListener {
            // TODO: Implement actual registration logic and validation (use backend/API)
            val name = editName.text.toString()
            val phone = editPhone.text.toString()
            val pass = editPassword.text.toString()
            if (name.isNotBlank() && phone.isNotBlank() && pass.isNotBlank()) {
                // Fake immediate registration
                startActivity(Intent(this, HomeActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, "Fill all fields", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
