package day5;

import java.util.*;

public class Merchandise {
    private String ItemId;
    private int Qty;
    private double price;

    public Merchandise(String ItemId, int Qty, double price) {
        this.ItemId = ItemId;
        this.Qty = Qty;
        this.price = price;
    }

    public String getItemId() {
        return ItemId;
    }

    public int getQty() {
        return Qty;
    }

    public double getPrice() {
        return price;
    }

    public void setItemId(String ItemId) {
        this.ItemId = ItemId;
    }

    public void setQty(int Qty) {
        this.Qty = Qty;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Merchandise{");
        sb.append("ItemId='").append(ItemId).append('\'');
        sb.append(", Qty=").append(Qty);
        sb.append(", price=").append(price);
        sb.append('}');
        return sb.toString();
    }
}
