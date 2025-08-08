package org.example.app

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import org.example.app.ui.auth.LoginActivity

class MainActivity : Activity() {
    /**
     * Launch activity.
     * Entry point: redirects straight to Login.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }
}
