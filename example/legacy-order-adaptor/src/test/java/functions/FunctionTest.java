package functions;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import io.vertx.core.json.JsonObject;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.InputStream;

import com.fasterxml.jackson.databind.ObjectMapper;

@QuarkusTest
public class FunctionTest {

    @Test
    void testCreateEvent() {
        CDCEvent createEvent;

        InputStream inJson = CDCEvent.class.getResourceAsStream("/testCreateEvent.json");
        
        try{
            createEvent = new ObjectMapper().readValue(inJson, CDCEvent.class);

            Output output = (new Function()).function(createEvent, null);
            Assertions.assertEquals("mssql_server_linux.dbo.Orders.Envelope", output.getMessage());
        }
        catch (Exception e)
        {
            assertTrue(false, String.format("Error loading test file: %s", e.getMessage()));
        }

    }


    // @Test
    // public void testFunctionIntegration() {
    //     RestAssured.given().contentType("application/json")
    //             .body("{\"message\": \"Hello!\"}")
    //             .header("ce-id", "42")
    //             .header("ce-specversion", "1.0")
    //             .post("/")
    //             .then().statusCode(200)
    //             .header("ce-id", notNullValue())
    //             .header("ce-specversion", equalTo("1.0"))
    //             .header("ce-source", equalTo("function"))
    //             .header("ce-type", equalTo("function.output"))
    //             .body("message", equalTo("Hello!"));
    // }

}
