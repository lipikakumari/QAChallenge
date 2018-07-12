package tests.api;
import static io.restassured.RestAssured.*;
import static io.restassured.config.EncoderConfig.encoderConfig;
import static org.hamcrest.Matchers.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.Test;


public class lightBulbApiTest {

    @BeforeClass
    public static void setUp(){
        RestAssured.baseURI = "https://qa-challenges-lightbulb.atlassian.io";
        RestAssured.basePath = "/api/allmethods/";

        //To avoid Rest Assured from adding charset to content-type header automatically
        RestAssured.config = RestAssured.config().encoderConfig(encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false));
    }

    @Test
    public void switchBulbOn() {

       given().
               header("userId", "937eb6c2-cd76-82be-affb-d833c85f19ed").
               contentType(ContentType.JSON).
               body("{ \"power\" : 60" + " }").
               when().
               post("/on").
               then().
               assertThat().statusCode(200).
               and().
               assertThat().body("Result", equalTo("Switch & custom power set successfully"));


    }

    @Test
    public void switchBulbOff() {

        given().
                header("userId", "937eb6c2-cd76-82be-affb-d833c85f19ed").
                contentType(ContentType.JSON).
                when().
                post("/off").
                then().
                assertThat().statusCode(200).
                and().
                assertThat().body("Result", equalTo("Switch set successfully"));


    }

}
