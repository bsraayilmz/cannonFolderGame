import java.util.ArrayList;

public abstract class BattleArea extends Location {
    BattleArea(ArrayList arrayList, String locationName) {
        super(arrayList);
        this.locationName = locationName;
    }

    //return true because you can get this location.
    @Override
    public boolean takeLocation() {
        return true;


    }}
