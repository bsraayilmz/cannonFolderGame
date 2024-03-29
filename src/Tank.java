import java.security.SecureRandom;

public class Tank extends Characters{



    SecureRandom secureRandom = new SecureRandom();
    int strengthLevelForTank = secureRandom.nextInt(1,5);
    int vitalityLevelForTank = secureRandom.nextInt(6,10);
    int intelligenceLevelForTank = secureRandom.nextInt(3,7);

    public Tank(String type, int ID, String name, double money, Weapons weapons){
        setKind(2);
        setType(type);
        setIdChar(ID);
        this.name = name;
        this.moneyOfChar = money;
        setStrength(strengthLevelForTank);
        setVitality(vitalityLevelForTank);
        setIntelligence(intelligenceLevelForTank);
        setWeaponsRandomly(weapons);
        inventoryTank.add(weapons);
        setVisible(true);
        setStunned(false);
        setInTheGame(true);
        inventoryWeight = 0;
    }
    public Tank(){

    }
    // to display all tanks be selected for the first time
    @Override
    public void displayInfoForAll(){
        for(Tank tank : tankArrayList){
            tank.printInfo();
        }
    }
    //for choosing character tank
    @Override
    public void printInfo() {
       super.printInfo();
            System.out.print( " \tStrength Level: "+  strengthLevelForTank + " \tVitality Level: " + vitalityLevelForTank+
                    " \tIntelligence Level: " + intelligenceLevelForTank +"\t" +"Health point: "+  calculateHealthPoint(strengthLevelForTank,vitalityLevelForTank,intelligenceLevelForTank)+ "\n");

    }
    @Override
    public int calculateHealthPoint(int strength, int vitality, int intelligence) {
        super.calculateHealthPoint(strengthLevelForTank, vitalityLevelForTank, intelligenceLevelForTank);
        return healthPoint;
    }
    @Override
    public int attack(){
        return (int) (super.onHand[0].getDamage()+this.strength);
    }

}
