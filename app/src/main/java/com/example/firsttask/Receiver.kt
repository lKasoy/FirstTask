package com.example.firsttask

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class Receiver : BroadcastReceiver() {

    val SAVED_ITEM_ID = "item_id"

    override fun onReceive(context: Context, intent: Intent) {
        val sharedPrefs = context.getSharedPreferences("items_prefs", -1)
        val itemId = sharedPrefs.getInt(SAVED_ITEM_ID, -1)
        val intent1 = Intent(context, MainActivity::class.java).apply {
            putExtra("id", itemId)
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }
        context.startActivity(intent1)
    }
}

