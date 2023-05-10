package com.noor.fakeshopestore.data

import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitClient {

    private const val BASE_URL = "https://fakestoreapi.com/"

    private val moshi: Moshi = Moshi.Builder().build()
    private val retrofit: Retrofit by lazy {
        val client = OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor()).build()
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()

    }
}