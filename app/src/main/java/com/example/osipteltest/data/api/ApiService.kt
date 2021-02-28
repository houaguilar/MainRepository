package com.example.osipteltest.data.api

import com.example.osipteltest.data.model.*
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

//interface ApiService {
//
//    @GET("counters")
//    fun getCounter(): Observable<ArrayList<Counter>>
//
//    @Headers("Content-Type: application/json")
//    @POST("counter")
//    fun createNewCounter(@Body createNewCounter: CreateNewCounter): Single<NewCounterResponse>
//
//    @Headers("Content-Type: application/json")
//    @POST("counter/inc")
//    fun incrementCounter(@Body idCounter: IdCounter): Single<NewCounterResponse>
//
//    @Headers("Content-Type: application/json")
//    @POST("counter/dec")
//    fun decrementCounter(@Body idCounter: IdCounter): Single<NewCounterResponse>
//}