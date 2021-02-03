package com.example.android.employeesdetails.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class Employee (val name:String, val email:String, val geo: Geo, val website:String):Parcelable

@Parcelize
data class Geo (val lat:Double, @Json(name="lng")val long:Double): Parcelable