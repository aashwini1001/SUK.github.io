package com.suk.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.suk.dao.TeacherDAO;
import com.suk.daoimple.TeacherDAOImple;
import com.suk.model.Teacher;

@WebServlet("/ViewTeacherDetails") // Correct URL mapping
public class ViewTeacherServlet extends HttpServlet {

    private TeacherDAO teacherDAO;

    @Override
    public void init() {
        teacherDAO = new TeacherDAOImple();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Teacher> teacherList = teacherDAO.getAllTeachers();

        req.setAttribute("teacherList", teacherList);

        RequestDispatcher dispatcher = req.getRequestDispatcher("Viewteacherdetails.jsp"); // Correct JSP filename with leading slash
        dispatcher.forward(req, resp);
    }
}
