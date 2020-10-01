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
        Student[] updatedStudents = new Student[students.length + 1];
        for (int i = 0; i < students.length; i++) {
            updatedStudents[i] = students[i];
        }
        updatedStudents[students.length] = newStudent;
        students = updatedStudents;
    }

    public void removeStudent(int id) {
        if (!containsId(id)){
            return;
        }
        boolean removed = false;
        Student[] updatedStudents = new Student[students.length - 1];
        for (int i = 0; i < updatedStudents.length; i++) {
            Student student = students[i];
            if (student.getId() == id) {
                removed = true;
            }
            int readIndex = removed ? i+1 : i;
            updatedStudents[i] = students[readIndex];
        }
        students = updatedStudents;
    }

    private boolean containsId(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return true;
            }
        }
        return false;
    }
}
