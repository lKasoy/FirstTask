package com.example.firsttask

import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.example.firsttask.Constants.ID
import com.example.firsttask.Constants.ITEMS_PREFS
import com.example.firsttask.Constants.ITEM_ID
import com.example.firsttask.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        val position: Int = intent.extras!!.getInt(ID)
        binding.txtId.text = ItemsHolder.getById(position).id.toString()
        binding.txtName.text = ItemsHolder.getById(position).name
        binding.txtDescription.text = ItemsHolder.getById(position).description
        saveLastElementId(ItemsHolder.getById(position).id)
    }

    private fun saveLastElementId(position: Int) {
        val savedPref: SharedPreferences =
            this.getSharedPreferences(ITEMS_PREFS, MODE_PRIVATE) ?: return
        with(savedPref.edit()) {
            putInt(ITEM_ID, position)
            apply()
        }
    }
}