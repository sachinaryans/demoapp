package com.demoapp.rest.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.demoapp.rest.dao.EmployeeDAO;
import com.demoapp.rest.model.Employee;
import com.demoapp.rest.model.Employees;

// TODO: Auto-generated Javadoc
/**
 * The Class EmployeeController.
 * @author Sachin
 */
@RestController
@RequestMapping(path = "/employees")
public class EmployeeController 
{
    
    /** The employee dao. */
    @Autowired
    private EmployeeDAO employeeDao;
    
    /**
     * Gets the employees.
     *
     * @return the employees
     */
    @GetMapping(path="/", produces = "application/json")
    public Employees getEmployees() 
    {
        return employeeDao.getAllEmployees();
    }
    
    /**
     * Gets the employee bt id.
     *
     * @param id the id
     * @return the employee bt id
     */
    @GetMapping(path="/{id}", produces = "application/json")
    public Employee getEmployeeBtId(@PathVariable("id") int id) 
    {
    	if(employeeDao.getEmployeeById(id)==null) {
    		
    	}
        return employeeDao.getEmployeeById(id);
    }
    
    /**
     * Adds the employee.
     *
     * @param headerPersist the header persist
     * @param headerLocation the header location
     * @param employee the employee
     * @return the employee
     * @throws Exception the exception
     */
    @PostMapping(path= "/", consumes = "application/json", produces = "application/json")
    public Employee addEmployee(
                        @RequestHeader(name = "X-COM-PERSIST", required = true) String headerPersist,
                        @RequestHeader(name = "X-COM-LOCATION", required = false, defaultValue = "ASIA") String headerLocation,
                        @RequestBody Employee employee) 
                 throws Exception 
    {       
        //Generate resource id
        Integer id = employeeDao.getAllEmployees().getEmployeeList().size() + 1;
        employee.setId(id);
        
        //add resource
        employeeDao.addEmployee(employee);
        
        //Create resource location
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                                    .path("/{id}")
                                    .buildAndExpand(employee.getId())
                                    .toUri();
        
        //Send location in response
        return employee;
    }
    
    /**
     * Update employee.
     *
     * @param id the id
     * @param headerPersist the header persist
     * @param headerLocation the header location
     * @param employee the employee
     * @return the response entity
     * @throws Exception the exception
     */
    @PatchMapping(path= "/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> updateEmployee(@PathVariable("id") int id,
                        @RequestHeader(name = "X-COM-PERSIST", required = true) String headerPersist,
                        @RequestHeader(name = "X-COM-LOCATION", required = false, defaultValue = "ASIA") String headerLocation,
                        @RequestBody Employee employee) 
                 throws Exception 
    {       
        //Generate resource id

        
        //add resource
    	employee.setId(id);
        employeeDao.updateEmployeeById(employee);
        
        //Create resource location
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                                    .path("/{id}")
                                    .buildAndExpand(employee.getId())
                                    .toUri();
        
        //Send location in response
        return new ResponseEntity<>("Employee updated successfully", HttpStatus.OK);
    }
    
    /**
     * Delete employee.
     *
     * @param id the id
     * @return the response entity
     * @throws Exception the exception
     */
    @DeleteMapping(path= "/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> deleteEmployee(@PathVariable("id") int id
) 
                 throws Exception 
    {       
        //Generate resource id

        
        //add resource
        employeeDao.deleteEmployeeById(id);
        
        //Create resource location
        
        //Send location in response
        return new ResponseEntity<>("Employee deleted successfully", HttpStatus.OK);
    }
}
