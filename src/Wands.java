import java.security.SecureRandom;
import java.util.Locale;

public class Wands extends Weapons{
    SecureRandom secureRandom = new SecureRandom();
    int healPoint;

    public Wands(int ID, String name, double weight, double moneyOfWeapon){

        super(ID,name,weight,moneyOfWeapon);
        healPoint = secureRandom.nextInt(1,5);
        setKindWeapon(3);
    }

    @Override
    public void printInfoForWeapons() {
        System.out.println();
        System.out.println("Information of the Swords: ".toUpperCase(Locale.ROOT));
        super.printInfoForWeapons();
        System.out.println();
    }
    public Wands() {

    }

    @Override
    public void displayInfoForAllWeapons() {
        for(Wands wands : wandsList){
            wands.printInfoForWeapons();
        }
    }
    public void special (Characters holder, Characters effected){
        System.out.println("Your character used this wand's special ability." +
                "\nHP of character you have choose increase");
        effected.setHealthPoint(holder.getIntelligence()+healPoint);
    }
}
