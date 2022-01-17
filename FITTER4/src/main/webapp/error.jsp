<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isErrorPage="true"
    import="java.lang.Exception"%>

	<% Exception e=(Exception)request.getAttribute("error"); %>

<h1 style="text-align:center ;color:red">INTERNAL ERROR ...TRAY AGAIN</h1>
<h2 style="color:blue ; text-align:center">PROBLEM IS ::<%= e.getMessage() %></h2>
<br>
<br>
<span> Already have account? </span><a href="signin.html" style="color: blue">Sign In</a>
<br>
<br>
<span>New to Fittr? <a href=signup.html style="color: blue">Sign Up</a></span>
