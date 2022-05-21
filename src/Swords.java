import java.security.SecureRandom;

public class Swords extends Weapons{
    public Swords(String nameWeapon, double damageLevel, double weight, double moneyWeapon){
        super(nameWeapon,damageLevel,weight,moneyWeapon);
    }

    @Override
    public double calculateDamageLevel(){
        gamePlay gamePlay = new gamePlay();

        damageLevel = super.damageLevel * gamePlay.characters.getStrength();
        return damageLevel;
    }

}
