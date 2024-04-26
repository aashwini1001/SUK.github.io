<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.suk.model.Student" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>View Student Details</title>
    <style>
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
            padding: 12px;
            border-bottom: 1px solid #ddd;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
            font-weight: bold;
        }
        tr:nth-child(even) {
            background-color: #f9f9f9;
        }
        td {
            vertical-align: top;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2 style="text-align:center;">Student Details</h2>
        <table>
            <tr>
                <th>Roll Number</th>
                <th>Name</th>
                <th>Father's Name</th>
                <th>Date of Birth</th>
                <th>Address</th>
                <th>Phone</th>
                <th>Email</th>
                <th>Course</th>
                <th>Branch</th>
            </tr>
            <!-- Use JSTL or scriptlet to loop through student details -->
            <% List<Student> studentList = (List<Student>) request.getAttribute("studentList");
               if (studentList != null && !studentList.isEmpty()) {
                   for (Student student : studentList) {
            %>
            <tr>
                <td><%= student.getRollNumber() %></td>
                <td><%= student.getName() %></td>
                <td><%= student.getFatherName() %></td>
                <td><%= student.getDob() %></td>
                <td><%= student.getAddress() %></td>
                <td><%= student.getPhone() %></td>
                <td><%= student.getEmail() %></td>
                <td><%= student.getCourse() %></td>
                <td><%= student.getBranch() %></td>
            </tr>
            <%     }
               } else { %>
            <tr>
                <td colspan="9">No student records found</td>
            </tr>
            <% } %>
        </table>
    </div>
</body>
</html>
