import java.security.SecureRandom;
import java.util.ArrayList;

public class Weapons extends Items{
    SecureRandom secureRandom = new SecureRandom();
    protected String nameWeapon;
    protected int damage;

    protected double moneyWeapon;

    public int getKindWeapon() {
        return kindWeapon;
    }

    public void setKindWeapon(int kindWeapon) {
        this.kindWeapon = kindWeapon;
    }

    protected int kindWeapon;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    protected int ID;

     protected ArrayList<Wands>wandsList = new ArrayList<>();
     protected ArrayList<Swords> swordsList = new ArrayList<>();
     protected ArrayList<Shields> shieldsList = new ArrayList<>();
    static protected ArrayList<Weapons> weaponsAll = new ArrayList<>();


    public ArrayList<Shields> getShieldsList() {
        return shieldsList;
    }

    public void setShieldsList(ArrayList<Shields> shieldsList) {
        this.shieldsList = shieldsList;
    }

    public ArrayList<Wands> getWandsList() {
        return wandsList;
    }

    public void setWandsList(ArrayList<Wands> wandsList) {
        this.wandsList = wandsList;
    }


    public void displayInfoForAllWeapons(){

    }

    public void displaySwordsInfo(){

        Swords swords1 = new Swords("Swords1");
        Swords swords2 = new Swords("Swords2");
        Swords swords3 = new Swords("Swords3");
        Swords swords4 = new Swords("Swords4");

        swordsList.add(swords1);
        swordsList.add(swords2);
        swordsList.add(swords3);
        swordsList.add(swords4);

        weaponsAll.add(swords1);
        weaponsAll.add(swords2);
        weaponsAll.add(swords3);
        weaponsAll.add(swords4);



    }
    public void displayShieldsInfo(){
        Shields shields1 = new Shields("Shields1");
        Shields shields2 = new Shields("Shields2");
        Shields shields3 = new Shields("Shields3");
        Shields shields4 = new Shields("Shields4");

        shieldsList.add(shields1);
        shieldsList.add(shields2);
        shieldsList.add(shields3);
        shieldsList.add(shields4);

        weaponsAll.add(shields1);
        weaponsAll.add(shields2);
        weaponsAll.add(shields3);
        weaponsAll.add(shields4);

    }
    public void displayWandsInfo(){
        Wands wands1 = new Wands("Wands1");
        Wands wands2 = new Wands("Wands2");
        Wands wands3 = new Wands("Wands3");
        Wands wands4 = new Wands("Wands4");

        wandsList.add(wands1);
        wandsList.add(wands2);
        wandsList.add(wands3);
        wandsList.add(wands4);

        weaponsAll.add(wands1);
        weaponsAll.add(wands2);
        weaponsAll.add(wands3);
        weaponsAll.add(wands4);

    }

    public void printInfo(){
        System.out.println(" \tName: " + getNameWeapon()+ " \tWeight: " + getItemWeight() + " \tPrice of the " +
                getNameWeapon() + " : " + getMoneyWeapon());
    }
    public Weapons(String nameWeapon){

       setNameWeapon(nameWeapon);
       setItemWeight(secureRandom.nextInt(1,4));
       setMoneyWeapon(secureRandom.nextInt(1,4));
       setDamage((int) (Math.random()*9)+1);
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

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public double getDamage() {
        return damage;
    }


    public ArrayList<Swords> getSwordsList() {
        return swordsList;
    }

    public void setSwordsList(ArrayList<Swords> swordsList) {
        this.swordsList = swordsList;
    }

    public void special(Characters characters){}

    public void special(Characters holder, Characters effected){}

    public Weapons createWeaponRandomly(Weapons weapon){
        int randomWeapon = (int) (Math.random()*3)+1;
        if (randomWeapon==1){
            return weapon = new Swords("Sword");
        }
        else if (randomWeapon==2){
            return weapon = new Shields("Shield");
        }
        else {
            return weapon = new Wands("Wand");
        }

    }
}

