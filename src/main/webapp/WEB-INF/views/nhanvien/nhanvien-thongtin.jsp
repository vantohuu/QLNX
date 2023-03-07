<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Thông tin nhân viên</title>
    
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" 
     integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://kit.fontawesome.com/ee36f81461.js" crossorigin="anonymous"></script>
  </head>
<body>
    <div class="container-fluid">
    <div class="row flex-nowrap">
        <div class="col-auto col-md-3 col-xl-2 px-sm-2 px-0 bg-dark">
            <div class="d-flex flex-column align-items-center align-items-sm-start px-3 pt-2 text-white min-vh-100">
                <a href="/" class="d-flex align-items-center pb-5 pt-5 mb-md-0 me-md-auto text-white text-decoration-none">
                    <span class="fs-5 d-none d-sm-inline">QUẢN LÍ NHÀ XE PTITHCM</span>
                </a>
                <ul class="nav nav-pills flex-column mb-sm-auto mb-0 align-items-center align-items-sm-start" id="menu">
                    <li class="nav-item">
                        <a href="home.htm" class="nav-link align-middle px-0">
                           <i class="fa-solid fa-house"></i>
                            <span class="ms-1 d-none d-sm-inline">Home</span>
                        </a>
                    </li>
                    <li>
                        <a href="#submenu1" data-bs-toggle="collapse" class="nav-link px-0 align-middle">
                             <i class="fa-solid fa-keyboard"></i>
                             <span class="ms-1 d-none d-sm-inline">Gửi xe</span>
                        </a>
                        <ul class="collapse show nav flex-column ms-1" id="submenu1" data-bs-parent="#menu">
                            <li class="w-100">
                                <a href="thevao" class="nav-link px-0"> <span class="d-none d-sm-inline">Nhập thẻ vào</span></a>
                            </li>
                            <li>
                                <a href="thera" class="nav-link px-0"> <span class="d-none d-sm-inline">Nhập thẻ ra</span></a>
                            </li>
                            <li>
                                <a href="lichsugui" class="nav-link px-0"> <span class="d-none d-sm-inline">Lịch sử gửi </span></a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="#" class="nav-link px-0 align-middle">
                           <i class="fa-solid fa-calendar-days"></i>
                           <span class="ms-1 d-none d-sm-inline">Lịch làm việc</span></a>
                    </li>
                    <li>
                        <a href="#submenu2" data-bs-toggle="collapse" class="nav-link px-0 align-middle ">
                            <i class="fa-solid fa-clipboard-user"></i>
                            <span class="ms-1 d-none d-sm-inline">Quản lí</span></a>
                        <ul class="collapse nav flex-column ms-1" id="submenu2" data-bs-parent="#menu">
                            <li class="w-100">
                                <a href="doanhthu" class="nav-link px-0"> <span class="d-none d-sm-inline">Doanh thu</span></a>
                            </li>
                            <li>
                                <a href="nhanvien.htm" class="nav-link px-0"> <span class="d-none d-sm-inline">Nhân viên</span></a>
                            </li>
                            <li>
                                <a href="luong" class="nav-link px-0"> <span class="d-none d-sm-inline">Lịch</span></a>
                            </li>
                             <li>
                                <a href="chucvu.htm" class="nav-link px-0"> <span class="d-none d-sm-inline">Chức vụ</span></a>
                            </li>
                             <li>
                                <a href="quanlitaikhoan.htm" class="nav-link px-0"> <span class="d-none d-sm-inline">Tài khoản</span></a>
                            </li>
                             <li>
                                <a href="bangluong.htm" class="nav-link px-0"> <span class="d-none d-sm-inline">Bảng lương</span></a>
                            </li>
                             <li>
                                <a href="nhanvien-phi.htm" class="nav-link px-0"> <span class="d-none d-sm-inline">Sự cố</span></a>
                            </li>
                        </ul>
                    </li>
                    
                <hr>
              
                <div class="dropdown pb-4">
                    <a href="#" class="d-flex align-items-center text-white text-decoration-none dropdown-toggle" id="dropdownUser1" data-bs-toggle="dropdown" aria-expanded="false">
                        <img src="https://github.com/mdo.png" alt="hugenerd" width="30" height="30" class="rounded-circle">
                        <span class="d-none d-sm-inline mx-1">Tài khoản</span>
                    </a>
                    <ul class="dropdown-menu dropdown-menu-dark text-small shadow">
   
                        <li><a class="dropdown-item" href="nhanvien-thongtin.htm">Chỉnh sửa thông tin cá nhân</a></li>
                        <li><a class="dropdown-item" href="doimatkhau.htm">Đổi mật khẩu</a></li>
                        <li>
                            <hr class="dropdown-divider">
                        </li>
                        <li><a class="dropdown-item" href="logout.htm">Đăng xuất</a></li>
                    </ul>
                </div>
            </div>
        </div>
		<div class="col py-3">
		         <h4 class="mb-2">Sửa đổi nhân viên</h4>
		  <form:form action="capnhatthongtincanhan.htm" modelAttribute="nhanVien">
		    <div class="col-sm-4">
		        <label for="id" class="form-label">Mã nhân viên:</label>
		        <form:input path="maNv" type="text" class="form-control" readonly="true"/>
		    </div>
		    <div class="form-group row">
		    <div class="col-sm-4">
		        <label for="name" class="form-label">Họ:</label>
		        <form:input path="ho" type="text" class="form-control"/>
		     </div>
		     <div class="col-sm-4">
		        <label for="name" class="form-label">Tên:</label>
		        <form:input path="ten" type="text" class="form-control"/>
		     </div>
		    </div>
		    <div class="col-sm-2">
		        <label for="gioiTinh" class="form-label">Giới tính:</label>
		         <form:radiobuttons path="gioiTinh" items="${gioiTinh}" />
		     </div> 
		    <div class="form-group row">
		    <div class="col-sm-2">
		        <label for="name" class="form-label">CCCD:</label>
		        <form:input path="cccd" type="text" class="form-control"/>
		     </div>
		     <div class="col-sm-2">
		        <label for="name" class="form-label">SĐT:</label>
		        <form:input path="sdt" type="text" class="form-control"/>
		     </div>
		     <div class="col-sm-4">
		        <label for="name" class="form-label">Email:</label>
		        <form:input path="email" type="text" class="form-control" />
		     </div>
		    </div>
		    <div class="form-group row">
		    <div class="col-sm-2">
		        <label for="name" class="form-label">Ngày sinh:</label>
		         <input name="ngaySinh1" type="date" value="${ngaySinh1 }"/>
		     </div>
		     <div class="col-sm-4">
		        <label for="name" class="form-label">Địa chỉ:</label>
		        <form:input path="diaChi" type="text" class="form-control"/>
		     </div>
		    </div>
		     <div class="form-group row">
		     <div class="form-group col-sm-4" style="margin-top: 20px;">
		    	<label for="chucVu">Chức vụ:</label>
		    <form:input path="CTChucVu.chucVu.ten" type="text" class="form-control" readonly="true"/>
		    </div>	

		    <div class="form-group col-sm-4" style="margin-top: 20px;">
		    	<label for="chucVu">Hình thức:</label>
		     <form:input path="CTChucVu.loaiNhanVien" type="text" class="form-control" readonly="true" />
		     </div>	
		    </div>
		    <div > 
            		${message }
				</div>
		    <form:button type="submit" name="capnhatthongtincanhan" class="btn btn-primary" style="margin-top: 40px;">
		    Lưu thông tin</form:button>
		    
		</form:form>
      </div>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
</body>
</html>