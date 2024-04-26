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

import com.suk.dao.StudentDAO;
import com.suk.daoimple.StudentDAOImple;
import com.suk.model.Student;

@WebServlet("/NewStudent")
public class NewStudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private StudentDAO studentDAO;

    public void init() {
        studentDAO = new StudentDAOImple();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String fatherName = request.getParameter("father_name");
        String dobString = request.getParameter("dob");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String course = request.getParameter("course");
        String branch = request.getParameter("branch");

        // Parse the dobString into a Date object
        Date dob = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            dob = dateFormat.parse(dobString);
        } catch (ParseException e) {
            e.printStackTrace(); // Handle the parse exception appropriately
        }

        // Create a new Student object
        Student student = new Student();
        student.setName(name);
        student.setFatherName(fatherName);
        student.setDob(dob);
        student.setAddress(address);
        student.setPhone(phone);
        student.setEmail(email);
        student.setCourse(course);
        student.setBranch(branch);

        // Add the student to the database
        studentDAO.addStudent(student);

        // Redirect to a success page or display a success message
        response.sendRedirect("home.jsp");
    }
}
