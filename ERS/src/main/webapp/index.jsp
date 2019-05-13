<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link rel="stylesheet" href="./erslogin.css">
</head>
<body>
    <div class="login-box">
        <h1>Login</h1>
        <form name="login-form" method="POST"  action="loginServlet">
        <div class="textbox">
            <i class="fas fa-user" aria-hidden="true"></i>
            <input type="text" placeholder="Username" name="username">
        </div>

        <div class="textbox">
            <i class="fas fa-lock" aria-hidden="true"></i>
            <input type="password" placeholder="Password" name="password">
        </div>
        <input class="btn" type="submit" name="submit" value="Login">
        </form>
    
    </div>
</body>
</html>