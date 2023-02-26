<%@ page language="java" contentType="text/html; charset=uft-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resource/css/login.css">
<title>Nhà xe PTIT - login</title>
</head>
<body>
	<div class="login-box">
        <p>Login</p>
        <form>
            <div class="user-box">
                <input required="" name="" type="text">
                <label>Tài khoản</label>
            </div>
            <div class="user-box">
                <input required="" name="" type="password">
                <label>Mật khẩu</label>
            </div>
            <a href="#">
                <span></span>
                <span></span>
                <span></span>
                <span></span>
                Đăng nhập
            </a>
        </form>
    </div>
</body>
</html>