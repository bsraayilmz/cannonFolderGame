import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Scanner;
public class Dungeon {
    SecureRandom secureRandom = new SecureRandom();
    Scanner input = new Scanner(System.in);
    static ArrayList<Characters> EnemyInBattle = new ArrayList<>();
    static ArrayList<Characters> actionOrder = new ArrayList<>();
    static ArrayList<Characters> enemyKilled = new ArrayList<>();
    int turn = 1;
    int enemyNumber = 1;
    int floorNumber = 0;


    public void displayDungeonInfo() {
        while (true) {
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
                //menuStore();
            }
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            System.out.println();
            System.out.println("You are on dungeon " + floorNumber + "\n\n" +
                    "There are " + enemyNumber + " enemy in front of you.");
            System.out.println();
            addEnemyAlg();
        }


    }

    public void addEnemyAlg() {
        int weaponSecure = secureRandom.nextInt(1, 12);
        // create enemy according to level of the game
        for (int i = enemyNumber; i > 0; i--) {
            createEnemy(new Enemy("Enemy " + (i+1), Weapons.weaponsAll.get(weaponSecure)), EnemyInBattle);
        }
        battleForEnemy();


    }

    public void battleForEnemy() {
        for (Characters characters : EnemyInBattle) {
            //you will start with enemy to the war.
            if (characters.getKind() == 4 && characters.isVisible()) {
                //
                if (characters.isStunned()) {
                    System.out.println("This enemy is stunned.");
                }
                //when enemy is not stunned, and control the situation of the character alive?
                else if (!characters.isStunned() && characters.isVisible()) {
                    boolean isTankAlive = false, isFighterAlive = false, isHealerAlive = false;
                    int indexOfTank = 0, indexOfFighter = 0, indexOfHealer = 0, indexOfEnemies = 0;

                    for (int i = 0; i < EnemyInBattle.size(); i++) {
                        if (EnemyInBattle.get(i).getKind() == 2 && EnemyInBattle.get(i).isVisible()) {
                            isTankAlive = true;
                            indexOfTank = i;
                        }
                        if (EnemyInBattle.get(i).getKind() == 1 && EnemyInBattle.get(i).isVisible()) {
                            isFighterAlive = true;
                            indexOfFighter = i;
                        }
                        if (EnemyInBattle.get(i).getKind() == 3 && EnemyInBattle.get(i).isVisible()) {
                            isHealerAlive = true;
                            indexOfHealer = i;
                        }

                        if (EnemyInBattle.get(i).getKind() == 4 && EnemyInBattle.get(i).isVisible()) {
                            indexOfEnemies = i;
                        }
                    }
                    //Enemy's Battle Ranking:
                    if (isTankAlive && turn == 1) {
                        System.out.println();
                        System.out.println("Enemy is attacking to " + EnemyInBattle.get(indexOfTank).getName());

                        EnemyInBattle.get(indexOfEnemies).attack(EnemyInBattle.get(indexOfEnemies).getWeaponsRandomly());
                        EnemyInBattle.get(indexOfTank).setRestHealthPoint((int) (EnemyInBattle.get(indexOfTank).getHealthPoint() -
                                EnemyInBattle.get(indexOfEnemies).getWeaponsRandomly().calculateDamageLevel()));
                        if (EnemyInBattle.get(indexOfTank).getRestHealthPoint() <= 0) {
                            isTankAlive = false;
                            System.out.println(EnemyInBattle.get(indexOfTank).getName() + " is dead");
                            EnemyInBattle.get(indexOfTank).setVisible(false);
                            Characters.ChosenChar.remove(EnemyInBattle.get(indexOfTank));
                            EnemyInBattle.remove(EnemyInBattle.get(indexOfTank));

                            yourTurn();
                        } else {
                            System.out.println(EnemyInBattle.get(indexOfTank).getName() + "'s rest health point: " + EnemyInBattle.get(indexOfTank).getRestHealthPoint());
                            yourTurn();

                        }
                    } else if (isTankAlive && isFighterAlive && isHealerAlive) {
                        System.out.println();
                        System.out.println(" Enemy is attacking randomly");
                        int randomlyAttack = secureRandom.nextInt(0, 2);
                        EnemyInBattle.get(indexOfEnemies).attack(EnemyInBattle.get(indexOfEnemies).getWeaponsRandomly());
                        EnemyInBattle.get(randomlyAttack).setRestHealthPoint((int) (EnemyInBattle.get(randomlyAttack).getHealthPoint() -
                                EnemyInBattle.get(indexOfEnemies).getWeaponsRandomly().calculateDamageLevel()));
                        if (EnemyInBattle.get(randomlyAttack).getRestHealthPoint() <= 0) {
                            System.out.println(EnemyInBattle.get(randomlyAttack).getName() + " is dead");
                            EnemyInBattle.remove(EnemyInBattle.get(randomlyAttack));
                            Characters.ChosenChar.remove(EnemyInBattle.get(randomlyAttack));
                            EnemyInBattle.get(randomlyAttack).setVisible(false);
                            yourTurn();
                        } else {
                            System.out.println(EnemyInBattle.get(indexOfTank).getName() + "'s rest health point: " + EnemyInBattle.get(indexOfTank).getRestHealthPoint());
                            yourTurn();
                        }
                    }
                    if (!isTankAlive && isFighterAlive) {
                        System.out.println();
                        System.out.println("Enemy is attacking " + EnemyInBattle.get(indexOfFighter).getName());
                        EnemyInBattle.get(indexOfEnemies).attack(EnemyInBattle.get(indexOfEnemies).getWeaponsRandomly());
                        EnemyInBattle.get(indexOfFighter).setRestHealthPoint((int) (EnemyInBattle.get(indexOfFighter).getHealthPoint() -
                                EnemyInBattle.get(indexOfEnemies).getWeaponsRandomly().getDamageLevel()));
                        System.out.println(EnemyInBattle.get(indexOfFighter).getRestHealthPoint());
                        if (EnemyInBattle.get(indexOfFighter).getRestHealthPoint() <= 0) {
                            System.out.println("This character is dead");
                            EnemyInBattle.remove(EnemyInBattle.get(indexOfFighter));
                            Characters.ChosenChar.remove(EnemyInBattle.get(indexOfFighter));
                            EnemyInBattle.get(indexOfFighter).setVisible(false);
                        }
                    } else if (!isTankAlive && !isFighterAlive && isHealerAlive) {
                        System.out.println();
                        System.out.println("Enemy is attacking " + EnemyInBattle.get(indexOfHealer).getName());
                        EnemyInBattle.get(indexOfEnemies).attack(EnemyInBattle.get(indexOfEnemies).getWeaponsRandomly());
                        EnemyInBattle.get(indexOfFighter).setRestHealthPoint((int) (EnemyInBattle.get(indexOfHealer).getHealthPoint() -
                                EnemyInBattle.get(indexOfEnemies).getWeaponsRandomly().getDamageLevel()));
                        //  actionOrder.get(indexOfHealer).takeDamage(character.attack());
                        System.out.println(EnemyInBattle.get(indexOfHealer).getRestHealthPoint());
                        if (EnemyInBattle.get(indexOfHealer).getRestHealthPoint() <= 0) {
                            System.out.println("This character's is dead");
                            EnemyInBattle.remove(EnemyInBattle.get(indexOfHealer));
                            Characters.ChosenChar.remove(EnemyInBattle.get(indexOfHealer));
                            EnemyInBattle.get(indexOfHealer).setVisible(false);
                            yourTurn();
                        }
                    }
                }
            }
        }

    }

    public void yourTurn() {
        System.out.println("\n");
        System.out.println("Now, turn is for your characters");
        System.out.println("Which character do you want to fight firstly? ");
        for (int i = 0; i < Characters.ChosenChar.size(); i++) {
            System.out.println("\tID: " + Characters.ChosenChar.get(i).getKind() + "\tName: " +
                    Characters.ChosenChar.get(i).getName() + "\tHealth point: " + Characters.ChosenChar.get(i).getRestHealthPoint());
        }
        int chooseWith = input.nextInt();
        if (chooseWith == 1) {
            for (int j = 0; j < EnemyInBattle.size(); j++) {
                if (EnemyInBattle.get(j).getKind() == 1 && EnemyInBattle.get(j).isVisible()) {
                    actionOrder.add(EnemyInBattle.get(j));
                    System.out.println("You will use as a character " + Characters.ChosenChar.get(0).getName() + " to fight with enemies ");
                    System.out.println("Character list in the battle area");
                    for (int i = 0; i < EnemyInBattle.size(); i++) {
                        System.out.println((i + 1) + "-" + " " + EnemyInBattle.get(i).getName());
                    }
                    System.out.println("Please select enemy to fight with enemy..!");
                    chooseAttackOrSpecial();
                    break;
                }}


        }
        else if (chooseWith == 2) {
            for (int j = 0; j < EnemyInBattle.size(); j++) {
                if (EnemyInBattle.get(j).getKind() == 2 && EnemyInBattle.get(j).isVisible()) {
                    actionOrder.add(EnemyInBattle.get(j));
                    System.out.println("You will use as a character " + Characters.ChosenChar.get(1).getName() + " to fight with enemies ");
                    System.out.println("Character list in the battle area");
                    for (int i = 0; i < EnemyInBattle.size(); i++) {
                        System.out.println((i + 1) + "-" + " " + EnemyInBattle.get(i).getName());
                    }
                    System.out.println("Please select enemy to fight with enemy..!");
                    chooseAttackOrSpecial();
                }

            }
            System.out.println("Your choosing of the character to fight with enemies is not valid! Please try again! ");
            yourTurn();
        } else if (chooseWith == 3) {
            for (int j = 0; j < EnemyInBattle.size(); j++) {
                if (EnemyInBattle.get(j).getKind() == 3 && EnemyInBattle.get(j).isVisible()) {
                    actionOrder.add(EnemyInBattle.get(j));
                    System.out.println("You will use as a character " + Characters.ChosenChar.get(2).getName() + " to fight with enemies ");
                    System.out.println("Character list in the battle area");
                    for (int i = 0; i < EnemyInBattle.size(); i++) {
                        System.out.println((i + 1) + "-" + " " + EnemyInBattle.get(i).getName());
                    }

                    System.out.println("Please select enemy to fight with enemy..!");
                    chooseAttackOrSpecial();
                    break;

                }}

                    System.out.println("Your choosing of the character to fight with enemies is not valid! Please try again! ");
                    yourTurn();



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


    public static int getIndexOfEnemy(ArrayList<Characters> EnemyInBattle) {
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < EnemyInBattle.size(); i++) {
            if (EnemyInBattle.get(i).isVisible()) {
                if (Characters.ChosenChar.get(i).getKind() == 1) {
                    EnemyInBattle.remove(Characters.ChosenChar.get(i));
                    break;
                } else if (Characters.ChosenChar.get(i).getKind() == 2) {
                    EnemyInBattle.remove(Characters.ChosenChar.get(i));
                    break;
                } else if (Characters.ChosenChar.get(i).getKind() == 3) {
                    EnemyInBattle.remove(Characters.ChosenChar.get(i));
                    break;
                }
                System.out.println(i + "-" + EnemyInBattle.get(i).getName());
            }

        }
        int choice = input.nextInt();
        return choice;
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
                            2-Weapon's Speacial Move""");
                }
                int attackOrSpecial = input.nextInt();
                if (attackOrSpecial == 1) {
                    System.out.println("Attacking to the enemy...");
                    int restHealthPoint;
                    for (int j = 0; j < EnemyInBattle.size(); j++) {
                        if (EnemyInBattle.get(j).getKind() == 1) {
                            restHealthPoint = (int) EnemyInBattle.get(i).getHealthPoint() -
                                    actionOrder.get(j).attack(EnemyInBattle.get(j).getWeaponsRandomly());
                            if (restHealthPoint <= 0) {
                                enemyKilled.add(EnemyInBattle.get(i));
                                EnemyInBattle.remove(EnemyInBattle.get(i));
                                System.out.println("Well done, you killed the enemy :)");
                                areThereEnemy();
                                break;
                            } else {
                                    System.out.println("You couldn't kill the enemy..!");
                                System.out.println(" Rest health point of enemy: " + EnemyInBattle.get(i).getRestHealthPoint());
                                turn++;
                                battleForEnemy();
                            }
                            break;

                        } else if (EnemyInBattle.get(j).getKind() == 2) {
                            restHealthPoint = (int) EnemyInBattle.get(i).getHealthPoint() -
                                    EnemyInBattle.get(j).attack(EnemyInBattle.get(j).getWeaponsRandomly());
                            if (restHealthPoint <= 0) {
                                enemyKilled.add(EnemyInBattle.get(i));
                                EnemyInBattle.remove(EnemyInBattle.get(i));
                                System.out.println("Well done, you killed the enemy :)");
                                areThereEnemy();
                                break;
                            } else {
                                System.out.println("You couldn't kill the enemy..!");
                                System.out.println(" Rest health point of enemy: " + EnemyInBattle.get(i).getRestHealthPoint());
                                turn++;
                                battleForEnemy();
                            }
                            break;
                        } else if (actionOrder.get(j).getKind() == 3) {
                            restHealthPoint = (int) EnemyInBattle.get(i).getHealthPoint() -
                                    actionOrder.get(j).attack(actionOrder.get(j).getWeaponsRandomly());
                            if (restHealthPoint <= 0) {
                                enemyKilled.add(EnemyInBattle.get(i));
                                EnemyInBattle.remove(EnemyInBattle.get(i));
                                System.out.println("Well done, you killed the enemy :) ");
                                areThereEnemy();
                                break;
                            } else {
                                System.out.println("You couldn't kill the enemy..!");
                                System.out.println(" Rest health point of enemy: " + EnemyInBattle.get(i).getRestHealthPoint());
                                turn++;
                                battleForEnemy();
                            }
                            break;
                        }
                    }

                } else {
                    System.out.print("Please enter a valid value to kill the enemies: ");
                    chooseAttackOrSpecial();
                }

            }
        }
}


    /*     System.out.println("""

                 Here what you can do:
                 1-Attack
                 2-Weapon's Speacial Move""");
              int choice = input.nextInt();
              if (choice==1){
                  int index = getIndexOfEnemy(EnemyInBattle);

              //    actionOrder.get(index).takeDamage(character.attack(EnemyInBattle.get(index).getWeaponsRandomly()));
                  actionOrder.get(index).printInfo();
                  if (actionOrder.get(index).getHealthPoint()<=0){
                      System.out.println("This character's is dead");
                      actionOrder.get(index).setVisible(false);
                  }
              }
              else if (choice==2){
                  if (character.onHand[0].getKindWeapon()==1){
                      character.onHand[0].special(character, character);
                  }
                  else if (character.onHand[0].getKindWeapon()==2){
                      int index = getIndexOfEnemy(actionOrder);
                      character.onHand[0].special(character,actionOrder.get(index));
                  }
                  else if (character.onHand[0].getKindWeapon()==3){
                      int index = getIndexOfEnemy(actionOrder);
                      character.onHand[0].special(actionOrder.get(index),turn);
                  }

              }
          }*/
    //method control if the enemy is in the battle area.
   public void areThereEnemy() {
        int passingInArrayList = 0;
            boolean areThereEnemy = false;
            //showOption(actionOrder.get(passingInArrayList), actionOrder, turn);

            for (Characters characters : EnemyInBattle) {
                if (characters.getKind() == 4) {
                    if (characters.isVisible()) {
                        areThereEnemy = true;
                    }
                }
            }
            //if there is least an enemy;
            if (areThereEnemy) {
                System.out.println("You haven't killed all enemies yet. New turn is loading!!");
                turn++;
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
                enemyNumber++;
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

     /* public void addEnemy() {
        int weaponSecure = secureRandom.nextInt(1, 12);
        // create enemy according to level of the game
        for (int i = enemyNumber; i > 0; i--) {
            createEnemy(new Enemy("Enemy", Weapons.weaponsAll.get(weaponSecure)), EnemyInBattle);
        }
        //EnemyInBattle.addAll(Characters.ChosenChar);

        do {
            int willDelete = 0;
            Characters[] highestChar = new Characters[1];
            //to decide the high dexerity level!
            highestChar[0] = EnemyInBattle.get(0);
            for (int i = 0; i < EnemyInBattle.size(); i++) {
                if (EnemyInBattle.get(i).getDexerity() > highestChar[0].getDexerity()) {
                    highestChar[0] = EnemyInBattle.get(i);
                    willDelete = i;
                }
            }
            actionOrder.add(highestChar[0]);
            //EnemyInBattle.remove(willDelete);
            EnemyInBattle.remove(EnemyInBattle.get(willDelete));

        }
        while ((enemyNumber + 3) != actionOrder.size());
       // areThereEnemy();
    }*/
