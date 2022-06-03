import java.util.ArrayList;

public abstract class BattleArea extends Location {
    BattleArea(Characters characters) {
        super(characters);
    }
    BattleArea(ArrayList arrayList, String locationName) {
        super(arrayList);
        this.locationName = locationName;
    }

    //return true because you can get this location.
    @Override
    public boolean takeLocation() {
        return true;


    }}
