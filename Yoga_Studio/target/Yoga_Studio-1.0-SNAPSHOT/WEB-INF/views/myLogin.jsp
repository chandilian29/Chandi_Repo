<%-- 
    Document   : addUser
    Created on : May 4, 2014, 2:26:51 PM
    Author     : Sandy
--%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link href="resources/style.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        
        <form form  action="myLogin" method="post">
            <table>
                <tr>
                    <td>First Name</td>
                    <td><input type="text" name="uname" /> </td>
                   
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input type="password" name="pwd" /> </td>
                    
                </tr>
                <tr>
            </table>
            <input type="submit"/>
        </form>
    </body>
</html>