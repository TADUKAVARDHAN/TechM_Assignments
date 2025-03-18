<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>form.jsp</title>
</head>
<body>
    <h2>Login Form</h2>
    <form:form action="index" method="POST" modelAttribute="empInfo">
        <label>Email:</label>
        <form:input path="email" id="email"/>
        <form:errors path="email"/>
        <br>
        
        <label>Password:</label>
        <form:password path="password" id="password"/>
        <form:errors path="password"/>
        <br>
        
        <input type="submit" value="Login">
    </form:form>
</body>
</html>
