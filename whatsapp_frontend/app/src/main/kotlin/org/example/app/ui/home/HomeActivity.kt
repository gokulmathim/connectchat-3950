package org.example.app.ui.home

import android.app.Activity
import android.app.Fragment
import android.app.FragmentManager
import android.os.Bundle
import android.widget.TabHost
import org.example.app.R
import org.example.app.ui.chats.ChatsFragment
import org.example.app.ui.groups.GroupsFragment
import org.example.app.ui.status.StatusFragment
import org.example.app.ui.settings.SettingsFragment

// PUBLIC_INTERFACE
class HomeActivity : Activity() {
    /** Root activity with tabbed navigation. */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val tabHost = findViewById<TabHost>(android.R.id.tabhost)
        tabHost.setup()

        tabHost.addTab(tabHost.newTabSpec("chats").setIndicator(getString(R.string.tab_chats)).setContent(R.id.tab1))
        tabHost.addTab(tabHost.newTabSpec("groups").setIndicator(getString(R.string.tab_groups)).setContent(R.id.tab2))
        tabHost.addTab(tabHost.newTabSpec("status").setIndicator(getString(R.string.tab_status)).setContent(R.id.tab3))
        tabHost.addTab(tabHost.newTabSpec("settings").setIndicator(getString(R.string.tab_settings)).setContent(R.id.tab4))

        // Add fragments into tab containers
        if (savedInstanceState == null) {
            fragmentManager.beginTransaction().replace(R.id.tab1, ChatsFragment()).commit()
            fragmentManager.beginTransaction().replace(R.id.tab2, GroupsFragment()).commit()
            fragmentManager.beginTransaction().replace(R.id.tab3, StatusFragment()).commit()
            fragmentManager.beginTransaction().replace(R.id.tab4, SettingsFragment()).commit()
        }
    }
}
