package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.Hello.Hello;

public class HelloSteps {
    @Steps
    Hello hello;

    @Given("I set hello url")
    public void iSetHelloUrl() {
        hello.setUrl();
    }

    @When("i send get request")
    public void iSendGetRequest() {
        hello.requestGet();
    }

    @Then("I get reply")
    public void iGetReply() {
        hello.getReply();
    }
}
