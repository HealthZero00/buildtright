package com.example.building3.Motherboards

import androidx.room.ColumnInfo

data class MOTHERBOARDSWITHOUTURL(
    @ColumnInfo(name = "motherboard_name")
    val name: String,

    @ColumnInfo(name = "motherboard_brand")
    val brand: String,

    @ColumnInfo(name = "motherboard_formFactor")
    val formFactor: String,

    @ColumnInfo(name = "motherboard_price")
    val price: String,

    @ColumnInfo(name = "motherboard_socket")
    val socket: String,

    @ColumnInfo(name = "motherboard_chipset")
    val chipset: String,

    @ColumnInfo(name = "motherboard_memoryType")
    val memoryType: String,

    @ColumnInfo(name = "motherboard_nvmeStatus")
    val nvmeStatus: String
)
