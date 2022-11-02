package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.Authentication.Authentication;

public class AuthenticationSteps {
    @Steps
    Authentication authentication;

    @Given("I set login url")
    public void iSetLoginUrl() {
        authentication.setLoginUrl();
    }

    @And("I set {string} and {string}")
    public void iSetEmailAndPassword(String email, String password) {
        authentication.setLoginData(email, password);
    }

    @When("I request post auth")
    public void iRequestPostAuth() {
        authentication.requestPost();
    }

    @Given("I set user info url")
    public void iSetUserInfoUrl() {
        authentication.setUserInfoUrl();
    }

    @When("I request get user with token")
    public void iRequestGetUserWithToken() {
        authentication.getUserInfoWithToken();
    }

    @Then("I get user information")
    public void iGetUserInformation() {
        authentication.authSuccess();
    }

    @When("I request get user without token")
    public void iRequestGetUserWithoutToken() {
        authentication.getUserInfoWithoutToken();
    }

    @Then("I get unauthorized error")
    public void iGetUnauthorizedError() {
    }

    @Then("I get {string} as auth result")
    public void loginResult(String res) {
        if (res.equals("logged in")) {
            authentication.authSuccess();
        }
        else if (res.equals("invalid error")) {
            authentication.invalidError();
        } else if (res.equals("password error")) {
            authentication.passwordEmptyError();
        } else if (res.equals("email error")) {
            authentication.emailEmptyError();
        }
        else if (res.equals("fullname error")) {
            authentication.fullnameEmptyError();
        }
        else if (res.equals("duplicate error")) {
            authentication.duplicateError();
        }
        else {
            authentication.userNotFoundError();
        }
    }

    @Given("I set register url")
    public void iSetRegisterUrl() {
        authentication.setRegisterUrl();
    }

    @And("I set {string} and {string} and {string} as data")
    public void iSetAndAndAsData(String arg0, String arg1, String arg2) {
        authentication.setRegisterData(arg0, arg1, arg2);
    }

    @When("I set new data")
    public void iSetNewData() {
        String email = authentication.randomEmail();
        authentication.setRegisterData(email, "thispass", "fname lname");
    }

    @Then("I am registered")
    public void iAmRegistered() {
        authentication.authSuccess();
    }
}
