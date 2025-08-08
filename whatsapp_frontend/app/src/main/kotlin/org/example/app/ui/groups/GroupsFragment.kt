package org.example.app.ui.groups

import android.app.Fragment
import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.*
import org.example.app.R
import org.example.app.ui.groups.NewGroupActivity
import org.example.app.ui.messaging.ChatActivity

// PUBLIC_INTERFACE
class GroupsFragment : Fragment() {
    /** Fragment showing user's group chats + group add button. */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val v = inflater.inflate(R.layout.fragment_groups, container, false)
        val btnNewGroup = v.findViewById<Button>(R.id.btnNewGroup)
        val lvGroups = v.findViewById<ListView>(R.id.listGroups)

        // TODO: Use data from backend; this is a placeholder
        val groupNames = listOf("Android Devs", "Family", "Friends👫")
        lvGroups.adapter = ArrayAdapter(activity, android.R.layout.simple_list_item_1, groupNames)

        btnNewGroup.setOnClickListener {
            startActivity(Intent(activity, NewGroupActivity::class.java))
        }

        lvGroups.setOnItemClickListener { _, _, position, _ ->
            val gName = lvGroups.adapter.getItem(position) as String
            startActivity(Intent(activity, ChatActivity::class.java).putExtra("CHAT_NAME", gName))
        }

        return v
    }
}
