package monApplication;

public enum MenuOption {

    CITYBYCODEINSEE (0,"Recherche par code insee"),
    CITIESBYNAME (1,"Recherche par nom de communes") ;
//    CITYBYCODEINSEE (0),
//    CITIESBYNAME (1) ;

    private final int value;

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    private final String name;

    MenuOption(int value,String name){
//    MenuOption(int value){

        this.value = value;
        this.name = name;
    }

    public String toString(){
        return name;
    }

    public int giveNumberValue(){
        return value;
    }
}
