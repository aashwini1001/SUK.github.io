package com.suk.controller;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.suk.dao.TeacherDAO;
import com.suk.daoimple.TeacherDAOImple;
import com.suk.model.Teacher;

@WebServlet("/NewTeacher")
public class NewTeacherServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private TeacherDAO teacherDAO;

    public void init() {
        teacherDAO = new TeacherDAOImple();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve parameters from the form
        String name = request.getParameter("name");
        String fatherName = request.getParameter("father_name");
        String address = request.getParameter("address");
        String dobStr = request.getParameter("dob");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String education = request.getParameter("education");
        String department = request.getParameter("department");

        // Check for null or empty values for mandatory parameters
        if (name == null || name.isEmpty() || fatherName == null || fatherName.isEmpty() ||
            address == null || address.isEmpty() || dobStr == null || dobStr.isEmpty() ||
            phone == null || phone.isEmpty() || email == null || email.isEmpty() ||
            education == null || education.isEmpty() || department == null || department.isEmpty()) {
            // Handle missing parameters error
            response.sendRedirect("error.jsp?message=Missing parameters");
            return;
        }

        Date dob = null;
        try {
            // Parse the String date into a Date object using SimpleDateFormat
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            dob = sdf.parse(dobStr);
        } catch (ParseException e) {
            // Handle date parsing error
            e.printStackTrace();
            response.sendRedirect("error.jsp?message=Invalid date format");
            return;
        }

        // Create a new Teacher object
        Teacher teacher = new Teacher();
        teacher.setName(name);
        teacher.setFatherName(fatherName);
        teacher.setAddress(address);
        teacher.setDob(dob);
        teacher.setPhone(phone);
        teacher.setEmail(email);
        teacher.setEducation(education);
        teacher.setDepartment(department);

        // Add the teacher to the database
        teacherDAO.addTeacher(teacher);

        // Redirect to a success page or display a success message
        response.sendRedirect("newteacherdetails.jsp");
    }
}
