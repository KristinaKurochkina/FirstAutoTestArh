package data;

public enum CountryData {

        RUSSIA("Россия");

        private final String name;
        CountryData(String name){
            this.name = name;
        }
        public String getName(){
            return name;
        }
    }

