package sk.kosickaakademia.kristian.school.hobby;

public abstract class Hobby { //neda sa urobit new Hobby
    private String name;

    public Hobby(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
