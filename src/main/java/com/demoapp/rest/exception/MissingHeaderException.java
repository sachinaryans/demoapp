package com.demoapp.rest.exception;

// TODO: Auto-generated Javadoc
/**
 * The Class MissingHeaderException.
 * @author Sachin
 */
public class MissingHeaderException extends RuntimeException
{
    
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /**
     * Instantiates a new missing header exception.
     *
     * @param exception the exception
     */
    public MissingHeaderException(String exception) {
        super(exception);
    }
}
