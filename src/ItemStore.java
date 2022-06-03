public abstract class ItemStore extends Location {
    private Weapons weapons;
    private Clothes clothes;

    ItemStore(Characters characters, String locationName) {
        super(characters);
        this.locationName = locationName;
    }
    ItemStore(Characters characters){
        super(characters);
    }
    ItemStore(){
        super();
    }

    // when char comes here, this is a true.
    public boolean takeLocation() {
        System.out.println("You are in Item Store now. You can choose weaponsRandomly and clothes here.");
        return true;
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

}




