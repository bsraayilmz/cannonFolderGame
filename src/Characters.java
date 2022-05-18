import java.util.Scanner;

public class Characters {
    protected String name;
    protected double vitality, intelligence, strength, moneyOfChar;
    protected Weapons weapons;
    protected Clothes clothes;
    protected double healthPoint;

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    private Inventory inventory;
    int charEntering;
    int newCharEntering;

    //this is our character's bag that includes items is in the inventory!!
    public Characters(String name){
        this.name = name;
        inventory = new Inventory();
    }
    public Characters(){

    }
    /* public Characters(String name, double strength, double vitality, double intelligence, double moneyOfChar){
         setName(name);
         setStrength(strength);
         setVitality(vitality);
         setIntelligence(intelligence);
         setMoneyOfChar(moneyOfChar);
     }*/
    public Characters(Weapons weapons){
        this.weapons = weapons;
    }

    public int getCharEntering() {
        return charEntering;
    }

    public void setCharEntering(int charEntering) {
        this.charEntering = charEntering;
    }

    public int getNewCharEntering() {
        return newCharEntering;
    }

    public void setNewCharEntering(int newCharEntering) {
        this.newCharEntering = newCharEntering;
    }



    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public double getVitality() {
        return vitality;
    }

    public void setVitality(double vitality) {
        this.vitality = vitality;
    }

    public double getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(double intelligence) {
        this.intelligence = intelligence;
    }

    public double getStrength() {
        return strength;
    }

    public void setStrength(double strength) {
        this.strength = strength;
    }

    public double getMoneyOfChar() {
        return moneyOfChar;
    }

    public void setMoneyOfChar(int charEntering) {
    }
    public void setMoneyOfChar(double moneyOfChar){
        this.moneyOfChar = moneyOfChar;
    }

    public Weapons getWeapons() {
        return weapons;
    }

    public void setWeapons(Weapons weapons) {
        this.weapons = weapons;
    }

    public Clothes getClothes() {
        return clothes;
    }

    public void setClothes(Clothes clothes) {
        this.clothes = clothes;
    }

    public double getHealthPoint() {
        return healthPoint;
    }

    public void setHealthPoint(double healthPoint) {
        this.healthPoint = healthPoint;
    }


    public void attack() {

    }

    public double calculateHealthPoint(double strength, double vitality, double intelligence) {
        healthPoint = (0.7 * vitality) + (0.2 * strength) + (0.1 * intelligence);
        return healthPoint;
    }

    public void printInfo() {

    }


    public void submitValues() {

        if (charEntering == 1) {
            charValuesTable("Fighter", 6, 3, 1, 18);
            System.out.println("FEATURES OF THE CHARACTER THAT YOU CHOSE ");
            System.out.println(" --> Your character: " + getName() + " \tStrength level:" + getStrength() + "    \tVitality level: " + getVitality()
                    + "    \tIntelligence level: " + getIntelligence() + "    \tMoney of Character: " + getMoneyOfChar() + "   " +
                    "\tHealth point: " + calculateHealthPoint(getStrength(), getVitality(), getIntelligence()));
        } else if (charEntering == 2) {
            charValuesTable("Tank", 1, 6, 3, 17);
            System.out.println("FEATURES OF THE CHARACTER THAT YOU CHOSE ");
            System.out.println(" --> Your character: " + getName() + " \tStrength level:" + getStrength() + "    \tVitality level: " + getVitality()
                    + "    \tIntelligence level: " + getIntelligence() + "    \tMoney of Character: " + getMoneyOfChar() + "   " +
                    "\tHealth point: " + calculateHealthPoint(getStrength(), getVitality(), getIntelligence()));
        } else if (charEntering == 3) {
            charValuesTable("Healer", 3, 1, 6, 25);
            System.out.println("FEATURES OF THE CHARACTER THAT YOU CHOSE ");
            System.out.println(" --> Your character: " + getName() + " \tStrength level:" + getStrength() + "    \tVitality level: " + getVitality()
                    + "    \tIntelligence level: " + getIntelligence() + "    \tMoney of Character: " + getMoneyOfChar() + "   " +
                    "\tHealth point: " + calculateHealthPoint(getStrength(), getVitality(), getIntelligence()));
        }
    }
    public void charValuesTable(String name,double strength,double vitality,double intelligence, double moneyOfChar){
        setName(name);
        setStrength(strength);
        setVitality(vitality);
        setIntelligence(intelligence);
        setMoneyOfChar(moneyOfChar);
        calculateHealthPoint(strength,vitality,intelligence);

    }
    public void chooseCharTable() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("If your selection is   Fighter--> please enter 1 ------- ");
        System.out.println("                       Tank-->    please enter 2 ------- ");
        System.out.print("                       Healer-->  please enter 3 ------- ");
        System.out.print("YOUR CHARACTER: ");
        setCharEntering(charEntering = scanner.nextInt());
        while (charEntering < 1 || charEntering > 3) {
            System.out.println("!!! Your selection is not valid. Please enter a value between 1 and 3 !!!");
            System.out.print("YOUR CHARACTER: ");
            setCharEntering(scanner.nextInt());
        }
        if (charEntering == 1) {
            System.out.println("Fighter is so angry to fight... " + " 'WHOOOAAAAHH!!!!' ");
        } else if (charEntering == 2) {
            System.out.println("Tank is ready to fight... " + " 'WHUUOOUH!!!' ");
        } else if (charEntering == 3) {
            System.out.println("Healer is so excited to fight..." + " 'FIUUVVV!!' ");
        }
        submitValues();


    }}
