package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.Category.Category;

public class CategorySteps {
    @Steps
    Category category;

    @Given("I set category url")
    public void iSetCategoryUrl() {
        category.setUrl();
    }

    @And("I filled new category data with token")
    public void iFilledNewCategoryDataWithToken() {
        category.setFilledDataWithToken();
    }

    @When("I request post category")
    public void iRequestPostCategory() {
        category.requestPost();
    }

    @Then("New category created")
    public void newCategoryCreated() {
        category.newCategory();
    }

    @And("I leave new category data empty with token")
    public void iLeaveNewCategoryDataEmptyWithToken() {
        category.setEmptyDataWithToken();
    }

    @And("I filled new category data")
    public void iFilledNewCategoryData() {
        category.setFilledDataWithoutToken();
    }

    @And("I leave new category data empty")
    public void iLeaveNewCategoryDataEmpty() {
        category.setEmptyDataWithoutToken();
    }

    @When("I request get category")
    public void iRequestGetCategory() {
        category.requestGet();
    }

    @Then("I see all categories list")
    public void iSeeAllCategoriesList() {
        category.categoryList();
    }

    @And("I add {string} to url")
    public void iAddIdToUrl(String id) {
        category.add("/" + id);
        category.setCatTemp(id);
    }

    @Then("I get {string}")
    public void iGetResult(String result) {
        if (result.equals("category")) {
            category.categoryResponse();
        } else {
            category.invalidSyntaxError();
        }
    }
}
