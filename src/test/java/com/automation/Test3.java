package com.automation;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import java.nio.file.Paths;

import com.files.payload;
import com.google.common.io.Files;
import com.files.ReUsableMethods;

public class Test3 {

    // @Test(dataProvider = "booksData")
    @Test
    public void addBook(String aisle, String isbn) {

        // RestAssured.baseURI = "http://216.10.245.166";
        // String response = 
        // given().log().all()
        //     .header("Content-Type","application/json")
        //     .body(new String()
        // .when()
        //     .post("Library/Addbook.php")
        // .then()
        //     .assertThat().statusCode(200)
        //     .extract().response().asString();
        
        // System.out.println(response);

        // JsonPath js = ReUsableMethods.rawToJson(response);
        // // get the property
        // String id = js.get("ID");
        // System.out.println(id);
    }

    // @DataProvider(name="booksData")
    // public Object[][] getData() {
    //     // array collection of elements
    //     // multidimensional array = collection of arrays
    //     Object[][] stringMultiArray= {{"aaa","12341"},{"bbb","1826"},{"ccc","12313"}};
    //     return stringMultiArray;
    // }

    @AfterTest
    public void do_something() {
        System.out.println("This is after test");
    }

}
