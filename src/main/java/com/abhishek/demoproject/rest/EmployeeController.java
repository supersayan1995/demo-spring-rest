package com.abhishek.demoproject.rest;

import com.abhishek.demoproject.dao.EmployeeDAOImpl;
import com.abhishek.demoproject.entity.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/employee")
public class EmployeeController
{
    private EmployeeDAOImpl employeeDAO;

    public EmployeeController(EmployeeDAOImpl theEmployeeDAO)
    {
        employeeDAO = theEmployeeDAO;
    }

    @GetMapping("/")
    public List<Employee> findAll()
    {
        return employeeDAO.findAll();
    }

    @GetMapping("/{id}")
    public Employee findById(@PathVariable int id)
    {
        return employeeDAO.findById(id);
    }

    @PostMapping("/")
    public void insertEmployee(@RequestBody Employee employee)
    {
        employeeDAO.insertEmployee(employee);
    }
}
