package com.example.building3.CpuCooler

import androidx.room.ColumnInfo

data class CPUCOOLERWITHOUTURL(
    @ColumnInfo(name = "cooler_name")
    val name: String,

    @ColumnInfo(name = "cooler_price")
    val price: String
)

