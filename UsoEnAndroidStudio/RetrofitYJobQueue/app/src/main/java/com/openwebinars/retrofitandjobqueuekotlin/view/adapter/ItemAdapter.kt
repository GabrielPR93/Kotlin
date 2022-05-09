package com.openwebinars.retrofitandjobqueuekotlin.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.openwebinars.retrofitandjobqueuekotlin.model.ItemModel
import com.openwebinars.retrofitandjobqueuekotlin.R
import kotlinx.android.synthetic.main.row_item.view.*

class ItemAdapter(private val items: List<ItemModel>, private val listener: (ItemModel) -> Unit)
    : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(LayoutInflater.from(parent.context).inflate(
                R.layout.row_item, parent, false))
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = items.get(position) //- También se puede usar items[position]
        holder.itemId.text = item.farmerId
        holder.itemName.text = item.farmName
        holder.itemView.setOnClickListener {
            listener(item)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemId = itemView.rowItemId
        val itemName = itemView.rowItemName
    }
}