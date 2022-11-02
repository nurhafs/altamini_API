package starter.Authentication;

import org.json.simple.JSONObject;

import java.util.Random;

import static net.serenitybdd.rest.SerenityRest.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class Authentication {
    private String url;

    private String auth = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IlRoYXVyIiwiRW1haWwiOiJ0aGF1ckBtYWlsLmNvbSJ9.MQtDVCwaIvFycZV8nu32ZZEX55XGtlo-VkKpb1r-HaY";

    private JSONObject loginData(String email, String pass) {
        JSONObject body = new JSONObject();
        body.put("email", email);
        body.put("password", pass);
        return body;
    }

    private JSONObject registerData(String email, String pass, String fname) {
        JSONObject body = new JSONObject();
        body.put("email", email);
        body.put("password", pass);
        body.put("fullname", fname);
        return body;
    }

    public void setUserInfoUrl() { url = "https://alta-shop.herokuapp.com/api/auth/info"; }

    public void setRegisterUrl() { url = "https://alta-shop.herokuapp.com/api/auth/register"; }

    public void setLoginUrl() { url = "https://alta-shop.herokuapp.com/api/auth/login"; }

    public void setLoginData(String email, String pass) {
        given().header("Content-Type", "application/json")
                .body(loginData(email, pass).toJSONString());
    }

    public void setRegisterData(String email, String pass, String fullname) {
        given().header("Content-Type", "application/json")
                .body(registerData(email, pass, fullname).toJSONString());
    }

    public void getUserInfoWithToken() {
        given().header("Content-Type", "application/json")
                .header("Authorization", auth);
        when().get(url);
    }

    public void getUserInfoWithoutToken() {
        given().header("Content-Type", "application/json");
        when().get(url);
    }

    public void requestPost() {
        when().post(url);
    }

    public void authSuccess() {
        then().statusCode(200);
        then().body("data", notNullValue());
    }

    public void unauthorizedError() {
        then().statusCode(401);
        then().body("error", equalTo("token contains an invalid number of segments"));
    }

    public void invalidError() {
        then().statusCode(400);
        then().body("error", equalTo("email or password is invalid"));
    }

    public void emailEmptyError() {
        then().statusCode(400);
        then().body("error", equalTo("email is required"));
    }

    public void passwordEmptyError() {
        then().statusCode(400);
        then().body("error", equalTo("password is required"));
    }

    public void fullnameEmptyError() {
        then().statusCode(400);
        then().body("error", equalTo("fullname is required"));
    }

    public void userNotFoundError() {
        then().statusCode(400);
        then().body("error", equalTo("record not found"));
    }

    public void duplicateError() {
        then().statusCode(400);
        then().body("error", equalTo("ERROR: duplicate key value violates unique constraint \"users_email_key\" (SQLSTATE 23505)"));
    }

    public String randomEmail() {
        Random rand = new Random();
        String email = "mailer" + rand.nextInt() + "@mail.com";
        return email;
    }
}
