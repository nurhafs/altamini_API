package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.Order.Order;

public class OrderSteps {
    @Steps
    Order order;

    @Given("I set order url")
    public void iSetOrderUrl() {
        order.setUrl();
    }

    @When("I send request get with authorization")
    public void iSendRequestGetWithAuthorization() {
        order.requestGetWithToken();
    }

    @Then("I get my orders list")
    public void iGetMyOrdersList() {
        order.getOrderList();
    }

    @When("I send request get without authorization")
    public void iSendRequestGetWithoutAuthorization() {
        order.requestGetWithoutToken();
    }

    @Then("I get unauthorized")
    public void iGetUnauthorized() {
        order.unauthorizedError();
    }

    @Given("I set order url with {string} parameter")
    public void iSetOrderUrlWithParameter(String arg0) {
        order.setUrl();
        order.add("/" + arg0);
    }

    @Then("I get {string} order")
    public void iGetOrder(String arg0) {
        if (arg0.equals("specific")) {
            order.getOrder();
        } else if (arg0.equals("invalid syntax error")) {
            order.invalidSyntaxError();
        } else if (arg0.equals("unauthorized error")) {
            order.unauthorizedError();
        }

    }

    @And("I fill the form with token")
    public void iFillTheFormWithToken() {
        order.fillFormWithToken();
    }

    @When("I request post")
    public void iRequestPost() {
        order.requestPost();
    }

    @Then("order submitted")
    public void orderSubmitted() {
        order.orderSubmitted();
    }

    @And("I leave the form empty with token")
    public void iLeaveTheFormEmptyWithToken() {
        order.emptyFormWithToken();
    }

    @And("I fill the form")
    public void iFillTheForm() {
        order.fillFormWithoutToken();
    }

    @And("I leave the form empty")
    public void iLeaveTheFormEmpty() {
        order.emptyFormWithoutToken();
    }
}
