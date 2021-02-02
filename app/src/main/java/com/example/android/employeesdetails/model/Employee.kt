package com.example.android.employeesdetails.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Employee (val name:String, val email:String, val geo: Geo, val website:String):Parcelable

@Parcelize
data class Geo (val lat:Double, val lng:Double): Parcelable