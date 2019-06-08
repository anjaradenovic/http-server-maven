package com.anjastanojevic;

import java.util.ArrayList;
import java.util.List;

public class TeamDAOInMemory implements TeamDAO {

    private List<Team> teamList = new ArrayList<>();

    public TeamDAOInMemory(){
        Employee employee1 = new Employee("John", "Doe","architect", "j_doe", "jdoe@gmail.com");
        Employee employee2 = new Employee("Bob", "Williams","architect", "b_williams", "bwilliams@gmail.com");
        Employee employee3 = new Employee("Jane", "Piters","architect", "j_piters", "jpiters@gmail.com");

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee1);
        employeeList.add(employee2);
        employeeList.add(employee3);

        Team team1 = new Team("crveni", employeeList);
        Team team2 = new Team("zeleni", employeeList);
        Team team3 = new Team("ljubicasti", employeeList);

        teamList.add(team1);
        teamList.add(team2);
        teamList.add(team3);
    }


    @Override
    public List<Team> getAll() {
        return new ArrayList<>(teamList);
    }
}
