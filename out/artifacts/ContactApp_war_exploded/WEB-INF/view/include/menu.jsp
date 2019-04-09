<%@ taglib prefix="us" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<c:url var="url_logout" value="/logout"/>


<us:if test="${sessionScope.userId==null}">

    <c:url var="reg_form" value="/reg_form"/>
    <%-- Guest Menu--%>
    <a href="#">Home</a> &nbsp;|&nbsp; <a href="#">Login</a> &nbsp;|&nbsp;<a href="${reg_form}">Register</a> &nbsp;|&nbsp; <a href="#">About</a>
</us:if>

<us:if test="${sessionScope.userId!=null && sessionScope.role==1}">
    <%-- Admin Menu--%>
    <a href="#">Home</a> &nbsp;|&nbsp; <a href="#">User List</a> &nbsp;|&nbsp;<a href="${url_logout}">Logout</a> &nbsp;|&nbsp;
</us:if>

<us:if test="${sessionScope.userId!=null && sessionScope.role==2}">
    <%-- User Menu--%>
    <a href="#">Home</a> &nbsp;|&nbsp; <a href="#">Add Contact</a> &nbsp;|&nbsp;<a href="${url_logout}">Contact List</a> &nbsp;|&nbsp;<a href="#">Logout</a>
</us:if>
