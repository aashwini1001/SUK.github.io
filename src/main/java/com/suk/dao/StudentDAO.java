package com.suk.dao;

import java.util.List;

import com.suk.model.Student;

public interface StudentDAO {
    void addStudent(Student student);
    Student getStudent(int rollNumber);
    void updateStudent(Student student);
    void deleteStudent(int rollNumber);
    List<Student> getAllStudents();
}
