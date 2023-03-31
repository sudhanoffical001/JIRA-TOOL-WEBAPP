<!DOCTYPE html>    
<html>    
<head>    
    <title>Login Form</title>    
    <link rel="stylesheet" type="text/css" href="Log.css">    
</head>    
<body>    
    <h1 style="text-align: center;">Login Page</h1><br> 
    <% String msg="";
    if(request.getAttribute("msg") !=null)
    msg=(String)request.getAttribute("msg"); %>   
        <form id="login" method="get" action="/Jiramodel/Login">    
        <div class="login">    
        <label><b>User Name</b>    
        </label>    
        <input type="email" name="Uname" id="Uname" placeholder="Username">    
        <br><br>    
        <label><b>Password</b>    
        </label>    
        <input type="Password" name="Pass" id="Pass" placeholder="Password">    
        <br><br>    
        <button type="submit" id="pass">Login</button>      
        <br><br>    
        <input type="checkbox" id="check">    
        <span>Remember me</span>    
        <br><Forgotbr>    
         <a href="Register.jsp">Register</a> 
       </form>         
</body>    
</html>     


