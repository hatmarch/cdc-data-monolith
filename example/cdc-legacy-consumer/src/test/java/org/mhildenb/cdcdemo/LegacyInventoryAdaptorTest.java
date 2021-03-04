package org.mhildenb.cdcdemo;

import io.quarkus.test.junit.QuarkusTest;
import io.smallrye.reactive.messaging.kafka.Record;

import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import javax.inject.Inject;

@QuarkusTest
public class LegacyInventoryAdaptorTest {

    @Inject
    CdcKafkaConsumer cdcConsumer;
    
    // @Test
    // public void testHelloEndpoint() {
    //     given()
    //       .when().get("/hello-resteasy")
    //       .then()
    //          .statusCode(200)
    //          .body(is("Hello RESTEasy"));
    // }

    @Test
    public void testKafkaRecord() {
        InputStream inJson = Thread.currentThread().getContextClassLoader().getResourceAsStream("/testCreateEvent.json");
        try
        {
            String text = IOUtils.toString(inJson, StandardCharsets.UTF_8.name());

            Record<String,String> kr = Record.of(null,text);
            cdcConsumer.receive(kr);
        }
        catch (Exception e)
        {
            assertTrue(false, e.getMessage());
        }

    }

}