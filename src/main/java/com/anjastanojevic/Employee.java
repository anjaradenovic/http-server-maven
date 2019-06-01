package com.anjastanojevic;

import com.google.gson.annotations.SerializedName;

public class Employee {

    @SerializedName("first_name")
    private String firstName;

    @SerializedName("last_name")
    private String lastName;

    @SerializedName("role")
    private String role;

    @SerializedName("user_name")
    private String userName;

    @SerializedName("email")
    private String email;


    public Employee(String firstName, String lastName, String role, String userName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.userName = userName;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
