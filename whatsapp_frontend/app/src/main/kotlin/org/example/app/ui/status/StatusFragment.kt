package org.example.app.ui.status

import android.app.Fragment
import android.os.Bundle
import android.view.*
import android.widget.*
import org.example.app.R

// PUBLIC_INTERFACE
class StatusFragment : Fragment() {
    /** Fragment for viewing user and friends status updates. */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val v = inflater.inflate(R.layout.fragment_status, container, false)
        val listStatus = v.findViewById<ListView>(R.id.listStatus)

        // TODO: Query and show status from backend, add 'add status' UI
        val statusList = listOf("You: (add a status…)", "Alice: On vacation!", "Bob: Busy 🚦")
        listStatus.adapter = ArrayAdapter(activity, android.R.layout.simple_list_item_1, statusList)
        return v
    }
}
