package org.mhildenb.cdcdemo;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.mhildenb.cdcdemo.model.Inventory;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

import java.util.List;

@Path("/api/inventory")
@RegisterRestClient
public interface InventoryProxy {

    @POST
    List<Inventory> upsertInventory(List<Inventory> inventoryRecords);
}