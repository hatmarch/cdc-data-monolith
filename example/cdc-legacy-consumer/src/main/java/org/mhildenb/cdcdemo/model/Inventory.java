package org.mhildenb.cdcdemo.model;

// For use with the inventory service
public class Inventory {

    public String itemId;
    public String location;
    public int quantity;
    public String link;

    public Inventory() {

    }

	public static Inventory createFromCdc(RowData cdcRowData) {
        var retInv = new Inventory();

        retInv.itemId = cdcRowData.getItemId().toString();
        retInv.link = cdcRowData.getLink();
        retInv.quantity = cdcRowData.getQuantity().intValue();
        retInv.location = cdcRowData.getLocation();

		return retInv;
	}
}