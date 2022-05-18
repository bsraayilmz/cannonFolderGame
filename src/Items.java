public class Items {

    protected String itemName;
    protected double itemPrice;
    protected Weapons weapons;
    public String getItemName() {
        return itemName;
    }
    public Items(String itemName, double itemPrice){
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }
    public Items(){

    }

}
