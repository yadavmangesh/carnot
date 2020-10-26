package com.mangesh.carnot

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CommodityLocalStore(private val commodityDao: CommodityDao) : Repository {

    val ioDispatcher: CoroutineDispatcher = Dispatchers.IO

    override suspend fun getData(list: MutableLiveData<MutableList<Commodity>>): MutableLiveData<MutableList<Commodity>> =
        withContext(ioDispatcher) {
            list.postValue(commodityDao.gettCommodities())
            return@withContext list

        }

    override suspend fun saveData(list: MutableList<Commodity>) {
        withContext(ioDispatcher) {
            commodityDao.saveCommodities(list)
        }
    }

    override suspend fun getFilteredCommodityList(
        list: MutableLiveData<MutableList<Commodity>>,
        price: ArrayList<String>,
        district: ArrayList<String>
    ):
            MutableLiveData<MutableList<Commodity>> = withContext(ioDispatcher) {

         if (price.isNotEmpty()&&district.isNotEmpty()){
             list.postValue(commodityDao.getFilter(price,district))
         }else if (price.isEmpty()){
             list.postValue(commodityDao.getDistrictFilter(district))
         }else if (district.isEmpty()){
             list.postValue(commodityDao.getPriceFilter(price))
         }else{
             list.postValue(commodityDao.gettCommodities())
         }

        return@withContext list
    }

    override suspend fun getSortedByPrice( list: MutableLiveData<MutableList<Commodity>>): MutableLiveData<MutableList<Commodity>> =
        withContext(ioDispatcher) {
            list.postValue(commodityDao.getCommodityByPrice())
            return@withContext list
        }


}