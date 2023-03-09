import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;

public class APITests {

    public static void task1Post(){
        JSONObject requestBody = new JSONObject();
        JSONArray locale = new JSONArray();
        locale.put("en");
        locale.put("de");

        requestBody.put("name", "item1");
        requestBody.put("locale", locale);
        requestBody.put("is_verified", true);
        requestBody.put("department_id", 3);

        Response response = RestAssured
                .given()
                .contentType(io.restassured.http.ContentType.JSON)
                .body(requestBody.toString())
                .when()
                .post("https://variousitems.org/api/items");

        assert response.getStatusCode() == 201;

        System.out.println(response.getBody().toString());
    }

    public static void task1Put(int entityId){
        JSONObject requestBody = new JSONObject();
        requestBody.put("name", "updatedName");

        Response response = RestAssured
                .given()
                .contentType(io.restassured.http.ContentType.JSON)
                .body(requestBody.toString())
                .when()
                .post("https://variousitems.org/api/items/" + entityId);

        assert response.getStatusCode() == 200;

        System.out.println(response.getBody().toString());
    }

    public static void task1Get(int entityId){
        Response response = RestAssured
                .given()
                .when()
                .get("https://variousitems.org/api/items/" + entityId);

        assert response.getStatusCode() == 200;

        System.out.println(response.getBody().toString());
    }

}
