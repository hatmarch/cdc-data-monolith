package org.mhildenb.cdcdemo;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletionStage;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import io.smallrye.reactive.messaging.kafka.Record;

import org.jboss.logging.Logger;

import org.mhildenb.cdcdemo.model.CDCEvent;
import org.mhildenb.cdcdemo.model.Inventory;
import org.mhildenb.cdcdemo.model.Product;

@ApplicationScoped
public class CdcKafkaConsumer {

    private final Logger logger = Logger.getLogger(CdcKafkaConsumer.class);

    @Inject 
    @RestClient
    InventoryProxy invProxy;

    @Inject
    @RestClient
    CatalogProxy catProxy;

    @Incoming("legacy-inventory-cdc")
    public void receive(Record<String, String> record) throws JsonProcessingException {
        logger.infof("Got a cdc event with key %s", record.key());
    
        CDCEvent event = new ObjectMapper().readValue(record.value(), CDCEvent.class);
        

        try{
            switch (event.getPayload().getOp()) {

                // "r" applies to snapshots, 
                // per here: https://debezium.io/documentation/reference/connectors/sqlserver.html
                // since we're just doing "upserting" we'll treat it just like a create
                case "r":
                    logger.info("Got a snapshot cdc event [op=r]");
                case "c":
                case "u":
                    processUpsert(event);
                    break;
                case "d":
                    processDelete(event);
                    break;
                default:
                    assert(false);
                    break;
            }    

            // FIXME: Commit this message
        }
        catch (Exception e)
        {
            logger.errorf("Error processing event.  Error is %s", e.getMessage());
        }

    }

    private void processUpsert(CDCEvent event) {
        // For inserts and updates, look at the after event
        var cdcRowData = event.getPayload().getAfter();

        logger.infof("New/Updated a payload with item name of %s (itemId: %d)", 
            cdcRowData.getItemName(), cdcRowData.getItemId());

        // Extract Inventory and Product information
        var prodInfo = Product.createFromCdc(cdcRowData);
        var invInfo = Inventory.createFromCdc(cdcRowData);

        // Update the product catalog
        catProxy.upsertProduct(List.of(prodInfo));

        // Update the inventory catalog
        invProxy.upsertInventory(List.of(invInfo));
    }

    private void processDelete(CDCEvent event) 
    {
        // for deletes, look at the before rowData
        var cdcRowData = event.getPayload().getBefore();

        logger.infof("Delete a payload with item name of %s (itemId: %d)", 
            cdcRowData.getItemName(), cdcRowData.getItemId());

        logger.error("NOT IMPLEMENTED");
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
