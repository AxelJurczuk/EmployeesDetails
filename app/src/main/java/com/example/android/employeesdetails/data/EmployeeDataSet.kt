package com.example.android.employeesdetails.data

import com.example.android.employeesdetails.model.Employee
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EmployeeDataSet {

    private val api = RetrofitUtil.getApiInstance()

    fun getEmployeeList (callback:OnResultCallback){
        api.getEmployees().enqueue(object: Callback<List<Employee>> {
            override fun onResponse(
                call: Call<List<Employee>>,
                response: Response<List<Employee>>
            ) {
                if (response.isSuccessful){
                    val employeeList = response.body()?: return
                    callback.onResult(Result.Success(employeeList))
                }
                else{
                    callback.onResult(Result.Failure("Something went wrong"))
                }
            }
            override fun onFailure(call: Call<List<Employee>>, t: Throwable) {
                callback.onResult(Result.Failure(t.localizedMessage))
            }
        })
    }
    interface  OnResultCallback{
        fun onResult (result:Result)
    }
}