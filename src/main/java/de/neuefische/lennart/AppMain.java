package de.neuefische.lennart;

import de.neuefische.lennart.db.StudentDB;
import de.neuefische.lennart.model.Student;

public class AppMain {

    public static void main(String[] args) {

        Student[] studentArray = new Student[] {
                new Student("John Doe", 1),
                new Student("Jane Doe", 2),
                new Student("Jake Doe", 3),
                new Student("Jolly Doe", 4),
                new Student("Jinx Doe", 5)};

        StudentDB studentData = new StudentDB(studentArray);

        System.out.println(studentData.toString());

        for (int i = 0; i < 20; i++) {
            System.out.println(studentData.randomStudent());
        }

    }
}
