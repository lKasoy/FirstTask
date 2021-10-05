package com.example.firsttask

import android.app.PendingIntent
import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.IBinder
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import com.example.firsttask.Constants.CHANNEL_ID
import com.example.firsttask.Constants.NOTIFICATION_CLICK

class ForegroundService : Service() {

    companion object {
        fun startService(context: Context) {
            val startIntent = Intent(context, ForegroundService::class.java)
            ContextCompat.startForegroundService(context, startIntent)
        }
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val notificationIntent = Intent(NOTIFICATION_CLICK)
        val pendingIntent = PendingIntent.getBroadcast(
            this,
            0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT
        )
        val notification = NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle("CLICK ON ME")
            .setContentText("TO SEND MESSAGE")
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentIntent(pendingIntent)
            .build()
        startForeground(1, notification)
        return START_NOT_STICKY
    }

    override fun onBind(intent: Intent): IBinder? {
        return null
    }
}

