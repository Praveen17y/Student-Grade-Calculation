
package com.mile1.main;

import com.mile1.bean.Student;
import com.mile1.exception.NullMarksArrayException;
import com.mile1.exception.NullNameException;
import com.mile1.exception.NullStudentObjectException;
import com.mile1.service.StudentReport;
import com.mile1.service.StudentService;

public class StudentMain {
    static Student[] data = new Student[4];

    public StudentMain() {
        data[0] = new Student("Sekar", new int[]{85, 75, 95});
        data[1] = new Student(null, new int[]{11, 22, 33});
        data[2] = null;
        data[3] = new Student("Manoj", null);
    }

    public static void main(String[] args) {
        StudentMain sm = new StudentMain();
        StudentReport report = new StudentReport();
        StudentService service = new StudentService();

        for (Student student : data) {
            try {
                String result = report.validate(student);
                if ("VALID".equals(result)) {
                    System.out.println("Grade: " + report.findGrades(student));
                }
            } catch (NullNameException | NullMarksArrayException | NullStudentObjectException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Number of objects with null marks array: " + service.findNumberOfNullMarksArray(data));
        System.out.println("Number of objects with null name: " + service.findNumberOfNullName(data));
        System.out.println("Number of null objects: " + service.findNumberOfNullObjects(data));
    }
}

