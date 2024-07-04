package com.example.building3.GPU

import androidx.room.ColumnInfo

data class GPUWITHOUTURL(
    @ColumnInfo(name = "gpu_name")
    val name: String,

    @ColumnInfo(name = "gpu_brand")
    val gpuBrand: String,

    @ColumnInfo(name = "gpu_typeMemory")
    val typeMemory: String,

    @ColumnInfo(name = "gpu_price")
    val gpuPrice: String,

    @ColumnInfo(name = "gpu_memoryBus")
    val memoryBus: String,

    @ColumnInfo(name = "gpu_amountOfMemory")
    val amountOfMemory: String
)