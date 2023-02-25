package data;

public enum PersonalData {
    FIRSTNAME ("Кристина"),
    FIRSTNAMELATIN ("Kristina"),
    LASTNAME("Иванова"),
    LASTNAMELATIN("Ivanova"),
    BLOGNAME("Кристина"),
    BIRTHDATE("21.04.1990"),
    ENGLISHLEVEL("Начальный уровень (Beginner)"),
    CONTACT1("Viber"),
    CONTACT2("Facebook"),
    CONTACTVALUE1("89677019887"),
    CONTACTVALUE2("KrisK");

    private final String name;
    PersonalData(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
}