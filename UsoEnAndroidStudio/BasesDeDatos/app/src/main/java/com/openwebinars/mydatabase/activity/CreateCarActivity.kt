package com.openwebinars.mydatabase.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import com.openwebinars.mydatabase.model.CarModel
import com.openwebinars.mydatabase.R
import com.openwebinars.mydatabase.extension.toast
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_create_car.*

class CreateCarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_car)

        createBtn.setOnClickListener {
            val text = createInput.text.toString()
            if (!TextUtils.isEmpty(text)) {
                Realm.getDefaultInstance().executeTransaction {
                    createCarIntoBd(it, text)
                }
                createInput.setText("")
                toast("Creado correctamente")
            } else {
                toast("El texto no puede ser vacío")
            }
        }
    }

    private fun createCarIntoBd(realm: Realm, text: String) {
        realm.copyToRealmOrUpdate(CarModel(text, text))
    }
}
