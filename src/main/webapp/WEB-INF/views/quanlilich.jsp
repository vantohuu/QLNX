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

								<li><a class="dropdown-item" href="chinhsuathongtin">Chỉnh
										sửa thông tin cá nhân</a></li>
								<li><a class="dropdown-item" href="doimatkhau">Đổi mật
										khẩu</a></li>
								<li>
									<hr class="dropdown-divider">
								</li>
								<li><a class="dropdown-item" href="dangxuat">Đăng xuất</a></li>
							</ul>
						</div>
				</div>
			</div>
			<div class="col py-3">
				<h2>Quản lí lịch làm việc</h2>

				<div class="d-flex" style="height: 80px">
					<!-- Button trigger modal -->


					<button type="button" class="btn btn-primary my-2 mx-3"
						data-bs-toggle="modal" data-bs-target="#exampleModal">Thêm
						lịch</button>

					<!-- Modal -->
					<div class="modal fade" id="exampleModal" tabindex="-1"
						aria-labelledby="exampleModalLabel" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<h5 class="modal-title" id="exampleModalLabel">Thêm lịch</h5>
									<button type="button" class="btn-close" data-bs-dismiss="modal"
										aria-label="Close"></button>
								</div>
								<div class="modal-body">

									<form action="/QLNX/quanlilich.htm" method="post">
										<p>Chọn nhân viên</p>
										<select class="form-select" name="chonnhanvien"
											required="required">
											<c:forEach var="nv" items="${listNhanVien}" varStatus="stt">
												<option value="${nv.maNv}">${nv.ho}${nv.ten} -
													${nv.CTChucVu.chucVu.ten} - ${nv.CTChucVu.loaiNhanVien}</option>
											</c:forEach>
										</select>
										<p>Chọn ngày</p>
										<input class="form-control" name="chonngay"
											data-provide="datepicker" type="date" required="required">

										<p>Chọn ca</p>
										<select class="form-select" name="chonca"
											aria-label="Default select example" required="required">
											<c:forEach var="ca" items="${listCa}" varStatus="stt">
												<option value="${ca.maCa}">${ca.tenCa}</option>
											</c:forEach>
										</select>


										<div class="form-group row mt-3 ">
											<div class="col-sm-10">
												<button type="submit" class="btn btn-primary">Xác
													nhận</button>
											</div>
										</div>
									</form>
								</div>
							</div>
						</div>
					</div>

					<div class="d-flex justify-content-center align-items-center">
						<form action="/QLNX/quanlilich.htm"
							class="d-flex justify-content-center align-items-center">
							<p class="text-nowrap mt-2">Lọc nhân viên:</p>
							<select class="form-select mx-2" name="locnhanvien">
								<c:forEach var="nv" items="${listNhanVien}" >
									<option value="${nv.maNv}">${nv.ho}${nv.ten} -
										${nv.CTChucVu.chucVu.ten} - ${nv.CTChucVu.loaiNhanVien}</option>
								</c:forEach>
							</select>
							<p class="text-nowrap mt-2">Lọc ngày:</p>
							<input class="form-control mx-2" name="locngay"
								data-provide="datepicker" type="date">
							<div class="form-group row  ">
								<div class="col-sm-10">
									<button type="submit" class="btn btn-primary">Lọc</button>
								</div>
							</div>
						</form>

						<form action="/QLNX/quanlilich.htm">
							<div class="form-group row  ">
								<div class="col-sm-10 mx-5">
									<button type="submit" class="btn btn-success text-nowrap">Xóa lọc</button>
								</div>
							</div>
						</form>
					</div>

				</div>
				<p class="text-success">${successlich}</p>
				<p class="text-danger">${errlich}</p>

				<table class="table table-hover">
					<tr>
						<th>Ngày</th>
						<th>Ca</th>
						<th>Họ</th>
						<th>Tên</th>
						<th>Chức vụ</th>
						<th>Loại</th>
						<th>Xóa</th>
					</tr>
					<c:forEach var="lich" items="${listLich}" varStatus="stt">
						<tr>
							<td>${lich.ngay}</td>
							<td>${lich.ca.tenCa}</td>
							<td>${lich.nhanVien.ho}</td>
							<td>${lich.nhanVien.ten}</td>
							<td>${lich.nhanVien.CTChucVu.chucVu.ten}</td>
							<td>${lich.nhanVien.CTChucVu.loaiNhanVien}</td>
							<td><a href="/QLNX/quanlilich/${lich.idLichLamViec}.htm"><button
										type="button" class="btn btn-danger">Xóa</button></a></td>
						</tr>
					</c:forEach>
				</table>
				<ul class="pagination"
					style="position: absolute; bottom: 0; right: 0; width: 400px;">
					<li class="page-item ${currentPage == 0 ? 'disabled' : ''}"><a
						class="page-link"
						href="/QLNX/quanlilich.htm?page=${currentPage - 1}">Trước</a></li>
					<c:forEach begin="0" end="${totalPages > 0 ? totalPages - 1 : 0}"
						var="i">
						<li class="page-item ${currentPage == i ? 'active' : ''}"><a
							class="page-link" href="/QLNX/quanlilich.htm?page=${i}">${i + 1}</a>
						</li>
					</c:forEach>
					<li
						class="page-item ${currentPage == totalPages - 1 ? 'disabled' : ''}">
						<a class="page-link"
						href="/QLNX/quanlilich.htm?page=${currentPage + 1}">Sau</a>
					</li>
				</ul>
			</div>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
		crossorigin="anonymous"></script>
</body>
</html>