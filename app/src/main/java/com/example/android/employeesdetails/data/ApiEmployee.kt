package com.example.android.employeesdetails.data

import com.example.android.employeesdetails.model.Employee
import retrofit2.Call
import retrofit2.http.GET

interface ApiEmployee {

    @GET("users")
    fun getEmployees (): Call<List<Employee>>
}