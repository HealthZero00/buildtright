package com.example.building3.SSD

import androidx.room.ColumnInfo

data class SSDWITHOUTURL(
    @ColumnInfo(name = "ssd_name")
    val name: String,

    @ColumnInfo(name = "ssd_storagePrice")
    val storagePrice: String,

    @ColumnInfo(name = "ssd_NVMestatus")
    val NVMestatus: String,

    @ColumnInfo(name = "ssd_amountOfMemory")
    val amountOfMemory: String
)