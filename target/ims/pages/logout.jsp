<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@ page isELIgnored="false" %>
</head>
<body>
<%-- <security:authorize access="isAuthenticated()">
    authenticated as <security:authentication property="Details.accessType" /> 
</security:authorize> --%>

 <security:authentication property="authorities"/> 

<p>${pages.pageList}</p>

<c:forEach items="${pages.pageList}" var="page">
    <tr>
        <td>page<c:out value="${page}"/></td>  
    </tr>
</c:forEach>

<%-- <div><p><security:authentication property="Details.pages" /></p></div> --%> -

<%-- <c:set var="pages"><security:authentication property="Details.pages" /></c:set> --%>

<%--  <c:forEach items=<security:authentication property="Details.pages" /> var="person" varStatus="loop">
   <c:if test="${!loop.last}">,</c:if>
   
</c:forEach> --%>
 
 <security:authorize access="hasAnyRole('ADMIN,SUPERVISOR')">
 This content 1 will only be visible to users who have
 the "supervisor" authority in their list of <tt>GrantedAuthority</tt>s.
</security:authorize>


 <security:authorize access="hasAnyRole('ROLE_ADMIN,ROLE_SUPERVISOR')">
 This content 2 will only be visible to users who have
 the "supervisor" authority in their list of <tt>GrantedAuthority</tt>s.
</security:authorize>



<%-- <c:set var="obj"><security:authentication property="Details" /></c:set>

<c:forEach items="${obj}" var="summa">
        <tr>
            <td>Employee ID: <c:out value="${summa[0]}"/></td>       
        </tr>
    </c:forEach> --%>



<%-- <c:if test="${not empty object['class'].declaredFields}">
    <h2>Declared fields <em>&dollar;{object.name}</em></h2>
    <ul>
        <c:forEach var="field" items="${object['class'].declaredFields}">
            <c:catch><li><span>${field.name}</span>${object[field.name]}</li></c:catch>
        </c:forEach>
    </ul>
</c:if> --%>

<%-- <%=org.springframework.security.core.context.SecurityContextHolder.getContext()
    .getAuthentication().getPrincipal().equals("anonymousUser")
    ? "false":"true"%> --%>
 you are logged out due to session expired.
</body>
</html>