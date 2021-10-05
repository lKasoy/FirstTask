package com.example.firsttask

object InitItems {

    val items: List<Item> by lazy {
        val mutableItems = mutableListOf<Item>()
        for (i in 0 until 20) {
            mutableItems.add(Item(i, "name № $i", "descrition № $i"))
        }
        mutableItems
    }

    fun getById(id: Int): Item {
        return items.first {
            it.idValueView == id
        }
    }
}
