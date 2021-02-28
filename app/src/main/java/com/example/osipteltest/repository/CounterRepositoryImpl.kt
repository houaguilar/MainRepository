package com.example.osipteltest.repository

import com.example.osipteltest.data.model.Counter
import com.example.osipteltest.data.remote.RemoteCounterDataSource

class CounterRepositoryImpl (private val dataSourceRemote: RemoteCounterDataSource): CounterRepository {
    override suspend fun getCounters(): ArrayList<Counter> {
        return dataSourceRemote.getCounters()
    }

    override suspend fun postCounter(title: String): ArrayList<Counter> {
        return dataSourceRemote.postNewCounter(title)
    }
}