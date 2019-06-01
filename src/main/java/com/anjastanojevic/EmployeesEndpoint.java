package com.anjastanojevic;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/")
public class EmployeesEndpoint {

    @GET
    @Path("api/employees")
    @Produces(MediaType.APPLICATION_JSON)
    public String employees() {

        List<Employee> employeesList = EmployeeDAO.getInstance().getAll();

//        String json = new Gson().toJson(employeeList);
        String json = new GsonBuilder().setPrettyPrinting().create().toJson(employeesList);
        return json;
    }

    @GET
    @Path("api/employees/{user_name}")
    @Produces(MediaType.APPLICATION_JSON)
    public String employees(@PathParam("user_name") String employee_user_name) {

        Employee employee = EmployeeDAO.getInstance().findbyUsername(employee_user_name);
        String json = new GsonBuilder().setPrettyPrinting().create().toJson(employee);
        return json;
    }

    @POST
    @Path("api/employees")
    @Produces(MediaType.TEXT_PLAIN)
    public String addEmployee(String employeeAsJson) {

        Employee employee = new Gson().fromJson(employeeAsJson, Employee.class);

        try {
            EmployeeDAO employeeDAO = EmployeeDAO.getInstance();
            employeeDAO.add(employee);

            return "Added";
        } catch (EmployeeAlreadyExistsException e) {
            return "Employee already exists";
        }
    }
}
