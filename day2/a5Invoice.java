package day2;

public class a5Invoice implements a5Payable {
    private String partNum;
    private String partDescription;
    private int quantity;
    private double pricePerItem;

    public a5Invoice(String partNum, String partDescription, int quantity, double pricePerItem){
        this.partNum=partNum;
        this.partDescription=partDescription;
        this.quantity=quantity;
        this.pricePerItem=pricePerItem;
    }

    public String getPartNum() {
        return partNum;
    }
    public String getPartDescription() {
        return partDescription;
    }
    public int getQuantity() {
        return quantity;
    }
    public double getPricePerItem() {
        return pricePerItem;
    }

    public void setPartNum(String partNum) {
        this.partNum = partNum;
    }
    public void setPartDescription(String partDescription) {
        this.partDescription = partDescription;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public void setPricePerItem(double pricePerItem) {
        this.pricePerItem = pricePerItem;
    }

    @Override
    public String toString() {
        return "Invoice{" + "partNum=" + partNum + ", partDescription=" + partDescription + ", quantity=" + quantity + ", pricePerItem=" + pricePerItem + '}';
    }

    @Override
    public double getPayment() {
        return quantity*pricePerItem;
    }
}
