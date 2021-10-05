package com.example.firsttask

import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.example.firsttask.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private val SAVED_ITEM_ID = "item_id"
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        val position: Int = intent.extras!!.getInt("id")
        binding.txtIdValue.text = InitItems.getById(position).idValueView.toString()
        binding.txtNameValueSecond.text = InitItems.getById(position).nameValueView
        binding.txtDescriptionValue.text = InitItems.getById(position).descriptionValueView
        saveLastElementId(InitItems.getById(position).idValueView)
    }

    private fun saveLastElementId(position: Int) {
        val savedPref: SharedPreferences =
            this.getSharedPreferences("items_prefs", MODE_PRIVATE) ?: return
        with(savedPref.edit()) {
            putInt(SAVED_ITEM_ID, position)
            apply()
        }
    }
}