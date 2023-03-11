package get_requests;

import io.restassured.response.Response;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

public class RequestResponse {
    /*
 1)Postman manuel API testi için kullanilir.

 2)API otomasyonu için Rest-Assured Library kullanacagiz.

 3)Otomasyon kodlarının yazımı için şu adımları izliyoruz:

    a) Gereksinimleri anlama

    b) Test case i yazma:
       -Test case i yazmak için "Gherkin Language" kullaniyoruz.
        x) Given: Ön koşullar  --> Endpoint, body
        y) When : İşlemlee --> Get,Put,Delete...
        z) Then : Dönütler --> Assert
        t) And --> Çoklu işlemlerin art arda yazilacağı yerlerde kullanilir.

    c)Test kodunu yazarken şu adımları izleriz
        i) Set the URL
        İİ) Set the expected data
        iii) Set the request and get the response
        iv)Do assertion


  */
    public static void main(String[] args) {

        String url = "https://restful-booker.herokuapp.com/booking/55";

        // GET REQUEST nasıl yapilir:
        Response response = given().when().get(url);
        response.prettyPrint();// bu method response datayı yazdırır.


        // Status code nasıl yazdırılır.
        System.out.println("status code" + response.statusCode());

        //Content Type nasil yazdirilir?
        System.out.println("Content Type: " + response.contentType());

        //Status Line nasil yazdirilir?
        System.out.println("Status Line: " + response.statusLine());

        //Header nasıl yazdırılır?
        System.out.println(response.header("Connection"));

        //Headers nasıl yazdırılır?
        System.out.println(response.headers());


    }

}
