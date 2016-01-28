<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
	int a = 0;
	try{
		 a = 10/0;
	}catch(Exception ex ){
		out.println("0으로 나눌 수 없다.");
	}
	%>
	
	<%= "a"+a %>
	
</body>
</html>