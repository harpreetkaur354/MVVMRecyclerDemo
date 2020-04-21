package com.example.mvvmrecyclerdemo.retrofit;


import com.example.mvvmrecyclerdemo.model.EmployeeBeen;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface
{
    @GET("v1/employees")
    Call<EmployeeBeen> getEmployees();
}
