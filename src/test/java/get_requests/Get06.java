package get_requests;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Get06 extends HerOkuAppBaseUrl {
    /*
       Given
           https://restful-booker.herokuapp.com/booking/23
       When
           User send a GET request to the URL
       Then
           HTTP Status Code should be 200
       And
           Response content type is "application/json"
       And
           Response body should be like;
{
   "firstname": "Josh",
   "lastname": "Allen",
   "totalprice": 111,
   "depositpaid": true,
   "bookingdates": {
       "checkin": "2018-01-01",
       "checkout": "2019-01-01"
   },
   "additionalneeds": "midnight snack"
}
     */
    @Test
    public void get06() {
        //Set the URL
        spec.pathParams("first", "booking", "second", 23);

        //Set the expected data

        //Send the request and get the response
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();


        //Do Assertion
        //1. Yol:
//        response.then().
//                statusCode(200).
//                contentType(ContentType.JSON).
//                body("firstname", equalTo("John"),
//                        "lastname", equalTo("Smith"),
//                        "totalprice", equalTo(111),
//                        "depositpaid", equalTo(true),
//                        "bookingdates.checkin", equalTo("2018-01-01"),
//                        "bookingdates.checkout", equalTo("2019-01-01"),
//                        "additionalneeds", equalTo("Breakfast")
//                );

        //2. Yol: JsonPath ile
        JsonPath jsonPath = response.jsonPath();

        assertEquals("Josh",jsonPath.getString("firstname"));
        assertEquals("Allen",jsonPath.getString("lastname"));
        assertEquals(111,jsonPath.getInt("totalprice"));
        assertTrue(jsonPath.getBoolean("depositpaid"));
        assertEquals("2018-01-01",jsonPath.getString("bookingdates.checkin"));
        assertEquals("2019-01-01",jsonPath.getString("bookingdates.checkout"));
        assertEquals("super bowls",jsonPath.getString("additionalneeds"));


        //3.yol TetNG ile SoftAssert..

        // 1.adım sofAssertobjesiolsutur
        SoftAssert softAssert= new SoftAssert();





    }
}