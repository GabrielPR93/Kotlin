package com.openwebinars.recyclerviewandadapterkotlin

import android.app.Activity
import android.widget.Toast


fun Activity.toast(text: String, duration: Int = Toast.LENGTH_SHORT) {
    android.widget.Toast.makeText(this, text, duration).show()
}