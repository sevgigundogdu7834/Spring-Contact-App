<%@ taglib prefix="us" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: sevgigundogdu
  Date: 25.03.2019
  Time: 13:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Dashboard - Contact Application </title>
    <us:url var="url_css" value="/static/css/style1.css"/>
    <link href="${url_css}" rel="stylesheet" type="text/css"/>
</head>
<us:url var="url_image" value="/static/images/abstract-paper-hexagon-white-background_51543-7.jpg"/>
<body background="${url_image}">

<table border="1" width="80%" align="center">

    <tr>
        <td height="100px">
            <jsp:include page="include/header.jsp"/>
        </td>
    </tr>


    <tr>
        <td height="25px">
            <jsp:include page="include/menu.jsp"/>
        </td>
    </tr>



    <tr>
        <td height="350px" valign="top">
            <h1> Admin Dashboard </h1>
            TODO - Admin Dashboard
        </td>
    </tr>

    <tr>
        <td height="25px">
            <jsp:include page="include/footer.jsp"/>
        </td>
    </tr>

</table>
</body>
</html>

