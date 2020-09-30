// Aufgabe "Random Student" von Montag der zweiten Woche.
// Alle Aufgaben wurden umgesetzt. Es fehlt nur noch removeStudent()
// und der Test dazu.


package de.neuefische.lennart.db;

import de.neuefische.lennart.model.Student;

import java.util.Arrays;

public class StudentDB {

    private Student[] students;

    public StudentDB(Student[] students) {
        this.students = students;
    }

    public Student[] list() {
        return students;
    }

    @Override
    public String toString() {
        String output = "StudentDB\n";
        for (int i = 0; i < students.length; i++) {
            output += "Name: " + students[i].getName() +
                    "; ID: " + students[i].getId() + "\n";
        }
        return output + "End of DB.";
    }

    public String randomStudent() {
        int index = (int) (Math.random() * students.length);
        return "Randomly selected student\n" +
                "Name: " + students[index].getName() +
                "; ID: " + students[index].getId();
    }

    public void addStudent(Student newStudent) {
        Student[] newStudents = new Student[students.length + 1];
        for (int i = 0; i < students.length; i++) {
            newStudents[i] = students[i];
        }
        newStudents[students.length] = newStudent;
        students = newStudents;
    }
}
