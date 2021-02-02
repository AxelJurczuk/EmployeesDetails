package com.example.android.employeesdetails.data

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitUtil {

    fun getApiInstance (): ApiEmployee {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

        return retrofit.create(ApiEmployee::class.java)
    }
}