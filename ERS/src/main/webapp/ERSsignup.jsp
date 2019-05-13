<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link rel="stylesheet" href="./erssignup.css">
</head>
<body>
    <div class="signup-box">
        <h1>Signup</h1>
        <form name="login-form" method="POST"  action="signupServlet">
        <div class="textbox">
            <i class="fas fa-user" aria-hidden="true"></i>
            <input type="text" placeholder="First Name" name="firstname">        
        </div>

        <div class="textbox">
                <i class="fas fa-user" aria-hidden="true"></i>
                <input type="text" placeholder="Last Name" name="lastname">        
            </div>

        <div class="textbox">
            <i class="fas fa-user" aria-hidden="true"></i>
            <input type="text" placeholder="Username" name="username">
        </div>

        <div class="textbox">
            <i class="fas fa-lock" aria-hidden="true"></i>
            <input type="text" placeholder="Email" name="email">
        </div>
        <input class="btn" type="submit" name="submit" value="Signup">
        </form>
    
    </div>
</body>
</html>