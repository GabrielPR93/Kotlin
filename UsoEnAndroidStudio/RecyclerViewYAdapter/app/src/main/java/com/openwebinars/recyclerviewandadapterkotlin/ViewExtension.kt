package com.openwebinars.recyclerviewandadapterkotlin

import android.text.TextUtils
import android.widget.TextView

fun TextView.setTextDefault(text: String) {
    if (!TextUtils.isEmpty(text)) {
        this.text = text
    } else {
        this.text = "Id no válido"
    }
}