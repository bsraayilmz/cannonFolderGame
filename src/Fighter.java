import java.security.SecureRandom;

public class Fighter extends Characters{
    SecureRandom secureRandom = new SecureRandom();
    int strengthLevelForFighter = secureRandom.nextInt(6,10);
    int vitalityLevelForFighter = secureRandom.nextInt(3,7);
    int intelligenceLevelForFighter = secureRandom.nextInt(1,5);


    //for the fighter to be selected for the first time
    @Override
    public void displayInfoForAll(){
        for(Fighter fighter : fighterArrayList){
            fighter.printInfo();
        }
    }


    @Override
    public double calculateHealthPoint(int strength, int vitality, int intelligence) {
        super.calculateHealthPoint(strengthLevelForFighter, vitalityLevelForFighter, intelligenceLevelForFighter);
        return healthPoint;
    }


    @Override
    public void printInfo() {
        super.printInfo();
        System.out.print( " \tStrength Level: "+  strengthLevelForFighter + " \tVitality Level: " + vitalityLevelForFighter+
                " \tIntelligence Level: " + intelligenceLevelForFighter  + "\t" +"Health point: "+  calculateHealthPoint(strengthLevelForFighter,vitalityLevelForFighter,intelligenceLevelForFighter)
        + "\tDexerity Level : " + getDexerity() + "\n");
            }
    public Fighter(String type,int ID, String name, double money, Weapons weapons){
        setKind(1);
        setType(type);
        setIdChar(ID);
        setName(name);
        setMoneyOfChar(money);
        setStrength(strengthLevelForFighter);
        setVitality(vitalityLevelForFighter);
        setIntelligence(intelligenceLevelForFighter);
        setWeaponsRandomly(weapons);
        inventoryFighter.add(weapons);
        setVisible(true);
        setStunned(false);
        setInTheGame(true);
        inventoryWeight = 0;
    }
    public Fighter(){
    }

    @Override
    public int attack(Weapons weapons) {
        weapons = Dungeon.EnemyInBattle.get(0).getWeaponsRandomly();
        return weapons.calculateDamageLevel();

    }
}
