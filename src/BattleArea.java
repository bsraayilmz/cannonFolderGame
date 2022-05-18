public abstract class BattleArea extends Location {
    BattleArea(Characters characters) {
        super(characters);
    }

    //return true because you can get this location.
    @Override
    public boolean takeLocation() {
        return true;
    }
}
