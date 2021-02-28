
package functions;

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
    "OrderId",
    "OrderType",
    "OrderItemName",
    "Quantity",
    "Price",
    "ShipmentAddress",
    "ZipCode",
    "CreditCardNumber",
    "Expiration",
    "Name",
    "OrderUser"
})
public class After {

    @JsonProperty("OrderId")
    private Long orderId;
    @JsonProperty("OrderType")
    private String orderType;
    @JsonProperty("OrderItemName")
    private String orderItemName;
    @JsonProperty("Quantity")
    private Long quantity;
    @JsonProperty("Price")
    private String price;
    @JsonProperty("ShipmentAddress")
    private String shipmentAddress;
    @JsonProperty("ZipCode")
    private String zipCode;
    @JsonProperty("CreditCardNumber")
    private String creditCardNumber;
    @JsonProperty("Expiration")
    private String expiration;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("OrderUser")
    private String orderUser;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("OrderId")
    public Long getOrderId() {
        return orderId;
    }

    @JsonProperty("OrderId")
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    @JsonProperty("OrderType")
    public String getOrderType() {
        return orderType;
    }

    @JsonProperty("OrderType")
    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    @JsonProperty("OrderItemName")
    public String getOrderItemName() {
        return orderItemName;
    }

    @JsonProperty("OrderItemName")
    public void setOrderItemName(String orderItemName) {
        this.orderItemName = orderItemName;
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

    @JsonProperty("ShipmentAddress")
    public String getShipmentAddress() {
        return shipmentAddress;
    }

    @JsonProperty("ShipmentAddress")
    public void setShipmentAddress(String shipmentAddress) {
        this.shipmentAddress = shipmentAddress;
    }

    @JsonProperty("ZipCode")
    public String getZipCode() {
        return zipCode;
    }

    @JsonProperty("ZipCode")
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @JsonProperty("CreditCardNumber")
    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    @JsonProperty("CreditCardNumber")
    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    @JsonProperty("Expiration")
    public String getExpiration() {
        return expiration;
    }

    @JsonProperty("Expiration")
    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    @JsonProperty("Name")
    public String getName() {
        return name;
    }

    @JsonProperty("Name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("OrderUser")
    public String getOrderUser() {
        return orderUser;
    }

    @JsonProperty("OrderUser")
    public void setOrderUser(String orderUser) {
        this.orderUser = orderUser;
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
