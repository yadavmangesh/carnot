package com.mangesh.carnot

import android.app.Application
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity(), CoroutineScope {

    private var job: Job = Job()

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    private var mainViewModel: MainViewModel =
        MainViewModel(CarnotApplication.applicationContext() as Application)

    lateinit var adapter: CommodityAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = CommodityAdapter()
        rvCommodity.adapter = adapter

        if (intent.getBooleanExtra("filter", false)) {
             launch {
                 mainViewModel.getFilterData()
             }
        }else{
            launch {
                Log.d("TAG", "onCreate: launch")
                mainViewModel.getData()
            }
        }

        tvFilter.setOnClickListener {
            startActivity(Intent(this, FilterActivity::class.java))
        }

        tvSort.setOnClickListener {
            launch {
                mainViewModel.getPriceSort()
            }
        }



        mainViewModel.getLiveData().observe(this, Observer {
            adapter.setData(it)
        })

    }
}