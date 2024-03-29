import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
public class Dungeon {
    SecureRandom secureRandom = new SecureRandom();
    Scanner input = new Scanner(System.in);
    static ArrayList<Characters> EnemyInBattle = new ArrayList<>();
    static ArrayList<Characters> actionOrder = new ArrayList<>();
    static ArrayList<Characters> enemyKilled = new ArrayList<>();

    //int turn = 1;
    int enemyNumber = 1;
    int floorNumber = 0;
    int indexOfChar = 0;

    public Items randomWeapon(Weapons weapon){

            int randomWeapon = secureRandom.nextInt(1,4);
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


    public void displayDungeonInfo() {
        while (Characters.ChosenChar.size()>0) {
            System.out.println();
            if (floorNumber == 0) {
                System.out.println("\t\t\t\t-----------------------------HINT--------------------------------------\n" + "\t\tYou can kill your teammates! However, don't forget that " +
                        "if you kill your teammates you can lose your total power against the enemies...!");
                System.out.println("\t\t\t\t-----------------------------------------------------------------------");
                System.out.println("Now, the game is starting! Be careful and ready!");
                System.out.println("LOADING...");
            } else {
                System.out.println("*******************************************");
                System.out.println("Well done! You can successfully passed the level " + (floorNumber + 1));
                System.out.println("*******************************************");
                    if(floorNumber%2==0){
                        System.out.println("------------------------------");
                        System.out.println();
                        System.out.println("We have a gift..! Huhuuuuuwww :) ".toUpperCase(Locale.ROOT));
                        System.out.println();
                        System.out.println("Do you want to take it? YES <1> or NO <2>");
                        int yesOrNo =input.nextInt();
                        if(yesOrNo==1){
                            System.out.println("YEEEEEESSS, YOU TOOK IT :) ");
                            EnemyInBattle.get(0).Inventory.add(randomWeapon(new Weapons("Weapon")));
                            EnemyInBattle.get(0).listInventory(EnemyInBattle.get(0).Inventory);
                            System.out.println(EnemyInBattle.get(0).Inventory.isEmpty());
                        }
                        else if(yesOrNo == 2){
                            System.out.println("Well... You know :( ");
                        }
                        else{
                            System.out.println("Please select a valid value..!");
                        }
                    }

            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }


            System.out.println();
            System.out.println("You are on dungeon " + floorNumber + "\n\n" +
                    "There are " + enemyNumber + " enemy in front of you.");
            System.out.println();
            setZero(actionOrder);
            addEnemyAlg();
        }



    }

    public void addEnemyAlg() {
        int weaponSecure = secureRandom.nextInt(0, 11);
        // create enemy according to level of the game
        for (int i = enemyNumber; i > 0; i--) {
            createEnemy(new Enemy("Enemy " + (i+1)), EnemyInBattle);
        }
        battleForEnemy();


    }

    public void battleForEnemy() {
        for (int i=0;i<EnemyInBattle.size();i++) {
            //you will start with enemy to the war.
            if (EnemyInBattle.get(i).getKind() == 4) {
                //
                if (EnemyInBattle.get(i).isStunned()) {
                    System.out.println("This enemy is stunned.");
                    EnemyInBattle.get(i).setStunned(false);
                    break;
                }
                //when enemy is not stunned, and control the situation of the character alive?
                else if (!EnemyInBattle.get(i).isStunned() ) {
                    boolean isTankAlive = false, isFighterAlive = false, isHealerAlive = false;
                    int indexOfTank = 0, indexOfFighter = 0, indexOfHealer = 0, indexOfEnemies = 0;

                    for (int j = 0; j < EnemyInBattle.size(); j++) {
                        if (EnemyInBattle.get(j).getKind() == 2 ) {
                            isTankAlive = true;
                            indexOfTank = j;
                        }
                        if (EnemyInBattle.get(j).getKind() == 1 ) {
                            isFighterAlive = true;
                            indexOfFighter = j;
                        }
                        if (EnemyInBattle.get(j).getKind() == 3) {
                            isHealerAlive = true;
                            indexOfHealer = j;
                        }

                        if (EnemyInBattle.get(i).getKind() == 4 ) {
                            indexOfEnemies = i;
                        }
                    }
                    //Enemy's Battle Ranking:
                    if (isTankAlive && EnemyInBattle.get(indexOfTank).getInTheGame()) {
                        System.out.println();
                        System.out.println("Enemy is attacking to " + EnemyInBattle.get(indexOfTank).getName());
                        if(enemyNumber>1){
                            EnemyInBattle.get(indexOfTank).takeDamage(EnemyInBattle.get(3).attack());
                            /*EnemyInBattle.get(3).attack(EnemyInBattle.get(3).getWeaponsRandomly());
                            EnemyInBattle.get(indexOfTank).setRestHealthPoint((int) (EnemyInBattle.get(indexOfTank).getHealthPoint() -
                                    EnemyInBattle.get(3).getWeaponsRandomly().calculateDamageLevel()));*/

                        }
                        else{
                            EnemyInBattle.get(indexOfTank).takeDamage(EnemyInBattle.get(indexOfEnemies).attack());
                            /*EnemyInBattle.get(indexOfEnemies).attack(EnemyInBattle.get(indexOfEnemies).getWeaponsRandomly());
                            EnemyInBattle.get(indexOfTank).setRestHealthPoint((int) (EnemyInBattle.get(indexOfTank).getHealthPoint() -
                                    EnemyInBattle.get(indexOfEnemies).attack()));*/
                        }
                        if (EnemyInBattle.get(indexOfTank).getHealthPoint() <= 0) {
                            System.out.println(EnemyInBattle.get(indexOfTank).getName() + " is dead");
                            Characters.ChosenChar.remove(EnemyInBattle.get(indexOfTank));
                            EnemyInBattle.remove(EnemyInBattle.get(indexOfTank));

                            if(Characters.ChosenChar.size()<=0){
                                System.out.println("GAME OVER !");
                                System.exit(1);
                                break;
                            } yourTurn();
                        }

                        else {
                            System.out.println(EnemyInBattle.get(indexOfTank).getName() + "'s rest health point: " +
                                    EnemyInBattle.get(indexOfTank).getHealthPoint());
                            yourTurn();

                         break;
                    }}

                    else if (!isTankAlive && isFighterAlive && EnemyInBattle.get(indexOfFighter).getInTheGame()) {
                        System.out.println();
                        System.out.println("Enemy is attacking " + EnemyInBattle.get(indexOfFighter).getName());
                        EnemyInBattle.get(indexOfFighter).takeDamage(EnemyInBattle.get(indexOfEnemies).attack());
                        /*EnemyInBattle.get(indexOfEnemies).attack(EnemyInBattle.get(indexOfEnemies).getWeaponsRandomly());
                        EnemyInBattle.get(indexOfFighter).setRestHealthPoint((int) (EnemyInBattle.get(indexOfFighter).getHealthPoint() -
                                EnemyInBattle.get(indexOfEnemies).getWeaponsRandomly().getDamage()));*/
                        System.out.println(EnemyInBattle.get(indexOfFighter).getHealthPoint());
                        if (EnemyInBattle.get(indexOfFighter).getHealthPoint() <= 0) {
                            isFighterAlive = false;
                            System.out.println("This character is dead");
                            Characters.ChosenChar.remove(EnemyInBattle.get(indexOfFighter));
                            EnemyInBattle.remove(EnemyInBattle.get(indexOfFighter));

                            if(Characters.ChosenChar.size()<=0){
                                System.out.println("GAME OVER !");
                                System.exit(1);
                                break;
                            } yourTurn();
                        }
                            else{
                            System.out.println(EnemyInBattle.get(indexOfTank).getName() + "'s rest health point: " +
                                    EnemyInBattle.get(indexOfTank).getHealthPoint());
                                yourTurn();
                            }

                        break;
                    } else if (!isTankAlive && !isFighterAlive && isHealerAlive && EnemyInBattle.get(indexOfHealer).getInTheGame()) {
                        System.out.println();
                        System.out.println("Enemy is attacking " + EnemyInBattle.get(indexOfHealer).getName());
                        EnemyInBattle.get(indexOfHealer).takeDamage(EnemyInBattle.get(indexOfEnemies).attack());
                        /*EnemyInBattle.get(indexOfEnemies).attack(EnemyInBattle.get(indexOfEnemies).getWeaponsRandomly());
                        EnemyInBattle.get(indexOfFighter).setRestHealthPoint((int) (EnemyInBattle.get(indexOfHealer).getHealthPoint() -
                                EnemyInBattle.get(indexOfEnemies).getWeaponsRandomly().getDamage()));*/
                        System.out.println(EnemyInBattle.get(indexOfHealer).getHealthPoint());
                        if (EnemyInBattle.get(indexOfHealer).getHealthPoint() <= 0) {
                            System.out.println("This character is dead");
                            isHealerAlive = false;
                            Characters.ChosenChar.remove(EnemyInBattle.get(indexOfHealer));
                            EnemyInBattle.remove(EnemyInBattle.get(indexOfHealer));
                            if(Characters.ChosenChar.size()<=0){
                                System.out.println("GAME OVER !");
                                System.exit(1);
                                break;
                            } yourTurn();
                        }
                            else{
                            System.out.println(EnemyInBattle.get(indexOfTank).getName() + "'s rest health point: " +
                                    EnemyInBattle.get(indexOfTank).getHealthPoint());
                                yourTurn();
                            }


                         break;
                    }

                }
            }
        }

    }

    public void yourTurn() {
        System.out.println("\n");
        System.out.println("Now, turn is for your characters");
        System.out.println("Which character do you want to fight ? ");
        for (int i = 0; i < Characters.ChosenChar.size(); i++) {
            System.out.println("\tID: " + Characters.ChosenChar.get(i).getKind() + "\tName: " +
                    Characters.ChosenChar.get(i).getName() + "\tHealth point: " + Characters.ChosenChar.get(i).getHealthPoint());
        }
        for (Characters characters : EnemyInBattle) {
            characters.setInTheGame(true);
        }
        int chooseWith = input.nextInt();
        if (chooseWith == 1 ) {
            for (int j = 0; j < EnemyInBattle.size(); j++) {
                if (EnemyInBattle.get(j).getKind() == 1) {
                    EnemyInBattle.get(j).setInTheGame(true);
                    indexOfChar = j;
                    actionOrder.add(EnemyInBattle.get(j));
                    System.out.println("You will use as a character " + EnemyInBattle.get(j).getName() + " to fight with enemies ");
                    System.out.println("Character list in the battle area");
                    for (int i = 0; i < EnemyInBattle.size(); i++) {
                        System.out.println((i + 1) + "-" + " " + EnemyInBattle.get(i).getName());
                    }
                    System.out.println("Please select enemy to fight with enemy..!");
                    chooseAttackOrSpecial();
                }
            }yourTurn();

        }
        else if (chooseWith == 2) {
            for (int j = 0; j < EnemyInBattle.size(); j++) {
                if (EnemyInBattle.get(j).getKind() == 2 ) {
                    EnemyInBattle.get(j).setInTheGame(true);
                    indexOfChar = j;
                    actionOrder.add(EnemyInBattle.get(j));
                    System.out.println("You will use as a character " + EnemyInBattle.get(j).getName() + " to fight with enemies ");
                    System.out.println("Character list in the battle area");
                    for (int i = 0; i < EnemyInBattle.size(); i++) {
                        System.out.println((i + 1) + "-" + " " + EnemyInBattle.get(i).getName());
                    }
                    System.out.println("Please select enemy to fight with enemy..!");
                    chooseAttackOrSpecial();
                }

            }
            yourTurn();
        } else if (chooseWith == 3) {
            for (int j = 0; j < EnemyInBattle.size(); j++) {
                if (EnemyInBattle.get(j).getKind() == 3 ) {
                    EnemyInBattle.get(j).setInTheGame(true);
                    indexOfChar = j;
                    actionOrder.add(EnemyInBattle.get(j));
                    System.out.println("You will use as a character " + EnemyInBattle.get(j).getName() + " to fight with enemies ");
                    System.out.println("Character list in the battle area");
                    for (int i = 0; i < EnemyInBattle.size(); i++) {
                        System.out.println((i + 1) + "-" + " " + EnemyInBattle.get(i).getName());
                    }

                    System.out.println("Please select enemy to fight with enemy..!");
                    chooseAttackOrSpecial();

                }


            }yourTurn();
        }
        else{
            System.out.println("Please, write a valid value!");
            yourTurn();
        }



    }

    public static void createEnemy(Enemy enemy, ArrayList<Characters> EnemyInBattle) {
        enemy.displayInfoForAll();
        EnemyInBattle.add(enemy);
    }



    public void chooseAttackOrSpecial() {
        int choice2 = input.nextInt();
        for (int i = 0; i < EnemyInBattle.size(); i++) {
            if (choice2 == (i + 1)) {
                if (EnemyInBattle.get(i).getKind() == 4) {
                    System.out.println("Health point of enemy: " + EnemyInBattle.get(i).getHealthPoint());
                    System.out.println("""

                            Here what you can do:
                            1-Attack
                            2-Weapon's Special Move""");
                }
                int attackOrSpecial = input.nextInt();
                if (attackOrSpecial == 1) {
                    System.out.println("Attacking to the enemy...");
                    int restHealthPoint;
                    for (int j = 0; j < EnemyInBattle.size(); j++) {
                        if (EnemyInBattle.get(j).getKind() == 1) {
                            EnemyInBattle.get(i).takeDamage(EnemyInBattle.get(j).attack());

                            if (EnemyInBattle.get(i).getHealthPoint()<0) {
                                enemyKilled.add(EnemyInBattle.get(i));
                                EnemyInBattle.remove(EnemyInBattle.get(i));
                                System.out.println("Well done, you killed the enemy :)");
                                areThereEnemy();
                                break;
                            } else {
                                    System.out.println("You couldn't kill the enemy..!");
                                System.out.println(" Rest health point of enemy: " + EnemyInBattle.get(i).getHealthPoint());
                                battleForEnemy();
                            }
                            break;

                        } else if (EnemyInBattle.get(j).getKind() == 2) {
                            EnemyInBattle.get(i).takeDamage(EnemyInBattle.get(j).attack());
                            if ( EnemyInBattle.get(i).getHealthPoint()<0) {
                                enemyKilled.add(EnemyInBattle.get(i));
                                EnemyInBattle.remove(EnemyInBattle.get(i));
                                System.out.println("Well done, you killed the enemy :)");
                                areThereEnemy();
                                break;
                            } else {
                                System.out.println("You couldn't kill the enemy..!");
                                System.out.println(" Rest health point of enemy: " + EnemyInBattle.get(i).getHealthPoint());
                                battleForEnemy();
                            }
                            break;
                        } else if (EnemyInBattle.get(j).getKind() == 3) {
                            EnemyInBattle.get(i).takeDamage(EnemyInBattle.get(j).attack());
                            if (EnemyInBattle.get(i).getHealthPoint()<0) {
                                enemyKilled.add(EnemyInBattle.get(i));
                                EnemyInBattle.remove(EnemyInBattle.get(i));
                                System.out.println("Well done, you killed the enemy :) ");
                                areThereEnemy();
                                break;
                            } else {
                                System.out.println("You couldn't kill the enemy..!");
                                System.out.println(" Rest health point of enemy: " + EnemyInBattle.get(i).getHealthPoint());
                                battleForEnemy();
                            }
                            break;
                        }
                    }

                }

                else if (attackOrSpecial == 2){

                    if(EnemyInBattle.get(indexOfChar).onHand[0].getKindWeapon()==1){
                        EnemyInBattle.get(indexOfChar).onHand[0].printInfo();
                        EnemyInBattle.get(indexOfChar).onHand[0].special(EnemyInBattle.get(indexOfChar));
                        System.out.println(EnemyInBattle.get(indexOfChar).getName() + " has used his swords to avoid attack");
                        battleForEnemy();
                    }
                    else if(EnemyInBattle.get(indexOfChar).onHand[0].getKindWeapon()==2){
                        EnemyInBattle.get(indexOfChar).onHand[0].printInfo();
                        EnemyInBattle.get(indexOfChar).onHand[0].special(EnemyInBattle.get(choice2-1));
                        System.out.println(EnemyInBattle.get(indexOfChar).getName()+" has used his shield to stun " + EnemyInBattle.get(choice2-1).getName() );
                        battleForEnemy();
                    }
                    else if(EnemyInBattle.get(indexOfChar).onHand[0].getKindWeapon()==3){
                        EnemyInBattle.get(indexOfChar).onHand[0].printInfo();
                        System.out.println("Character list in the battle area");
                        for (int n = 0; n < EnemyInBattle.size(); n++) {
                            System.out.println((n + 1) + "-" + " " + EnemyInBattle.get(n).getName());
                        }
                        System.out.println("Which character do you want to heal?");
                        int choiceToHeal = input.nextInt();
                        EnemyInBattle.get(indexOfChar).onHand[0].special(EnemyInBattle.get(indexOfChar),EnemyInBattle.get(choiceToHeal));
                        battleForEnemy();
                    }
                }
                else {
                    System.out.print("Please enter a valid value to kill the enemies: ");
                    chooseAttackOrSpecial();
                }

            }
        }
}
    //method control if the enemy is in the battle area.
   public void areThereEnemy() {
        int passingInArrayList = 0;
            boolean areThereEnemy = false;
            //showOption(actionOrder.get(passingInArrayList), actionOrder, turn);

            for (Characters characters : EnemyInBattle) {
                if (characters.getKind() == 4) {
                    areThereEnemy = true;

                }
            }
            //if there is least an enemy;
            if (areThereEnemy) {
                System.out.println("You haven't killed all enemies yet. New turn is loading!!");

                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                battleForEnemy();
            } else {
                System.out.println("You have killed all enemies on level. Well done...!");
                System.out.println("Your number of killed enemies: " + enemyKilled.size());
                floorNumber++;
                enemyNumber*=2;
                displayDungeonInfo();

                //menuForWeapon
            }
        }
        public static void setZero(ArrayList<Characters>actionOrder){
            for (Characters characters : actionOrder) {
                if (characters.isStunned()) {
                    characters.setStunned(false);
                }
            }
            for (Characters characters : actionOrder) {
                if (!characters.getInTheGame()) {
                    characters.setInTheGame(true);
                }
            }

        }
    }
