<%--
  Created by IntelliJ IDEA.
  User: axmedbek
  Date: 6/15/17
  Time: 1:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<form method="post" action="uploadServlet" enctype="multipart/form-data">
    <table border="0">
        <tr>
            <td>First Name: </td>
            <td><input type="text" name="fname" size="50"/></td>
        </tr>
        <tr>
            <td>Last Name: </td>
            <td><input type="text" name="lname" size="50"/></td>
        </tr>
        <tr>
            <td>Portrait Photo: </td>
            <td><input type="file" name="photo" size="50"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Save">
            </td>
        </tr>
    </table>


</form>
</body>
</html>
