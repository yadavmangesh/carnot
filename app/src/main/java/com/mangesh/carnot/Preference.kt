package com.mangesh.carnot

object Preference {

    var firstLaunch:Boolean=false

    val districtList= arrayListOf("Durg","Chittor","Kurnool","Bilaspur","Kabirdham" ,"Balodabazar","Tiphra","Nagari")
    val priceList= arrayListOf("2000","2500","3000")

    const val district=0

    const val price=1

    var filterMap = HashMap<Int,FilterValue>()

    const val url="https://api.data.gov.in/resource/" +
            "9ef84268-d588-465a-a308-a864a43d0070?api-key=579b464db66ec23bdd00000108aaacdb5a6543f277c849c4ca3bffe3&format=" +
            "json&offset=0&limit=30"


}