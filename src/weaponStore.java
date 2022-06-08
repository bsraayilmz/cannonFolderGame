public class weaponStore extends ItemStore {

    Swords swords = new Swords(1, "",5,20 );
    Weapons weapons = new Weapons();

    weaponStore(Characters characters,Weapons weapons ) {
        super(characters);
        this.weapons = weapons;
    }
    weaponStore(){
        super();

    }


    weaponStore(Characters characters){
        super(characters, "Weapon Store");
        System.out.println("------------------------------------------------");
        System.out.println("");
       // weaponsRandomly.displaySwordsInfo();
    }

    public boolean takeLocation() {
        selectWeaponsHintMenu();
        return true;
    }


    public void selectWeaponsHintMenu() {

        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("Yeeeess, perfect choice to start with weaponsRandomly. You know this job!!!");
        if (characters.ChosenChar.get(0).getType().equals("Fighter")) {
            System.out.println("Hint: Your character is " + characters.ChosenChar.get(0).getName() + ". Therefore you must chooseAttackOrSpecial a sword " +
                    "that is used more effective by the Fighter type");
        } else if (characters.ChosenChar.get(1).getType().equals("Tank")) {
            System.out.println("Hint: Your character is " + characters.ChosenChar.get(1).getName() + ". Therefore you must chooseAttackOrSpecial a shields" +
                    "that is used more effective by the Tank type");
        } else if (characters.ChosenChar.get(2).getType().equals("Healer")) {
            System.out.println("Hint: Your character is " + characters.ChosenChar.get(2).getName() + ". Therefore you must chooseAttackOrSpecial a wands " +
                    "that is used more effective by the Healer");

        }
        selectWeaponsMenu();
    }

    public void selectWeaponsMenu() {
        System.out.println("\t1) Swords\t2) Shields\t3) Wands\t4)Exit from the game ");
        System.out.print("Which weapon type do you prefer? :");
        int selectionOfWeaponType = scanner.nextInt();
        switch (selectionOfWeaponType) {
            case 1:
                weapons.setNameWeapon("Swords");
                System.out.println("Your Money: " + characters.getMoneyOfChar());
                System.out.println("   \tSWORDS TYPE        DAMAGE        WEIGHT        PRICE");
                System.out.println("1) \tClaymore            " + swords.calculateDamageLevel()+  "              3            30");
                System.out.println("2) \tSamurai             " + swords.calculateDamageLevel()+ "             5            40");
                System.out.println("3) \tYataghan            " + swords.calculateDamageLevel()+ "            7            50");
                System.out.println("4) I don't wanna buy a sword. ");
                System.out.println();
                System.out.print("I want to buy:  ");
                int chooseSword = scanner.nextInt();
                if(chooseSword == 1){
                    buySword(1);
                }
                else if(chooseSword == 2){
                    //buy samurai
                }
                else if(chooseSword==3){
                    //buy yataghan
                }
                else if(chooseSword == 4){
                    System.out.println("Okayy... You can return the weapon menu!");
                    selectWeaponsMenu();
                }
                break;
            case 2:
                weapons.setNameWeapon("Shields");
                System.out.println("Your Money: " + characters.getMoneyOfChar());
                System.out.println("   \tSHIELDS TYPE       DAMAGE        WEIGHT        PRICE");
                System.out.println("1) \tWooden Shelo        " +  /*weaponsRandomly.calculateDamageLevel()*/ "            1            25");
                System.out.println("2) \tBouche              " +  /*weaponsRandomly.calculateDamageLevel()*/ "            3            35");
                System.out.println("3) \tMetal Aspis         " +  /*weaponsRandomly.calculateDamageLevel()*/ "           5            45");
                System.out.println("4) I don't wanna buy a sword. ");
                System.out.println();
                int chooseShield = scanner.nextInt();
                if(chooseShield == 1){
                    buySword(1);
                }
                else if(chooseShield == 2){
                    //buy samurai
                }
                else if(chooseShield==3){
                    //buy yataghan
                }
                else if(chooseShield == 4){
                    System.out.println("Okayy... You can return the weapon menu!");
                    selectWeaponsMenu();
                }
                break;
            case 3:
                weapons.setNameWeapon("Wands");
                System.out.println("Your Money: " + characters.getMoneyOfChar());
                System.out.println("   \tWANDS TYPE        DAMAGE          WEIGHT        PRICE");
                System.out.println("1) \tAmethyst           " +  /*weaponsRandomly.calculateDamageLevel()*/ "              2              40");
                System.out.println("2) \tQuartz             "  /*weaponsRandomly.calculateDamageLevel()*/ + "             3              50");
                System.out.println("3) \tDiamond            " +  /*weaponsRandomly.calculateDamageLevel()*/  "            4              60");
                System.out.println();

                break;
            case 4:
                System.out.println("Return weaponsRandomly menu");
                changeYourWeaponSelection();
                break;
            default:
                System.out.println("Login failed... Please enter a valid value.");
                selectWeaponsMenu();
                break;
        }}




    public void changeYourWeaponSelection() {
        System.out.print("You can change your selection. If you want please enter 0, not enter a number that you want ");
        int changeSelection = scanner.nextInt();
        if (changeSelection == 0) {
            selectWeaponsMenu();
        } else if (changeSelection != 0) {
            //buyWeapon();

        }
    }

    public void buySword(int swordID) {
        double weight = 0;
        String name = null;
        double price = 0;
        double damageSword = 0;
        switch(swordID){
            case 1:
                weight = 3;
                name = "Claymore";
                price = 30;
                damageSword = 50;

                break;
            case 2:
                weight = 5;
                name = "Samurai";
                price = 40;
                damageSword = 30;
                break;

        }
        characters.getInventory().setWeaponName(name);;
        if(swordID >0 && swordID<4){
            if (characters.getMoneyOfChar() < getWeapons().moneyWeapon){
                System.out.println("You cannot buy this weapon. Your money is not enough.!");
                selectWeaponsMenu();
            }else if (characters.getMoneyOfChar() >= getWeapons().moneyWeapon && characters.getStrength() >= getWeapons().getItemWeight()) {
                System.out.println("Congratulations! You had" + getWeapons());
                System.out.println("Your remaining money is: " + (characters.getMoneyOfChar()-getWeapons().moneyWeapon));
            }else if(characters.getStrength() < getWeapons().getItemWeight()){
                System.out.println("You cannot buy this weapon. Be careful, this weapon's weight is too heavy...!");
                selectWeaponsMenu();
            }
        }
        else{
            System.out.println("Please enter a valid value to buy a weapon!!");
            selectWeaponsMenu();
        }


    }

};