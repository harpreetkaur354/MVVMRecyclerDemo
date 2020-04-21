package com.example.mvvmrecyclerdemo.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;


import com.example.mvvmrecyclerdemo.R;
import com.example.mvvmrecyclerdemo.adapters.EmployeeAdapter;
import com.example.mvvmrecyclerdemo.model.EmployeeBeen;
import com.example.mvvmrecyclerdemo.viewmodel.EmployeeViewModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvEmployees;
    private ProgressBar progressCircular;
    private LinearLayoutManager layoutManager;
    private EmployeeAdapter employeeAdapter;
    private ArrayList<EmployeeBeen.Datum> employeeBeenArrayList = new ArrayList<>();
    EmployeeViewModel employeeViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //initial method call
        initView();
        //get set data
        getSetEmployeesData();
    }

    public void initView()
    {
        rvEmployees = findViewById(R.id.rvEmployees);
        progressCircular = findViewById(R.id.progressCircular);

        layoutManager = new LinearLayoutManager(MainActivity.this);
        rvEmployees.setLayoutManager(layoutManager);
        rvEmployees.setHasFixedSize(true);
        //set adapter in recycler view
        employeeAdapter = new EmployeeAdapter(MainActivity.this,employeeBeenArrayList);
        rvEmployees.setAdapter(employeeAdapter);
        //view model
        employeeViewModel = ViewModelProviders.of(this).get(EmployeeViewModel.class);
    }

    private void getSetEmployeesData()
    {
        employeeViewModel.getEmployeeBeenLiveData().observe(this,employeeBeen->{
            if(employeeBeen != null)
            {
                progressCircular.setVisibility(View.GONE);
                List<EmployeeBeen.Datum> employeeList = employeeBeen.getData();
                employeeBeenArrayList.addAll(employeeList);
                employeeAdapter.notifyDataSetChanged();
            }
        });
    }
}
