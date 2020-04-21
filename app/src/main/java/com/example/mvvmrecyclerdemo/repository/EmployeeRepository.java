package com.example.mvvmrecyclerdemo.repository;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;


import com.example.mvvmrecyclerdemo.model.EmployeeBeen;
import com.example.mvvmrecyclerdemo.retrofit.ApiClient;
import com.example.mvvmrecyclerdemo.retrofit.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EmployeeRepository {
    private static final String TAG = EmployeeRepository.class.getSimpleName();
    private ApiInterface apiInterface;

    public EmployeeRepository()
    {
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
    }

    public LiveData<EmployeeBeen> getEmployees()
    {
        final MutableLiveData<EmployeeBeen> data = new MutableLiveData<>();
        apiInterface.getEmployees().enqueue(new Callback<EmployeeBeen>() {
            @Override
            public void onResponse(@NonNull Call<EmployeeBeen> call,@NonNull Response<EmployeeBeen> response) {
                Log.d(TAG,"Response: "+response);
                if(response.body()!= null)
                {
                    data.setValue(response.body());
                    Log.e(TAG,"Total Employee :"+response.body().getData().size());
                }
            }

            @Override
            public void onFailure(@NonNull Call<EmployeeBeen> call,@NonNull Throwable t) {
               data.setValue(null);
            }
        });
        return data;
    }
}
