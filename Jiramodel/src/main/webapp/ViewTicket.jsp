<%@page import="Pojo.Jira"%>
<%@page import="org.apache.tomcat.websocket.PojoClassHolder"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
table {
	border-collapse: collapse;
	width: 100%;
}

th, td {
	padding: 1rem 2rem;
	text-align: center;
	border-bottom: 1px solid #ddd;
}

th {
	font-weight: normal;
	font-size: .875rem;
	color: #666;
	background: #eee;
	position: sticky;
	top: 0;
}

img {
	width: 80px;
	display: block;
	margin: 0 auto;
	margin-bottom: .5rem;
}

@media ( max-width : 500px) {
	.heading {
		display: none;
	}
	td {
		display: block;
	}
	.car-name {
		background: #eee;
	}
}

h1 {
	text-align: center;
	font-size: 2.5rem;
}
</style>
<meta charset="ISO-8859-1">
<title>VIEW TIKET</title>
</head>
<body>
	<%
	String tableDetails = "";

	ArrayList<Jira> jira1=(ArrayList<Jira>) request.getAttribute("jiralist");
	if(jira1!=null){
	for (Jira jira : jira1) {
		tableDetails = tableDetails + "<tr>	" + "<td>" + jira.getTicketid()+ "</td>" + " <td>" + jira.getAssignee() + "</td>"
		+ " <td>" + jira.getReporter() + "</td>" + " <td>" + jira.getHeading() + "</td>" + "<td>" +jira.getNotify()+"</td>"+"<td>"+ jira.getStatusto()
		+ "</td> " + "<td>" + "<button type=\"button\"><a href=\"Edit?id="+jira.getTicketid()+"\" class=\"text-link\">Edit</a></button>"
		+ "<br><br>" + "<button type=\"button\"><a href=\"Delete?id="+ jira.getTicketid()+"\" class=\"text-link\">Delete</a></button>"
		+ "</td> " + "</tr>";
	}
	}
	
	%>
	<div class="table-reponsive box">
		<table id="example" class="table table-striped table-bordered">
			<thead>
			<% String msg="";  
			  if(request.getAttribute("msg")!=null){  
			     msg=(String)request.getAttribute("msg");
			     }%>
			     <a href="Home.jsp">Home</a>
				<tr>
					<th>ID</th>
					<th>Assignee</th>
					<th>Reporter</th>
					<th>Problem</th>
					<th>Notify</th>
					<th>Status</th>
					<th>Option</th>
				</tr>
			</thead>
			<tbody>

				<%=tableDetails%>


			</tbody>
		</table>
	</div>
</body>
</html>