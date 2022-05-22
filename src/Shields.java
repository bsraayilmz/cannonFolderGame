import java.util.Locale;

public class Shields extends Weapons{
    public Shields(int ID, String nameWeapon, double weight, double moneyOfWeapon){
        super(ID,nameWeapon,weight,moneyOfWeapon);
    }

    @Override
    public void printInfo() {
        System.out.println();
        System.out.println("Information of the Shields: ".toUpperCase(Locale.ROOT));
        super.printInfo();
        System.out.println();
    }
}
