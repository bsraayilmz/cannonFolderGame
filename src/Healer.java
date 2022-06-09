import java.security.SecureRandom;

public class Healer extends Characters{
    SecureRandom secureRandom = new SecureRandom();
    int strengthLevelForHealer = secureRandom.nextInt(3,7);
    int vitalityLevelForHealer = secureRandom.nextInt(1,5);
    int intelligenceLevelForHealer = secureRandom.nextInt(6,10);
    public Healer(String type,int ID,String name, double money, Weapons weapons){
        setKind(3);
        setType(type);
        setIdChar(ID);
        this.name = name;
        this.moneyOfChar =  money;
        setStrength(strengthLevelForHealer);
        setVitality(vitalityLevelForHealer);
        setIntelligence(intelligenceLevelForHealer);
        setWeaponsRandomly(weapons);
        inventoryHealer.add(weapons);
    }
    //to display all healer
    @Override
    public void displayInfoForAll(){
        for(Healer healer : healerArrayList){
            // with for loop, I can see all healers' info.
            healer.printInfo();
        }
    }
    public Healer(){

    }
    // for the specific healer
    @Override
    public void printInfo() {
        super.printInfo();
        System.out.print( " \tStrength Level: "+  strengthLevelForHealer + " \tVitality Level: " + vitalityLevelForHealer+
                " \tIntelligence Level: " + intelligenceLevelForHealer +"\t" +"Health point: "+  calculateHealthPoint(strengthLevelForHealer,vitalityLevelForHealer,intelligenceLevelForHealer)+
                "\t Dexerity Level: " + getDexerity() + "\n");
    }
    @Override
    public double calculateHealthPoint(int strength, int vitality, int intelligence) {
        super.calculateHealthPoint(strengthLevelForHealer, vitalityLevelForHealer, intelligenceLevelForHealer);
        return healthPoint;
    }
    @Override
    public int attack(Weapons weapons){
        for(int i=0; i<Dungeon.EnemyInBattle.size();i++){
            if(Dungeon.EnemyInBattle.get(i).getKind()==3){
                weapons = Dungeon.EnemyInBattle.get(i).getWeaponsRandomly();
            }
        }return weapons.calculateDamageLevel();

    }
}
