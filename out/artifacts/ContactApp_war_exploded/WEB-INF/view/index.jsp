<%@ taglib prefix="us" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: sevgigundogdu
  Date: 25.03.2019
  Time: 13:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>

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

        <h3>User Login </h3>
        <us:if test="${err!=null}">
          <p class="error">${err}</p>
        </us:if>
        <us:if test="${param.act=='lo'}">
          <p class="success"> Logout successfully!. Thanks for using contact application. </p>
        </us:if>

        <us:if test="${param.act=='red'}">
          <p class="success"> User Registered  Successfully!.Please login ....  </p>
        </us:if>

        <s:url var="url_login" value="/login"/>
        <f:form action="${url_login}" modelAttribute="command">
        <table border="1">

          <tr>
            <td>UserName</td>
            <td><f:input path="loginName"/></td>
          </tr>

          <tr>
            <td>Password</td>
            <td><f:password path="password"/></td>
          </tr>

          <tr>
            <td colspan="2" align="right"><button>Login</button>
              <a href="#" >New User Registration</a>

            </td>

          </tr>
        </table>
        </f:form>
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
