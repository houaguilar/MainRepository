package com.example.osipteltest.repository

import com.example.osipteltest.application.AppConstants
import com.example.osipteltest.data.model.*
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST

interface WebService {

    @GET("counters")
    suspend fun getListCounters(): ArrayList<Counter>

    @POST("counter")
    suspend fun postCounter(@Body createNewCounter: CreateNewCounter): ArrayList<Counter>

    @POST("counter/inc")
    suspend fun postIncCounter(@Body idCounter: IdCounter): ArrayList<Counter>

    @POST("counter/dec")
    suspend fun postDecCounter(@Body idCounter: IdCounter): ArrayList<Counter>

    @DELETE("counter")
    suspend fun deleteCounter(@Body idCounter: IdCounter): ArrayList<Counter>
}

object RetrofitClient {

    val webservice by lazy {
        Retrofit.Builder()
            .baseUrl(AppConstants.URL_BASE)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build().create(WebService::class.java)
    }

}