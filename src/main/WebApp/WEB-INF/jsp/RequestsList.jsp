<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; ISO-8859-1" pageEncoding="iso-8859-1" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>requests</title>
</head>
<body>

<c:forEach var="request" items="${requests}">
    ${request}
</c:forEach>

</body>
</html>