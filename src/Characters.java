import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Characters {
    protected String name;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    protected String type;
    protected int vitality;
    protected int intelligence;
    protected int strength;

    public int getIdChar() {
        return idChar;
    }

    public void setIdChar(int idChar) {
        this.idChar = idChar;
    }

    protected int idChar;
    protected double moneyOfChar;
    protected Weapons weapons;
    protected Clothes clothes;
    protected double healthPoint;

    ArrayList<Healer> healerArrayList = new ArrayList<>();
    ArrayList<Tank> tankArrayList = new ArrayList<>();
    ArrayList<Fighter> fighterArrayList = new ArrayList<>();
    ArrayList<ArrayList> charactersTypesList = new ArrayList<>();
    ArrayList<Characters> ChosenChar = new ArrayList<>();


    public void controlChar() {
        gamePlay gamePlay = new gamePlay();
        Scanner scanner = new Scanner(System.in);

        if (ChosenChar.get(0).getType().equals("Fighter")) {
            System.out.println("You cannot add a fighter character in battle char list! ");
            System.out.println();
            System.out.println("Now, for the second char, which one do you add? ");
            System.out.println("                       Tank-->    please enter 1 ------- ");
            System.out.print("                       Healer-->  please enter 2 ------- ");
            System.out.print("YOUR CHARACTER TYPE: ");
            setCharEntering(charEntering = scanner.nextInt());

            while (charEntering < 1 || charEntering > 3) {
                System.out.println("!!! Your selection is not valid. Please enter a value between 1 and 3 !!!");
                System.out.print("YOUR CHARACTER TYPE: ");
                setCharEntering(scanner.nextInt());
            }
            if (charEntering == 1) {
                tankChoose();
                System.out.println("You cannot add a tank character in battle char list! ");
                System.out.println();
                healerChoose();
                System.out.println("Yeeeey, you completed char list. Well done :)");
            } else if (charEntering == 2) {
                healerChoose();
                System.out.println("You cannot add a healer character in battle char list! ");
                System.out.println();
                tankChoose();
                System.out.println("Yeeeey, you completed char list. Well done :)");
            }
            System.out.println("Your characters that you choose ");
            for (Characters characters : ChosenChar) {
                characters.printInfo();
                gamePlay.selectItem();
            }
        }

    }


        public Inventory getInventory () {
            return inventory;
        }

        public void setInventory (Inventory inventory){
            this.inventory = inventory;
        }

        private Inventory inventory;
        int charEntering;
        int newCharEntering;

        //this is our character's bag that includes items is in the inventory!!
    public Characters(String name) {
            this.name = name;
            inventory = new Inventory();
        }
    public Characters() {

        }
    public Characters(Weapons weapons) {
            this.weapons = weapons;
        }

        public int getCharEntering () {
            return charEntering;
        }

        public void setCharEntering ( int charEntering){
            this.charEntering = charEntering;
        }

        public int getNewCharEntering () {
            return newCharEntering;
        }

        public void setNewCharEntering ( int newCharEntering){
            this.newCharEntering = newCharEntering;
        }


        public String getName () {
            return name;
        }


        public void setName (String name){
            this.name = name;
        }

        public double getVitality () {
            return vitality;
        }

        public void setVitality ( int vitality){
            this.vitality = vitality;
        }

        public double getIntelligence () {
            return intelligence;
        }

        public void setIntelligence ( int intelligence){
            this.intelligence = intelligence;
        }

        public double getStrength () {
            return strength;
        }

        public void setStrength ( int strength){
            this.strength = strength;
        }

        public double getMoneyOfChar () {
            return moneyOfChar;
        }

        public void setMoneyOfChar ( int charEntering){
        }
        public void setMoneyOfChar ( double moneyOfChar){
            this.moneyOfChar = moneyOfChar;
        }

        public Weapons getWeapons () {
            return weapons;
        }

        public void setWeapons (Weapons weapons){
            this.weapons = weapons;
        }

        public Clothes getClothes () {
            return clothes;
        }

        public void setClothes (Clothes clothes){
            this.clothes = clothes;
        }

        public double getHealthPoint () {
            return healthPoint;
        }

        public void setHealthPoint ( double healthPoint){
            this.healthPoint = healthPoint;
        }


        public void attack () {

        }
        public void submitTypeOfChar () {
            charactersTypesList.add(1, fighterArrayList);
            charactersTypesList.add(2, tankArrayList);
            charactersTypesList.add(3, healerArrayList);
        }


        public void displayInfoForFighter() {
            Fighter cammy = new Fighter("Fighter", 1, "Cammy", 20);
            Fighter frost = new Fighter("Fighter", 2, "Frost", 30);
            Fighter harley = new Fighter("Fighter", 3, "Harley", 15);
            Fighter ling = new Fighter("Fighter", 4, "Ling", 50);
            fighterArrayList.add(cammy);
            fighterArrayList.add(frost);
            fighterArrayList.add(harley);
            fighterArrayList.add(ling);
            cammy.printInfo();
            frost.printInfo();
            harley.printInfo();
            ling.printInfo();

        }
        public void displayInfoForAll () {

        }


        public void displayInfoForTank () {
            Tank hulk = new Tank("Tank",1, "Hulk", 24);
            Tank annie = new Tank("Tank",2, "Annie..", 35);
            Tank emily = new Tank("Tank",3, "Emily..", 15);
            Tank ico = new Tank("Tank",4, "Ico", 30);
            tankArrayList.add(hulk);
            tankArrayList.add(annie);
            tankArrayList.add(emily);
            tankArrayList.add(ico);
            hulk.printInfo();
            annie.printInfo();
            emily.printInfo();
            ico.printInfo();
        }


        public void displayInfoForHealer () {
            Healer byron = new Healer("Healer",1, "Byron", 20);
            Healer baika = new Healer("Healer",2, "Baika", 40);
            Healer jacky = new Healer("Healer",3, "Jacky", 35);
            Healer naruti = new Healer("Healer",4, "Naruti", 30);

            healerArrayList.add(byron);
            healerArrayList.add(baika);
            healerArrayList.add(jacky);
            healerArrayList.add(naruti);

            byron.printInfo();
            baika.printInfo();
            jacky.printInfo();
            naruti.printInfo();

        }


        public double calculateHealthPoint ( int strength, int vitality, int intelligence){
            healthPoint = (0.7 * vitality) + (0.2 * strength) + (0.1 * intelligence);
            return healthPoint;
        }

        public void printInfo () {
            System.out.print(" \tType of the character: "+ getType()+ "\t ID: " + getIdChar() + " \tName: " + getName() +
                    "\t\t\tMoney of Character: " + getMoneyOfChar());
        }
        public void charValuesTable (String name,int strength, int vitality, int intelligence, double moneyOfChar){
            setName(name);
            setStrength(strength);
            setVitality(vitality);
            setIntelligence(intelligence);
            setMoneyOfChar(moneyOfChar);
            calculateHealthPoint(strength, vitality, intelligence);

        }
        public void chooseCharTable () {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Our game has three main characters which are Fighter, Tank and Healer. You must choose all of them" +
                    " in a game! ");
            System.out.println("Don't forget that all character type has four different character.\n" +
                    "               Firstly which character type do you want to choose?");
            System.out.println();
            System.out.println("When choosing a character, you must pay money to get other characters");
            System.out.println();
            charGeneralChoose();
        }

        public void charGeneralChoose () {
            Scanner scanner = new Scanner(System.in);
            System.out.println("If your selection is   Fighter--> please enter 1 ------- ");
            System.out.println("                       Tank-->    please enter 2 ------- ");
            System.out.print("                       Healer-->  please enter 3 ------- ");
            System.out.print("YOUR CHARACTER TYPE: ");
            setCharEntering(charEntering = scanner.nextInt());
            while (charEntering < 1 || charEntering > 3) {
                System.out.println("!!! Your selection is not valid. Please enter a value between 1 and 3 !!!");
                System.out.print("YOUR CHARACTER TYPE: ");
                setCharEntering(scanner.nextInt());
            }
            if (charEntering == 1) {
                setType("Fighter");
                fighterChoose();
            } else if (charEntering == 2) {
                setType("Tank");
                tankChoose();
            } else if (charEntering == 3) {
                setType("Healer");
                healerChoose();
            }

        }
        public void fighterChoose () {
            Scanner scanner = new Scanner(System.in);
            Characters characterFighter = new Fighter();
            System.out.println();
            System.out.println("You want to start with choosing Fighter! Fighters are so excited:) ");
            System.out.println();
            System.out.println("-----------------------------------------------------");
            displayInfoForFighter();
            characterFighter.displayInfoForAll();
            System.out.println("-----------------------------------------------------");
            System.out.println();
            System.out.println("Which character do you want to use for fighter? :)");
            int fighterEnter = scanner.nextInt();
            switch (fighterEnter) {
                case 1:
                    characterFighter = fighterArrayList.get(0);
                    System.out.println("Information of the character: ".toUpperCase(Locale.ROOT));
                    System.out.println(" \tType of the character: "+ characterFighter.getType()+" \tName: " + characterFighter.getName() + " \tStrength: " + characterFighter.getStrength() +
                            " \tVitality: " + characterFighter.getVitality() + " \tIntelligence: " + characterFighter.getIntelligence() +
                            " \tMoney of character : " + characterFighter.getMoneyOfChar());
                    ChosenChar.add(characterFighter);
                    System.out.println("added in array ");
                    controlChar();

                    break;
                case 2:
                    characterFighter = fighterArrayList.get(1);
                    System.out.println("Information of the character: ".toUpperCase(Locale.ROOT));
                    System.out.println(" \tType of the character: "+ characterFighter.getType()+ "\tName: " + characterFighter.getName() + " \tStrength: " + characterFighter.getStrength() +
                            " \tVitality: " + characterFighter.getVitality() + " \tIntelligence: " + characterFighter.getIntelligence() +
                            " \tMoney of character : " + characterFighter.getMoneyOfChar());
                    ChosenChar.add(characterFighter);
                    System.out.println("added in array ");
                    controlChar();
                    break;
                case 3:
                    characterFighter = fighterArrayList.get(2);
                    System.out.println("Information of the character: ".toUpperCase(Locale.ROOT));
                    System.out.println(" \tType of the character: "+ characterFighter.getType()+" \tName: " + characterFighter.getName() + " \tStrength: " + characterFighter.getStrength() +
                            " \tVitality: " + characterFighter.getVitality() + " \tIntelligence: " + characterFighter.getIntelligence() +
                            " \tMoney of character : " + characterFighter.getMoneyOfChar());
                    ChosenChar.add(characterFighter);
                    System.out.println("added in array ");
                    controlChar();

                    break;
                case 4:
                    characterFighter = fighterArrayList.get(3);
                    System.out.println("Information of the character: ".toUpperCase(Locale.ROOT));
                    System.out.println(" \tType of the character: "+ characterFighter.getType()+" \tName: " + characterFighter.getName() + " \tStrength: " + characterFighter.getStrength() +
                            " \tVitality: " + characterFighter.getVitality() + " \tIntelligence: " + characterFighter.getIntelligence() +
                            " \tMoney of character : " + characterFighter.getMoneyOfChar());
                    ChosenChar.add(characterFighter);
                    System.out.println("added in array ");
                    controlChar();
                    break;
                default:
                    System.out.println("Invalid entering! Please enter a value between 1 and 4.");
                    fighterChoose();
                    break;

            }
        }
        public void tankChoose () {
            Scanner scanner = new Scanner(System.in);
            Characters characterTank = new Tank();
            System.out.println();
            System.out.println("You want to start with choosing Tank ! Tanks are so excited:) ");
            System.out.println();
            System.out.println("-----------------------------------------------------");
            displayInfoForTank();
            System.out.println("-----------------------------------------------------");
            System.out.println();
            System.out.println("Which character do you want to use for tank? :)");
            int tankEnter = scanner.nextInt();
            switch (tankEnter) {

                case 1:
                    characterTank = tankArrayList.get(0);
                    System.out.println("Information of the character: ".toUpperCase(Locale.ROOT));
                    System.out.println(" \tType of the character: "+ characterTank.getType()+" \tName: " + characterTank.getName() + " \tStrength: " + characterTank.getStrength() +
                            " \tVitality: " + characterTank.getVitality() + " \tIntelligence: " + characterTank.getIntelligence() +
                            " \tMoney of character : " + characterTank.getMoneyOfChar());
                    ChosenChar.add(characterTank);
                    System.out.println("added in array ");

                    break;
                case 2:
                    characterTank = tankArrayList.get(1);
                    System.out.println("Information of the character: ".toUpperCase(Locale.ROOT));
                    System.out.println(" \tType of the character: "+ characterTank.getType()+" \tName: " + characterTank.getName() + " \tStrength: " + characterTank.getStrength() +
                            " \tVitality: " + characterTank.getVitality() + " \tIntelligence: " + characterTank.getIntelligence() +
                            " \tMoney of character : " + characterTank.getMoneyOfChar());
                    ChosenChar.add(characterTank);
                    System.out.println("added in array ");
                    break;

                case 3:
                    characterTank = tankArrayList.get(2);
                    System.out.println("Information of the character: ".toUpperCase(Locale.ROOT));
                    System.out.println(" \tType of the character: "+ characterTank.getType()+" \tName: " + characterTank.getName() + " \tStrength: " + characterTank.getStrength() +
                            " \tVitality: " + characterTank.getVitality() + " \tIntelligence: " + characterTank.getIntelligence() +
                            " \tMoney of character : " + characterTank.getMoneyOfChar());
                    ChosenChar.add(characterTank);
                    System.out.println("added in array ");

                    break;
                case 4:
                    characterTank = tankArrayList.get(3);
                    System.out.println("Information of the character: ".toUpperCase(Locale.ROOT));
                    System.out.println(" \tType of the character: "+ characterTank.getType()+" \tName: " + characterTank.getName() + " \tStrength: " + characterTank.getStrength() +
                            " \tVitality: " + characterTank.getVitality() + " \tIntelligence: " + characterTank.getIntelligence() +
                            " \tMoney of character : " + characterTank.getMoneyOfChar());
                    ChosenChar.add(characterTank);
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
            System.out.println("You want to start with choosing Healers! Healers are so excited:) ");
            System.out.println();
            System.out.println("-----------------------------------------------------");
            displayInfoForHealer();
            System.out.println("-----------------------------------------------------");
            System.out.println();
            System.out.println("Which character do you want to use for healer? :)");
            int healerEnter = scanner.nextInt();
            switch (healerEnter) {

                case 1:
                    characterHealer = healerArrayList.get(0);
                    System.out.println("Information of the character: ".toUpperCase(Locale.ROOT));
                    System.out.println(" \tType of the character: "+ characterHealer.getType()+" \tName: " + characterHealer.getName() + " \tStrength: " + characterHealer.getStrength() +
                            " \tVitality: " + characterHealer.getVitality() + " \tIntelligence: " + characterHealer.getIntelligence() +
                            " \tMoney of character : " + characterHealer.getMoneyOfChar());
                    ChosenChar.add(characterHealer);
                    System.out.println("added in array ");
                    break;
                case 2:
                    characterHealer = healerArrayList.get(1);
                    System.out.println("Information of the character: ".toUpperCase(Locale.ROOT));
                    System.out.println(" \tType of the character: "+ characterHealer.getType()+" \tName: " + characterHealer.getName() + " \tStrength: " + characterHealer.getStrength() +
                            " \tVitality: " + characterHealer.getVitality() + " \tIntelligence: " + characterHealer.getIntelligence() +
                            " \tMoney of character : " + characterHealer.getMoneyOfChar());
                    ChosenChar.add(characterHealer);
                    System.out.println("added in array ");
                    break;
                case 3:
                    characterHealer = healerArrayList.get(2);
                    System.out.println("Information of the character: ".toUpperCase(Locale.ROOT));
                    System.out.println(" \tType of the character: "+ characterHealer.getType()+" \tName: " + characterHealer.getName() + " \tStrength: " + characterHealer.getStrength() +
                            " \tVitality: " + characterHealer.getVitality() + " \tIntelligence: " + characterHealer.getIntelligence() +
                            " \tMoney of character : " + characterHealer.getMoneyOfChar());
                    ChosenChar.add(characterHealer);
                    System.out.println("added in array ");
                    break;
                case 4:
                    characterHealer = healerArrayList.get(3);
                    System.out.println("Information of the character: ".toUpperCase(Locale.ROOT));
                    System.out.println(" \tType of the character: "+ characterHealer.getType()+" \tName: " + characterHealer.getName() + " \tStrength: " + characterHealer.getStrength() +
                            " \tVitality: " + characterHealer.getVitality() + " \tIntelligence: " + characterHealer.getIntelligence() +
                            " \tMoney of character : " + characterHealer.getMoneyOfChar());
                    ChosenChar.add(characterHealer);
                    System.out.println(characterHealer.name + "added in array ");
                    break;
                default:
                    System.out.println("Invalid entering! Please enter a value between 1 and 4.");
                    healerChoose();
                    break;
            }

        }


    }