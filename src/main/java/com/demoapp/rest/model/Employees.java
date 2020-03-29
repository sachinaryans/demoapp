package com.demoapp.rest.model;

import java.util.ArrayList;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class Employees.
 * @author Sachin
 */
public class Employees 
{
    
    /** The employee list. */
    private List<Employee> employeeList;
    
    /**
     * Gets the employee list.
     *
     * @return the employee list
     */
    public List<Employee> getEmployeeList() {
        if(employeeList == null) {
            employeeList = new ArrayList<>();
        }
        return employeeList;
    }
 
    /**
     * Sets the employee list.
     *
     * @param employeeList the new employee list
     */
    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
