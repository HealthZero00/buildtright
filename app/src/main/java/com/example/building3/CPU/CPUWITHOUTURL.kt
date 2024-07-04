package com.example.building3.CPU

import androidx.room.ColumnInfo

data class CPUWITHOUTURL(
    @ColumnInfo(name = "cpu_name")
    val name: String,

    @ColumnInfo(name = "cpu_brand")
    val brand: String,

    @ColumnInfo(name = "cpu_model")
    val model: String,

    @ColumnInfo(name = "cpu_price")
    val price: String,

    @ColumnInfo(name = "cpu_socket")
    val socket: String
)