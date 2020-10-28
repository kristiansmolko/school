package sk.kosickaakademia.kristian.school;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Grades student1 = new Grades(1,2,3);
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Date dobS1 = getDate(sdf, "2001-05-10");
        Student s1 = new Student("Janko", "Hrasko", student1, dobS1, ClassName.N1, 200);
        s1.print();

        Grades student2 = new Grades(1, 1, 1);
        Date dobS2 = getDate(sdf, "1995-10-15");
        Student s2 = new Student("Marienka", "Nejaka", student2, dobS2, ClassName.N2, 0);
        s2.print();

        Grades student3 = new Grades(2,2,2);
        Date dobS3 = getDate(sdf, "1990-2-5");
        Student s3 = new Student("Marian", "Ano", student3, dobS3, ClassName.N1, 1500);
        s3.print();

        Grades student4 = new Grades(1,2,5);
        Date dobS4 = getDate(sdf, "2000-10-5");
        Student s4 = new Student("Adam", "Marek", student4, dobS4, ClassName.N3, 1000);
        s4.print();




    }

    private static Date getDate(DateFormat sdf, String date) {
        Date dobS1 = null;
        try {
            dobS1 = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dobS1;
    }
}
