import java.util.ArrayList;
import java.util.Locale;

public class Weapons {
    protected String nameWeapon;
    protected double damageLevel = 1;



    public Weapons(String nameWeapon, double damageLevel, double weight, double moneyWeapon){
        this.nameWeapon = nameWeapon;
        this.damageLevel = damageLevel;
        this.weight = weight;
        this.moneyWeapon = moneyWeapon;
    }
    public Weapons(){

    }
    public double calculateDamageLevel(){
        return damageLevel;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getMoneyWeapon() {
        return moneyWeapon;
    }

    public void setMoneyWeapon(double moneyWeapon) {
        this.moneyWeapon = moneyWeapon;
    }

    protected double weight;
    protected double moneyWeapon;



    public void setNameWeapon(String nameWeapon) {
        this.nameWeapon = nameWeapon;
    }

    public String getNameWeapon() {
        return nameWeapon;
    }

    public void setDamageLevel(double damageLevel) {
        this.damageLevel = damageLevel;
    }

    public double getDamageLevel() {
        return damageLevel;
    }
    public Weapons(String nameWeapon){
        setNameWeapon(nameWeapon);
    }

}

