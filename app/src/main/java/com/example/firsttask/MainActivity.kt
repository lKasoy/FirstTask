package com.example.firsttask

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firsttask.Constants.ID
import com.example.firsttask.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        binding.rclItems.layoutManager = LinearLayoutManager(this)
        initRecycler()
        ForegroundService.startService(this)
        startActivityFromReceiver()
    }

    private fun startActivityFromReceiver() {
        if (intent.hasExtra(ID)) {
            val id = intent.extras?.getInt(ID) ?: -1
            if (id != -1) {
                val itemIntent = Intent(this, SecondActivity::class.java)
                itemIntent.putExtra(ID, id)
                startActivity(itemIntent)
            }
        }
    }

    private fun initRecycler() {
        val adapter = ItemAdapterKotlin(ItemsHolder.items)
        { itemId: Item ->
            val itemIntent = Intent(this, SecondActivity::class.java)
            itemIntent.putExtra(ID, itemId.id)
            startActivity(itemIntent)
        }
        binding.rclItems.adapter = adapter
    }
}








