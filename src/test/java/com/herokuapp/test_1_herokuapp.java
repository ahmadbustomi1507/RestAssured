package com.herokuapp;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.AssertJUnit.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import com.files.payload;
import com.herokuapp.utility;


public class test_1_herokuapp {

    @BeforeTest
    public void set_driver() {
        RestAssured.baseURI= "https://restful-booker.herokuapp.com";
    }



    @Test(dataProvider ="bookingData" )    public void test_createBooking(String firstname, String lastname,
    int totalprice, Boolean depositpaid, String checkin, String checkout,
    String additionalneed) throws IOException {

        System.out.println("----Create the booking----");
        // TO DO fix the checkin and checkout from string to date formatter
        String payload = utility.createPayload(firstname,lastname,totalprice,depositpaid,checkin,checkout,additionalneed);
        // String payload = new String(Files.readAllBytes(Paths.get("E:\\Project\\JavaProject\\myProject\\project\\src\\test\\java\\com\\herokuapp\\testfile.json")));

        String response_create =given().log().all()
                            .header("Content-Type","application/json")
                            .body(payload).
                        when().
                            post("/booking").
                        then()
                            .assertThat().statusCode(200)
                            .extract().response().asString();
                            
        JsonPath respBody_create = new JsonPath(response_create);

        int resp_create_bookingid  = respBody_create.getInt("bookingid");
        assertEquals(firstname, respBody_create.get("booking.firstname"));
        assertEquals(lastname, respBody_create.get("booking.lastname"));
        assertEquals(totalprice, respBody_create.getInt("booking.totalprice"));
        assertTrue(depositpaid == respBody_create.getBoolean("booking.depositpaid"));
        assertEquals(checkin, respBody_create.get("booking.bookingdates.checkin"));
        assertEquals(checkout, respBody_create.get("booking.bookingdates.checkout"));
        assertEquals(additionalneed, respBody_create.get("booking.additionalneeds"));
        System.out.println(response_create);

        System.out.println("----Get the booking----");
        String response_get =given().log().all()
                            .header("Content-Type","application/json")
                            .pathParam("id",resp_create_bookingid).
                        when().
                            get("/booking/{id}").
                        then()
                            .assertThat().statusCode(200)
                            .extract().response().asString();

        JsonPath respBody_get = new JsonPath(response_get);
        System.out.println(response_get);

        assertEquals(firstname, respBody_get.get("firstname"));
        assertEquals(lastname, respBody_get.get("lastname"));
        assertEquals(totalprice, respBody_get.getInt("totalprice"));
        assertTrue(depositpaid == respBody_get.getBoolean("depositpaid"));
        assertEquals(checkin, respBody_get.get("bookingdates.checkin"));
        assertEquals(checkout, respBody_get.get("bookingdates.checkout"));
        assertEquals(additionalneed, respBody_get.get("additionalneeds"));
                            

    }

    @DataProvider(name="bookingData")
    public Object[][] getData() throws IOException {

        // string json
        // String path = "E:\\Project\\JavaProject\\myProject\\project\\src\\test\\java\\com\\herokuapp\\testfile.json";
        String dirPath = "E:\\Project\\JavaProject\\myProject\\project\\src\\test\\java\\com\\herokuapp";

        File dir = new File(dirPath);
        File[] listFile = dir.listFiles();

        for (File child : listFile){
            if (child.getName().contains("*.json")){
                String data = new String(child.getAbsoluteFile());
                JsonPath payload = new JsonPath(data);
                System.out.println(payload.getString("firstname"));
            }
        }
        // String data = new String(Files.readAllBytes(Paths.get(path)));
        // JsonPath payload = new JsonPath(data);
        // System.out.println(payload.getString("firstname"));

        Object[] array ={payload.getString("firstname"),
                        payload.getString("lastname"),
                        payload.getInt("totalprice"),
                        payload.getBoolean("depositpaid"),
                        payload.getString("bookingdates.checkin"),
                        payload.getString("bookingdates.checkout"),
                        payload.getString("additionalneeds")
                        };
                           
        Object[][] stringMultiArray= {{"ahmad","bustomi",100,true,"2018-01-01", "2019-01-01","Dinner"}};
        return stringMultiArray;
        
        
    }    


}
