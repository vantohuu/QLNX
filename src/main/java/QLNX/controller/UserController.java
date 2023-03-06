package QLNX.controller;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;


import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import QLNX.entity.CTChucVu;
import QLNX.entity.ChucVu;
import QLNX.entity.NhanVien;
import QLNX.entity.TaiKhoan;
import QLNX.entity.ThongKeLuong;

@Transactional
@Controller
public class UserController {

	@Autowired
	SessionFactory factory;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLoginForm() {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(ModelMap model, HttpServletRequest request, HttpSession session) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		int check = isValidUser(username, password);
		if (check == 1) {
			session.setAttribute("username", username);
			session.setAttribute("quyenHan", this.checkQuyenHan(username));
			return "redirect:/home.htm";
		} else {
			if (check == 0) {
				model.addAttribute("error", "Tài khoản không tồn tại!");
				return "login";
			} else {
				model.addAttribute("error", "Mật khẩu không chính xác!");
				return "login";
			}
		}
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(HttpSession session) {
		// Kiểm tra xem người dùng đã đăng nhập chưa
		if (session.getAttribute("username") != null) {
			return "home";
		} else {
			return "redirect:/login.htm";
		}
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		// Xóa thông tin người dùng khỏi phiên làm việc và kết thúc phiên
		session.removeAttribute("username");
		session.invalidate();
		return "redirect:/login.htm";
	}

	@RequestMapping(value="/nhanvien")
	public String thongTinNhanVien(HttpSession session, ModelMap model, @RequestParam(defaultValue = "0") int page) {
		if (!session.getAttribute("quyenHan").equals("QL")) {;
			return "home";
		} else {
			int pageSize = 10;
			List<NhanVien> thongTinNhanVien = this.getNhanVien(page,pageSize);
			model.addAttribute("nhanVien",thongTinNhanVien);
			int totalUsers = getSize();
		    int totalPages = (int) Math.ceil((double) totalUsers / pageSize);
		    model.addAttribute("totalPages", totalPages);
		    model.addAttribute("currentPage", page);
			return "nhanvien/nhanvien";
		}
	}
	
	@RequestMapping(value="nhanvien-sua/{maNV}.htm")
	public String suaNhanVien(@ModelAttribute("nhanVien") NhanVien nhanVien,@PathVariable("maNV") String maNV,ModelMap model) {
		model.addAttribute("nhanVien",this.searchNhanVien(maNV));
		
		return "nhanvien/nhanvien-sua";
	}
	@RequestMapping(value="nhanvien-sua/update",params = "update", method = RequestMethod.POST) 
	public String editNhanVien(@ModelAttribute("nhanVien") NhanVien nhanVien,ModelMap model) {
		NhanVien nhanVien1 = searchNhanVien(nhanVien.getMaNv());
		System.out.println(nhanVien1);
		System.out.println(nhanVien);
		if(!nhanVien.getCTChucVu().getChucVu().getMaCV().equals(nhanVien1.getCTChucVu().getChucVu().getMaCV())) {
			nhanVien1.setCTChucVu(searchCTChucVu(nhanVien.getCTChucVu().getChucVu().getMaCV(), nhanVien.getCTChucVu().getLoaiNhanVien()));
			Session session = factory.openSession();
			Transaction t = session.beginTransaction();
			try {
				session.update(nhanVien1);
				t.commit();
				model.addAttribute("message", "Update thành công");
			} catch (Exception e) {
				t.rollback();
				
			} finally {
				session.close();
			}
		} else {
			model.addAttribute("message", "Update thất bại!");
		}
		return "nhanvien/nhanvien-sua";
	}
	@RequestMapping(value="/chucvu")
	public String thongTinChucVu(HttpSession session, ModelMap model) {
		if (!session.getAttribute("quyenHan").equals("QL")) {;
			return "home";
		} else {
			List<CTChucVu> thongTinChucVu = this.getCTChucVu();
			model.addAttribute("ctChucVu",thongTinChucVu);
			return "nhanvien/nhanvien-chucvu";
		}
	}
	
	@RequestMapping(value="/nhanvien-themmoi") 
	public String themNhanVienMoi() {
		return "nhanvien/nhanvien-themmoi";
	}
	@RequestMapping(value="nhanvien-themchucvu")
	public String themChucVu(@ModelAttribute("ctChucVu") CTChucVu ctChucVu,ModelMap model) {
		return "nhanvien/nhanvien-themchucvu";
	}
	@RequestMapping(value="add-vitri", method = RequestMethod.POST) 
	public String addChucVu(@ModelAttribute("ctChucVu") CTChucVu ctChucVu,ModelMap model) {
		if(ctChucVu.getLuong()== null) {
			model.addAttribute("message", "** Lương không thể bỏ trống");
			return "nhanvien/nhanvien-themchucvu";
		}
		if(searchCTChucVu(ctChucVu.getChucVu().getMaCV(), ctChucVu.getLoaiNhanVien()) == null) {
			Session session = factory.openSession();
			Transaction t = session.beginTransaction();
			try {
				session.save(ctChucVu);
				t.commit();
				model.addAttribute("message", "Thêm mới thành công");
			} catch (Exception e) {
				t.rollback();
				
			} finally {
				session.close();
			}
		} else {
			model.addAttribute("message", "Vị trí đã tồn tại !");
		}
		return "nhanvien/nhanvien-themchucvu";
	}
	@RequestMapping(value="nhanvien-suachucvu/{id}.htm")
	public String suaChucVu(@ModelAttribute("ctChucVu") CTChucVu ctChucVu,@PathVariable("id") int id,ModelMap model) {
		Session session = factory.getCurrentSession();
		String hql = "FROM CTChucVu WHERE idCTChucVu = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		CTChucVu ctChucVu1 = (CTChucVu) query.list().get(0);
		model.addAttribute("ctChucVu",ctChucVu1);
		
		return "nhanvien/nhanvien-suachucvu";
	}
	@RequestMapping(value="/nhanvien-suachucvu/edit-vitri", method = RequestMethod.POST) 
	public String editChucVu(@ModelAttribute("ctChucVu") CTChucVu ctChucVu,ModelMap model) {
		if(ctChucVu.getLuong()== null) {
			model.addAttribute("message", "** Lương không thể bỏ trống");
			return "nhanvien/nhanvien-themchucvu";
		}
		CTChucVu ctChucVu1 = searchCTChucVu(ctChucVu.getChucVu().getMaCV(), ctChucVu.getLoaiNhanVien());
		if(ctChucVu1.getLuong().compareTo(ctChucVu.getLuong())!=0) {
			Session session = factory.openSession();
			Transaction t = session.beginTransaction();
			try {
				ctChucVu1.setLuong(ctChucVu.getLuong());
				session.update(ctChucVu1);
				t.commit();
				model.addAttribute("message", "Sửa lương đổi thành công");
			} catch (Exception e) {
				t.rollback();
				
			} finally {
				session.close();
			}
		} else {
			return "redirect:../chucvu.htm";
		}
		return "nhanvien/nhanvien-suachucvu";
	}
	@RequestMapping("/nhanvien-thongtin")
	public String xemThongTin(@ModelAttribute("nhanVien") NhanVien nhanVien,ModelMap model, HttpSession session) {		
		NhanVien nv = searchNhanVien((String) session.getAttribute("username"));

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = formatter.format(nv.getNgaySinh());

		System.out.println("Chuỗi ngày mới: " + dateString);

		System.out.println(nv.getNgaySinh());
		model.addAttribute("nhanVien",nv);
		model.addAttribute("ngaySinh1",dateString);
		return "nhanvien/nhanvien-thongtin";
	}
	@ModelAttribute("chucVu")
	public List<ChucVu> getChucVu() {
		Session session = factory.getCurrentSession();
		String hql = "FROM ChucVu";
		Query query = session.createQuery(hql);
		List<ChucVu> list = query.list();
		return list;
	}
	@ModelAttribute("loaiNhanVien")
	public List<String> getLoaiNhanVien() {
		List<String> list = new ArrayList<String>();
		list.add("Full-time");
		list.add("Part-time");
		return list;
	}
	@ModelAttribute("gioiTinh")
	public List<String> getGioiTinh() {
		List<String> list = new ArrayList<String>();
		list.add("Nam");
		list.add("Nữ");
		return list;
	}
	@RequestMapping(value="/capnhatthongtincanhan", method = RequestMethod.POST)
	public String capNhatThongTinCaNhan(@ModelAttribute("nhanVien") NhanVien nhanVien, ModelMap model, HttpServletRequest request) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		NhanVien nv = searchNhanVien(nhanVien.getMaNv());
		if(!nv.getCccd().equals(nhanVien.getCccd())) {
			if(checkTrungCCCD(nhanVien.getCccd())==1) {
				model.addAttribute("nhanVien",nv);
				String dateString = formatter.format(nv.getNgaySinh());
				model.addAttribute("ngaySinh1",dateString);
				model.addAttribute("message","** CCCD vừa thay đổi bị trùng rồi !");
				return "nhanvien/nhanvien-thongtin";
			}
		}
		String tmp = request.getParameter("ngaySinh1");
		Date c1 = formatter.parse(tmp);
		System.out.println(c1);
		System.out.println(tmp);
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			nv.setHo(nhanVien.getHo());
			nv.setTen(nhanVien.getTen());
			nv.setGioiTinh(nhanVien.getGioiTinh());
			nv.setCccd(nhanVien.getCccd());
			nv.setSdt(nhanVien.getSdt());
			nv.setEmail(nhanVien.getEmail());
			nv.setNgaySinh(c1);
			nv.setDiaChi(nhanVien.getDiaChi());
			session.update(nv);
			model.addAttribute("message", "Sửa đổi thông tin cá nhân thành công");
			t.commit();
			
		} catch (Exception e) {
			t.rollback();
			
		} finally {
			session.close();
		}
		String dateString = formatter.format(nv.getNgaySinh());
		model.addAttribute("ngaySinh1",dateString);
		model.addAttribute("nhanVien",nv);
		return "nhanvien/nhanvien-thongtin";
	}
	
	@RequestMapping(value="/nhanvien-themmoi",method = RequestMethod.POST) 
	public String themMoi(HttpServletRequest request,ModelMap model) {
		Session session = factory.openSession();
		Transaction tr = session.beginTransaction();
		NhanVien nhanVien = new NhanVien();
		nhanVien.setMaNv(request.getParameter("maNv"));
		nhanVien.setHo(request.getParameter("ho"));
		nhanVien.setTen(request.getParameter("ten"));
		nhanVien.setGioiTinh(request.getParameter("gioiTinh"));
		nhanVien.setCccd(request.getParameter("cccd"));
		nhanVien.setSdt(request.getParameter("sdt"));
		nhanVien.setEmail(request.getParameter("email"));
		String maCV =request.getParameter("chucVu");
		String loaiNhanVien =  request.getParameter("loaiNhanVien");
		CTChucVu ctCV = searchCTChucVu(maCV,loaiNhanVien);
		if(ctCV == null) {
			model.addAttribute("messagectChucVu", "!Không tồn tại chức vụ " +searchTenChucVu(maCV) +
					" với hình thức "+ loaiNhanVien);
			return "nhanvien/nhanvien-themmoi";
		} else {
			model.addAttribute("messagectChucVu", "");
		}
		nhanVien.setCTChucVu(ctCV);
		System.out.print(nhanVien.getMaNv());
		System.out.print(nhanVien.getHo());
		System.out.print(nhanVien.getTen());
		System.out.print(nhanVien.getGioiTinh());
		System.out.print(nhanVien.getCccd());
		System.out.print(nhanVien.getEmail());
		try {
			String mkDefault = "123456";
			TaiKhoan tk = new TaiKhoan(nhanVien.getMaNv(), mkDefault, 1);
			session.save(tk);
			session.save(nhanVien);
			tr.commit();
			model.addAttribute("message","Đã thêm mới nhân viên thành công!");
		} catch (Exception e) {
			tr.rollback();
			model.addAttribute("message","Nhân viên đã tồn tại!");
		} finally {
			session.close();
		}
		return "nhanvien/nhanvien-themmoi";
	}
	@RequestMapping("/bangluong")
	public String bangLuong(ModelMap model, HttpSession session1) {
		if (!session1.getAttribute("quyenHan").equals("QL")) {;
		return "home";
		}
		Session session = factory.getCurrentSession();
		Query query = ((SQLQuery) session.createSQLQuery("EXEC THONG_KE_LUONG :month, :year")
		    .setParameter("month", 1)
		    .setParameter("year", 2023))
		    .addEntity(ThongKeLuong.class);

		List<ThongKeLuong> results = query.list();
//		for (int i=0; i<results.size();i++) {
//			
//			System.out.print("Manv:" +results.get(i).getMaNV() +" tongGio: "+results.get(i).getTongGio()+ " loaiNhanVien: " 
//			+results.get(i).getLoaiNV() +" tenchucvu: "+ results.get(i).getTenCV());
//		}
		model.addAttribute("nhanVien",results);
		return "nhanvien/nhanvien-bangluong";
	}
	
	public List<CTChucVu> getCTChucVu() {
		Session session = factory.getCurrentSession();
		String hql = "FROM CTChucVu";
		Query query = session.createQuery(hql);
		List<CTChucVu> list = query.list();
		return list;
	}
	
	public NhanVien searchNhanVien(String maNV) {
		Session session = factory.getCurrentSession();
		String hql = "FROM NhanVien WHERE maNv = :maNV";
		Query query = session.createQuery(hql);
		query.setParameter("maNV", maNV);
		if(query.list().size()==0) return null;
		return (NhanVien) query.list().get(0);
	}
	
	public CTChucVu searchCTChucVu(String maCV, String loaiNhanVien) {
		Session session = factory.getCurrentSession();
		String hql = "FROM CTChucVu WHERE maCV = :maCV AND loaiNhanVien = :loaiNhanVien";
		Query query = session.createQuery(hql);
		query.setParameter("maCV", maCV);
		query.setParameter("loaiNhanVien", loaiNhanVien);
		if(query.list().size()==0) return null;
		CTChucVu ctCV =(CTChucVu) query.list().get(0);
		return ctCV;
	}
	
	public String searchTenChucVu(String maCV) {
		Session session = factory.getCurrentSession();
		String hql = "SELECT ten FROM ChucVu WHERE maCV = :maCV";
		Query query = session.createQuery(hql);
		query.setParameter("maCV", maCV);
		if(query.list().size()==0) return null;
		String ten = (String)query.list().get(0);
		return ten;
	}
	
	public List<NhanVien> getNhanVien(int page, int pageSize) {
		Session session = factory.getCurrentSession();
		String hql = "FROM NhanVien";
		Query query = session.createQuery(hql);
		int offset = page * pageSize;
		List<NhanVien> list = query.setFirstResult(offset).setMaxResults(pageSize).list();

		return list;
	}
	
	public List<TaiKhoan> getTaiKhoan() {
		Session session = factory.getCurrentSession();
		String hql = "FROM TaiKhoan";
		Query query = session.createQuery(hql);
		List<TaiKhoan> list = query.list();

		return list;
	}
	
	public int  getSize() {
		Session session = factory.getCurrentSession();
		String hql = "FROM NhanVien";
		Query query = session.createQuery(hql);
		List<NhanVien> list = query.list();

		return list.size();
	}


	public TaiKhoan searchTK(String username) {
		Session session = factory.getCurrentSession();
		String hql = "FROM TaiKhoan where username = :username";
		Query query = session.createQuery(hql);
		query.setParameter("username", username);
		if(query.list().size()==0) {
			return null;
		}
		TaiKhoan tk = (TaiKhoan) query.list().get(0);

		return tk;
	}

	private int isValidUser(String username, String password) {
		TaiKhoan check = this.searchTK(username);
		if (check == null) {
			return 0;
		} else if (password.equals(check.getPassword())) {
			return 1;
		} else {
			return 2;
		}
	}
	private int checkTrungCCCD( String CCCD) {
		Session session = factory.getCurrentSession();
		String hql = "FROM NhanVien where cccd = :CCCD";
		Query query = session.createQuery(hql);
		query.setParameter("CCCD", CCCD);
		List<NhanVien> list = query.list();
		if(list.size() == 0) return 0;
		return 1;
	}
	private String checkQuyenHan(String username) {
		TaiKhoan check = this.searchTK(username);
		return check.getNhanVien().getCTChucVu().getChucVu().getMaCV();
	}
}
