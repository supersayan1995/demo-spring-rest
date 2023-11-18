package com.abhishek.demoproject.dao;

import com.abhishek.demoproject.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO
{
    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager)
    {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll()
    {
        TypedQuery<Employee> query = entityManager.createQuery("from Employee", Employee.class);
        return query.getResultList();
    }

    @Override
    public Employee findById(int id)
    {
        return entityManager.find(Employee.class, id);
    }

    @Override
    @Transactional
    public void insertEmployee(Employee employee)
    {
        entityManager.persist(employee);
    }
}
