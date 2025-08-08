package org.example.app.ui.settings

import android.app.Activity
import android.os.Bundle
import android.widget.*
import org.example.app.R

// PUBLIC_INTERFACE
class ProfileActivity : Activity() {
    /** Shows and allows editing of user's account settings/profile. */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val tvUser = findViewById<TextView>(R.id.profileName)
        val tvPhone = findViewById<TextView>(R.id.profilePhone)
        val btnLogout = findViewById<Button>(R.id.btnLogout)

        // TODO: Fetch real user profile from backend
        tvUser.text = "John Doe"
        tvPhone.text = "+1234567890"

        btnLogout.setOnClickListener {
            // TODO: Clear session/token on real logout
            finishAffinity()
        }
    }
}
