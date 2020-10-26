package com.mangesh.carnot

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_filter.*
import java.util.*
import kotlin.collections.ArrayList

class FilterActivity : AppCompatActivity() {

    var list:ArrayList<String> = ArrayList()
    lateinit var adapter: FilterAdapter

    init {
        list.add("District")
        list.add("Price")
        Preference.filterMap[Preference.district] = FilterValue("District",Preference.districtList, arrayListOf())
        Preference.filterMap[Preference.price] = FilterValue("Price",Preference.priceList, arrayListOf())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filter)

        adapter=FilterAdapter(Preference.filterMap,rvFilterValues)

        rvFilterParameter.adapter=adapter

        applyB.setOnClickListener {
            val intent=Intent(this,MainActivity::class.java)
            intent.putExtra("filter",true)
            startActivity(intent)
        }

        clearB.setOnClickListener {
            Preference.filterMap[Preference.price]?.selectedList= arrayListOf()
            Preference.filterMap[Preference.district]?.selectedList= arrayListOf()
            val intent=Intent(this,MainActivity::class.java)
            intent.putExtra("filter",false)
            startActivity(intent)
        }
    }
}