package de.neuefische.lennart.db;

import de.neuefische.lennart.model.Student;
import org.junit.jupiter.api.Test;

import java.rmi.StubNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class StudentDBTest {

    @Test
    void testList() {
        // GIVEN
        Student student1 = new Student("John Doe", 1);
        Student student2 = new Student("Jane Doe", 2);
        Student student3 = new Student("Jake Doe", 3);
        Student student4 = new Student("Jolly Doe", 4);
        Student student5 = new Student("Jinx Doe", 5);

        // WHEN
        Student[] studentsArray = new Student[]
                {student1, student2, student3, student4, student5};
        StudentDB studentData = new StudentDB(studentsArray);
        Student[] result = studentData.list();

        // THEN
        assertArrayEquals(studentsArray, result);
    }

    @Test
    void testToString() {
        // GIVEN
        Student student1 = new Student("John Doe", 1);
        Student student2 = new Student("Jane Doe", 2);
        Student student3 = new Student("Jake Doe", 3);
        Student student4 = new Student("Jolly Doe", 4);
        Student student5 = new Student("Jinx Doe", 5);

        // WHEN
        String expectedString = "StudentDB\n" +
                "Name: John Doe; ID: 1\n" +
                "Name: Jane Doe; ID: 2\n" +
                "Name: Jake Doe; ID: 3\n" +
                "Name: Jolly Doe; ID: 4\n" +
                "Name: Jinx Doe; ID: 5\n" +
                "End of DB.";
        Student[] testArray = new Student[]
                {student1, student2, student3, student4, student5};
        StudentDB testData = new StudentDB(testArray);
        String result = testData.toString();

        // THEN
        assertEquals(expectedString, result);
    }

    @Test
    void testAddStudent() {
        // GIVEN
        Student student1 = new Student("John Doe", 1);
        Student student2 = new Student("Jane Doe", 2);
        Student[] testArray = new Student[] {student1, student2};
        StudentDB testData = new StudentDB(testArray);

        Student student3 = new Student("Jake Doe", 3);

        // WHEN
        String expectedResult = "StudentDB\n" +
                                "Name: John Doe; ID: 1\n" +
                                "Name: Jane Doe; ID: 2\n" +
                                "Name: Jake Doe; ID: 3\n" +
                                "End of DB.";

        testData.addStudent(student3);
        String result = testData.toString();

        // THEN
        assertEquals(expectedResult, result);
    }


    @Test
    void testRemoveStudent() {
        // GIVEN
        Student student1 = new Student("John Doe", 1);
        Student student2 = new Student("Jane Doe", 2);
        Student student3 = new Student("Jake Doe", 3);
        Student[] testArray = new Student[]{student1, student2, student3};
        StudentDB testData = new StudentDB(testArray);


        // WHEN
        testData.removeStudent(2);
        Student[] actualArray = testData.list();

        // THEN
        assertArrayEquals(new Student[] {student1, student3}, actualArray);
    }

    @Test
    void testRemoveLastStudent() {
        // GIVEN
        Student student1 = new Student("John Doe", 1);
        Student student2 = new Student("Jane Doe", 2);
        Student student3 = new Student("Jake Doe", 3);
        Student[] testArray = new Student[]{student1, student2, student3};
        StudentDB testData = new StudentDB(testArray);


        // WHEN
        testData.removeStudent(3);
        Student[] actualArray = testData.list();

        // THEN
        assertArrayEquals(new Student[] {student1, student2}, actualArray);
    }
}