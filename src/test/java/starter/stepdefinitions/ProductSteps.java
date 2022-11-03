package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.Product.Product;

public class ProductSteps {
    @Steps
    Product product;

    @Given("I set product url")
    public void iSetProductUrl() {
        product.setUrl();
    }

    @When("request get product")
    public void requestGetProduct() {
        product.requestGet();
    }

    @Then("I get all products list")
    public void iGetAllProductsList() {
        product.success();
    }

    @And("I enter new product data")
    public void iEnterNewProductData() {
        product.enterNewData();
    }

    @When("I request post product")
    public void iRequestPostProduct() {
        product.requestPost();
    }

    @Then("I get new product detail")
    public void iGetNewProductDetail() {
        product.success();
    }

    @Then("I get error {int}")
    public void iGetError(int arg0) {
        product.statusCode(arg0);
    }

    @And("I enter empty product data")
    public void iEnterEmptyProductData() {
        product.enterEmptyData();
    }

    @When("I request get with valid id")
    public void iRequestGetWithValidId() {
        product.add("/30");
        product.requestGet();
    }

    @Then("I get product detail")
    public void iGetProductDetail() {
        product.success();
    }

    @When("I request get with invalid id")
    public void iRequestGetWithInvalidId() {
        product.add("/e");
        product.requestGet();
    }

    @Then("I get invalid syntax error")
    public void iGetInvalidSyntaxError() {
        product.invalidSyntaxError();
    }

    @When("I request delete with valid id")
    public void iRequestDeleteWithValidId() {
        product.add("/1");
        product.requestDelete();
    }

    @Then("I get null data")
    public void iGetNullData() {
        product.getNullData();
    }

    @When("I request delete with invalid id")
    public void iRequestDeleteWithInvalidId() {
        product.add("/e");
        product.requestDelete();
    }

    @When("I enter {string} with rating url")
    public void iEnterIdWithRatingUrl(String id) {
        product.add("/" + id + "/ratings");
    }

    @And("I input {int} rating")
    public void iInputRatingRating(int rating) {
        product.enterRating(rating);
    }

    @Then("I get {string} as result")
    public void iGetResultAsResult(String res) {
        if (res.equals("record not found error")) {
            product.recordNotFoundError();
        } else if (res.equals("changed ratings")) {
            product.checkRatings();
        } else if (res.equals("invalid syntax error")) {
            product.invalidSyntaxError();
        } else if (res.equals("unauthorized error")) {
            product.unauthorizedError();
        } else if (res.equals("product ratings")) {
            product.getRatings();
        } else {
            product.notFoundError();
        }

    }

    @And("I input {int} rating with authorization")
    public void iInputRatingRatingWithAuthorization(int rate) {
        product.enterRatingWithToken(rate);
    }

    @And("I request get product")
    public void iRequestGetProduct() {
        product.requestGet();
    }

    @When("I enter valid id with comment url")
    public void iEnterValidIdWithCommentUrl() {
        product.add("/31/comments");
    }

    @Then("I get comments of the product")
    public void iGetCommentsOfTheProduct() {
        product.commentsResponse();
    }

    @When("I enter invalid id with comment url")
    public void iEnterInvalidIdWithCommentUrl() {
        product.add("/e/comments");
    }

    @And("I fill the comments")
    public void iFillTheComments() {
        product.fillCommentWithoutToken("This is a comment");
    }

    @Then("My comment is submitted")
    public void myCommentIsSubmitted() {
        product.commentsSubmitted();
    }

    @And("I leave the comments empty")
    public void iLeaveTheCommentsEmpty() {
        product.fillCommentWithoutToken("");
    }

    @And("I fill the comments with token")
    public void iFillTheCommentsWithToken() {
        product.fillCommentWithToken("This is a comment");
    }

    @And("I leave the comments empty with token")
    public void iLeaveTheCommentsEmptyWithToken() {
        product.fillCommentWithToken("");
    }

    @And("I enter new product data with token")
    public void iEnterNewProductDataWithToken() {
        product.enterNewDataWithToken();
    }

    @And("I enter empty product data with token")
    public void iEnterEmptyProductDataWithToken() {
        product.enterEmptyDataWithToken();
    }
}
