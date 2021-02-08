package com.example.android.employeesdetails.ui.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.employeesdetails.data.EmployeeDataSet
import com.example.android.employeesdetails.data.Result
import com.example.android.employeesdetails.model.Employee

class EmployeeViewModel : ViewModel() {


    val liveDataList = MutableLiveData<Result>()
    private val employeeDataSet = EmployeeDataSet()

    init {
        getEmployeeList()
    }

    private fun getEmployeeList (){
        employeeDataSet.getEmployeeList(object : EmployeeDataSet.OnResultCallback {
            override fun onResult(result: Result) {
                if (result is Result.Success){
                    liveDataList.value= result
                }
            }
        })
    }
    fun getListData (): LiveData<Result>{
        return liveDataList
    }

}