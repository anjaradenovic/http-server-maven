package com.anjastanojevic;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String team_name;
    private List<Employee> employees;

    public Team(String team_name, List<Employee> employees) {
        this.team_name = team_name;
        this.employees = new ArrayList<>(employees);
    }

    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
