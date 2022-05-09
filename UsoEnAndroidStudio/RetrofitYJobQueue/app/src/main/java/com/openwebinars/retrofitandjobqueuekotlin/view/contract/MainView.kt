package com.openwebinars.retrofitandjobqueuekotlin.view.contract

import com.openwebinars.retrofitandjobqueuekotlin.model.ItemModel

interface MainView {
    fun setDataSet(items: List<ItemModel>)
}

