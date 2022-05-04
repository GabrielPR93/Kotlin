package com.openwebinars.recyclerviewandadapterkotlin

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.row_car.view.*

class CarAdapter(private val items: List<CarModel>, private val listener: (CarModel) -> Unit)
    : RecyclerView.Adapter<CarAdapter.CarViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CarViewHolder {
        return CarViewHolder(LayoutInflater.from(parent!!.context)
                .inflate(R.layout.row_car, parent, false))
    }

    override fun onBindViewHolder(holder: CarViewHolder?, position: Int) {
        val car = items.get(position) //- También podemos usar items[position]
        holder!!.brandLabel.text = car.brand //- También podemos usar holder?.brandLabel?.text

        //- Esta función de extensión está en ViewExtension
        holder.idLabel.setTextDefault(car.id)

        holder.itemView.setOnClickListener {
            listener(car)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class CarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val brandLabel = itemView.rowCarBrandLabel
        var idLabel = itemView.rowCarIdLabel
    }
}