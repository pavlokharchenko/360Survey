package com.survey.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author Artur Myseliuk
 */

@Configuration
@EnableWebMvc
@ComponentScan("com.survey")
public class AppConfiguration extends WebMvcConfigurerAdapter {

}
