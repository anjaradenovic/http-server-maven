package com.anjastanojevic;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TeamDAOMySQL implements TeamDAO{

    @Override
    public List<Team> getAll() {

        Connection connection = null;

        List<Team> teams = new ArrayList<>();

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/employee_management?" +
                    "user=root&password=root");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "select * from employee inner join team on employee.team_id=team.id");

            while(resultSet.next()) {

                String first_name = resultSet.getString("first_name");
                String last_name = resultSet.getString("last_name");
                String role = resultSet.getString("role");
                String user_name = resultSet.getString("user_name");
                String email = resultSet.getString("email");

                String team_name = resultSet.getString("team_name");

                Employee employee = new Employee(first_name, last_name, role, user_name, email);

                boolean isFound = false;
                for (Team team : teams) {
                    if(team.getTeam_name().equals(team_name)){
                        team.getEmployees().add(employee);
                        isFound = true;
                    }
                }

                if(isFound == false){
                    List<Employee> employees = new ArrayList<>();
                    employees.add(employee);
                    Team team = new Team(team_name,employees);
                    teams.add(team);
                }

            }
            return teams;
            } catch (SQLException e) {
            e.printStackTrace();
        }

        return teams;
    }
}
