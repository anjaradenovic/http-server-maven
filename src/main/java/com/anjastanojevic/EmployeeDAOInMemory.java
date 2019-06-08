package com.anjastanojevic;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOInMemory implements EmployeeDAO {
    private List<Employee> employeeList = new ArrayList<>();

    public EmployeeDAOInMemory(){

        Employee employee1 = new Employee("John", "Doe","architect", "j_doe", "jdoe@gmail.com");
        Employee employee2 = new Employee("Bob", "Williams","architect", "b_williams", "bwilliams@gmail.com");
        Employee employee3 = new Employee("Jane", "Piters","architect", "j_piters", "jpiters@gmail.com");

        employeeList.add(employee1);
        employeeList.add(employee2);
        employeeList.add(employee3);

    }

    @Override
    public List<Employee> getAll() {
        System.out.println("pozvan getall nad objektom sa heskodom "+ this.hashCode());

        return new ArrayList<>(employeeList);
    }

    @Override
    public Employee findbyUsername(String employee_user_name) {
        for (Employee employee : employeeList) {
            if(employee.getUserName().equals(employee_user_name)){
                return employee;
            }
        }
        return null;
    }

    @Override
    public void add(Employee employee) throws EmployeeAlreadyExistsException {
        System.out.println("pozvan add nad objektom sa heskodom "+ this.hashCode());

        for (Employee employee1 : employeeList) {
            if (employee1.getUserName().equals(employee.getUserName()) ||
                employee1.getEmail().equals(employee.getEmail())) {

                throw new EmployeeAlreadyExistsException("Vec postoji u bazi");
            }
        }
        employeeList.add(employee);
    }
}
