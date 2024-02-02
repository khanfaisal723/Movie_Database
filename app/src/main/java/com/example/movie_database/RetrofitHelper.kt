package com.example.movie_database

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetrofitHelper {
    companion object {
        val BASE_URL: String
            get() = "https://jsonplaceholder.typicode.com/"


        val retrofit
            get() = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()


    }

    @GET("posts")
    fun getData(): Call<List<Data>>
}