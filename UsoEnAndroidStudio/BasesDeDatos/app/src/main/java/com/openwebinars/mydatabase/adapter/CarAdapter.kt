package com.openwebinars.mydatabase.adapter

import android.support.v7.widget.RecyclerView
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.openwebinars.mydatabase.model.CarModel
import com.openwebinars.mydatabase.R
import kotlinx.android.synthetic.main.row_car.view.*

class CarAdapter(private var items: List<CarModel>, private val listener: (CarModel) -> Unit)
    : RecyclerView.Adapter<CarAdapter.CarViewHolder>() {

    private var originalDataset = listOf<CarModel>()

    init {
        originalDataset = items
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        return CarViewHolder(LayoutInflater.from(parent.context).inflate(
                R.layout.row_car, parent, false))
    }

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        val car = items.get(position) //- También se puede usar items[position]
        holder.brandLabel.text = car.brand
        holder.itemView.setOnClickListener {
            listener(car)
        }
    }

    fun setData(items: List<CarModel>) {
        originalDataset = items
        this.items = originalDataset
        notifyDataSetChanged()
    }

    fun filterData(text: String) {
        if (TextUtils.isEmpty(text)) {
            this.items = originalDataset
        } else {
            this.items = originalDataset.filter {
                it.brand.contains(text)
            }
        }
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class CarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val brandLabel = itemView.carRowBrandLabel
    }
}