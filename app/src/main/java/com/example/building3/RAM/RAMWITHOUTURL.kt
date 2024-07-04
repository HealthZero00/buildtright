package com.example.building3.RAM

import androidx.room.ColumnInfo

data class RAMWITHOUTURL(
    @ColumnInfo(name = "ram_name")
    val name: String,

    @ColumnInfo(name = "ram_price")
    val price: String,

    @ColumnInfo(name = "ram_typeMemory")
    val typeMemory: String,

    @ColumnInfo(name = "ram_amountOfMemory")
    val amountOfMemory: String
)