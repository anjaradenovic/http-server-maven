package com.anjastanojevic;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOMySQL implements EmployeeDAO{

    @Override
    public List<Employee> getAll() {
        List<Employee> employees = new ArrayList<>();

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/employee_management?" +
                    "user=root&password=root");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from employee");



            while(resultSet.next()){
                String first_name = resultSet.getString("first_name");
                String last_name = resultSet.getString("last_name");
                String role = resultSet.getString("role");
                String user_name = resultSet.getString("user_name");
                String email = resultSet.getString("email");

                Employee employee = new Employee(first_name, last_name, role, user_name, email);
                employees.add(employee);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    @Override
    public Employee findbyUsername(String employee_user_name) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/employee_management?" +
                    "user=root&password=root");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "select * from employee where employee.user_name = '" + employee_user_name + "'");

            if(resultSet.next()) {
                String first_name = resultSet.getString("first_name");
                String last_name = resultSet.getString("last_name");
                String role = resultSet.getString("role");
                String user_name = resultSet.getString("user_name");
                String email = resultSet.getString("email");

                return new Employee(first_name, last_name, role, user_name, email);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void add(Employee employee) throws EmployeeAlreadyExistsException {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/employee_management?" +
                    "user=root&password=root");
            Statement statement = connection.createStatement();
            int result = statement.executeUpdate(
                    "insert into employee (first_name, last_name, role, user_name, email) values ('"
                            + employee.getFirstName() + "', '"
                            + employee.getLastName() + "', '"
                            + employee.getRole() + "', '"
                            + employee.getUserName() + "', '"
                            + employee.getEmail() + "')");
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
