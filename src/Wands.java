import java.util.Locale;

public class Wands extends Weapons{
    public Wands(int ID, String name, double weight, double moneyOfWeapon){
        super(ID,name,weight,moneyOfWeapon);
    }

    @Override
    public void printInfo() {
        System.out.println();
        System.out.println("Information of the Swords: ".toUpperCase(Locale.ROOT));
        super.printInfo();
        System.out.println();
    }
}
