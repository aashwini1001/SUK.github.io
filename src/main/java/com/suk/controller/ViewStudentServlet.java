package com.suk.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.suk.dao.StudentDAO;
import com.suk.daoimple.StudentDAOImple;
import com.suk.model.Student;


@WebServlet("/ViewDetails")
public class ViewStudentServlet extends HttpServlet {

    private StudentDAO studentDAO;

    @Override
    public void init() {
        studentDAO = new StudentDAOImple();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
        List<Student> studentList = studentDAO.getAllStudents();
        
        req.setAttribute("studentList", studentList);
        
        RequestDispatcher dispatcher = req.getRequestDispatcher("viewStudents.jsp");
        dispatcher.forward(req, resp);
    }
}
