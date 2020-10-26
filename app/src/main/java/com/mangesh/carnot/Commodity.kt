package com.mangesh.carnot

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "commodity",primaryKeys = ["district" , "commodity"])
data class Commodity(

                     val timeStamp: Double,
                     val state:String,
                     val district:String,
                     val market:String,
                     val commodity:String,
                     val variety:String,
                     val arrival_date:String,
                     val min_price:Double,
                     val max_price:Double,
                     val modal_price:Double
                   )