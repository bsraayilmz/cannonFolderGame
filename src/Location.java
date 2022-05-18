import java.util.Scanner;

public abstract class Location {
    Scanner scanner = new Scanner(System.in);
    gamePlay gamePlay = new gamePlay();
    protected Characters characters;
    protected String locationName;
    public Characters getCharacters() {
        return characters;
    }
    //this is boolean and abstract because this method is unclear what to do.--> Character can be died etc.
    public abstract boolean takeLocation();

    public void setCharacters(Characters characters) {
        this.characters = characters;
    }

    public String getCharName() {
        return locationName;
    }

    public void setCharName(String locationName) {
        this.locationName = locationName;
    }


    public Location(Characters characters){
        this.characters = characters;
    }



}


