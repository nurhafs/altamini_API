package starter.Order;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static net.serenitybdd.rest.SerenityRest.*;
import static org.hamcrest.Matchers.*;

public class Order {
    private String url;

    private String auth = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IlRoYXVyIiwiRW1haWwiOiJ0aGF1ckBtYWlsLmNvbSJ9.MQtDVCwaIvFycZV8nu32ZZEX55XGtlo-VkKpb1r-HaY";

    private JSONArray filledForm() {
       JSONObject product = new JSONObject();
       product.put("product_id", 16);
       product.put("quantity", 2);
       JSONArray products = new JSONArray();
       products.add(product);
       return products;
    }

    private JSONArray emptyForm() {
        JSONObject product = new JSONObject();
        JSONArray products = new JSONArray();
        products.add(product);
        return products;
    }

    public void setUrl() {
        url = "https://alta-shop.herokuapp.com/api/orders";
    }

    public void add(String s) {
        url = url + s;
    }
    public void fillFormWithToken() {
        given().header("Authorization", auth)
                .header("Content-Type", "application/json")
                .body(filledForm());
    }

    public void fillFormWithoutToken() {
        given().header("Content-Type", "application/json")
                .body(filledForm());
    }

    public void emptyFormWithToken() {
        given().header("Authorization", auth)
                .header("Content-Type", "application/json")
                .body(emptyForm());
    }

    public void emptyFormWithoutToken() {
        given().header("Content-Type", "application/json")
                .body(emptyForm());
    }

    public void requestPost() {
        when().post(url);
    }

    public void requestGetWithToken() {
        given().header("Authorization", auth)
                .header("Content-Type", "application/json");
        when().get(url);
    }

    public void requestGetWithoutToken() {
        given().header("Content-Type", "application/json");
        when().get(url);
    }

    public void getOrderList() {
        then().statusCode(200);
        then().body("data", notNullValue());
    }

    public void unauthorizedError() {
        then().statusCode(401);
        then().body("error", equalTo("unauthorized"));
    }

    public void invalidSyntaxError() {
        then().statusCode(400);
        then().body("error", equalTo("strconv.Atoi: parsing \"q\": invalid syntax"));
    }

    public void getOrder() {
        then().statusCode(200);
        then().body("data.ID", equalTo(1));
    }

    public void orderSubmitted() {
        then().statusCode(200);
        then().body("data.ID", notNullValue());
        then().body("data.User", notNullValue());
        then().body("data.Product", notNullValue());
    }
}
