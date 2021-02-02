package com.example.android.employeesdetails.data

import com.example.android.employeesdetails.model.Employee

sealed class Result {
    data class Success (val employeeList:List<Employee>):Result()
    data class Failure (val errorMessage:String):Result()
}