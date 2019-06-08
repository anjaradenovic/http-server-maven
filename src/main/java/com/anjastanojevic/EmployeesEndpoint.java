package com.anjastanojevic;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/api/employees")
public class EmployeesEndpoint {

    private EmployeeDAO employeeDAO;

    @Inject
    public EmployeesEndpoint(EmployeeDAO employeeDAO){
        this.employeeDAO = employeeDAO;
        System.out.println("EmployeesEndpoint sa hashcodom " + this.hashCode() + " koristi EmployeeDAO sa haschodom " + employeeDAO.hashCode());
    }

    @GET
    @Path("")
    @Produces(MediaType.APPLICATION_JSON)
    public String employees() {

        List<Employee> employeesList = employeeDAO.getAll();

//        String json = new Gson().toJson(employeeList);
        String json = new GsonBuilder().setPrettyPrinting().create().toJson(employeesList);
        return json;
    }

    @GET
    @Path("/{user_name}")
    @Produces(MediaType.APPLICATION_JSON)
    public String employees(@PathParam("user_name") String employee_user_name) {

        Employee employee = employeeDAO.findbyUsername(employee_user_name);
        String json = new GsonBuilder().setPrettyPrinting().create().toJson(employee);
        return json;
    }

    @POST
    @Path("")
    @Produces(MediaType.TEXT_PLAIN)
    public String addEmployee(String employeeAsJson) {

        Employee employee = new Gson().fromJson(employeeAsJson, Employee.class);

        try {
            employeeDAO.add(employee);

            return "Added";
        } catch (EmployeeAlreadyExistsException e) {
            return "Employee already exists";
        }
    }
}
