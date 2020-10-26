package com.mangesh.carnot

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

interface Repository {

    suspend fun getData(list: MutableLiveData<MutableList<Commodity>>): MutableLiveData<MutableList<Commodity>>

    suspend fun saveData(list: MutableList<Commodity>)

    suspend fun getFilteredCommodityList(list:MutableLiveData<MutableList<Commodity>>,
                                         price: ArrayList<String>, district:ArrayList<String>):MutableLiveData<MutableList<Commodity>>

    suspend fun getSortedByPrice( list: MutableLiveData<MutableList<Commodity>>):MutableLiveData<MutableList<Commodity>>
}