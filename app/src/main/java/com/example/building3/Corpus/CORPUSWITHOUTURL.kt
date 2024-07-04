package com.example.building3.Corpus

import androidx.room.ColumnInfo

data class CORPUSWITHOUTURL(
    @ColumnInfo(name = "corpus_name")
    val name: String,

    @ColumnInfo(name = "case_price")
    val case_price: String
)