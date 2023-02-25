package data;

public enum UserMenuItemsData {
    PERSONAL("personal");

    private final String name;

    UserMenuItemsData(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
