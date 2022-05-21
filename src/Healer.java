import java.security.SecureRandom;
import java.util.IllegalFormatCodePointException;

public class Healer extends Characters{
    SecureRandom secureRandom = new SecureRandom();
    int strengthLevelForHealer = secureRandom.nextInt(3,7);
    int vitalityLevelForHealer = secureRandom.nextInt(1,5);
    int intelligenceLevelForHealer = secureRandom.nextInt(6,10);
    public Healer(String type,int ID,String name, double money){
        setType(type);
        setIdChar(ID);
        this.name = name;
        this.moneyOfChar =  money;
        setStrength(strengthLevelForHealer);
        setVitality(vitalityLevelForHealer);
        setIntelligence(intelligenceLevelForHealer);
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
                " \tIntelligence Level: " + intelligenceLevelForHealer +"\n");
    }
    @Override
    public double calculateHealthPoint(int strength, int vitality, int intelligence) {
        super.calculateHealthPoint(strengthLevelForHealer, vitalityLevelForHealer, intelligenceLevelForHealer);
        return healthPoint;
    }
}
