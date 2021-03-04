
package org.mhildenb.cdcdemo.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ItemId",
    "ItemName",
    "Description",
    "Quantity",
    "Price",
    "Location",
    "Link"
})
public class After {

    @JsonProperty("ItemId")
    private Long itemId;
    @JsonProperty("ItemName")
    private String itemName;
    @JsonProperty("Description")
    private String description;
    @JsonProperty("Quantity")
    private Long quantity;
    @JsonProperty("Price")
    private String price;
    @JsonProperty("Location")
    private String location;
    @JsonProperty("Link")
    private String link;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("ItemId")
    public Long getItemId() {
        return itemId;
    }

    @JsonProperty("ItemId")
    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    @JsonProperty("ItemName")
    public String getItemName() {
        return itemName;
    }

    @JsonProperty("ItemName")
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    @JsonProperty("Description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("Description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("Quantity")
    public Long getQuantity() {
        return quantity;
    }

    @JsonProperty("Quantity")
    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    @JsonProperty("Price")
    public String getPrice() {
        return price;
    }

    @JsonProperty("Price")
    public void setPrice(String price) {
        this.price = price;
    }

    @JsonProperty("Location")
    public String getLocation() {
        return location;
    }

    @JsonProperty("Location")
    public void setLocation(String location) {
        this.location = location;
    }

    @JsonProperty("Link")
    public String getLink() {
        return link;
    }

    @JsonProperty("Link")
    public void setLink(String link) {
        this.link = link;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
