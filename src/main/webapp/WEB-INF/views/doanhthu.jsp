<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resource/css/home.css">
<title>Bootstrap demo</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
<script src="https://kit.fontawesome.com/ee36f81461.js"
	crossorigin="anonymous"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>resource/js.jquery.min.js">></script>
<script src="<%=request.getContextPath()%>resource/js.table2excel.js">></script>
</head>
<body>
	<div class="container-fluid">
		<div class="row flex-nowrap">
			<div class="col-auto col-md-3 col-xl-2 px-sm-2 px-0t bg-dark">
				<div
					class="d-flex flex-column align-items-center align-items-sm-start px-3 pt-2 text-white min-vh-100 ">
					<a href="#" class="d-flex align-items-center pb-5 pt-5 mb-md-0 me-md-auto text-white text-decoration-none">
                    <span class="fs-5 d-none d-sm-inline">QUẢN LÍ NHÀ XE PTITHCM</span>
                </a>
                <ul class="nav nav-pills flex-column mb-sm-auto mb-0 align-items-center align-items-sm-start " id="menu">
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
                                <a href="thevao.htm" class="nav-link px-0"> <span class="d-none d-sm-inline">Nhập thẻ vào</span></a>
                            </li>
                            <li>
                                <a href="thera.htm" class="nav-link px-0"> <span class="d-none d-sm-inline">Nhập thẻ ra</span></a>
                            </li>
                            <li>
                                <a href="lichsugui.htm" class="nav-link px-0"> <span class="d-none d-sm-inline">Lịch sử gửi </span></a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="lich.htm" class="nav-link px-0 align-middle">
                           <i class="fa-solid fa-calendar-days"></i>
                           <span class="ms-1 d-none d-sm-inline">Lịch làm việc</span></a>
                    </li>
                    <li>
                        <a href="#submenu2" data-bs-toggle="collapse" class="nav-link px-0 align-middle ">
                            <i class="fa-solid fa-clipboard-user"></i>
                            <span class="ms-1 d-none d-sm-inline">Quản lí</span></a>
                        <ul class="collapse nav flex-column ms-1" id="submenu2" data-bs-parent="#menu">
                            <li class="w-100">
                                <a href="doanhthu.htm" class="nav-link px-0"> <span class="d-none d-sm-inline">Doanh thu</span></a>
                            </li>
                            <li>
                                <a href="nhanvien.htm" class="nav-link px-0"> <span class="d-none d-sm-inline">Nhân viên</span></a>
                            </li>
                            <li>
                                <a href="quanlithethang.htm" class="nav-link px-0"> <span class="d-none d-sm-inline">Thẻ tháng</span></a>
                            </li>
                            <li>
                                <a href="quanlilich.htm" class="nav-link px-0"> <span class="d-none d-sm-inline">Lịch</span></a>
                            </li>
                             <!-- <li>
                                <a href="luong.htm" class="nav-link px-0"> <span class="d-none d-sm-inline">Lương</span></a>
                            </li> -->
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
                                <a href="chinhsuaphi.htm" class="nav-link px-0"> <span class="d-none d-sm-inline">Phí gửi xe</span></a>
                            </li>
                        </ul>
                    </li>
                    
 						<hr>

						<div class="dropdown pb-4">
							<a href="#"
								class="d-flex align-items-center text-white text-decoration-none dropdown-toggle"
								id="dropdownUser1" data-bs-toggle="dropdown"
								aria-expanded="false"> <img src="https://github.com/mdo.png"
								alt="hugenerd" width="30" height="30" class="rounded-circle">
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
				<h2>Xem doanh thu</h2>
				<div class="d-flex justify-content-center align-items-center">
					<form action="/QLNX/doanhthu.htm"
						class="d-flex justify-content-center align-items-center">

						<p class="text-nowrap mt-2">Từ ngày:</p>
						<input class="form-control mx-2" name="tungay"
							data-provide="datepicker" type="date">
						<p class="text-nowrap mt-2">Đến ngày:</p>
						<input class="form-control mx-2" name="denngay"
							data-provide="datepicker" type="date">
						<div class="form-group row  ">
							<div class="col-sm-10">
								<button type="submit" class="btn btn-primary">Lọc</button>
							</div>
						</div>
					</form>
				</div>
				<table class="table table-bordered table-striped mt-5" id = "tbldemo">
					<thead>
						<tr>
							<th scope="col">Hình thức</th>
							<th scope="col" colspan="2">Gửi ngày</th>
							<th scope="col" colspan="2">Gửi đêm</th>
							<th scope="col" colspan="2">Gửi tháng</th>
							<th scope="col" colspan="2">Tổng</th>
							<th scope="col">Tổng</th>
						</tr>
						<tr>
							<th scope="col">Loại xe</th>
							<th scope="col">Xe máy số</th>
							<th scope="col">Xe tay ga</th>
							<th scope="col">Xe máy số</th>
							<th scope="col">Xe tay ga</th>
							<th scope="col">Xe máy số</th>
							<th scope="col">Xe tay ga</th>
							<th scope="col">Xe máy số</th>
							<th scope="col">Xe tay ga</th>

						</tr>
					</thead>
					<tbody>
						<tr>
							<th scope="row">Số lượng</th>
							<td>${c_ga_ngay}</td>
							<td>${c_ga_ngay}</td>
							<td>${c_so_dem}</td>
							<td>${c_ga_dem}</td>
							<td>${c_so_thang}</td>
							<td>${c_ga_thang}</td>
							<td>${c_so_ngay + c_so_dem + c_so_thang}</td>
							<td>${c_ga_ngay + c_ga_dem + c_ga_thang}</td>
							<td>${c_so_ngay + c_so_dem + c_so_thang + c_ga_ngay + c_ga_dem + c_ga_thang}</td>
						</tr>
						<tr>
							<th scope="row">Thành tiền</th>
							<td>${s_ga_ngay}</td>
							<td>${s_ga_ngay}</td>
							<td>${s_so_dem}</td>
							<td>${s_ga_dem}</td>
							<td>${s_so_thang}</td>
							<td>${s_ga_thang}</td>
							<td>${s_so_ngay + s_so_dem + s_so_thang}</td>
							<td>${s_ga_ngay + s_ga_dem + s_ga_thang}</td>
							<td>${s_so_ngay + s_so_dem + s_so_thang + s_ga_ngay + s_ga_dem + s_ga_thang}</td>
						</tr>
					</tbody>
				</table>
				<button id="btnexport" class = "btn btn-info">Export to excel</button>
				<script>
        $(function () {
            $("#btnexport").click(function () {
                $("#tbldemo").table2excel();
            });
        });
    </script>
			</div>
		</div>
		<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
			integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
			crossorigin="anonymous"></script>
</body>
</html>