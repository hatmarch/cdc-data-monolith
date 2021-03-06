package org.mhildenb.cdcdemo;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.mhildenb.cdcdemo.model.Product;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

import java.util.List;

@Path("/api/products")
@RegisterRestClient
public interface CatalogProxy {

    @POST
    List<Product> upsertProduct(List<Product> productRecords);
}