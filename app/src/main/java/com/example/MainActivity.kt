package com.example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
    }
}
