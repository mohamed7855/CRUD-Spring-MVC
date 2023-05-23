package com.project.springboot.cruddemo.service;

import com.project.springboot.cruddemo.dao.EmployeeRepository;
import com.project.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository thEmployeeRepository){
        this.employeeRepository=thEmployeeRepository;
    }
    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int theId) {
        Optional<Employee> result = employeeRepository.findById(theId);

        Employee thEmployee = null;

        if (result.isPresent()) {
            thEmployee = result.get();
        }else {
            // we didn't find the employee
            throw new RuntimeException("Did not find employee id - "+theId);
        }

        return thEmployee;
    }

    @Override
    public void save(Employee theEmployee) {
        employeeRepository.save(theEmployee);
    }

    @Override
    public void deleteById(int theId) {
        employeeRepository.deleteById(theId);
    }
}
