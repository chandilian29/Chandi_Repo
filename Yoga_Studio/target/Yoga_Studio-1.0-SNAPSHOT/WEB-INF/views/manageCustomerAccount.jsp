<%-- 
    Document   : manageCustomerAccount
    Created on : May 14, 2014, 2:20:30 PM
    Author     : Sandy
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer Details</title>
        <link href="../resources/style.css" rel="stylesheet" type="text/css" />
    </head>
    <h1>Customer Details</h1>
    <body>
        <form:form commandName="user" method="post">
            
            <table>
                <tr>
                    <td>First Name</td>
                    <td><form:input path="firstName" /> </td>

                </tr>
                <tr>
                    <td>Last Name</td>
                    <td><form:input path="lastName" /> </td>

                </tr>
                <tr>
                    <td>Address</td>
                    <td><form:input path="address" /> </td>

                </tr>
                <tr>
                    <td>TelePhone Number</td>
                    <td><form:input path="phoneNo" /> </td>

                </tr>
                <tr>
                    <td>User Name</td>
                    <td><form:input path="uname" /> </td>

                </tr>
                <tr>
                    <td>Password</td>
                    <td><form:input path="password" /> </td>

                </tr>
                <tr>
                    <td>User Type</td>
                    <td><form:input path="usertype" /> </td>

                </tr>
                <tr>
            </table>
            <input type="submit" value="Update"/>
        </form:form>
    </body>
</html>

