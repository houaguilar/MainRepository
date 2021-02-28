package com.example.osipteltest.data.api

import android.util.Log
import com.example.osipteltest.data.model.Counter
import com.example.osipteltest.data.model.CreateNewCounter
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

//object RequestCreateNewCounter {
//
//    private const val BASE_URL = "http://localhost:3000/api/v1/"
//
//    private fun createOkHttpClient(): OkHttpClient {
//        return OkHttpClient.Builder()
//            .addInterceptor { chain ->
//                var request = chain.request()
//                val url = request.url.newBuilder()
//                    .build()
//                request = request.newBuilder().url(url).build()
//                chain.proceed(request)
//            }
//            .connectTimeout(15, TimeUnit.SECONDS)
//            .writeTimeout(15, TimeUnit.SECONDS)
//            .readTimeout(15, TimeUnit.SECONDS)
//            .build()
//    }
//    private inline fun <reified T> createService(callAdapter: CallAdapter.Factory? = null): T {
//        val parseObject = GsonBuilder().create()
//        return Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .client(createOkHttpClient())
//            .apply {
//                callAdapter?.let { addCallAdapterFactory(it) }
//            }
//            .addConverterFactory(GsonConverterFactory.create(parseObject))
//            .build().create(T::class.java)
//    }
//    val rxr = createService<ApiService>(RxJava2CallAdapterFactory.create())


//    companion object {
//
//        val URL_BASE = "http://localhost:3000/api/v1/"
//
//        fun postNewCounter(title: String): Observable<Boolean> {
//            return Observable.create {
//
//                val retrofit = Retrofit.Builder()
//                    .baseUrl(URL_BASE)
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .build()
//
//                val newCounterData = CreateNewCounter(
//                    title
//                )
//
//                val call: Call<Key> =
//                    retrofit.create(ApiService::class.java).createNewCounter(newCounterData)
//
//                call.enqueue(
//                    object : Callback<Key> {
//                        override fun onResponse(call: Call<Key>?, response: Response<Key>?) {
//                            if (response!!.isSuccessful) {
//                                it.onNext(true)
//                                it.onComplete()
//                                val key = response.body() as Key
//                                Log.d("createCounter", "failure--" + key.key)
//                            } else {
//                                it.onNext(false)
//                                it.onComplete()
//                            }
//                        }
//
//                        override fun onFailure(call: Call<Key>?, t: Throwable?) {
//                            Log.d("createCounter", "failure--" + t.toString())
//                            it.onError(error(t.toString()))
//                        }
//                    })
//
//            }
//        }
//    }
//}