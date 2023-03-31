<%@page import="java.util.ArrayList"%>
<%@page import="Pojo.Jira"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="NewJira.css">
<title>new ticket</title>
</head>
<body>
	<%
	String message = "";
	if (request.getAttribute("msg") != null) {
		message = (String) request.getAttribute("msg");
		message = message + "<br><a href=\"Home\" class=\"text-link\">home</a>";

	}
	Jira jira = (Jira) request.getAttribute("jira detial");
	int id = jira.getTicketid();
	String assignee = jira.getAssignee();
	String reporter = jira.getReporter();
	String heading = jira.getHeading();
	String notify = jira.getNotify();
	String status = jira.getStatusto();

	String usl = "";
	ArrayList<String> userlist = new ArrayList<String>();
	userlist = (ArrayList<String>) request.getAttribute("userinfo");

	for (String str : userlist) {
		usl = usl + "<option >" + str + "</option>";
	}
	%>

	<form method="get" action="/Jiramodel/UpdateATicket">
		<div class="box">
			<h1>Update ticket</h1>
			<h3><%=message%></h3>
			<input type="hidden" name="id" value="<%=id%>"> 
			<label>Assignee:</label>
			<select name="assignee"  class="email2">
			<option name="<%=assignee%>"><%=assignee %></option>	
				<%=usl%>

			</select> 
			<label>Reporter:</label> 
			<select name="reportee"  class="email2">
			<option name="<%=reporter%>"><%=reporter %></option>
				<%=usl%>
			</select> 
			<label>Problem:</label> 
			<input type="text" value="<%=heading%>"
			name="problem" placeholder="Problem Description"
				onFocus="field_focus(this, 'email');"
				onblur="field_blur(this, 'email');" class="email"
				required="required" /> 
				<label>Notify: &nbsp&nbsp&nbsp</label> 
				
				<select name="notify"  class="email2">
				<option name="<%=notify%>"><%=notify %></option>
				<%=usl%>
			</select> 
			<label>Status:&nbsp&nbsp&nbsp</label> 
			<select name="status" id="status" class="email2">
			<option name="<%=status%>"><%=status %></option>
				<option name="To-do">To-do</option>
				<option name="Analysis Wip">Analysis Wip</option>
				<option name="Analysis Done">Analysis Done</option>
				<option name="Dev Wip">Dev Wip</option>
				<option name="Dev Done">Dev Done</option>
			</select>
			<button class="btn" type="submit">update</button>



		</div>
		<!-- End Box -->

	</form>
</body>
</html>