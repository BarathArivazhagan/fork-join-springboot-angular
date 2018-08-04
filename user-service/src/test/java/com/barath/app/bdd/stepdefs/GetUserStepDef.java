package com.barath.app.bdd.stepdefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GetUserStepDef {

    @Given("^the user saved with user name \"([^\"]*)\" and user id (\\d+)$")
    public void the_user_saved_with_user_name_and_user_id(String arg1, int arg2) throws Throwable {

    }

    @When("^the client calls GET \"([^\"]*)\" with user id as (\\d+)$")
    public void the_client_calls_GET_with_user_id_as(String arg1, int arg2) throws Throwable {

    }

    @Then("^the response contains user id (\\d+)$")
    public void the_response_contains_user_id(int arg1) throws Throwable {

    }

    @When("^the client calls GET \"([^\"]*)\" with user name as \"([^\"]*)\" in uri variable$")
    public void the_client_calls_GET_with_user_name_as_in_uri_variable(String arg1, String arg2) throws Throwable {

    }

    @Then("^the response contains user name \"([^\"]*)\"$")
    public void the_response_contains_user_name(String arg1) throws Throwable {

    }

}
