<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
//request로 받을때, get방식은 그대로 쓸수 있지만, post방식은 한글이 깨져서 인코딩 추가해야함
//forward로 받을때는 상관 없음

   //post방식으로 전송되는 한글데이터의 인코딩처리 필요
   request.setCharacterEncoding("UTF-8");

   //전송된 데이터 받기
   String name= request.getParameter("name");
   String blood= request.getParameter("blood");

   //out.println(name+" , " + blood);
%>


<%-- <jsp:forward page='<%=blood +".jsp"%>'/> --%>



</body>
</html>



