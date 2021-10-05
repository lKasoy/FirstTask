package com.example.firsttask

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.example.firsttask.Constants.ID
import com.example.firsttask.Constants.ITEMS_PREFS
import com.example.firsttask.Constants.ITEM_ID

class Receiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val sharedPrefs = context.getSharedPreferences(ITEMS_PREFS, -1)
        val itemId = sharedPrefs.getInt(ITEM_ID, -1)
        val intent1 = Intent(context, MainActivity::class.java).apply {
            putExtra(ID, itemId)
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }
        context.startActivity(intent1)
    }
}

