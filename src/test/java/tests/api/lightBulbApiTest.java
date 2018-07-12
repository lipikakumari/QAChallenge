package tests.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.config.EncoderConfig.encoderConfig;
import static org.hamcrest.Matchers.equalTo;


public class lightBulbApiTest {

    private final  String userId ="937eb6c2-cd76-82be-affb-d833c85f19ed";

    @BeforeClass
    public static void setUp(){
        RestAssured.baseURI = "https://qa-challenges-lightbulb.atlassian.io";
        RestAssured.basePath = "/api/allmethods/";

        //To avoid Rest Assured from adding charset to content-type header automatically
        RestAssured.config = RestAssured.config().encoderConfig(encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false));
    }

    // Test bulb is switched on successfully
    @Test
    public void switchBulbOn() {

       given().
               header("userId", userId).
               contentType(ContentType.JSON).
               body("{ \"power\" : 20" + " }").
               when().
               post("/on").
               then().
               assertThat().statusCode(200).
               and().
               assertThat().body("Result", equalTo("Switch & custom power set successfully"));


    }

    // Test bulb is switched off successfully
    @Test
    public void switchBulbOff() {

        given().
                header("userId", userId).
                contentType(ContentType.JSON).
                when().
                post("/off").
                then().
                assertThat().statusCode(200).
                and().
                assertThat().body("Result", equalTo("Switch set successfully"));


    }

}