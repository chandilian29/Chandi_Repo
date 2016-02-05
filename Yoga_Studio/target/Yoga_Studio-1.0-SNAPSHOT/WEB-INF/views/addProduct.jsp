<%-- 
    Document   : addProduct
    Created on : May 11, 2014, 1:27:46 PM
    Author     : Sandy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" context/html; charset=UTF-8">
              <title>Add New Product</title>
        <link href="resources/style.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <h1>Add New Product</h1>
        <form:form commandName="myproduct" action="addProduct" method="post">
            <form:errors path="*" cssClass="errorblock" element="div" />
            <table>
                <tr>
                    <td>Product Name</td>
                    <td><form:input path="productName" /> </td>

                </tr>
                <tr>
                    <td>Product price</td>
                    <td><form:input path="productPrice" /> </td>

                </tr>
                <tr>
                    <td>Product description</td>
                    <td><form:input path="productDescription" /> </td>

                </tr>
            </table>
            <input type="submit"/>

        </form:form>
    </body>
</html>