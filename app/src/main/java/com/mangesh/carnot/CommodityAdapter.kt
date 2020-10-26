package com.mangesh.carnot

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.commodity_item.view.*

class CommodityAdapter: RecyclerView.Adapter<CommodityAdapter.CommodityHolder>() {

    private var list:MutableList<Commodity> = mutableListOf()

    class CommodityHolder(itemView: View):RecyclerView.ViewHolder(itemView)

    fun setData(list: MutableList<Commodity>){
        this.list=list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommodityHolder {
      return CommodityHolder(LayoutInflater.from(parent.context).inflate(R.layout.commodity_item,parent,false))
    }

    override fun getItemCount(): Int {
       return list.size
    }

    override fun onBindViewHolder(holder: CommodityHolder, position: Int) {
        val commodity=list[position]

        holder.itemView.tvCommodity.text=commodity.commodity
        holder.itemView.tvPrice.text=commodity.min_price.toString()
        holder.itemView.tvState.text=commodity.district
    }
}