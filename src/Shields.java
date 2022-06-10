import java.util.Locale;

public class Shields extends Weapons{
    public Shields(String nameWeapon){
        super(nameWeapon);
        setKindWeapon(2);
    }

    @Override
    public void printInfo() {
        System.out.println();
        System.out.println("Information of the Shields: ".toUpperCase(Locale.ROOT));
        super.printInfo();
        System.out.println();
    }


    @Override
    public void displayInfoForAllWeapons() {
        for(Shields shields : shieldsList){
            shields.printInfo();
        }
    }
    public void special (Characters character){
        System.out.println("Your character used this shield's special ability." +
                "\nThe character you have chooseAttackOrSpecial will stunned.");
        character.setStunned(true);
    }
}
