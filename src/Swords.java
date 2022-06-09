import java.util.Locale;

public class Swords extends Weapons {
    public Swords( String nameWeapon) {
        super(nameWeapon);
        setKindWeapon(1);
    }


    @Override
    public void printInfo() {
        System.out.println();
        System.out.println("information of the Sword: ".toUpperCase(Locale.ROOT));
        super.printInfo();
        System.out.println();
    }
 /*@Override
    /*public double calculateDamageLevel(){
        gamePlay gamePlay = new gamePlay();

        damageLevel = super.damageLevel * gamePlay.characters.getStrength();
        return damageLevel;
    }*/


    @Override
    public void displayInfoForAllWeapons() {
        for(Swords swords : swordsList){
            swords.printInfo();
        }
    }
    public void special(Characters characters){
        System.out.println("Your character used this sword's special ability." +
                "\nYour character will not take any damage this turn.");
        characters.setInTheGame(false);
    }

    @Override
    public int calculateDamageLevel() {
            int damage=1;
            for (Characters characters : Dungeon.EnemyInBattle) {
                characters.getWeaponsRandomly().setDamageLevel(characters.getStrength() * getDamageLevel());
                damage = (int) characters.getWeaponsRandomly().getDamageLevel();
            }
            return damage;
        }
    }
