package starter.Product;

import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static net.serenitybdd.rest.SerenityRest.*;
import static org.hamcrest.Matchers.*;

public class Product {
    private String url, commentTemp;

    private int assignedRate;

    private String auth = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IlRoYXVyIiwiRW1haWwiOiJ0aGF1ckBtYWlsLmNvbSJ9.MQtDVCwaIvFycZV8nu32ZZEX55XGtlo-VkKpb1r-HaY";

    private JSONObject filledData() {
        JSONObject body = new JSONObject();
        List<Integer> cats = new ArrayList<Integer>();
        cats.add(2);
        body.put("name", "Xbox PS5");
        body.put("description", "we just want to have fun");
        body.put("price", 399);
        body.put("categories", cats);
        return body;
    }

    private JSONObject emptyData() {
        JSONObject body = new JSONObject();
        body.put("name", "");
        body.put("description", "");
        body.put("price", null);
        body.put("categories", null);
        return body;
    }

    private JSONObject rating(int rate) {
        JSONObject body = new JSONObject();
        body.put("count", rate);
        return body;
    }

    private JSONObject comment(String comment) {
        JSONObject body = new JSONObject();
        body.put("content", comment);
        return body;
    }

    public void setUrl() {
        url="https://alta-shop.herokuapp.com/api/products";
    }

    public void add(String s) {
        url = url + s;
    }

    public void enterNewData() {
        given().header("Content-Type", "application/json")
                .body(filledData().toJSONString());
    }

    public void enterEmptyData() {
        given().header("Content-Type", "application/json")
                .body(emptyData().toJSONString());
    }

    public void enterRating(int rate) {
        given().header("Content-Type", "application/json")
                .body(rating(rate).toJSONString());
    }

    public void enterRatingWithToken(int rate) {
        assignedRate = rate;
        given().header("Content-Type", "application/json")
                .header("Authorization", auth)
                .body(rating(rate).toJSONString());
    }

    public void requestGet() {
        given().header("Content-Type", "application/json");
        when().get(url);
    }

    public void requestPost() {
        when().post(url);
    }

    public void requestDelete() {
        given().header("Content-Type", "application/json");
        when().delete(url);
    }

    public void success() {
        then().statusCode(200);
        then().body("data", notNullValue());
    }

    public void statusCode(int arg) {
        then().statusCode(arg);
    }

    public void invalidSyntaxError() {
        then().statusCode(400);
        then().body("error", equalTo("strconv.Atoi: parsing \"e\": invalid syntax"));
    }

    public void getNullData() {
        then().statusCode(200);
        then().body("data", equalTo(null));
    }

    public void recordNotFoundError() {
        then().statusCode(500);
        then().body("error", equalTo("record not found"));
    }

    public void checkRatings() {
        then().statusCode(200);
        then().body("data.Ratings", equalTo(assignedRate));
    }

    public void unauthorizedError() {
        then().statusCode(401);
        then().body("error", equalTo("unauthorized"));
    }

    public void notFoundError() {
        then().statusCode(404);
    }

    public void commentsResponse() {
        then().statusCode(200);
        then().body(notNullValue());
    }

    public void fillCommentWithToken(String cm) {
        commentTemp = cm;
        given().header("Content-Type", "application/json")
                .header("Authorization", auth)
                .body(comment(cm).toJSONString());
    }

    public void fillCommentWithoutToken(String cm) {
        commentTemp = cm;
        given().header("Content-Type", "application/json")
                .body(comment(cm).toJSONString());
    }

    public void commentsSubmitted() {
        then().statusCode(200);
        then().body("data.Content", equalTo(commentTemp));
    }

    public void getRatings() {
        then().statusCode(200);
        then().body("data", notNullValue());
    }

}
