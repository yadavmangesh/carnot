package com.mangesh.carnot

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.filter_parameter_value_item.view.*

class FilterValueAdapter(val selectedPosition:Int): RecyclerView.Adapter<FilterValueAdapter.FilterValueHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilterValueHolder {
       return FilterValueHolder(LayoutInflater.from(parent.context).inflate(R.layout.filter_parameter_value_item,parent,false))

    }

    override fun getItemCount(): Int {
        return Preference.filterMap[selectedPosition]?.list?.size!!
    }

    override fun onBindViewHolder(holder: FilterValueHolder, position: Int) {
       val filterValue=Preference.filterMap[selectedPosition]

        var selectedList = filterValue?.selectedList

        holder.itemView.cbValue.setOnClickListener {
            if (holder.itemView.cbValue.isChecked){
                filterValue?.list?.get(position)?.let { it1 -> selectedList?.add(it1) }
            }else{
                selectedList?.remove(filterValue?.list?.get(position))
            }

            if (selectedList != null) {
                filterValue?.selectedList=selectedList
            }

            if (filterValue != null) {
                Preference.filterMap.put(selectedPosition,filterValue)
            }

        }
        holder.itemView.tvParameter.text=filterValue?.list?.get(position)

        if (filterValue?.selectedList?.contains(filterValue?.list?.get(position))!!){
            holder.itemView.cbValue.setChecked(true)
        }

    }

    class FilterValueHolder(itemView: View):RecyclerView.ViewHolder(itemView)
}