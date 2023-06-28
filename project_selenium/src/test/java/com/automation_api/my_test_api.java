package com.automation_api;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.Assert;

public class my_test_api {
        @Test
        public void test_api_1() {
                // RestAssured.baseURI ="";
                String token_response = given()
                                .queryParams("code", "")
                                .queryParams("client_id",
                                                "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
                                .queryParams("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
                                .queryParams("redirect_url", "https://rahulshettyacademy.com/getCourse.php")
                                .queryParams("grant_type", "authorization_code")
                                .when().log().all()
                                .post("https://www.googleapis.com/oauth2/v4/token").asString();
                JsonPath js = new JsonPath(token_response);
                String access_token = js.getString("access_token");

                String response = given().queryParam("access_token", access_token)
                                .when().log().all().get("https://rahulshettyacademy.com/getCourse.php").asString();
                String fs = String.format("This is my response : \n %s", response);
                System.out.println(fs);
                // .then().assertThat().log().all().statusCode(200).body("msg", equalTo("Address
                // successfully updated"));
        }

//        @Test
//        public void test_api_2_with_RequestSpecBuilder_ResponseSpecBuilder() {
//                RequestSpecBuilder req = new RequestSpecBuilder().setContentType(ContentType.JSON)
//                                .setBaseUri("sample")
//                                .addQueryParam("paramName", "paramValue")
//                                .build();
//                ResponseSpecBuilder res = new ResponseSpecBuilder().expectStatusCode(200)
//                                .expectContentType(ContentType.JSON).build();
//                // given().spec(req).body("sampleBOdy").when().post("theCollection").then().spec(res).extract().response();
//
//        }
}
