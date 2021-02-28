package com.example.osipteltest.data.api

import android.util.Log
import com.example.osipteltest.data.model.Counter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RequestListCounter{
//    companion object {
//        val BASE_URL = "http://localhost:3000/api/v1/"
//        fun getListCounters(): Observable<ArrayList<Counter>> {
//            return Observable.create {
//
//                //--Start Request
//                val retrofit = Retrofit.Builder()
//                    .baseUrl(BASE_URL)
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .build()
//
//                retrofit.create(ApiService::class.java)
//
//                val call: Call<ArrayList<Counter>> = retrofit.create(
//                    ApiService::class.java
//                ).getCounter()
//
////                val call: Call<ArrayList<ListProductModel>> = retrofit.create(
////                    ApiClient::class.java).getDjangoProduct()
//
//                //pone en cola de ejecucion la llamada al servicio
//                call.enqueue(
//
//                    object : Callback<ArrayList<Counter>> {
//                        override fun onFailure(call: Call<ArrayList<Counter>>, t: Throwable) {
//                            //si falla con error de servidor o error HTTP
//                            it.onError(t)
//                        }
//
//                        override fun onResponse(
//                            call: Call<ArrayList<Counter>>,
//                            response: Response<ArrayList<Counter>>
//                        ) {
//                            //si el servicio responde o me trae data
//                            if (response.isSuccessful) {
//                                val healLocations: ArrayList<Counter> =
//                                    response.body() as ArrayList<Counter>
//                                it.onNext(healLocations)
//                                it.onComplete()
//                                Log.v("response_locations", healLocations.size.toString())
//                            } else {
//                                //un error logico
//                                // it.onError(t)  la variable t deberia ser un error personalizado
//                            }
//                        }
//
//                    })
//                //--End Request
//            }
//
//        }
//
//    }
}