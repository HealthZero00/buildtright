package com.example.building3.Powersupplies

import androidx.room.ColumnInfo

data class POWERSUPPLIESWITHOUTURL(
    @ColumnInfo(name = "powersupply_name")
    val name: String,

    @ColumnInfo(name = "powersupply_rating")
    val powersupplies_rating: String,

    @ColumnInfo(name = "powersupply_power")
    val power: String,

    @ColumnInfo(name = "powersupply_price")
    val powersupplies_price: String
)