<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script type="text/javascript" src="{pageContext.request.contextPath}/js/jquery-3.6.1.min.js"></script>
<script type="text/javascript" src="js/jquery-3.6.1.min.js"></script>
</head>
<body>
<h3>~.jsp 이동</h3>
<form action="04_encodingResult.jsp" method="post">
이름 : <input type="text" name="name">
<input type="submit" value="전송">
</form>

<hr>
<h3>Servlet 이동</h3>
<form action="Ex03EncodingTest" method="post">
이름 : <input type="text" name="name">
<input type="submit" value="전송">
</body>
</html>