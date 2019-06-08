package com.anjastanojevic;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> getAll();

    Employee findbyUsername(String employee_user_name);

    void add(Employee employee) throws EmployeeAlreadyExistsException;
}
