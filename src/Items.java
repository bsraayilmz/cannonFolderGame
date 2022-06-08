public class Items {

    protected String itemName;
    protected double itemPrice;

    public int getItemWeight() {
        return itemWeight;
    }

    public void setItemWeight(int itemWeight) {
        this.itemWeight = itemWeight;
    }

    protected int itemWeight;
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
    public void printInfo(){

    }
    public Items(){

    }

}
