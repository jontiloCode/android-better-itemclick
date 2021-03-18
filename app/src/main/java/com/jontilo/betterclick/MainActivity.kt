package com.jontilo.betterclick

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private var recyclerView:RecyclerView? = null
    lateinit var myAdapter: MyAdapter
    var datas = arrayListOf<MyModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //init RecyclerView
        recyclerView = findViewById(R.id.myRec)
        initAdapter()
        initRecyclerView()
        for (i in 0..10) {
            val myModel = MyModel("name ${i}", "address ${i}")
            datas.add(myModel)
        }

        //set setter class
        myAdapter.data = datas


    }

    private fun initRecyclerView() {
        recyclerView?.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = myAdapter
        }
    }
    private fun initAdapter() {
        if (!::myAdapter.isInitialized) {
            myAdapter = MyAdapter {
                Toast.makeText(this@MainActivity, it.name, Toast.LENGTH_SHORT).show()

            }
        }
    }

}