package com.example.osipteltest.data.remote

import com.example.osipteltest.data.model.Counter
import com.example.osipteltest.data.model.CounterList
import com.example.osipteltest.data.model.CreateNewCounter
import com.example.osipteltest.data.model.NewCounterResponse
import com.example.osipteltest.repository.WebService
import retrofit2.Call

class RemoteCounterDataSource (private val webService: WebService) {

    suspend fun getCounters(): ArrayList<Counter> = webService.getListCounters()

    suspend fun postNewCounter(title: String): ArrayList<Counter> = webService.postCounter(CreateNewCounter(title))
}