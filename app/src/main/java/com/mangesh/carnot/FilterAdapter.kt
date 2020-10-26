package com.mangesh.carnot

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.filter_parameter_item.view.*

class FilterAdapter(val filterParameterList: HashMap<Int,FilterValue>,
                    val rvFilterParameterValue:RecyclerView) : RecyclerView.Adapter<FilterAdapter.FilterHolder>() {

    var selectedPosition:Int=0


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilterHolder {
        return FilterHolder(LayoutInflater.from(parent.context).inflate(R.layout.filter_parameter_item,parent,false))
    }

    override fun getItemCount(): Int {
        return filterParameterList.size
    }

    override fun onBindViewHolder(holder: FilterHolder, position: Int) {
       val parameterName= filterParameterList.values.toList()[position]
        holder.itemView.tvParameter.text=parameterName.name

        holder.itemView.setOnClickListener {
            selectedPosition=position
            notifyDataSetChanged()
        }
        rvFilterParameterValue.adapter=FilterValueAdapter(selectedPosition)
        holder.itemView.setBackgroundColor(if (selectedPosition == position) Color.WHITE else Color.TRANSPARENT)
    }


    class FilterHolder(itemView:View):RecyclerView.ViewHolder(itemView)
}