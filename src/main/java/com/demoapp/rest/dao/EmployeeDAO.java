package com.demoapp.rest.dao;

import org.springframework.stereotype.Repository;

import com.demoapp.rest.model.Employee;
import com.demoapp.rest.model.Employees;

// TODO: Auto-generated Javadoc
/**
 * The Class EmployeeDAO.
 * @author Sachin
 */
@Repository
public class EmployeeDAO 
{
    
    /** The list. */
    private static Employees list = new Employees();
    
    static 
    {
        list.getEmployeeList().add(new Employee(1, "Lokesh", "Gupta", "howtodoinjava@gmail.com","","","",""));
        list.getEmployeeList().add(new Employee(2, "Alex", "Kolenchiskey", "abc@gmail.com","","","",""));
        list.getEmployeeList().add(new Employee(3, "David", "Kameron", "titanic@gmail.com","","","",""));
    }
    
    /**
     * Gets the all employees.
     *
     * @return the all employees
     */
    public Employees getAllEmployees() 
    {
        return list;
    }
    
    /**
     * Adds the employee.
     *
     * @param employee the employee
     */
    public void addEmployee(Employee employee) {
        list.getEmployeeList().add(employee);
    }
    
    /**
     * Gets the employee by id.
     *
     * @param id the id
     * @return the employee by id
     */
    public Employee getEmployeeById(int id) {
    	Employee em=null;
    	for(Employee employee:list.getEmployeeList()) {
    		if(employee.getId() == id) {
    			em = employee;
    			break;
    		}
    	}
    	return em;
    }
    
    /**
     * Update employee by id.
     *
     * @param emp the emp
     * @return the employee
     */
    public Employee updateEmployeeById(Employee emp) {
    	Employee em=null;
    	for(Employee employee:list.getEmployeeList()) {
    		if(employee.getId() == emp.getId()) {
    			if(emp.getEmail()!=null) {
    				employee.setEmail(emp.getEmail());
    			}
    			if(emp.getFirstName()!=null) {
    				employee.setFirstName(emp.getFirstName());
    			}
    			 if(emp.getLastName()!=null) {
    				 employee.setLastName(emp.getLastName()); 
    			 }
    			
    			break;
    		}
    	}
    	return em;
    }
    
    /**
     * Delete employee by id.
     *
     * @param id the id
     */
    public void deleteEmployeeById(int id) {
    	for(Employee employee:list.getEmployeeList()) {
    		if(employee.getId() == id) {
    			list.getEmployeeList().remove(employee);
    			break;
    		}
    	}
    }
}
