package sk.kosickaakademia.kristian.school.hobby;

public class Games extends Hobby{
    private String genre;

    public Games(String name, String genre) {
        super(name);
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }
}
