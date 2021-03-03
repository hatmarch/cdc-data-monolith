package org.mhildenb.cdcdemo;

import java.io.IOException;
import java.util.concurrent.CompletionStage;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.reactive.messaging.Incoming;

import io.smallrye.reactive.messaging.kafka.Record;

import org.jboss.logging.Logger;

@ApplicationScoped
public class CdcKafkaConsumer {

    private final Logger logger = Logger.getLogger(CdcKafkaConsumer.class);

    @Incoming("mssql-server-linux.dbo.Orders")
    public void receive(Record<String, String> record) {
        logger.infof("Got a cdc event: %s - %s", record.key(), record.value());
    }

    // @Incoming()
    // public CompletionStage<Void> onMessage(KafkaRecord<String, String> message)
    //         throws IOException {

    //     LOG.info("Kafka order message with value = {} arrived", message.getPayload());

    //     JsonObject orders = new JsonObject(message.getPayload());
    //     Order order = new Order();
    //     order.setOrderId(orders.getString("orderId"));
    //     order.setName(orders.getString("name"));
    //     order.setTotal(orders.getString("total"));
    //     order.setCcNumber(orders.getJsonObject("creditCard").getString("number"));
    //     order.setCcExp(orders.getJsonObject("creditCard").getString("expiration"));
    //     order.setBillingAddress(orders.getString("billingAddress"));
    //     order.setStatus("PROCESSING");
    //     orderService.add(order);

    //     return message.ack();
    // }
}
