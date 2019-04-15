package com.example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val strList = ArrayList<String>()
        strList.add("test1")
        strList.add("test2")
        strList.add("test3")
        strList.add("test4")
        strList.add("test5")

        val adapter = ExampleAdapter(strList)
        recyclerView.adapter = adapter


        val callback = SimpleItemTouchHelperCallback(adapter)
        val touchHelper = ItemTouchHelper(callback)
        touchHelper.attachToRecyclerView(recyclerView)

        ItemTouchHelper(object : SwipeToDeleteCallback(applicationContext) {
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, p1: Int) {
                adapter.removeAt(viewHolder.adapterPosition)
            }
        }).attachToRecyclerView(recyclerView)

        ItemTouchHelper(object : SwipeToEditCallback(applicationContext) {
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, p1: Int) {
                adapter.editAt(viewHolder.adapterPosition, "new text")
            }
        }).attachToRecyclerView(recyclerView)

    }
}
