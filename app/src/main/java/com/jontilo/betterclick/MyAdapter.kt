package com.jontilo.betterclick

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(val onItemClicked: (MyModel) -> Unit):
    RecyclerView.Adapter<MyAdapter.ItemHolder>() {

    var data : List<MyModel> = ArrayList(0)
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    class ItemHolder(myView: View, onItemClicked: (Int) -> Unit) : RecyclerView.ViewHolder(myView) {
        init {
            itemView.setOnClickListener { onItemClicked(adapterPosition) }
        }
        var itemName: TextView = myView.findViewById(R.id.txt_item_name)
        var itemAddress: TextView = myView.findViewById(R.id.txt_item_addresss)

        fun bindItem(model: MyModel) {
            itemName.text = model.name
            itemAddress.text = model.address

        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
       val viewHolder = LayoutInflater.from(parent.context).inflate(R.layout.my_item, parent, false)
        return ItemHolder(viewHolder) {
            onItemClicked(data[it])
        }
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.bindItem(data[holder.adapterPosition])
    }

}