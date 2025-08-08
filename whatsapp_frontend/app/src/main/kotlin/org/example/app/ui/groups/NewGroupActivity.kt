package org.example.app.ui.groups

import android.app.Activity
import android.os.Bundle
import android.widget.*
import org.example.app.R

// PUBLIC_INTERFACE
class NewGroupActivity : Activity() {
    /** UI for creating a new group chat. */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_group)

        val edtGroupName = findViewById<EditText>(R.id.editGroupName)
        val btnCreate = findViewById<Button>(R.id.btnCreateGroup)

        btnCreate.setOnClickListener {
            val gname = edtGroupName.text.toString()
            if (gname.isBlank()) {
                Toast.makeText(this, "Enter a group name", Toast.LENGTH_SHORT).show()
            } else {
                // TODO: Call group creation API, refresh group list
                Toast.makeText(this, "Group \"$gname\" created (TODO)", Toast.LENGTH_LONG).show()
                finish()
            }
        }
    }
}
