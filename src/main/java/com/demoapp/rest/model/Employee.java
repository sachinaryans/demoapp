package com.demoapp.rest.model;

// TODO: Auto-generated Javadoc
/**
 * The Class Employee.
 * @author Sachin
 */
public class Employee {

    /**
     * Instantiates a new employee.
     */
    public Employee() {

    }

    /**
     * Instantiates a new employee.
     *
     * @param id the id
     * @param firstName the first name
     * @param lastName the last name
     * @param email the email
     * @param salutation the salutation
     * @param dob the dob
     * @param sex the sex
     * @param carCompany the car company
     */
    public Employee(Integer id, String firstName, String lastName, String email,String salutation,String dob,String sex,String carCompany) {
        super();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.carCompany=carCompany;
        this.dob=dob;
        this.salutation=salutation;
        this.sex=sex;
    }
 
    /** The id. */
    private Integer id;
    
    /** The first name. */
    private String firstName;
    
    /** The last name. */
    private String lastName;
    
    /** The email. */
    private String email;
    
    /** The salutation. */
    private String salutation;
    
    /** The dob. */
    private String dob;
    
    /** The sex. */
    private String sex;
    
    /** The car company. */
    private String carCompany;
    

    /**
     * Gets the salutation.
     *
     * @return the salutation
     */
    public String getSalutation() {
		return salutation;
	}

	/**
	 * Sets the salutation.
	 *
	 * @param salutation the new salutation
	 */
	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}

	/**
	 * Gets the dob.
	 *
	 * @return the dob
	 */
	public String getDob() {
		return dob;
	}

	/**
	 * Sets the dob.
	 *
	 * @param dob the new dob
	 */
	public void setDob(String dob) {
		this.dob = dob;
	}

	/**
	 * Gets the sex.
	 *
	 * @return the sex
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * Sets the sex.
	 *
	 * @param sex the new sex
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * Gets the car company.
	 *
	 * @return the car company
	 */
	public String getCarCompany() {
		return carCompany;
	}

	/**
	 * Sets the car company.
	 *
	 * @param carCompany the new car company
	 */
	public void setCarCompany(String carCompany) {
		this.carCompany = carCompany;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Integer getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param id the new id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name.
     *
     * @param firstName the new first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name.
     *
     * @param lastName the new last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email.
     *
     * @param email the new email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
    }
}
