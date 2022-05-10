package com.openwebinars.mydatabase.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.text.Editable
import android.text.TextWatcher
import com.openwebinars.mydatabase.adapter.CarAdapter
import com.openwebinars.mydatabase.model.CarModel
import com.openwebinars.mydatabase.R
import io.realm.Realm
import io.realm.kotlin.where
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var adapter = CarAdapter(listOf(), {})

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupRecyclerView(getCarList(Realm.getDefaultInstance()))

        mainInput.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable?) {}

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                adapter.filterData(s.toString())
            }

        })

        mainBtn.setOnClickListener {
            val intent = Intent(this, CreateCarActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        adapter.setData(getCarList(Realm.getDefaultInstance()))
    }

    private fun setupRecyclerView(carList: List<CarModel>) {
        mainList.layoutManager = LinearLayoutManager(this)
        adapter = CarAdapter(carList) {
            adapter.setData(deleteCarByBrand(Realm.getDefaultInstance(), it.brand))
            mainList.adapter.notifyDataSetChanged()
        }
    }

    private fun getCarList(realm: Realm): List<CarModel> {
        return realm.where<CarModel>().findAll().toList()
    }

    private fun deleteCarByBrand(realm: Realm, text: String): List<CarModel> {
        realm.executeTransaction {
            it.where<CarModel>()
                    .contains("brand", text)
                    .findFirst()?.deleteFromRealm()
        }
        return getCarList(realm)
    }
}
