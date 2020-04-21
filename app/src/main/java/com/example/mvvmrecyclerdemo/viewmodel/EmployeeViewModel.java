package com.example.mvvmrecyclerdemo.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.mvvmrecyclerdemo.model.EmployeeBeen;
import com.example.mvvmrecyclerdemo.repository.EmployeeRepository;


public class EmployeeViewModel extends AndroidViewModel {
    private EmployeeRepository employeeRepository;
    private LiveData<EmployeeBeen> employeeBeenLiveData;

    public EmployeeViewModel(Application application)
    {
        super(application);

        employeeRepository = new EmployeeRepository();
        this.employeeBeenLiveData = employeeRepository.getEmployees();
    }

    public LiveData<EmployeeBeen> getEmployeeBeenLiveData()
    {
        return employeeBeenLiveData;
    }
}
