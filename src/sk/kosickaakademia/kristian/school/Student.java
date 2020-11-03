package sk.kosickaakademia.kristian.school;

import sk.kosickaakademia.kristian.school.hobby.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

public class Student {
    private String firstName;
    private String lastName;
    private ClassName className; // N1 N2 N3
    private Grades grades;
    private Date dob;
    private int salary;
    private Hobby[] hobbies;
    private int countHobbies;

    public Student(String fname, String lastName, Grades grades, Date date, ClassName className, int salary){
        firstName = fname;
        this.lastName = lastName;
        this.grades = grades;
        this.className = className;
        this.salary = salary;
        dob = date;
        hobbies = new Hobby[5];
        countHobbies = 0;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public ClassName getClassName() {
        return className;
    }

    public int getSalary() {
        return salary;
    }

    public Date getDob() {
        return dob;
    }

    public Grades getGrades() {
        return grades;
    }

    public void print(){
        System.out.println();
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("First name: " + firstName);
        System.out.println("Last name: " + lastName);
        System.out.println("Date of birth: " + sdf.format(dob));
        System.out.println("Class: " + className);
        System.out.println("Salary: " + salary);
        System.out.println(grades.toString());
        printHobbies();
    }

    public void addHobby(Hobby newHobby){
        if (countHobbies == 5){
            System.out.println("Chyba, nemozes mat viac hobby");
            return;
        }
        hobbies[countHobbies++] = newHobby;
    }

    public void printHobbies(){
        System.out.println("\033[34mStudent's hobby: \033[0m");
        for (int i = 0; i < countHobbies; i++) {
            if (hobbies[i] instanceof Programming)
                System.out.print("\033[35m");
            System.out.print(hobbies[i].getName() + "\033[0m");
            if (hobbies[i] instanceof Book){
                System.out.print(" - " + "\033[33m" + ((Book) hobbies[i]).getAuthor() + "\033[0m");
            }
            if (hobbies[i] instanceof Movie){
                System.out.print(" - " + "\033[33m" + ((Movie) hobbies[i]).getYear() + "\033[0m");
            }
            if (hobbies[i] instanceof Games){
                System.out.print(" - " + "\033[33m" + (((Games) hobbies[i]).getGenre()) + "\033[0m");
            }
            System.out.println();
        }
        System.out.println();
    }
}
