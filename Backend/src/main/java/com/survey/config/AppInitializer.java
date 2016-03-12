package com.survey.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * @author Artur Myseliuk
 */

public class AppInitializer implements WebApplicationInitializer {
    private static final Logger LOGGER = LogManager.getLogger(AppInitializer.class.getName());

    private static final String CONFIG_LOCATION = "com.survey.config";

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        LOGGER.info("Initializing Application for " + servletContext.getServerInfo());

        // Create ApplicationContext
        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
        applicationContext.setConfigLocation(CONFIG_LOCATION);

        ServletRegistration.Dynamic servlet = servletContext.addServlet("mvc-dispatcher", new DispatcherServlet(applicationContext));

        servlet.addMapping("/");
        servlet.setAsyncSupported(true);
        servlet.setLoadOnStartup(1);
    }
}
