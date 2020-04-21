package com.example.mvvmrecyclerdemo.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.mvvmrecyclerdemo.R;
import com.example.mvvmrecyclerdemo.model.EmployeeBeen;

import java.util.ArrayList;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.MyViewHolder> {

    private Context mContext;
    ArrayList<EmployeeBeen.Datum> employeeBeenArrayList;

    public EmployeeAdapter(Context context, ArrayList<EmployeeBeen.Datum> employeeBeenArrayList)
    {
        this.mContext = context;
        this.employeeBeenArrayList = employeeBeenArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvEmployeeSalary.setText(employeeBeenArrayList.get(position).getEmployeeSalary());
        holder.tvEmployeeName.setText(employeeBeenArrayList.get(position).getEmployeeName());
    }

    @Override
    public int getItemCount() {
        return employeeBeenArrayList.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvEmployeeName, tvEmployeeSalary;
        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvEmployeeName = itemView.findViewById(R.id.tvEmployeeName);
            tvEmployeeSalary = itemView.findViewById(R.id.tvEmployeeSalary);
        }
    }
}
