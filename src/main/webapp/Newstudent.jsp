<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>New Student Details</title>
<style>
/* CSS styles */
body {
    font-family: Arial, sans-serif;
    background-color: #f2f2f2;
    margin: 0;
    padding: 0;
}

.container {
    max-width: 600px;
    margin: 20px auto;
    background-color: #fff;
    padding: 20px;
    border-radius: 8px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

input[type="text"], select {
    width: 100%;
    padding: 10px;
    margin: 5px 0;
    border: 1px solid #ccc;
    border-radius: 5px;
    box-sizing: border-box;
}

button {
    background-color: #4CAF50;
    color: white;
    padding: 10px 20px;
    border: none;
    border-radius: 5px;
    cursor: pointer;
}

button:hover {
    background-color: #45a049;
}

</style>
</head>
<body>



<div class="container">
    <h2 style="text-align:center;">New Student Details</h2>
    <form action="NewStudent" method="post">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required>

        <label for="father_name">Father's Name:</label>
        <input type="text" id="father_name" name="father_name" required>


        <label for="dob">Date of Birth:</label>
        <input type="date" id="dob" name="dob" required><br>

        <label for="address">Address:</label>
        <input type="text" id="address" name="address" required>

        <label for="phone">Phone:</label>
        <input type="text" id="phone" name="phone" required>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br><br>

        <label for="course">Course:</label>
        <select id="course" name="course" required>
            <option value="B tech">B Tech</option>
            <option value="BBA">BBA</option>
            <option value="BCA">BCA</option>
            <option value="BSC">BSC</option>
            <option value="MCA">MCA</option>
            <option value="MSC">MSC</option>
            <option value="BA">BA</option>
        </select>

        <label for="branch">Branch:</label>
<select id="branch" name="branch" required>
    <option value="CS">Computer Science</option>
    <option value="Mech">Mechanical</option>
    <option value="Civil">Civil</option>
    <option value="ECE">Electronics and Communication</option>
    <option value="EEE">Electrical and Electronics</option>
    <option value="IT">Information Technology</option>
    <!-- Add more options as needed -->
</select>
        <div style="text-align:center;">
            <button type="submit">Submit</button>
            <button type="button" onclick="home.jsp">Cancel</button>
        </div>
    </form>
</div>

</body>
</html>
