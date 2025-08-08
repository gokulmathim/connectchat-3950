package org.example.app.ui.chats

import android.app.Fragment
import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.*
import org.example.app.R
import org.example.app.ui.messaging.ChatActivity

// PUBLIC_INTERFACE
class ChatsFragment : Fragment() {
    /** Fragment that lists all 1:1 and group chats, allows search and opening messages. */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val v = inflater.inflate(R.layout.fragment_chats, container, false)
        val listView = v.findViewById<ListView>(R.id.listChats)
        val txtSearch = v.findViewById<EditText>(R.id.txtChatSearch)

        // TODO: Replace with real chat list from backend
        val chatNames = listOf("Alice", "Bob", "Project X Group", "Family", "Jane Doe")
        val adapter = ArrayAdapter(activity, android.R.layout.simple_list_item_1, chatNames)
        listView.adapter = adapter

        txtSearch.addTextChangedListener(object: android.text.TextWatcher {
            override fun afterTextChanged(s: android.text.Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val filtered = chatNames.filter { it.contains(s ?: "", ignoreCase = true) }
                listView.adapter = ArrayAdapter(activity, android.R.layout.simple_list_item_1, filtered)
            }
        })

        listView.setOnItemClickListener { _, _, position, _ ->
            val name = (listView.adapter.getItem(position) as String)
            startActivity(Intent(activity, ChatActivity::class.java).putExtra("CHAT_NAME", name))
        }
        return v
    }
}
