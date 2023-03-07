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

								<li><a class="dropdown-item" href="chinhsuathongtin">Chỉnh sửa thông tin cá nhân</a></li>
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
				<h2>Quản lí thẻ tháng</h2>
				<!-- Button trigger modal -->
				<button type="button" class="btn btn-primary my-2"
					data-bs-toggle="modal" data-bs-target="#exampleModal">Thêm
					thẻ tháng</button>

				<!-- Modal -->
				<div class="modal fade" id="exampleModal" tabindex="-1"
					aria-labelledby="exampleModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="exampleModalLabel">Thêm thẻ
									tháng</h5>
								<button type="button" class="btn-close" data-bs-dismiss="modal"
									aria-label="Close"></button>
							</div>
							<div class="modal-body">

								<form action="/QLNX/quanlithethang.htm" method="post">
									<div class="form-group row">
										<label for="inputPassword3" class="col-sm-5 col-form-label">
											Nhập biển số xe</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" id="bsx" name="bsx"
												placeholder="Biển số xe">
										</div>
									</div>
									<fieldset class="form-group">
										<div class="row">
											<legend class="col-form-label col-sm-5 pt-0">Loại xe</legend>
											<div class="col-sm-10">
												<div class="form-check">
													<input class="form-check-input" type="radio" name="xe"
														id="gridRadios1" value="option1" checked> <label
														class="form-check-label" for="gridRadios"> Xe Số </label>
												</div>
												<div class="form-check">
													<input class="form-check-input" type="radio" name="xe"
														id="gridRadios2" value="option2"> <label
														class="form-check-label" for="gridRadios"> Xe Ga </label>
												</div>
											</div>
										</div>
									</fieldset>
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

				<p class="text-success">${successthethang}</p>
				<p class="text-danger">${errthethang}</p>
				
				<form class = "d-flex my-2" action = "/QLNX/quanlithethang.htm">
						<label class = "mx-1 mt-2">Tra cứu biển số xe:</label>
						 <input 
							type="text" class="form-control w-25 mx-2 " name = "timkiem" placeholder="BSX">
					<button type="submit" class="btn btn-primary">Tra</button>
				</form>
				<table class="table table-hover">
					<tr>
						<th>STT</th>
						<th>BSX</th>
						<th>Loại xe</th>
						<th>Trạng thái</th>
						<th>Ngày tạo</th>
						<th>Ngày hết hạn</th>
						<th>Người tạo</th>
						<th>Hiệu chỉnh</th>
					</tr>
					<c:forEach var="the" items="${listTheThang}" varStatus="stt">
						<tr>
							<td><f:formatNumber value="${stt.index + 1}" type="number" /></td>
							<td>${the.xe.bienSoXe}</td>
							<td>${the.xe.loaiXe}</td>
							<td class = "${the.getTrangThai() == 0 ? "text-danger" : "text-success"}" >${the.getTrangThai() == 0 ? "Hết hạn" : "Còn hạn"}</td>
							<td>${the.ngayTao}</td>
							<td>${the.ngayHetHan}</td>
							<td>${the.nhanVien.maNv}</td>
							<td>
								<a href="/QLNX/quanlithethang-update/${the.id}.htm"><button type="button" class="btn btn-primary" >Sửa</button></a>
							</td>
						</tr>
					</c:forEach>
				</table>
				<ul class="pagination"
					style="position: absolute; bottom: 0; right: 0; width: 400px;">
					<li class="page-item ${currentPage == 0 ? 'disabled' : ''}"><a
						class="page-link"
						href="/QLNX/quanthethang.htm?page=${currentPage - 1}">Trước</a></li>
					<c:forEach begin="0" end="${totalPages > 0 ? totalPages - 1 : 0}"
						var="i">
						<li class="page-item ${currentPage == i ? 'active' : ''}"><a
							class="page-link" href="/QLNX/quanlithethang.htm?page=${i}">${i + 1}</a>
						</li>
					</c:forEach>
					<li
						class="page-item ${currentPage == totalPages - 1 ? 'disabled' : ''}">
						<a class="page-link"
						href="/QLNX/quanlithethang.htm?page=${currentPage + 1}">Sau</a>
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