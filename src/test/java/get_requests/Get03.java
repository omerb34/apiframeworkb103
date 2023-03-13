package get_requests;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;


public class Get03 {
    /*
       https://jsonplaceholder.typicode.com/todos/23

       When
       User send GET Request to the URL
               Then
       HTTP Status Code should be 200
       And
       Response format should be “application/json”
       And
               “title” is “et itaque necessitatibus maxime molestiae qui quas velit”,
       And
               “completed” is false
       And
               “userId” is 2
               */
    @Test
    public void get03() {
        //set the URL
        String url = "https://jsonplaceholder.typicode.com/todos/23";

        //Set the expected data

        //Send the request and get the response
        Response response = given().when().get(url);
        response.prettyPrint();

        //Do Assertion
        //1.yol
        response.
                then().
                statusCode(200).
                contentType("application/json").
                body("title", equalTo("et itaque necessitatibus maxime molestiae qui quas velit")).
                body("completed", equalTo(false)).
                body("userId", equalTo(2));


        //2.yol burada soft assetion yaptık. ancak sadece body içini tek paranteze aldık ki body içlerden biri kalırsa test kalmasın
        response.
                then().
                statusCode(200).
                contentType("application/json").
                body("title", equalTo("et itaque necessitatibus maxime molestiae qui quas velit"),
                        "completed", equalTo(false),
                        "userId", equalTo(2));
//Not!!!!
//Tek body() methodu içerisinde çoklu assertion yaparak soft assertion oluşturabilirsiniz. Fail durumunda body() içerisinde Java çalışmayı durdurmaz.
//Çoklu body() methodu ile assertion yapıldığında fail durumunda Java bir sonraki body() methodu öncesi çaılışmayı durdurur.
    }


}
