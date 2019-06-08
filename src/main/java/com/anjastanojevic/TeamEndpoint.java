package com.anjastanojevic;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/api/teams")
public class TeamEndpoint {

    private TeamDAO teamDAO;

    @Inject
    public TeamEndpoint(TeamDAO teamDAO){
        this.teamDAO = teamDAO;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String teams() {

        List<Team> teamList = teamDAO.getAll();

        //String json = new Gson().toJson(teamList);
        String json = new GsonBuilder().setPrettyPrinting().create().toJson(teamList);
        return json;

    }

    @GET
    @Path("/{team_name}")
    @Produces(MediaType.APPLICATION_JSON)
    public String teams(@PathParam("team_name") String team_name) {
        Employee employee1 = new Employee("John", "Doe","architect", "j_doe", "jdoe@gmail.com");
        Employee employee2 = new Employee("Bob", "Williams","architect", "b_williams", "bwilliams@gmail.com");
        Employee employee3 = new Employee("Jane", "Piters","architect", "j_piters", "jpiters@gmail.com");

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee1);
        employeeList.add(employee2);
        employeeList.add(employee3);

        Team team1 = new Team("red", employeeList);
        Team team2 = new Team("yellow", employeeList);
        Team team3 = new Team("green", employeeList);

        List<Team> teamList = new ArrayList<>();
        teamList.add(team1);
        teamList.add(team2);
        teamList.add(team3);

        for (Team team : teamList) {
            if(team.getTeam_name().equals(team_name)){
                return new Gson().toJson(team);
            }
        }
        return "team doesn't exist";
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String addTeam() {
        //TODO add support for adding teams
        return "Not yet implemented";
    }
}
