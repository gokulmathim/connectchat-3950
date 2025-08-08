package org.example.app.ui.settings

import android.app.Fragment
import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.*
import org.example.app.R
import org.example.app.ui.settings.ProfileActivity

// PUBLIC_INTERFACE
class SettingsFragment : Fragment() {
    /** Fragment for settings with profile and preferences. */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val v = inflater.inflate(R.layout.fragment_settings, container, false)
        val btnProfile = v.findViewById<Button>(R.id.btnProfile)
        btnProfile.setOnClickListener {
            startActivity(Intent(activity, ProfileActivity::class.java))
        }
        // TODO: Add more settings if needed
        return v
    }
}
