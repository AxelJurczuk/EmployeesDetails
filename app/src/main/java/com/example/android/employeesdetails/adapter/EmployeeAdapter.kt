package com.example.android.employeesdetails.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android.employeesdetails.R
import com.example.android.employeesdetails.model.Employee

class EmployeeAdapter(private val context:Context):RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder>() {
    private val employeeList= emptyList<Employee>()

    class EmployeeViewHolder (private val view: View): RecyclerView.ViewHolder(view){
        val employeeName:TextView= view.findViewById(R.id.tv_name)
        val employeeEmail:TextView= view.findViewById(R.id.tv_email)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list_employee, parent,false)
        return EmployeeViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: EmployeeViewHolder, position: Int) {
        val item = employeeList[position]
        holder.employeeName.text = item.name
        holder.employeeEmail.text = item.email
    }

    override fun getItemCount(): Int {
       return employeeList.size
    }
}