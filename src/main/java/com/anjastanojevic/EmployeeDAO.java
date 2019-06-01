package com.anjastanojevic;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    private List<Employee> employeeList = new ArrayList<>();
    private static EmployeeDAO instance;

    public static EmployeeDAO getInstance(){
        if(instance == null){
            instance = new EmployeeDAO();
        }

        return instance;
    }
    private EmployeeDAO(){

        Employee employee1 = new Employee("John", "Doe","architect", "j_doe", "jdoe@gmail.com");
        Employee employee2 = new Employee("Bob", "Williams","architect", "b_williams", "bwilliams@gmail.com");
        Employee employee3 = new Employee("Jane", "Piters","architect", "j_piters", "jpiters@gmail.com");

        employeeList.add(employee1);
        employeeList.add(employee2);
        employeeList.add(employee3);

    }

    public List<Employee> getAll() {
        return new ArrayList<>(employeeList);
    }

    public Employee findbyUsername(String employee_user_name) {
        for (Employee employee : employeeList) {
            if(employee.getUserName().equals(employee_user_name)){
                return employee;
            }
        }
        return null;
    }

    public void add(Employee employee) throws EmployeeAlreadyExistsException {
        for (Employee employee1 : employeeList) {
            if (employee1.getUserName().equals(employee.getUserName()) ||
                employee1.getEmail().equals(employee.getEmail())) {

                throw new EmployeeAlreadyExistsException("Vec postoji u bazi");
            }
        }
        employeeList.add(employee);
    }
}
