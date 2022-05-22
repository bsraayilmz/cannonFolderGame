import java.util.ArrayList;
import java.util.Locale;

public class Weapons {
    protected String nameWeapon;
    protected double damageLevel = 1;
    protected double weight;
    protected double moneyWeapon;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    protected int ID;

    Swords[] swordsList = new Swords[4];
    Shields[] shieldsList = new Shields[4];
    Wands[] wandsList = new Wands[4];

    public void displaySwordsInfo(){
        Swords swords1 = new Swords(1,"Swords1",10,20);
        Swords swords2 = new Swords(2,"Swords2",20,15);
        Swords swords3 = new Swords(3,"Swords3",30,25);
        Swords swords4 = new Swords(4,"Swords4",40,30);

        swordsList[0] = swords1;
        swordsList[1] = swords2;
        swordsList[2] = swords3;
        swordsList[3] = swords4;

        for(Swords swords : swordsList){
            swords.printInfo();
        }
    }
    public void displayShieldsInfo(){
        Shields shields1 = new Shields(1,"Shields1",10,20);
        Shields shields2 = new Shields(2,"Shields2",20,15);
        Shields shields3 = new Shields(3,"Shields3",30,25);
        Shields shields4 = new Shields(4,"Shields4",40,30);

        shieldsList[0] = shields1;
        shieldsList[1] = shields2;
        shieldsList[2] = shields3;
        shieldsList[3] = shields4;

        for(Shields shields : shieldsList){
            shields.printInfo();
        }
    }
    public void displayWandsInfo(){
        Wands wands1 = new Wands(1,"Wands1",10,20);
        Wands wands2 = new Wands(2,"Wands2",20,15);
        Wands wands3 = new Wands(3,"Wands3",30,25);
        Wands wands4 = new Wands(4,"Wands4",40,30);

        wandsList[0] = wands1;
        wandsList[1] = wands2;
        wandsList[2] = wands3;
        wandsList[3] = wands4;

        for(Wands wands : wandsList){
            wands.printInfo();
        }
    }

    public void printInfo(){
        System.out.println(" \tID: " +getID()+ " \tName: " + getNameWeapon()+ " \tWeight: " + getWeight() + " \tPrice of the " + getNameWeapon() + ": " + getMoneyWeapon());
    }

    public Weapons(int ID,String nameWeapon, double weight, double moneyWeapon){
        this.ID = ID;
        this.nameWeapon = nameWeapon;
        this.weight = weight;
        this.moneyWeapon = moneyWeapon;
    }
    public Weapons(){

    }
    public double calculateDamageLevel(){
        return damageLevel;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getMoneyWeapon() {
        return moneyWeapon;
    }

    public void setMoneyWeapon(double moneyWeapon) {
        this.moneyWeapon = moneyWeapon;
    }





    public void setNameWeapon(String nameWeapon) {
        this.nameWeapon = nameWeapon;
    }

    public String getNameWeapon() {
        return nameWeapon;
    }

    public void setDamageLevel(double damageLevel) {
        this.damageLevel = damageLevel;
    }

    public double getDamageLevel() {
        return damageLevel;
    }
    public Weapons(String nameWeapon){
        setNameWeapon(nameWeapon);
    }

}

