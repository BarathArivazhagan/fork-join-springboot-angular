package com.barath.app.bdd.stepdefs;

import com.barath.app.bdd.AbstractSpringConfigurationTest;
import com.barath.app.entity.User;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.lang.invoke.MethodHandles;

public class NewUserStepDef extends AbstractSpringConfigurationTest {

    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private ResponseEntity<String> response=null;

    @Given("^the user with user details$")
    public void the_user_with_user_details(String userJson) throws Throwable {

        String url = buildUrl(HOST,PORT,"/users/new");
//        User user = (User)convertJsonToObject(userJson,User.class);
//        logger.info("user {}",user.toString());
        HttpEntity<Object> requestEntity=new HttpEntity<>(userJson,getDefaultHttpHeaders());
        response=invokeRESTCall(url, HttpMethod.POST, requestEntity);
        System.out.println("Response "+response);
    }

    @When("^the client calls \"([^\"]*)\" with the given details$")
    public void the_client_calls_with_the_given_details(String arg1) throws Throwable {

    }

    @Then("^the client receives status code of (\\d+)$")
    public void the_client_receives_status_code_of(int arg1) throws Throwable {

    }

    @Then("^the response contains user details$")
    public void the_response_contains_user_details(String arg1) throws Throwable {

    }
}
