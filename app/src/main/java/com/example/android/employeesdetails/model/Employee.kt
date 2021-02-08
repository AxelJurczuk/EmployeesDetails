package com.example.android.employeesdetails.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class Employee (val name:String, val email:String, val address: Address, val website:String):Parcelable

@Parcelize
data class Address (val geo: Geo): Parcelable

@Parcelize
data class Geo (val lat:Double, @Json(name="lng")val long:Double): Parcelable