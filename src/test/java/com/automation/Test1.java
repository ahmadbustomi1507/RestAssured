package com.automation;
import io.restassured.RestAssured;
// import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

// import org.testng.Assert;
import org.testng.annotations.Test;

import com.files.payload;
// import com.files.ReUsableMethods;
/**
 * Unit test for simple App.
 */
class Test1 {
    /**
     * Rigorous Test.
     */
    @Test
    void testApp() {
		RestAssured.baseURI= "https://rahulshettyacademy.com";
		given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body(payload.AddPlace()).when().post("maps/api/place/add/json")
		.then().assertThat().statusCode(200).body("scope", equalTo("APP"))
		.header("server", "Apache/2.4.41 (Ubuntu)").extract().response().asString();



  }

    
}
