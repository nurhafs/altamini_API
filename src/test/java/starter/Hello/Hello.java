package starter.Hello;

import static net.serenitybdd.rest.SerenityRest.*;
import static org.hamcrest.Matchers.equalTo;

public class Hello {
    private String url;

    public void setUrl() {
        url = "https://alta-shop.herokuapp.com/api/hello";
    }

    public void requestGet() {
        given().header("Content-Type", "application/json");
        when().get(url);
    }

    public void getReply() {
        then().statusCode(200);
        then().body("data", equalTo("hello"));
    }
}
