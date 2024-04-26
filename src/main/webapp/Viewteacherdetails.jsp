<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.suk.model.Teacher" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>View Teacher Details</title>
    <style>
        /* CSS styles */
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            margin: 0;
            padding: 0;
        }
        .container {
            max-width: 800px;
            margin: 20px auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            padding: 12px; /* Increased padding for better alignment */
            border-bottom: 1px solid #ddd;
            text-align: center; /* Center-align content */
        }
        th {
            background-color: #f2f2f2;
        }
        h2 {
            text-align: center; /* Center-align heading */
            margin-bottom: 20px; /* Increased margin for better spacing */
        }
    </style>
</head>
<body>

<div class="container">
    <!-- Form to submit data to the servlet -->
    <form action="ViewTeacherDetails" method="GET">
        <h2>Teacher Details</h2>
        <table>
            <tr>
                <th>Employee ID</th>
                <th>Name</th>
                <th>Father's Name</th>
                <th>Address</th>
                <th>Date of Birth</th>
                <th>Phone</th>
                <th>Email</th>
                <th>Education</th>
                <th>Department</th>
            </tr>
            <!-- Retrieve list of teachers from the session -->
            <% 
               List<Teacher> teachers = (List<Teacher>) request.getAttribute("teacherList");
               if (teachers != null) {
                   for (Teacher teacher : teachers) { %>
                    <tr>
                        <td><%= teacher.getEmployeeId() %></td>
                        <td><%= teacher.getName() %></td>
                        <td><%= teacher.getFatherName() %></td>
                        <td><%= teacher.getAddress() %></td>
                        <td><%= teacher.getDob() %></td>
                        <td><%= teacher.getPhone() %></td>
                        <td><%= teacher.getEmail() %></td>
                        <td><%= teacher.getEducation() %></td>
                        <td><%= teacher.getDepartment() %></td>
                    </tr>
            <%     }
               }
            %>
        </table>
    </form> <!-- Closed the form tag -->
</div>

</body>
</html>
