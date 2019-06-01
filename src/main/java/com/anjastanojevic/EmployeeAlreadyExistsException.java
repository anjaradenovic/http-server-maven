package com.anjastanojevic;

public class EmployeeAlreadyExistsException extends Exception {

    public EmployeeAlreadyExistsException(String reason) {
        super(reason);
    }
}
