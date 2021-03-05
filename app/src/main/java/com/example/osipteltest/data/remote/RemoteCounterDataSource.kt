package com.example.osipteltest.data.remote

import com.example.osipteltest.data.model.*
import com.example.osipteltest.repository.WebService
import retrofit2.Call

class RemoteCounterDataSource (private val webService: WebService) {

    suspend fun getCounters(): ArrayList<Counter> = webService.getListCounters()

    suspend fun postNewCounter(title: String): ArrayList<Counter> = webService.postCounter(CreateNewCounter(title))

    suspend fun postIncCounter(id: String): ArrayList<Counter> = webService.postIncCounter(IdCounter(id))

    suspend fun postDecCounter(id: String): ArrayList<Counter> = webService.postDecCounter(IdCounter(id))

    suspend fun deleteCounter(id: String): ArrayList<Counter> = webService.deleteCounter(IdCounter(id))
}