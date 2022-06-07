import java.util.Locale;

public class Shields extends Weapons{
    public Shields(int ID, String nameWeapon, double weight, double moneyOfWeapon){
        super(ID,nameWeapon,weight,moneyOfWeapon);
        setKindWeapon(2);
    }

    @Override
    public void printInfoForWeapons() {
        System.out.println();
        System.out.println("Information of the Shields: ".toUpperCase(Locale.ROOT));
        super.printInfoForWeapons();
        System.out.println();
    }
    public Shields() {

    }

    @Override
    public void displayInfoForAllWeapons() {
        for(Shields shields : shieldsList){
            shields.printInfoForWeapons();
        }
    }
    public void special (Characters character,int turn){
        System.out.println("Your character used this shield's special ability." +
                "\nThe character you have chooseAttackOrSpecial will stunned for 3 turn.");
        character.setStunned(true,turn);
    }

    @Override
    public int calculateDamageLevel() {
            int damage=1;
            for (Characters characters : Dungeon.EnemyInBattle) {
                characters.getWeaponsRandomly().setDamageLevel(characters.getVitality() * getDamageLevel());
                damage = (int) characters.getWeaponsRandomly().getDamageLevel();
            }
            return damage;

    }
}
