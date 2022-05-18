public class Inventory {
    private Weapons weapons;
    private Clothes clothes;
    //clotheProtectPower--> of clothe that will be bought by user.
    //weaponDamage --> of weapon that will be bought by user.
    private int clotheProtectPower, weaponDamage;
    //weaponName and clotheName that are going to be bought by user too.
    private String weaponName, clotheName;

    // I created this value null or zero, because at the first time there is not any items that character buy.
    public Inventory(){
        this.weapons = null;
        this.clothes = null;
        this.clotheProtectPower = 0;
    }

    public Weapons getWeapons() {
        return weapons;
    }

    public void setWeapons(Weapons weapons) {
        this.weapons = weapons;
    }

    public Clothes getClothes() {
        return clothes;
    }

    public void setClothes(Clothes clothes) {
        this.clothes = clothes;
    }

    public int getClotheProtectPower() {
        return clotheProtectPower;
    }

    public void setClotheProtectPower(int clotheProtectPower) {
        this.clotheProtectPower = clotheProtectPower;
    }

    public int getWeaponDamage() {
        return weaponDamage;
    }

    public void setWeaponDamage(int weaponDamage) {
        this.weaponDamage = weaponDamage;
    }

    public String getWeaponName() {
        return weaponName;
    }

    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
    }

    public String getClotheName() {
        return clotheName;
    }

    public void setClotheName(String clotheName) {
        this.clotheName = clotheName;
    }

    public Inventory(Weapons weapons, Clothes clothes){
        this.weapons = weapons;
        this.clothes = clothes;
    }

}
