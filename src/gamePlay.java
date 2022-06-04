import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class gamePlay {
    Scanner scanner = new Scanner(System.in);
    int sure;
    public Characters characters = new Characters();
    private Items items = new Items();
    private Levels levels;
    Location location;

    public int getCharEntering() {
        return charEntering;
    }

    public void setCharEntering(int charEntering) {
        this.charEntering = charEntering;
    }

    int charEntering;

    public Characters getCharacters() {
        return characters;
    }

    public void setCharacters(Characters characters) {
        this.characters = characters;
    }

    public Items getItems() {
        return items;
    }

    public void setItems(Items items) {
        this.items = items;
    }

    public Levels getLevels() {
        return levels;
    }

    public void setLevels(Levels levels) {
        this.levels = levels;
    }

    public void logIn() {
        System.out.println("===============================================================================");
        System.out.print("WELCOME TO CANNON FOLDER GAME... \n");
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------");
        System.out.print("Before starting to the game, please enter your name --> ");
        String enter = scanner.nextLine();
        System.out.println("Hello " + enter + " :) ");
    }
    public void selectChar() {
        characters.chooseCharTable();
    }

    public void buySomething() {
         location = new weaponStore(characters){
    };

    /*public void selectItem() {
        int selectItem;
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("You chose your character successfully!!! Well done. Your character is looking forward you :)");
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("The last step before playing. You must choose a weapon and clothe for your character.");
        System.out.print("Which one do you want to choose firstly, weapon or clothe? If weapon select 1, clothe select 2: ");
        selectItem = scanner.nextInt();
        switch (selectItem) {
            case 1:
                // I could make a connection between location(weapon store) and characters
                location = new weaponStore(characters);
                break;
            case 2:

        }*/


    }
}






