package com.openwebinars.binddevistas

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //- El casting es automático por lo que no hace falta hacer nada
        text.text = "Test"
        img.setImageResource(R.mipmap.ic_launcher)
        input.setHint("Test")
    }
}
