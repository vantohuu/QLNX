<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resource/css/home.css">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" 
     integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://kit.fontawesome.com/ee36f81461.js" crossorigin="anonymous"></script>
  </head>
<body>
    <div class="container-fluid">
    <div class="row flex-nowrap">
        <div class="col-auto col-md-3 col-xl-2 px-sm-2 px-0t bg-dark">
            <div class="d-flex flex-column align-items-center align-items-sm-start px-3 pt-2 text-white min-vh-100 ">
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
                                <a href="quanlitheluot.htm" class="nav-link px-0"> <span class="d-none d-sm-inline">Thẻ lượt</span></a>
                            </li>
                            <li class="w-100">
                                <a href="quanlithethang.htm" class="nav-link px-0"> <span class="d-none d-sm-inline">Thẻ tháng</span></a>
                            </li>
                            <li class="w-100">
                                <a href="quanlidoanhthu.htm" class="nav-link px-0"> <span class="d-none d-sm-inline">Doanh thu</span></a>
                            </li>
                            <li>
                                <a href="quanlinhanvien.htm" class="nav-link px-0"> <span class="d-none d-sm-inline">Nhân viên</span></a>
                            </li>
                            <li>
                                <a href="quanlilich.htm" class="nav-link px-0"> <span class="d-none d-sm-inline">Lịch</span></a>
                            </li>
                             <li>
                                <a href="quanliluong.htm" class="nav-link px-0"> <span class="d-none d-sm-inline">Lương</span></a>
                            </li>
                             <li>
                                <a href="quanlitaikhoan.htm" class="nav-link px-0"> <span class="d-none d-sm-inline">Tài khoản</span></a>
                            </li>
                             <li>
                                <a href="quanlibienban.htm" class="nav-link px-0"> <span class="d-none d-sm-inline">Biên bản</span></a>
                            </li>
                             <li>
                                <a href="quanlisuco.htm" class="nav-link px-0"> <span class="d-none d-sm-inline">Sự cố</span></a>
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
   
                        <li><a class="dropdown-item" href="chinhsuathongtin">Chỉnh sửa thông tin cá nhân</a></li>
                        <li><a class="dropdown-item" href="doimatkhau">Đổi mật khẩu</a></li>
                        <li>
                            <hr class="dropdown-divider">
                        </li>
                        <li><a class="dropdown-item" href="dangxuat">Đăng xuất</a></li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="col py-3 d-flex justify-content-center align-items-center">
        	<div>
         <form action="/QLNX/thevao.htm" method="post">
  <div class="form-group row">
    <label for="inputEmail3" class="col-sm-2 col-form-label">Nhập mã thẻ</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="mathe" name="mathe" placeholder="Mã thẻ">
    </div>
  </div>
  <div class="form-group row">
    <label for="inputPassword3" class="col-sm-2 col-form-label">Nhập biển số xe</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="bsx" name = "bsx"  placeholder="Biển số xe">
    </div>
  </div>
  <fieldset class="form-group">
    <div class="row">
      <legend class="col-form-label col-sm-2 pt-0">Radios</legend>
      <div class="col-sm-10">
        <div class="form-check">
          <input class="form-check-input" type="radio" name="gridRadios" id="gridRadios1" value="option1" checked>
          <label class="form-check-label" for="gridRadios1">
            First radio
          </label>
        </div>
        <div class="form-check">
          <input class="form-check-input" type="radio" name="gridRadios" id="gridRadios2" value="option2">
          <label class="form-check-label" for="gridRadios2">
            Second radio
          </label>
        </div>
        <div class="form-check disabled">
          <input class="form-check-input" type="radio" name="gridRadios" id="gridRadios3" value="option3" disabled>
          <label class="form-check-label" for="gridRadios3">
            Third disabled radio
          </label>
        </div>
      </div>
    </div>
  </fieldset>
  <div class="form-group row">
    <div class="col-sm-2">Checkbox</div>
    <div class="col-sm-10">
      <div class="form-check">
        <input class="form-check-input" type="checkbox" id="gridCheck1">
        <label class="form-check-label" for="gridCheck1">
          Example checkbox
        </label>
      </div>
    </div>
  </div>
  <div class="form-group row">
    <div class="col-sm-10">
      <button type="submit" class="btn btn-primary">Sign in</button>
    </div>
  </div>
</form>
        	</div>
           
        </div>
    </div>
</div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
</body>
</html>