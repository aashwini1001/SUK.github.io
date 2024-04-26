package com.suk.dao;

import java.util.List;

import com.suk.model.Teacher;

public interface TeacherDAO {
	
	void addTeacher(Teacher teacher);
    Teacher getTeacher(int employeeId);
    void updateTeacher(Teacher teacher);
    void deleteTeacher(int employeeId);
    List<Teacher> getAllTeachers();

}
