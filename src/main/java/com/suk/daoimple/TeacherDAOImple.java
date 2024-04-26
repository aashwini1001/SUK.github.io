package com.suk.daoimple;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.suk.dao.TeacherDAO;
import com.suk.model.Teacher;
import com.suk.util.DBConnectionUtil;

public class TeacherDAOImple implements TeacherDAO {

    @Override
    public void addTeacher(Teacher teacher) {
        String sql = "INSERT INTO `teacher` (`employeeId`, `name`, `fatherName`, `address`, `dob`, `phone`, `email`, `education`, `department`) VALUES (?,?,?,?,?,?,?,?,?)";

        try (Connection connection = DBConnectionUtil.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setInt(1, teacher.getEmployeeId());
            pstmt.setString(2, teacher.getName());
            pstmt.setString(3, teacher.getFatherName());
            pstmt.setString(4, teacher.getAddress());
            pstmt.setDate(5, new Date(teacher.getDob().getTime()));
            pstmt.setString(6, teacher.getPhone());
            pstmt.setString(7, teacher.getEmail());
            pstmt.setString(8, teacher.getEducation());
            pstmt.setString(9, teacher.getDepartment());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(); // Replace with more robust error handling
        }
    }

    @Override
    public Teacher getTeacher(int employeeId) {
        String sql = "SELECT * FROM `teacher` WHERE `employeeId` = ?";
        Teacher teacher = null;

        try (Connection connection = DBConnectionUtil.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setInt(1, employeeId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    teacher = extractTeacherFromResultSet(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Replace with more robust error handling
        }

        return teacher;
    }

    @Override
    public void updateTeacher(Teacher teacher) {
        String sql = "UPDATE `teacher` SET `name` = ?, `fatherName` = ?, `address` = ?, `dob` = ?, `phone` = ?, `email` = ?, `education` = ?, `department` = ? WHERE `employeeId` = ?";
        try (Connection connection = DBConnectionUtil.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, teacher.getName());
            pstmt.setString(2, teacher.getFatherName());
            pstmt.setString(3, teacher.getAddress());
            pstmt.setDate(4, new Date(teacher.getDob().getTime()));
            pstmt.setString(5, teacher.getPhone());
            pstmt.setString(6, teacher.getEmail());
            pstmt.setString(7, teacher.getEducation());
            pstmt.setString(8, teacher.getDepartment());
            pstmt.setInt(9, teacher.getEmployeeId());

            pstmt.executeUpdate();

        } catch(SQLException e) {
            e.printStackTrace(); // Replace with more robust error handling
        }
    }

    @Override
    public void deleteTeacher(int employeeId) {
        String sql = "DELETE FROM `teacher` WHERE `employeeId` = ?";
        try (Connection connection = DBConnectionUtil.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setInt(1, employeeId);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(); // Replace with more robust error handling
        }
    }

    @Override
    public List<Teacher> getAllTeachers() {
        String sql = "SELECT * FROM `teacher`";
        List<Teacher> teachers = new ArrayList<>();

        try (Connection connection = DBConnectionUtil.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Teacher teacher = extractTeacherFromResultSet(rs);
                teachers.add(teacher);
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Replace with more robust error handling
        }

        return teachers;
    }

    private Teacher extractTeacherFromResultSet(ResultSet rs) throws SQLException {
        Teacher teacher = new Teacher();

        teacher.setEmployeeId(rs.getInt("employeeId"));
        teacher.setName(rs.getString("name"));
        teacher.setFatherName(rs.getString("fatherName"));
        teacher.setAddress(rs.getString("address"));
        teacher.setDob(rs.getDate("dob"));
        teacher.setPhone(rs.getString("phone"));
        teacher.setEmail(rs.getString("email"));
        teacher.setEducation(rs.getString("education"));
        teacher.setDepartment(rs.getString("department"));

        return teacher;
    }
}
