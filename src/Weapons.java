import java.security.SecureRandom;
import java.util.ArrayList;

public class Weapons {
    SecureRandom secureRandom = new SecureRandom();
    protected String nameWeapon;
    protected double damageLevel = 1;
    protected double weight;
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


    protected ArrayList<Swords> swordsList = new ArrayList<>();
    protected ArrayList<Shields> shieldsList = new ArrayList<>();

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

    protected ArrayList<Wands>wandsList = new ArrayList<>();
    public void displayInfoForAllWeapons(){

    }

    public void displaySwordsInfo(){

        Swords swords1 = new Swords(1,"Swords1",10,20);
        Swords swords2 = new Swords(2,"Swords2",20,15);
        Swords swords3 = new Swords(3,"Swords3",30,25);
        Swords swords4 = new Swords(4,"Swords4",40,30);

        swordsList.add(swords1);
        swordsList.add(swords2);
        swordsList.add(swords3);
        swordsList.add(swords4);


    }
    public void displayShieldsInfo(){
        Shields shields1 = new Shields(1,"Shields1",10,20);
        Shields shields2 = new Shields(2,"Shields2",20,15);
        Shields shields3 = new Shields(3,"Shields3",30,25);
        Shields shields4 = new Shields(4,"Shields4",40,30);

        shieldsList.add(shields1);
        shieldsList.add(shields2);
        shieldsList.add(shields3);
        shieldsList.add(shields4);
    }
    public void displayWandsInfo(){
        Wands wands1 = new Wands(1,"Wands1",10,20);
        Wands wands2 = new Wands(2,"Wands2",20,15);
        Wands wands3 = new Wands(3,"Wands3",30,25);
        Wands wands4 = new Wands(4,"Wands4",40,30);

        wandsList.add(wands1);
        wandsList.add(wands2);
        wandsList.add(wands3);
        wandsList.add(wands4);
    }

    public void printInfoForWeapons(){
        System.out.println(" \tID: " +getID()+ " \tName: " + getNameWeapon()+ " \tWeight: " + getWeight() + " \tPrice of the " +
                getNameWeapon() + " : " + getMoneyWeapon());
    }
    public Weapons(int ID,String nameWeapon, double weight, double moneyWeapon){
       setID(ID);
       setNameWeapon(nameWeapon);
       setWeight(weight);
       setMoneyWeapon(moneyWeapon);
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

    public ArrayList<Swords> getSwordsList() {
        return swordsList;
    }

    public void setSwordsList(ArrayList<Swords> swordsList) {
        this.swordsList = swordsList;
    }
    public void special(Characters holder, Character effected){
    }
    public void special(Characters character,int turn){

    }
    public void special(Characters characters, Characters character){}
}

