import java.security.SecureRandom;
import java.util.ArrayList;

public class Fighter extends Characters{
    SecureRandom secureRandom = new SecureRandom();
    int strengthLevelForFighter = secureRandom.nextInt(6,10);
    int vitalityLevelForFighter = secureRandom.nextInt(3,7);
    int intelligenceLevelForFighter = secureRandom.nextInt(1,5);
    Weapons weapons = new Swords();
    ArrayList<Inventory> inventoryOfFighter = new ArrayList<>();
    ArrayList<Weapons>weaponsOfFighter= new ArrayList<>();




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
                " \tIntelligence Level: " + intelligenceLevelForFighter  + "\n");
            }
    public Fighter(String type,int ID, String name, double money){
        setType(type);
        setIdChar(ID);
        setName(name);
        setMoneyOfChar(money);
        setStrength(strengthLevelForFighter);
        setVitality(vitalityLevelForFighter);
        setIntelligence(intelligenceLevelForFighter);
        //setWeapons(assignWeapon());


    }
    public Fighter(){
    }
    @Override
    public Weapons assignWeapon(){

        super.assignWeapon();
        System.out.println(weapons.getSwordsList().size());
        setWeapons(weapons.getSwordsList().get(secureRandom.nextInt(weapons.getSwordsList().size()-1)));
        return weapons;

    }
    @Override
    public Swords getWeapons () {
        return (Swords) weapons;
    }



}
