package com.spring5.practice;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

public class AppInitializer implements WebApplicationInitializer {

    public void onStartup(ServletContext servletContext) {

        // Load Spring web application configuration
        AnnotationConfigWebApplicationContext ac = new AnnotationConfigWebApplicationContext();
        ac.register(RootConfig.class);

        // activate dev/prod profile
        ac.getEnvironment().setActiveProfiles("prod");

        ac.refresh();

        servletContext.addListener(new ContextLoaderListener(ac));

        // Create and register the DispatcherServlet
        AnnotationConfigWebApplicationContext servletRegisterer = new AnnotationConfigWebApplicationContext();
        servletRegisterer.register(ServletConfig.class);
        ServletRegistration.Dynamic registration = servletContext.addServlet("servlet",
                new DispatcherServlet(servletRegisterer));
        registration.setLoadOnStartup(1);
        registration.addMapping("/");
    }
}