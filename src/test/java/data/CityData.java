package data;

public enum CityData {
    MOSCOW("Москва");

    private final String name;
    CityData(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
}
