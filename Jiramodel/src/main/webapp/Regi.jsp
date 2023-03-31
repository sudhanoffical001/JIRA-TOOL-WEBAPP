<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="Reg.css">
<title>Register</title>
</head>
<body>

<form method="get" action="Jiramodel/Regis">
<div class="box">
<h1>Jira Register</h1>
<input type="text" name="fname" placeholder="first name" onFocus="field_focus(this, 'email');" onblur="field_blur(this, 'email');" class="email" />
<input type="text" name="lname" placeholder="last name" onFocus="field_focus(this, 'email');" onblur="field_blur(this, 'email');" class="email" />
<input type="text" name="mob" placeholder="phone number" onFocus="field_focus(this, 'email');" onblur="field_blur(this, 'email');" class="email" />
<input type="email" name="email" placeholder="email" onFocus="field_focus(this, 'email');" onblur="field_blur(this, 'email');" class="email" />  
<input type="password" name="password" placeholder="password" onFocus="field_focus(this, 'email');" onblur="field_blur(this, 'email');" class="email" />

<button class="btn" type="submit">Register</button> 



  
</div> <!-- End Box -->
  
</form>

</body>
</html>