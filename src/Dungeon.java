import java.util.ArrayList;
import java.util.Scanner;
public class Dungeon{
    Scanner input = new Scanner(System.in);
    static Characters characters5 = new Characters();
    static ArrayList<Characters> EnemyInBattle = new ArrayList<>();
    static ArrayList<Characters> actionOrder = new ArrayList<>();
    int turn = 1;
    int enemyNumber = 1;
    int floorNumber = 0;



    public void displayDungeonInfo(){
                while (true){
                System.out.println("You are on dungeon "+floorNumber+"\n"+
                        "There are "+enemyNumber+" enemy in front of you.");
                        addEnemy();}

    }
    public void addEnemy(){
                for(int i = enemyNumber;i>0;i--){
                    createEnemy(new Enemy("Enemy", characters5.getWeaponsRandomly()),EnemyInBattle);
                }
                for (int k = 0; k< Characters.ChosenChar.size(); k++){
                    EnemyInBattle.add(Characters.ChosenChar.get(k));}
                do {
                    int willDelete = 0;
                    Characters[] highestChar = new Characters[1];
                    highestChar[0] = EnemyInBattle.get(0);
                    for (int i=0;i<EnemyInBattle.size();i++){
                        if (EnemyInBattle.get(i).getDexerity()>highestChar[0].getDexerity()){
                            highestChar[0] = EnemyInBattle.get(i);
                            willDelete = i;
                        }
                    }
                    actionOrder.add(highestChar[0]);
                    EnemyInBattle.remove(willDelete);

                }
                while ((enemyNumber+3)!=actionOrder.size());
                int passingInArrayList =0;
                while (true){
                    boolean areThereEnemy = false;
                    showOption(actionOrder.get(passingInArrayList),actionOrder,turn);

                    for (int i=0;i<actionOrder.size();i++){
                        if (actionOrder.get(i).getKind()==4){
                            if (actionOrder.get(i).isVisible()){
                                areThereEnemy = true;
                            }
                        }
                    }
                    if (areThereEnemy){
                        System.out.println("You haven't killed all enemies yet. New turn is loading!!");
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    else {
                        System.out.println("You have killed all enemies on level. Well done.!.!");
                        int[] indexOfEnemy = new int[enemyNumber];
                        for (int i=0;i<actionOrder.size();i++){
                            int counter = 0;
                            if (actionOrder.get(i).getKind()==4){
                                indexOfEnemy[counter] = i;
                                counter +=1;
                            }
                        }
                        for (int i=0;i<enemyNumber;i++){
                            actionOrder.remove(indexOfEnemy[i]);
                        }
                        EnemyInBattle.add(actionOrder.get(0));
                        EnemyInBattle.add(actionOrder.get(1));
                        EnemyInBattle.add(actionOrder.get(2));
                        actionOrder.remove(0);
                        actionOrder.remove(0);
                        actionOrder.remove(0);
                        break;
                    }

                    if (passingInArrayList != actionOrder.size()){
                        passingInArrayList = passingInArrayList + 1;
                        System.out.println(passingInArrayList);
                    }
                    else if(passingInArrayList == actionOrder.size()-1){
                        passingInArrayList = 0;
                        turn += 1;
                    }
                }
                    floorNumber +=1;
                    enemyNumber *=2;
            }

        public static void createEnemy(Enemy enemy,ArrayList<Characters>EnemyInBattle){
            EnemyInBattle.add(enemy);
        }
        public static void showOption(Characters character,ArrayList<Characters>actionOrder,int turn){
            System.out.println("BUraya giriyor....");
            Scanner input = new Scanner(System.in);
            for(int j=0; j<3; j++){
            if (character.getKind() == 1&& character.isVisible()){
                System.out.println("Now it is Fighter's turn:");}
            else if (character.getKind()== 3&&character.isVisible()){
                System.out.println("Now it is Healer's turn::");}
            else if (character.getKind()==2&&character.isVisible()){
                System.out.println("Now it is Tank's turn:");}
            else if (character.getKind()==4&&character.isVisible()){
                if (character.isStunned()){
                    System.out.println("This enemy is stunned.");
                }
                else if (!character.isStunned() && character.isVisible()){
                    boolean isTankAlive=false;
                    int indexOfTank=0;
                    boolean isFighterAlive=false;
                    int indexOfFighter=0;
                    boolean isHealerAlive=false;
                    int indexOfHealer=0;
                    for (int i=0;i<actionOrder.size();i++){
                        if (actionOrder.get(i).getKind()==2&& actionOrder.get(i).isVisible()){
                            isTankAlive = true;
                            indexOfTank = i;
                        }
                        if (actionOrder.get(i).getKind()==1&& actionOrder.get(i).isVisible()){
                            isFighterAlive=true;
                            indexOfFighter = i;
                        }
                        if (actionOrder.get(i).getKind()==3&& actionOrder.get(i).isVisible()){
                            isHealerAlive=true;
                            indexOfHealer=i;
                        }
                    }
                    if (isTankAlive){
                        System.out.println("Enemy is attacking Tank");
                        actionOrder.get(indexOfTank).takeDamage(character.attack());
                        actionOrder.get(indexOfTank).getHealthPoint();
                        if (actionOrder.get(indexOfTank).getHealthPoint()<=0){
                            System.out.println("This character's is dead");
                            actionOrder.get(indexOfTank).setVisible(false);
                        }
                    }
                    else if (!isTankAlive && isFighterAlive){
                        System.out.println("Enemy is attacking Fighter");
                        actionOrder.get(indexOfFighter).takeDamage(character.attack());
                        System.out.println(actionOrder.get(indexOfFighter).getHealthPoint());
                        if (actionOrder.get(indexOfFighter).getHealthPoint()<=0){
                            System.out.println("This character's is dead");
                            actionOrder.get(indexOfFighter).setVisible(false);
                        }
                    }
                    else if (!isFighterAlive && !isFighterAlive && isHealerAlive){
                        System.out.println("Enemy is attacking Healer");
                        actionOrder.get(indexOfHealer).takeDamage(character.attack());
                        System.out.println(actionOrder.get(indexOfHealer).getHealthPoint());
                        if (actionOrder.get(indexOfHealer).getHealthPoint()<=0){
                            System.out.println("This character's is dead");
                            actionOrder.get(indexOfHealer).setVisible(false);
                        }
                    }
                }}
            }
            if ((character.getType().equals("Fighter")||character.getType().equals("Tank")||character.getType().equals("Healer"))&& character.isVisible()){
                System.out.println("\nHere what you can do:" +
                        "\n1-Attack" +
                        "\n2-Weapon's Speacial Move");
                int choice = input.nextInt();
                if (choice==1){
                    int index = getIndexOfEnemy(actionOrder);
                    actionOrder.get(index).takeDamage(character.attack());
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
            }
        }


        public static int getIndexOfEnemy(ArrayList<Characters>actionOrder){
            Scanner input = new Scanner(System.in);
            System.out.println("Enemy list that you can attack:");
            for (int i = 0;i<actionOrder.size();i++){
                if (actionOrder.get(i).isVisible()){
                    System.out.println(i+"-"+actionOrder.get(i).getName());
                }

            }
            System.out.println("Please write number of Character that you want to have action on:");
            int choice = input.nextInt();
            return choice;
        }


}