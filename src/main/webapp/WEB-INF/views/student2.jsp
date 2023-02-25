<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Spring MVC</title>
	<base href="${pageContext.servletContext.contextPath}/">
</head>
<body>
	<form:form action="student/update.htm" modelAttribute = "student">
		<div>Họ và tên </div>
		<form:input path = "name"/>
		
		<div>Điểm trung bình </div>
		<form:input path = "mark"/>
		
		<div>Chuyên ngành </div>
		<label>
			<form:radiobutton path = 'major' value = "APP"/>
						Ứng dụng phần mềm
		</label>
		<label>
			<form:radiobutton path = 'major' value = "WEB"/> 
						Thiết kế trang web
		</label>
		
		<div>Chuyên ngành</div>
		<form:select path = "major" items = "${majors}" itemValue="id" itemLabel="name" />
		
		<hr>
		<div>
			<button>Cập nhật</button>
		</div>
	</form:form>
</body>
</html>