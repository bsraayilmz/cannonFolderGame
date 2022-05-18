public class Swords extends Weapons{
    gamePlay gamePlay = new gamePlay();

    public Swords(String nameWeapon, double damageLevel, double weight, double moneyWeapon){
        super(nameWeapon,damageLevel,weight,moneyWeapon);
    }

    @Override
    public double calculateDamageLevel(){

        damageLevel = super.damageLevel * gamePlay.characters.getStrength();
        return damageLevel;
    }

}
