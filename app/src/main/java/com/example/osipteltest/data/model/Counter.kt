package com.example.osipteltest.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

data class Counter(
    val id: String = "",
    val title: String = "",
    val count: Int = -1
)


data class CreateNewCounter(
    val title: String
)

data class IdCounter(
    val id: String
)

data class NewCounterResponse(
    val counter: Counter
)

data class CounterList(val counters: ArrayList<Counter> = arrayListOf())

//@Entity
//data class CounterEntity(
//    @PrimaryKey
//    val id: String = "",
//    @ColumnInfo(name = "title")
//    val title: String = "",
//    @ColumnInfo(name = "count")
//    val count: Int = -1
//)