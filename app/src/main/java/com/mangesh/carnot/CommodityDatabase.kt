package com.mangesh.carnot

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Commodity::class],version = 1, exportSchema = false)
abstract class CommodityDatabase:RoomDatabase() {

    abstract fun commodityDao():CommodityDao

    companion object{

        @Volatile
        private var INSTANCE:CommodityDatabase?=null

        fun getDataBase(context: Context):CommodityDatabase?{

            if (INSTANCE==null){
                synchronized(CommodityDatabase::class.java){
                    if (INSTANCE==null){
                        INSTANCE= Room.databaseBuilder(
                            context.applicationContext,
                            CommodityDatabase::class.java,
                            "cm_db").build()
                    }
                }
            }
            return INSTANCE
        }
    }
}