package com.suk.daoimple;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.suk.dao.StudentDAO;
import com.suk.model.Student;
import com.suk.util.DBConnectionUtil;

public class StudentDAOImple implements StudentDAO {

    @Override
    public void addStudent(Student student) {
        String sql = "INSERT INTO `student` (`rollNumber`, `name`, `fatherName`, `dob`, `address`, `phone`, `email`, `course`, `branch`) VALUES (?,?,?,?,?,?,?,?,?)";

        try (Connection connection = DBConnectionUtil.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setInt(1, student.getRollNumber());
            pstmt.setString(2, student.getName());
            pstmt.setString(3, student.getFatherName());
            pstmt.setDate(4, new Date(student.getDob().getTime()));
            pstmt.setString(5, student.getAddress());
            pstmt.setString(6, student.getPhone());
            pstmt.setString(7, student.getEmail());
            pstmt.setString(8, student.getCourse());
            pstmt.setString(9, student.getBranch());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(); // Replace with more robust error handling
        }
    }

    @Override
    public Student getStudent(int rollNumber) {
        String sql = "SELECT * FROM `student` WHERE `rollNumber` = ?";
        Student student = null;

        try (Connection connection = DBConnectionUtil.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setInt(1, rollNumber);
            try (ResultSet res = pstmt.executeQuery()) {
                if (res.next()) {
                    student = extractStudentFromResultSet(res);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Replace with more robust error handling
        }

        return student;
    }

    @Override
    public void updateStudent(Student student) {
        String sql = "UPDATE `student` SET `name` = ?, `fatherName` = ?, `dob` = ?, `address` = ?, `phone` = ?, `email` = ?, `course` = ?, `branch` = ? WHERE `rollNumber` = ?";
        try (Connection connection = DBConnectionUtil.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, student.getName());
            pstmt.setString(2, student.getFatherName());
            pstmt.setDate(3, new Date(student.getDob().getTime()));
            pstmt.setString(4, student.getAddress());
            pstmt.setString(5, student.getPhone());
            pstmt.setString(6, student.getEmail());
            pstmt.setString(7, student.getCourse());
            pstmt.setString(8, student.getBranch());
            pstmt.setInt(9, student.getRollNumber());

            pstmt.executeUpdate();

        } catch(SQLException e) {
            e.printStackTrace(); // Replace with more robust error handling
        }
    }

    @Override
    public void deleteStudent(int rollNumber) {
        String sql = "DELETE FROM `student` WHERE `rollNumber` = ?";
        try (Connection connection = DBConnectionUtil.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setInt(1, rollNumber);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(); // Replace with more robust error handling
        }
    }

    @Override
    public List<Student> getAllStudents() {
        String sql = "SELECT * FROM `student`";
        List<Student> students = new ArrayList<>();

        try (Connection connection = DBConnectionUtil.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql);
             ResultSet res = pstmt.executeQuery()) {

            while (res.next()) {
                Student student = extractStudentFromResultSet(res);
                students.add(student);
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Replace with more robust error handling
        }

        return students;
    }

    private Student extractStudentFromResultSet(ResultSet res) throws SQLException {
        Student student = new Student();
        student.setRollNumber(res.getInt("rollNumber"));
        student.setName(res.getString("name"));
        student.setFatherName(res.getString("fatherName"));
        student.setDob(res.getDate("dob"));
        student.setAddress(res.getString("address"));
        student.setPhone(res.getString("phone"));
        student.setEmail(res.getString("email"));
        student.setCourse(res.getString("course"));
        student.setBranch(res.getString("branch"));
        return student;
    }
}
