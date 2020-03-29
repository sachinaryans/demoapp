package com.demoapp.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demoapp.rest.dao.EmployeeDAO;
import com.demoapp.rest.model.Employees;

// TODO: Auto-generated Javadoc
/**
 * The Class TestController.
 * @author Sachin
 */
@RestController
@RequestMapping(path = "/test")
public class TestController {
	
	/** The employee dao. */
	@Autowired
    private EmployeeDAO employeeDao;
    
    /**
     * Gets the employees.
     *
     * @return the employees
     */
    @GetMapping(path="/get", produces = "application/json")
    public Employees getEmployees() 
    {
        return employeeDao.getAllEmployees();
    }

}
