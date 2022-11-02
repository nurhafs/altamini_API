package starter.Category;

import org.json.simple.JSONObject;

import static net.serenitybdd.rest.SerenityRest.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class Category {
    private String url, catTemp;

    private String auth = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IlRoYXVyIiwiRW1haWwiOiJ0aGF1ckBtYWlsLmNvbSJ9.MQtDVCwaIvFycZV8nu32ZZEX55XGtlo-VkKpb1r-HaY";


    private JSONObject filledForm() {
        JSONObject body = new JSONObject();
        body.put("name", "geming");
        body.put("description", "bukan untuk dimakan");
        return body;
    }

    private JSONObject emptyForm() {
        JSONObject body = new JSONObject();
        body.put("name", "");
        body.put("description", "");
        return body;
    }

    public void setUrl() {
        url="https://alta-shop.herokuapp.com/api/categories";
    }

    public void add(String s) {
        url = url + s;
    }

    public void setCatTemp(String s) {
        catTemp = s;
    }

    public void setFilledDataWithToken() {
        given().header("Content-Type", "application/json")
                .header("Authorization", auth)
                .body(filledForm().toJSONString());
    }

    public void setFilledDataWithoutToken() {
        given().header("Content-Type", "application/json")
                .body(filledForm().toJSONString());
    }

    public void setEmptyDataWithToken() {
        given().header("Content-Type", "application/json")
                .header("Authorization", auth)
                .body(emptyForm().toJSONString());
    }

    public void setEmptyDataWithoutToken() {
        given().header("Content-Type", "application/json")
                .body(emptyForm().toJSONString());
    }

    public void requestPost() {
        when().post(url);
    }

    public void requestGet() {
        when().get(url);
    }

    public void newCategory() {
        then().statusCode(200);
        then().body("data.Name", equalTo("geming"));
        then().body("data.Description", equalTo("bukan untuk dimakan"));
    }

    public void categoryList() {
        then().statusCode(200);
        then().body("data", notNullValue());
    }

    public void categoryResponse() {
        then().statusCode(200);
        then().body("data.ID", equalTo(Integer.parseInt(catTemp)));
    }

    public void invalidSyntaxError() {
        then().statusCode(400);
        then().body("error", equalTo("strconv.Atoi: parsing \"e\": invalid syntax"));
    }
}
