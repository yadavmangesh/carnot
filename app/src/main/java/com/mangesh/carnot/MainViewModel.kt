package com.mangesh.carnot

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class MainViewModel(application: Application):AndroidViewModel(application) {

    private val localDataSource=getLocalRepo()

    private var repo:CommodityRemoteRepo=CommodityRemoteRepo(localDataSource,application)

    var commodityList: MutableLiveData<MutableList<Commodity>> = MutableLiveData()


    init {
         if (!Preference.firstLaunch){
              repo.getCommodity()
             Preference.firstLaunch=true
         }
    }

    fun getLocalRepo():CommodityLocalStore{
        val database=CommodityDatabase.getDataBase(getApplication())
        return CommodityLocalStore(database?.commodityDao()!!)
    }

      suspend fun getData() {
        localDataSource.getData(commodityList)
         Log.d("", "getData: ")
    }

    fun getLiveData():LiveData<MutableList<Commodity>>{
        return this.commodityList
    }



   suspend  fun getFilterData() {
          commodityList=localDataSource.getFilteredCommodityList(
            commodityList,
            Preference.filterMap[Preference.price]?.selectedList!!,
            Preference.filterMap[Preference.district]?.selectedList!!
        )
    }

   suspend fun getPriceSort() {
        commodityList=localDataSource.getSortedByPrice(commodityList)
    }


}