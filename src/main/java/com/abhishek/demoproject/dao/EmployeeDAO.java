package com.abhishek.demoproject.dao;

import com.abhishek.demoproject.entity.Employee;

import java.util.List;

public interface EmployeeDAO
{
    List<Employee> findAll();
    Employee findById(int id);
    void insertEmployee(Employee employee);
}
