package com.openwebinars.definicionlisteners.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.openwebinars.definicionlisteners.R
import com.openwebinars.definicionlisteners.adapter.CustomCarAdapter
import com.openwebinars.definicionlisteners.model.CarModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var carList: MutableList<CarModel> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initCarList()

        mainList.layoutManager = LinearLayoutManager(this)
        mainList.adapter = CustomCarAdapter(carList, object: CustomCarAdapter.CustomListener {
            override fun clickOnCarItem(carModel: CarModel) {
                Toast.makeText(this@MainActivity,
                        "Click: " + carModel.brand,
                        Toast.LENGTH_SHORT).show()
            }

            override fun longClickOnCarItem(carModel: CarModel) {
                Toast.makeText(this@MainActivity,
                        "LongClick: " + carModel.brand,
                        Toast.LENGTH_SHORT).show()
            }

        })
    }

    private fun initCarList() {
        carList = (1..100).map { CarModel("Marca " + it.toString(), it.toString()) }.toMutableList()
    }
}
