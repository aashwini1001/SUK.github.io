package com.suk.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.suk.dao.UserDAO;
import com.suk.daoimple.UserDAOImple;
import com.suk.model.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private UserDAO userDAO;

    public void init() {
        userDAO = new UserDAOImple();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Encrypt the entered password for validation (You may add encryption logic here)

        // Validate the user credentials
        User user = userDAO.getUserByUsernameAndPassword(username, password);

        if (user != null) {
            // If the username and password are correct, set user object attribute in session and redirect to Home page
            HttpSession session = request.getSession();
            session.setAttribute("loggedInUser", user); // Set the user object directly
            String successMessage = "Login successful!";
            response.sendRedirect("home.jsp?successMessage=" + successMessage); // Redirect to home.jsp
        } else {
            // If the username or password is invalid, set an error message attribute and forward to login.jsp
            String errorMessage = "Invalid username or password for user: " + username;
            request.setAttribute("errorMessage", errorMessage);
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.html");
            dispatcher.forward(request, response);
        }
}
}