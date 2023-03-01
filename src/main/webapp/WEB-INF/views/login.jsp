<%@ page language="java" contentType="text/html; charset=uft-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resource/css/login.css">
<title>Nhà xe PTIT - login</title>
</head>
<body>
	<div class="login-box">
        <p>Login</p>
        <form action="login.htm" method="POST">
            <div class="user-box">
                <input required="" name="username" type="text">
                <label>Tài khoản</label>
            </div>
            <div class="user-box">
                <input required="" name="password" type="password">
                <label>Mật khẩu</label>
            </div>
            <div >
            ${error }
			</div>
            <button type="submit" class="cta">
                <span class="hover-underline-animation"> Đăng Nhập </span>
                <svg viewBox="0 0 46 16" height="10" width="30" xmlns="http://www.w3.org/2000/svg"
                    id="arrow-horizontal">
                    <path transform="translate(30)"
                        d="M8,0,6.545,1.455l5.506,5.506H-30V9.039H12.052L6.545,14.545,8,16l8-8Z" data-name="Path 10"
                        id="Path_10"></path>
                </svg>
            </button>
        </form>
    </div>
</body>
</html>