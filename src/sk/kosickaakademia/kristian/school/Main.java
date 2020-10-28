package sk.kosickaakademia.kristian.school;

public class Main {
    public static void main(String[] args) {
        Grades student1 = new Grades(1,2,3);
        Student s1 = new Student("Janko", "Hrasko", student1, ClassName.N1);
    }
}
