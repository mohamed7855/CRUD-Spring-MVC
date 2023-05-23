package com.project.springboot.cruddemo.rest;

import com.project.springboot.cruddemo.entity.Employee;
import com.project.springboot.cruddemo.service.EmployeeService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeRestController {


    // load employee data
    private List<Employee> theEmployees;

    @PostConstruct
    private void loadData() {

        // create employees
        Employee emp1 = new Employee("Leslie", "Andrews", "leslie@luv2code.com");
        Employee emp2 = new Employee("Emma", "Baumgarten", "emma@luv2code.com");
        Employee emp3 = new Employee("Avani", "Gupta", "avani@luv2code.com");

        // create the list
        theEmployees = new ArrayList<>();

        // add to the list
        theEmployees.add(emp1);
        theEmployees.add(emp2);
        theEmployees.add(emp3);
    }

    // add mapping for "/list"

    @GetMapping("/list")
    public String listEmployees(Model theModel) {

        // add to the spring model
        theModel.addAttribute("employees", theEmployees);

        return "list-employees";
    }
}