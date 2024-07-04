package com.example.building3.Databases

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.building3.CPU.CPUWITHOUTURL
import com.example.building3.Corpus.CORPUSWITHOUTURL
import com.example.building3.CpuCooler.CPUCOOLERWITHOUTURL
import com.example.building3.GPU.GPUWITHOUTURL
import com.example.building3.Motherboards.MOTHERBOARDSWITHOUTURL
import com.example.building3.Powersupplies.POWERSUPPLIESWITHOUTURL
import com.example.building3.RAM.RAMWITHOUTURL
import com.example.building3.SSD.SSDWITHOUTURL

@Entity(tableName = "builds")
data class BuildEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,

    val name1: String,

    @Embedded
    val motherboard1: MOTHERBOARDSWITHOUTURL? = null,

    @Embedded
    val cpu1: CPUWITHOUTURL? = null,

    @Embedded
    val gpu1: GPUWITHOUTURL? = null,

    @Embedded
    val powersupply1: POWERSUPPLIESWITHOUTURL? = null,

    @Embedded
    val ram1: RAMWITHOUTURL? = null,

    @Embedded
    val ssd1: SSDWITHOUTURL? = null,

    @Embedded
    val cpucooler1: CPUCOOLERWITHOUTURL? = null,

    @Embedded
    val corpus1: CORPUSWITHOUTURL? = null
)
