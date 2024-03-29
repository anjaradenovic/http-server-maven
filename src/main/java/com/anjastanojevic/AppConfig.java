package com.anjastanojevic;

import org.glassfish.jersey.internal.inject.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;

import javax.inject.Singleton;
import javax.ws.rs.ApplicationPath;

@ApplicationPath("/")
public class AppConfig extends ResourceConfig {

    public AppConfig() {
        register(EmployeeEndpoint.class);
        register(new AbstractBinder() {
            @Override
            protected void configure() {
                bind(EmployeeDAOMySQL.class).to(EmployeeDAO.class).in(Singleton.class);
                bind(TeamDAOMySQL.class).to(TeamDAO.class).in(Singleton.class);
            }
        });
    }
}
