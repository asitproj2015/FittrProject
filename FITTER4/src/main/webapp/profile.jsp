<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
String email=(String)session.getAttribute("email");
String name=(String)session.getAttribute("name");
name=name.toUpperCase();
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
	a {
	text-decoration: none;
	font-size: 25px;
	
}
</style>
</head>
<body>

	
 <div style="float:left;width:30%0;height:20%">
 <table style="text-align: center;padding-top: 30px;border-spacing: 20px;">
 	<caption style="color:green; padding-left: 40px;font-size: 35px;"> <strong>Welcome <%= name %></strong></caption>
 	<tr style="padding-top: 100px;">
 		<td><a href="editprofile.html" target="f"><strong>Edit Profile</strong></a></td>
 	</tr>
 	<tr style="border-spacing: 20px;">
 		<td style="font-size: 25px;"><strong>Goal Preference</strong> </td>
 	</tr>
 	<tr style="padding-top: 100px;">
 		<td><a href="changepassword.html" target="f"> <strong>Change Password</strong> </a></td>
 	</tr>
 </table>

</div>
<div style="float:right;width:60%;height:700px;border-left: 6px solid black ;height:110%;">
<iframe name="f"  style="width:100% ;height: 500px;border: none; padding-left: 30px" ></iframe>
  </div>


 
</body>
</html>