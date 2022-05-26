import java.util.Locale;

public class Swords extends Weapons {
    public Swords(int ID, String nameWeapon, double weight, double moneyWeapon) {
        super(ID, nameWeapon, weight, moneyWeapon);
    }


    @Override
    public boolean printInfo() {
        System.out.println();
        System.out.println("information of the Swords: ".toUpperCase(Locale.ROOT));
        super.printInfo();
        System.out.println();
        return true;
    }
 /*@Override
    /*public double calculateDamageLevel(){
        gamePlay gamePlay = new gamePlay();

        damageLevel = super.damageLevel * gamePlay.characters.getStrength();
        return damageLevel;
    }*/

    public Swords() {

    }

    @Override
    public void displayInfoForAllWeapons() {
        for(Swords swords : swordsList){
            swords.printInfo();
        }
    }
}