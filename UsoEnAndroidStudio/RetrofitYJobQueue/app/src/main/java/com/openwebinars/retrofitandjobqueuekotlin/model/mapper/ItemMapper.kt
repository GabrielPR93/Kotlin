package com.openwebinars.retrofitandjobqueuekotlin.model.mapper

import com.openwebinars.retrofitandjobqueuekotlin.model.ItemModel
import com.openwebinars.retrofitandjobqueuekotlin.model.dto.ItemDto

class ItemMapper {
    fun transform(items: List<ItemDto>): List<ItemModel> {
        return items.map { transform(it) }
    }

    fun transform(dto: ItemDto): ItemModel {
        return ItemModel(dto.item,
                dto.business,
                dto.farmerId,
                dto.category,
                dto.l,
                dto.farmName,
                dto.phone1)
    }
}


