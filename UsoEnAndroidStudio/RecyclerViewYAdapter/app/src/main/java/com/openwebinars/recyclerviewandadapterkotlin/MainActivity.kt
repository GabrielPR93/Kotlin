package com.openwebinars.recyclerviewandadapterkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val carList = mutableListOf<CarModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initCarList()
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        mainList.layoutManager = GridLayoutManager(this, 2)
        mainList.adapter = CarAdapter(carList, {
            toast(String.format("Marca %s", it.id), 500)
        })
    }

    private fun initCarList() {
        for (number in 1 until 100) {
            val id = if (number % 2 == 0) number.toString() else ""
            carList.add(CarModel(id, String.format("Marca %s", number)))
        }
    }
}
