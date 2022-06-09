import java.util.ArrayList;

public interface Playable {
    Weapons[] onHand = new Weapons[1];
    Clothes[] onBody = new Clothes[1];
    static ArrayList<Items> Inventory = new ArrayList<>();

    default void addWeapons(Weapons weapons){
        onHand[0] = weapons;
    }
    default void addClothing(Clothes clothing){
        onBody[0] = clothing;
    }
    default void listInventory(ArrayList<Items> Inventory){
        for (Items items : Inventory){
            items.printInfo();
        }
    }
}
