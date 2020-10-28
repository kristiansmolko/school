package sk.kosickaakademia.kristian.school;

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



    public Student(String fname, String lastName, Grades grades, Date date, ClassName className, int salary){
        firstName = fname;
        this.lastName = lastName;
        this.grades = grades;
        this.className = className;
        this.salary = salary;
        dob = date;
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

    }
}
