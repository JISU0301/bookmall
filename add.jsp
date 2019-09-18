<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
   <%
  	String firstName = request.getParameter("firstName");
  	String lastName = request.getParameter("lastName");
  	String email = request.getParameter("email");
  	
	EmaillistVo vo = new EmaillistVo();
	vo.setFirstName("지수");
	vo.setLastName("이");
	vo.setEmail("jisue0301@naver.com");   
	
	new EmaillistDao().insert(vo);
   %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>성공적으로 등록 되었습니다.</h1>
</body>
</html>