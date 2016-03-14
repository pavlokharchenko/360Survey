package com.survey.controller;

import com.survey.config.WebAppConfigurationTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.*;

/**
 * @author Artur Myseliuk
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebAppConfigurationTest.class, com.survey.config.WebAppConfiguration.class})
@WebAppConfiguration
public class UserControllerTest {



    @Test
    public void testGetUsers() throws Exception {

    }

    @Test
    public void testGetUser() throws Exception {

    }

    @Test
    public void testSaveUser() throws Exception {

    }
}