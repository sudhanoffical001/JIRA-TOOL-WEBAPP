<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="NewJira.css">
<title>NEW TICKET</title>
</head>
<body>
<% String message="";
	if(request.getAttribute("msg") != null){
		message=(String)request.getAttribute("msg");
		message=message+"<br><a href=\"Home\" class=\"text-link\">home</a>";
	
	}
%>
<%
String usl="";
ArrayList<String> ul=new ArrayList<String>();
if(request.getAttribute("userinfo")!=null){
ul=(ArrayList<String>)request.getAttribute("userinfo");
}
for(String str:ul){
	usl=usl+"<option >"+str+"</option>"	;
	
}

%>
<form method="get" action="/Jiramodel/Createticket">
<div class="box">
<h1>Create new ticket</h1>
<%= message %>
<label >Assignee:</label>
<select name="assignee" class="email2">
<%=usl %>

</select> 
<label>Reporter:</label>
<select name="reportee" class="email2">
<%=usl %>
</select> 

<label >Problem:</label>
<input type="text" name="problem" placeholder="Problem Description" onFocus="field_focus(this, 'email');" onblur="field_blur(this, 'email');" class="email" required="required"/>


<label >Notify: &nbsp&nbsp&nbsp</label>
<select name="notify" class="email2">
<%=usl %>
</select> 

<label >Status:&nbsp&nbsp&nbsp</label>
<select name="status" id="status" class="email2">
  <option name="To-do" >To-do</option>
  <option name="Analysis Wip">Analysis Wip</option>
  <option name="Analysis Done">Analysis Done</option>
  <option name="Dev Wip">Dev Wip</option>
   <option name="Dev Done">Dev Done</option>
</select>
<button class="btn" type="submit">create</button> 

</div> <!-- End Box -->

</body>
</html>