package com.openwebinars.definicionlisteners.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.openwebinars.definicionlisteners.R
import com.openwebinars.definicionlisteners.model.CarModel
import kotlinx.android.synthetic.main.row_car.view.*

class CarAdapter(val items: List<CarModel>, val listener: (CarModel) -> Unit)
    : RecyclerView.Adapter<CarAdapter.CarViewHolder>() {

override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
    return CarViewHolder(LayoutInflater.from(parent.context).inflate(
            R.layout.row_car, parent, false))
}

override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
    val car = items.get(position)
    holder.brandLabel.text = car.brand
    holder.check.isChecked = car.isSelected
    holder.itemView.setOnClickListener {
        holder.check.performClick()
    }
    holder.check.setOnCheckedChangeListener { _, isChecked ->
        car.isSelected = isChecked
        listener(car)
    }
}

override fun getItemCount(): Int {
    return items.size
}

class CarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val brandLabel = itemView.rowCarBrandLabel
    val check = itemView.rowCarSwitch
}
}