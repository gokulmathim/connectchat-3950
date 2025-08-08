package org.example.app.ui.messaging

import android.app.Activity
import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.*
import org.example.app.R
import java.io.InputStream

// PUBLIC_INTERFACE
class ChatActivity : Activity() {
    /** Chat activity for messaging, media, and status. */
    companion object {
        const val PICK_MEDIA_CODE = 420
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        val chatName = intent.getStringExtra("CHAT_NAME") ?: "(Chat)"
        findViewById<TextView>(R.id.tvChatTitle).text = chatName

        val btnSend = findViewById<Button>(R.id.btnSend)
        val etMsg = findViewById<EditText>(R.id.etMessage)
        val lvMsgs = findViewById<ListView>(R.id.listMessages)
        val btnMedia = findViewById<ImageButton>(R.id.btnSendMedia)

        // Placeholder messages
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mutableListOf<String>())
        lvMsgs.adapter = adapter

        btnSend.setOnClickListener {
            val msg = etMsg.text.toString()
            if (msg.isNotBlank()) {
                adapter.add("Me: $msg")
                etMsg.text.clear()
                // TODO: Send message via API; implement real-time updates
            }
        }

        btnMedia.setOnClickListener {
            val pickIntent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(pickIntent, PICK_MEDIA_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == PICK_MEDIA_CODE && resultCode == RESULT_OK && data != null) {
            val uri: Uri? = data.data
            // TODO: Send selected image/video to chat
            Toast.makeText(this, "Media sent (TODO)", Toast.LENGTH_SHORT).show()
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }
}
