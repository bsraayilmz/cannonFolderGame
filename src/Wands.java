import java.security.SecureRandom;
import java.util.Locale;

public class Wands extends Weapons{
    SecureRandom secureRandom = new SecureRandom();
    int healPoint;

    public Wands(int ID, String name, int weight, double moneyOfWeapon){

        super(ID,name,weight,moneyOfWeapon);
        healPoint = secureRandom.nextInt(1,5);
        setKindWeapon(3);
    }

    @Override
    public void printInfo() {
        System.out.println();
        System.out.println("Information of the Swords: ".toUpperCase(Locale.ROOT));
        super.printInfo();
        System.out.println();
    }
    public Wands() {

    }

    @Override
    public int calculateDamageLevel() {
        int damage=1;
        for (Characters characters : Dungeon.EnemyInBattle) {
            characters.getWeaponsRandomly().setDamageLevel(characters.getIntelligence() * getDamageLevel());
            damage = (int) characters.getWeaponsRandomly().getDamageLevel();
        }
    return damage;
    }

    @Override
    public void displayInfoForAllWeapons() {
        for(Wands wands : wandsList){
            wands.printInfo();
        }
    }
    public void special (Characters holder, Characters effected){
        System.out.println("Your character used this wand's special ability." +
                "\nHP of character you have chooseAttackOrSpecial increase");
        effected.setHealthPoint((int) (holder.getIntelligence()+healPoint));
    }
}
