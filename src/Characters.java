import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Characters{
    Weapons[] onHand = new Weapons[1];
    Clothes[] onBody = new Clothes[1];
    ArrayList<Items> Inventory = new ArrayList<>();
    Weapons weapon = new Swords("Sword");
    Weapons weapon1 = new Shields("Shield");
    Weapons weapon2 = new Wands("Wand");

    public void addWeapons(Weapons weapons){
        onHand[0] = weapons;
    }
    public void addClothing(Clothes clothing){
        onBody[0] = clothing;
    }
    public void listInventory(ArrayList<Items> Inventory){
        for (Items items : Inventory){
            items.printInfo();
        }
    }
    protected String name;
    private boolean stunned;
    private boolean isInTheGame;
    SecureRandom secureRandom = new SecureRandom();
    ArrayList<Weapons> inventoryFighter = new ArrayList<>();
    ArrayList<Weapons> inventoryTank = new ArrayList<>();
    ArrayList<Weapons> inventoryHealer = new ArrayList<>();
    static Dungeon dungeon = new Dungeon();
    int restHealthPoint;

    protected String type;

    public int getKind() {
        return kind;
    }

    public void setKind(int kind) {
        this.kind = kind;
    }

    protected int kind;
    protected int vitality;
    protected int intelligence;
    protected int strength;

    public int getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }

    protected int maxHP;
    ArrayList<Healer> healerArrayList = new ArrayList<>();
    ArrayList<Tank> tankArrayList = new ArrayList<>();
    ArrayList<Fighter> fighterArrayList = new ArrayList<>();

    static ArrayList<Characters> ChosenChar = new ArrayList<>();
    protected int idChar;
    protected double moneyOfChar;
    protected Weapons weaponsRandomly;
    protected Clothes clothes;
    protected int healthPoint;
    protected int inventoryWeight;

    public void pickUp(Items item){
        if (inventoryWeight<=strength){
            Inventory.add(item);
            inventoryWeight += item.getItemWeight();
        }
        else if (inventoryWeight>strength){
            System.out.println("Your character is carrying too much item on inventory.");
        }

    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    private boolean visible;

    public void setInTheGame(boolean isInTheGame){
        this.isInTheGame=isInTheGame;
    }
    public boolean getInTheGame(){
        return isInTheGame;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public int getIdChar() {
        return idChar;
    }

    public void setIdChar(int idChar) {
        this.idChar = idChar;
    }

    public boolean isStunned(){
        return stunned;
    }

    public void setStunned(boolean stunned) {
        this.stunned = stunned;
    }

    public void controlCharForTankAndHealer() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("You cannot add a fighter character in battle char list! ");
        System.out.println();
        System.out.println("NOW, SECONDLY PLEASE CHOOSE THE TANK BY ENTERING 2 ");
        System.out.print("YOUR CHARACTER TYPE: ");
        setCharEntering(charEntering = scanner.nextInt());

        while (charEntering!=2) {
            System.out.println("!!! Your selection is not valid. Please enter a value 2 !!!");
            System.out.print("YOUR CHARACTER TYPE: ");
            setCharEntering(scanner.nextInt());
        }
        if (charEntering == 2) {
            tankChoose();
            System.out.println("You cannot add a tank character in battle char list! ");
            healerChoose();
            System.out.println("Yeeeey, you completed char list. Well done :)");
            System.out.println();
            System.out.println("Your characters that you choose ");
            for (Characters characters : ChosenChar) {
                characters.printInfo();
            }
        }
        System.out.println();
        System.out.println("You chose your character successfully!!! Well done. Your character's are looking forward you :)");
        Dungeon dungeon = new Dungeon();
        dungeon.displayDungeonInfo();
    }


    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Inventory inventory;
    int charEntering;
    int newCharEntering;

    //this is our character's bag that includes items is in the inventory!!
    public Characters(String name) {
        this.name = name;
        inventory = new Inventory();
    }

    public Characters() {

    }
    public void setCharEntering(int charEntering) {
        this.charEntering = charEntering;
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

    public void setVitality(int vitality) {
        this.vitality = vitality;
    }

    public double getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public double getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public double getMoneyOfChar() {
        return moneyOfChar;
    }

    public void setMoneyOfChar(int charEntering) {
    }

    public void setMoneyOfChar(double moneyOfChar) {
        this.moneyOfChar = moneyOfChar;
    }

    public Weapons getWeaponsRandomly() {

        return weaponsRandomly;
    }

    public void setWeaponsRandomly(Weapons weaponsRandomly) {
        this.weaponsRandomly = weaponsRandomly;
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

    public void setHealthPoint(int healthPoint) {
        if (this.healthPoint+healthPoint>maxHP){
            this.healthPoint=maxHP;
        }
        else {
            this.healthPoint+=healthPoint;
        }
    }



    //the method shows that all information of the character fighter in the game.
    public void submitInfoForFighter() {

        weaponsRandomly.displaySwordsInfo();
        setWeaponsRandomly(weaponsRandomly.getSwordsList().get(secureRandom.nextInt(0, 3)));
        Playable.onHand[0]=getWeaponsRandomly();
        Fighter cammy = new Fighter("Fighter", 1, "Cammy", 20, getWeaponsRandomly());
        Fighter frost = new Fighter("Fighter", 2, "Frost", 30, getWeaponsRandomly());
        Fighter harley = new Fighter("Fighter", 3, "Harley", 15, getWeaponsRandomly());
        Fighter ling = new Fighter("Fighter", 4, "Ling", 50, getWeaponsRandomly());

        fighterArrayList.add(cammy);
        fighterArrayList.add(frost);
        fighterArrayList.add(harley);
        fighterArrayList.add(ling);

        cammy.printInfo();
        frost.printInfo();
        harley.printInfo();
        ling.printInfo();

    }

    public void displayInfoForAll() {

    }

    //the method shows that all information of the character tank in the game.
    public void submitInfoForTank() {
        //weaponsRandomly.displayShieldsInfo();
        //Playable.onHand[0]=getWeaponsRandomly();
        //setWeaponsRandomly(weaponsRandomly.getShieldsList().get(secureRandom.nextInt(0, 3)));
        Tank hulk = new Tank("Tank", 1, "Hulk", 24, getWeaponsRandomly());
        Tank annie = new Tank("Tank", 2, "Annie..", 35, getWeaponsRandomly());
        Tank emily = new Tank("Tank", 3, "Emily..", 15, getWeaponsRandomly());
        Tank ico = new Tank("Tank", 4, "Ico", 30, getWeaponsRandomly());

        tankArrayList.add(hulk);
        tankArrayList.add(annie);
        tankArrayList.add(emily);
        tankArrayList.add(ico);

        hulk.printInfo();
        annie.printInfo();
        emily.printInfo();
        ico.printInfo();
    }

    //the method shows that all information of the character healer in the game.
    public void submitInfoForHealer() {
        //weaponsRandomly.displayWandsInfo();
        //Playable.onHand[0]=getWeaponsRandomly();
        //setWeaponsRandomly(weaponsRandomly.getWandsList().get(secureRandom.nextInt(0, 3)));
        Healer byron = new Healer("Healer", 1, "Byron", 20, getWeaponsRandomly());
        Healer baika = new Healer("Healer", 2, "Baika", 40, getWeaponsRandomly());
        Healer jacky = new Healer("Healer", 3, "Jacky", 35, getWeaponsRandomly());
        Healer naruti = new Healer("Healer", 4, "Naruti", 30, getWeaponsRandomly());

        healerArrayList.add(byron);
        healerArrayList.add(baika);
        healerArrayList.add(jacky);
        healerArrayList.add(naruti);

        byron.printInfo();
        baika.printInfo();
        jacky.printInfo();
        naruti.printInfo();

    }
    public int calculateHealthPoint(int strength, int vitality, int intelligence) {
        healthPoint = (int) ((int )(8*0.7 * vitality) + (8*0.2 * strength) + (8*0.1 * intelligence));
        return healthPoint;
    }

    //this method show character information one by one to see a specific character.
    public void printInfo() {
        System.out.print(" \tType of the character: " + getType() + "\t ID: " + getIdChar() + " \tName: " + getName() +
                "\t\t\tMoney of Character: " + getMoneyOfChar());
    }

    //before choosing a character, this method make an information for user.
    public void chooseCharTable() {
        System.out.println();
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>><<<<>>>>>");
        System.out.println("---------------------------------------------------------------------HINT------------------------------------------------------");
        System.out.println("Our game has three main characters which are Fighter, Tank and Healer. When fighting has to be one of them all characters" +
                " in a game! ");
        System.out.println("Don't forget that all character type has four different character.\n" +
                "               Firstly you need to chooseAttackOrSpecial fighter type :)");
        System.out.println();
        System.out.println("After choosing a character in one type, you must pay money to get other characters for the same type character!");
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------------------------------------------------");
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>><<<<>>>>>");

        charGeneralChoose();
    }

    //this method control if the first character to chooseAttackOrSpecial is fighter because it must be fighter!
    public void charGeneralChoose() {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("FIRSTLY, PLEASE CHOOSE THE CHARACTER FIGHTER BY ENTERING 1! ");
        System.out.print("YOUR CHARACTER TYPE: ");
        setCharEntering(charEntering = scanner.nextInt());
        while (charEntering != 1) {
            System.out.println("!!! Your selection is not valid. Please enter 1 to chooseAttackOrSpecial a fighter!!!");
            System.out.print("YOUR CHARACTER TYPE: ");
            setCharEntering(scanner.nextInt());
        }
        if (charEntering == 1) {
            setType("Fighter");
            fighterChoose();
        }

    }

    public void fighterChoose() {
        Scanner scanner = new Scanner(System.in);
        weaponsRandomly = new Swords("Sword");
        Characters characterFighter = new Fighter();
        System.out.println();
        System.out.println("Fighters are so excited:) ");
        System.out.println();
        System.out.println("-----------------------------------------------------");
        submitInfoForFighter();
        characterFighter.displayInfoForAll();
        System.out.println("-----------------------------------------------------");
        System.out.println();
        System.out.println("Which character do you want to use for fighter? :)");
        int fighterEnter = scanner.nextInt();
        switch (fighterEnter) {
            case 1:

                characterFighter = fighterArrayList.get(0);
                weaponsRandomly.displaySwordsInfo();
                System.out.println("Information of the character: ".toUpperCase(Locale.ROOT));
                System.out.println(" \tType of the character: " + characterFighter.getType() + " \tName: " + characterFighter.getName() + " \tStrength: " + characterFighter.getStrength() +
                        " \tVitality: " + characterFighter.getVitality() + " \tIntelligence: " + characterFighter.getIntelligence() +
                        " \tMoney of character : " + characterFighter.getMoneyOfChar());
                takeRandomlyItemMenu();
                characterFighter.onHand[0]=weapon;
                characterFighter.onHand[0].printInfo();
                //characterFighter.getWeaponsRandomly().printInfo();
                ChosenChar.add(characterFighter);
                Dungeon.EnemyInBattle.add(characterFighter);
                System.out.println("added in array ");
                controlCharForTankAndHealer();
                break;
            case 2:
                characterFighter = fighterArrayList.get(1);
                System.out.println("Information of the character: ".toUpperCase(Locale.ROOT));
                System.out.println(" \tType of the character: " + characterFighter.getType() + "\tName: " + characterFighter.getName() + " \tStrength: " + characterFighter.getStrength() +
                        " \tVitality: " + characterFighter.getVitality() + " \tIntelligence: " + characterFighter.getIntelligence() +
                        " \tMoney of character : " + characterFighter.getMoneyOfChar());
                takeRandomlyItemMenu();
                characterFighter.onHand[0]=weapon;
                characterFighter.onHand[0].printInfo();
                //characterFighter.getWeaponsRandomly().printInfo();
                ChosenChar.add(characterFighter);
                Dungeon.EnemyInBattle.add(characterFighter);
                System.out.println("added in array ");
                controlCharForTankAndHealer();
                break;
            case 3:
                characterFighter = fighterArrayList.get(2);
                System.out.println("Information of the character: ".toUpperCase(Locale.ROOT));
                System.out.println(" \tType of the character: " + characterFighter.getType() + " \tName: " + characterFighter.getName() + " \tStrength: " + characterFighter.getStrength() +
                        " \tVitality: " + characterFighter.getVitality() + " \tIntelligence: " + characterFighter.getIntelligence() +
                        " \tMoney of character : " + characterFighter.getMoneyOfChar());
                takeRandomlyItemMenu();
                characterFighter.onHand[0]=weapon;
                characterFighter.onHand[0].printInfo();
                //characterFighter.getWeaponsRandomly().printInfo();
                ChosenChar.add(characterFighter);
                Dungeon.EnemyInBattle.add(characterFighter);
                System.out.println("added in array ");
                controlCharForTankAndHealer();

                break;
            case 4:
                characterFighter = fighterArrayList.get(3);
                System.out.println("Information of the character: ".toUpperCase(Locale.ROOT));
                System.out.println(" \tType of the character: " + characterFighter.getType() + " \tName: " + characterFighter.getName() + " \tStrength: " + characterFighter.getStrength() +
                        " \tVitality: " + characterFighter.getVitality() + " \tIntelligence: " + characterFighter.getIntelligence() +
                        " \tMoney of character : " + characterFighter.getMoneyOfChar());
                takeRandomlyItemMenu();
                characterFighter.onHand[0]=weapon;
                characterFighter.onHand[0].printInfo();
                //characterFighter.getWeaponsRandomly().printInfo();
                ChosenChar.add(characterFighter);
                Dungeon.EnemyInBattle.add(characterFighter);
                System.out.println("added in array ");
                controlCharForTankAndHealer();
                break;
            default:
                System.out.println("Invalid entering! Please enter a value between 1 and 4.");
                fighterChoose();
                break;

        }
    }

    public void tankChoose() {

        Scanner scanner = new Scanner(System.in);
        Characters characterTank = new Tank();
        System.out.println();
        System.out.println();
        System.out.println("-----------------------------------------------------");
        submitInfoForTank();
        System.out.println("-----------------------------------------------------");
        System.out.println();
        System.out.println("Which character do you want to use for tank? :)");
        int tankEnter = scanner.nextInt();
        switch (tankEnter) {

            case 1:
                characterTank = tankArrayList.get(0);
                System.out.println("Information of the character: ".toUpperCase(Locale.ROOT));
                System.out.println(" \tType of the character: " + characterTank.getType() + " \tName: " + characterTank.getName() + " \tStrength: " + characterTank.getStrength() +
                        " \tVitality: " + characterTank.getVitality() + " \tIntelligence: " + characterTank.getIntelligence() +
                        " \tMoney of character : " + characterTank.getMoneyOfChar());
                takeRandomlyItemMenu();
                characterTank.onHand[0]= weapon1;
                characterTank.onHand[0].printInfo();
                //characterTank.getWeaponsRandomly().printInfo();
                ChosenChar.add(characterTank);
                Dungeon.EnemyInBattle.add(characterTank);
                System.out.println("added in array ");

                break;
            case 2:
                characterTank = tankArrayList.get(1);
                System.out.println("Information of the character: ".toUpperCase(Locale.ROOT));
                System.out.println(" \tType of the character: " + characterTank.getType() + " \tName: " + characterTank.getName() + " \tStrength: " + characterTank.getStrength() +
                        " \tVitality: " + characterTank.getVitality() + " \tIntelligence: " + characterTank.getIntelligence() +
                        " \tMoney of character : " + characterTank.getMoneyOfChar());
                takeRandomlyItemMenu();
                characterTank.onHand[0]= weapon1;
                characterTank.onHand[0].printInfo();
                //characterTank.getWeaponsRandomly().printInfo();
                ChosenChar.add(characterTank);
                Dungeon.EnemyInBattle.add(characterTank);
                System.out.println("added in array ");
                break;

            case 3:
                characterTank = tankArrayList.get(2);
                System.out.println("Information of the character: ".toUpperCase(Locale.ROOT));
                System.out.println(" \tType of the character: " + characterTank.getType() + " \tName: " + characterTank.getName() + " \tStrength: " + characterTank.getStrength() +
                        " \tVitality: " + characterTank.getVitality() + " \tIntelligence: " + characterTank.getIntelligence() +
                        " \tMoney of character : " + characterTank.getMoneyOfChar());
                takeRandomlyItemMenu();
                characterTank.onHand[0]= weapon1;
                characterTank.onHand[0].printInfo();
                //characterTank.getWeaponsRandomly().printInfo();
                ChosenChar.add(characterTank);
                Dungeon.EnemyInBattle.add(characterTank);
                System.out.println("added in array ");

                break;
            case 4:
                characterTank = tankArrayList.get(3);
                System.out.println("Information of the character: ".toUpperCase(Locale.ROOT));
                System.out.println(" \tType of the character: " + characterTank.getType() + " \tName: " + characterTank.getName() + " \tStrength: " + characterTank.getStrength() +
                        " \tVitality: " + characterTank.getVitality() + " \tIntelligence: " + characterTank.getIntelligence() +
                        " \tMoney of character : " + characterTank.getMoneyOfChar());
                takeRandomlyItemMenu();
                characterTank.onHand[0]= weapon1;
                characterTank.onHand[0].printInfo();
                //characterTank.getWeaponsRandomly().printInfo();
                ChosenChar.add(characterTank);
                Dungeon.EnemyInBattle.add(characterTank);
                System.out.println("added in array ");
                break;
            default:
                System.out.println("Invalid entering! Please enter a value between 1 and 4.");
                tankChoose();
                break;

        }

    }

    public void healerChoose() {
        Scanner scanner = new Scanner(System.in);
        Characters characterHealer = new Healer();
        System.out.println();
        System.out.println();
        System.out.println("-----------------------------------------------------");
        submitInfoForHealer();
        System.out.println("-----------------------------------------------------");
        System.out.println();
        System.out.println("Which character do you want to use for healer? :)");
        int healerEnter = scanner.nextInt();
        switch (healerEnter) {
            case 1:
                characterHealer = healerArrayList.get(0);
                System.out.println("Information of the character: ".toUpperCase(Locale.ROOT));
                System.out.println(" \tType of the character: " + characterHealer.getType() + " \tName: " + characterHealer.getName() + " \tStrength: " + characterHealer.getStrength() +
                        " \tVitality: " + characterHealer.getVitality() + " \tIntelligence: " + characterHealer.getIntelligence() +
                        " \tMoney of character : " + characterHealer.getMoneyOfChar());
                takeRandomlyItemMenu();
                characterHealer.onHand[0]=weapon2;
                characterHealer.onHand[0].printInfo();
                //characterHealer.getWeaponsRandomly().printInfo();
                ChosenChar.add(characterHealer);
                Dungeon.EnemyInBattle.add(characterHealer);
                System.out.println("added in array ");
                break;
            case 2:
                characterHealer = healerArrayList.get(1);
                System.out.println("Information of the character: ".toUpperCase(Locale.ROOT));
                System.out.println(" \tType of the character: " + characterHealer.getType() + " \tName: " + characterHealer.getName() + " \tStrength: " + characterHealer.getStrength() +
                        " \tVitality: " + characterHealer.getVitality() + " \tIntelligence: " + characterHealer.getIntelligence() +
                        " \tMoney of character : " + characterHealer.getMoneyOfChar());
                takeRandomlyItemMenu();
                characterHealer.onHand[0]=weapon2;
                characterHealer.onHand[0].printInfo();
                //characterHealer.getWeaponsRandomly().printInfo();
                ChosenChar.add(characterHealer);
                Dungeon.EnemyInBattle.add(characterHealer);
                System.out.println("added in array ");
                break;
            case 3:
                characterHealer = healerArrayList.get(2);
                System.out.println("Information of the character: ".toUpperCase(Locale.ROOT));
                System.out.println(" \tType of the character: " + characterHealer.getType() + " \tName: " + characterHealer.getName() + " \tStrength: " + characterHealer.getStrength() +
                        " \tVitality: " + characterHealer.getVitality() + " \tIntelligence: " + characterHealer.getIntelligence() +
                        " \tMoney of character : " + characterHealer.getMoneyOfChar());
                takeRandomlyItemMenu();
                characterHealer.onHand[0]=weapon2;
                characterHealer.onHand[0].printInfo();
                //characterHealer.getWeaponsRandomly().printInfo();
                ChosenChar.add(characterHealer);
                Dungeon.EnemyInBattle.add(characterHealer);
                System.out.println("added in array ");
                break;
            case 4:
                characterHealer = healerArrayList.get(3);
                System.out.println("Information of the character: ".toUpperCase(Locale.ROOT));
                System.out.println(" \tType of the character: " + characterHealer.getType() + " \tName: " + characterHealer.getName() + " \tStrength: " + characterHealer.getStrength() +
                        " \tVitality: " + characterHealer.getVitality() + " \tIntelligence: " + characterHealer.getIntelligence() +
                        " \tMoney of character : " + characterHealer.getMoneyOfChar());
                takeRandomlyItemMenu();
                characterHealer.onHand[0]=weapon2;
                characterHealer.onHand[0].printInfo();
                //characterHealer.getWeaponsRandomly().printInfo();
                ChosenChar.add(characterHealer);
                Dungeon.EnemyInBattle.add(characterHealer);
                System.out.println(characterHealer.name + "added in array ");
                break;
            default:
                System.out.println("Invalid entering! Please enter a value between 1 and 4.");
                healerChoose();
                break;
        }

    }

    public void takeRandomlyItemMenu() {
        System.out.println();
        System.out.println("\t\t\t---------------------HINT--------------------");
        System.out.println(" The first weapon before starting the game will come automatically! \n " +
                "After first level, you can take weapon from weapon store according to your character's money");
        System.out.println("\t\t\t-----------------------------------------------------");
        System.out.println();
        System.out.println("Loading your randomly weapons... ");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    public int attack(){return 0;}


    public void takeDamage(int damage){
        healthPoint = healthPoint - damage;
    }



}