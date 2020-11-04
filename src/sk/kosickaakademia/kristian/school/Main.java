package sk.kosickaakademia.kristian.school;

import sk.kosickaakademia.kristian.school.hobby.*;
import sk.kosickaakademia.kristian.school.animal.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Student[] students;
        students = initStudents();

        //printN1Students(students);
        //printStudentsWhereAverageLE2(students);
        //printThisYears(students);
        //printAge(students);
        //sortByAverage(students);
        //System.out.println("Sorted");
        //printAverageAllStudents(students);
        Book b1 = new Book("Hlava XXII", "J. Heller");
        students[0].addHobby(b1);
        Sport s1 = new Sport("hockey");
        students[0].addHobby(s1);
        Book b2 = new Book("Marina", "A. Sladkovic");
        students[0].addHobby(b2);
        Movie m1 = new Movie("Aladdin", 2019);
        students[0].addHobby(m1);
        Programming p1 = new Programming("Java");
        students[0].addHobby(p1);
        b1 = new Book("Na zapade nic nove", "E.M.Remarque");
        students[2].addHobby(b1);
        s1 = new Sport("Football");
        students[1].addHobby(s1);
        students[2].addHobby(p1);
        Games g1 = new Games("League of Legends", "life-drainer");
        students[0].addHobby(g1);
        students[5].addHobby(g1);
        students[4].addHobby(g1);
        students[9].addHobby(p1);
        Dog d1 = new Dog("Husky");
        students[9].choosePet(d1);
        students[8].choosePet(new Fish(9));
        students[1].choosePet(new Turtle("Turta"));

        printAllStudents(students);
    }

    private static void sortByAverage(Student[] students) {
        int n = students.length;
        for (int i = 0; i <= n-1; i++){
            for (int j = 0; j < n-1-i; j++){
                if (students[j].getGrades().getAverage() > students[j+1].getGrades().getAverage()){
                    Student temp = students[j];
                    students[j] = students[j+1];
                    students[j+1] = temp;
                }
            }
        }
    }

    //1.1.2000 "2000-1-1"
    private static void printThisYears(Student[] students) {
        System.out.println("\033[32mStudents younger than 18: \033[0m");
        DateFormat dateFormat = new SimpleDateFormat("yyyy");
        for (int i = 0; i < students.length; i++){
            Date dates = students[i].getDob();
            String year = dateFormat.format(dates);
            if (Integer.parseInt(year) > 2000)
                students[i].print();
        }
    }

    private static void printAge(Student[] students){
        // 2020-2005
        // localDate - dob
        DateFormat y = new SimpleDateFormat("yyyy");
        DateFormat m = new SimpleDateFormat("MM");
        DateFormat d = new SimpleDateFormat("dd");
        System.out.println("\033[32mAge of students: \033[0m");
        for (int i = 0; i < students.length; i++){
            Date dates = students[i].getDob();
            int year = Integer.parseInt(y.format(dates));
            int month = Integer.parseInt(m.format(dates));
            int day = Integer.parseInt(d.format(dates));
            Date today = new Date();
            int todayYear = Integer.parseInt(y.format(today));
            int todayMonth = Integer.parseInt(m.format(today));
            int todayDay = Integer.parseInt(d.format(today));
            int result = 0;
            boolean birthday = false;
            /* //ta jednoducha uloha
            result = todayYear - year;
            System.out.println(students[i].getFirstName() + " " + students[i].getLastName() + " " + result); */
            // that complicated
            if (todayMonth > month){
                result = todayYear - year;
            }
            else if (todayMonth < month){
                result = todayYear - year - 1;
            }
            else{
                if (todayDay > day)
                    result = todayYear - year;
                else if (todayDay == day){
                    result = todayYear - year - 1;
                    birthday = true;
                }
                else
                    result = todayYear - year - 1;
            }
            if (birthday == true)
                System.out.println("\033[35m" + students[i].getFirstName() + " " + students[i].getLastName() + " " + result + "\033[0m");
            else
                System.out.println(students[i].getFirstName() + " " + students[i].getLastName() + " " + result);
        }
    }

    private static void printStudentsWhereAverageLE2(Student[] students) {
        System.out.println("\033[34mList of students with average of 2 or less: \033[0m");
        for (int i = 0; i < students.length; i++){
            double average = students[i].getGrades().getAverage();
            if (average <= 2){
                System.out.println("   " + students[i].getFirstName() + " " + students[i].getLastName() + " " + average);
            }
        }
    }

    private static void printN1Students(Student[] students) {
        System.out.println("\033[34mList of 1N students: \033[0m");
        /*for (int i = 0; i < students.length; i++) {
            if (students[i].getClassName() == ClassName.N1) {
                System.out.println("   " + students[i].getFirstName() + " " + students[i].getLastName());
            }
        }*/
        for (Student student : students){
            if (student.getClassName() == ClassName.N1){
                student.print();
            }
        }
        System.out.println();
    }

    private static void printAllStudents(Student[] students) {
        System.out.println("\033[34mList of all students: \033[0m");
        for (Student student : students){
            student.print();
        }
        System.out.println();
    }

    private static Student[] initStudents() {
        Student[] s = new Student[10];

        Grades student1 = new Grades(1,2,3);
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Date dobS1 = getDate(sdf, "2000-10-29");
        Student s1 = new Student("Janko", "Hrasko", student1, dobS1, ClassName.N1, 200);
        s[0] = s1;

        Grades student2 = new Grades(1, 1, 1);
        Date dobS2 = getDate(sdf, "1990-10-30");
        Student s2 = new Student("Marienka", "Nejaka", student2, dobS2, ClassName.N2, 0);
        s[1] = s2;

        Grades student3 = new Grades(2,2,2);
        Student s3 = new Student("Marian", "Ano", student3, getDate(sdf, "1990-2-5"), ClassName.N1, 1500);
        s[2] = s3;

        Date dobS4 = getDate(sdf, "2000-10-5");
        Student s4 = new Student("Adam", "Marek", new Grades(1,2,5), dobS4, ClassName.N3, 1000);
        s[3] = s4;

        Student s5 = new Student("Ivana", "Mackovych", new Grades(1,1,1), getDate(sdf, "2000-2-5"), ClassName.N1, 600);
        s[4] = s5;

        String[] fnames = new String[] {"Jakub", "Marek", "Zuzka", "Nikola", "Dominika"};
        String[] lnames = new String[] {"Nemec", "Slovak", "Cechova", "Malikova", "Malikova"};
        int[] mat = new int[] {1, 1, 4, 3, 2};
        int[] eng = new int[] {5, 1, 2, 1, 1};
        int[] pro = new int[] {2, 1, 3, 2, 2};
        String[] dates = new String[] {"2000-10-20", "1990-1-1", "1980-5-5", "2001-10-5", "1999-9-9"};
        ClassName[] classNames = new ClassName[] {ClassName.N1, ClassName.N1, ClassName.N3, ClassName.N2, ClassName.N1};
        int[] salaries = new int[] {0, 1000, 2500, 600, 800};

        for (int i = 0; i<5; i++){
            s[i+5] = new Student(fnames[i], lnames[i], new Grades(mat[i], eng[i], pro[i]), getDate(sdf, dates[i]), classNames[i], salaries[i]);
        }

        return s;

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

    private static void printAverageAllStudents(Student[] students) {
        System.out.println("\033[34mList of all students: \033[0m");

        for (Student student : students){
            System.out.println(student.getFirstName() + " " + student.getLastName() + " " + student.getGrades().getAverage());
        }

    }
}
