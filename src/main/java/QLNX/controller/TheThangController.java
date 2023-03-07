package QLNX.controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.joda.LocalDateParser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import QLNX.entity.TheLuot;
import QLNX.entity.TheThang;
import QLNX.entity.Xe;
import QLNX.entity.LichSuPhi;
import QLNX.entity.NhanVien;
import QLNX.entity.PhiGuiXe;
import QLNX.entity.TaiKhoan;
import QLNX.entity.TheLuot;

@Controller
@Transactional 
public class TheThangController {
    @Autowired
    SessionFactory factory;
    
	@RequestMapping("quanlithethang")
	public String theThang(ModelMap model, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "") String timkiem) {
		System.out.println("quanlithethang");
		Session session = factory.getCurrentSession();
		int pageSize = 18;
		List<TheThang> list = getTheThang(page, pageSize, timkiem);
		int size = getSize(timkiem);
	    int totalPages = (int) Math.ceil((double) size / pageSize);
	    model.addAttribute("totalPages", totalPages);
	    model.addAttribute("currentPage", page);
		model.addAttribute("listTheThang", list);
		model.addAttribute("listTheThang", list);
		return "thethang";
	}
	@RequestMapping(value = "quanlithethang", method = RequestMethod.POST)
	public String saveTheThang(ModelMap model,HttpServletRequest request,HttpSession ss) throws Exception{
		String username = (String) ss.getAttribute("username");
		System.out.println(username);
		Session session = factory.openSession();
		if (username != null)
		{
			Transaction tx = session.beginTransaction();
			try {
				String bsx = request.getParameter("bsx");
				String xe = request.getParameter("bsx");
				System.out.println(xe.equals("option2"));
				System.out.println(xe);
				System.out.println(bsx);
				System.out.println(request);
				if (bsx == null || xe == null || bsx == "" || xe == "")
				{
					model.addAttribute("errthethang", "Không được nhập rỗng!");
					return "thethang";
				}
				List<NhanVien> listNhanVien = getNhanVien(username);
				List<Xe> listKhachHang = getXe(bsx);
				
				if (listKhachHang.size() == 0)
				{
					Xe kh = new Xe(bsx,xe.equals("option2") ? "XETAYGA" : "XEMAYSO");
					listKhachHang.add(kh);
					session.save(kh);
				}
								
//				List<TheLuot> listTheLuot = getTheLuotIn(listKhachHang.get(0));
				System.out.println(listNhanVien.get(0).getMaNv());
				System.out.println(listKhachHang.get(0).getBienSoXe());
				LocalDateTime timeStarted = LocalDateTime.now(); 
				LocalDateTime timeExpired = timeStarted.plusDays(30);
				ZoneId defaultZoneId = ZoneId.systemDefault();
				TheThang thethang = new TheThang(Date.from(timeStarted.toLocalDate().atStartOfDay(defaultZoneId).toInstant()),
						Date.from(timeExpired.toLocalDate().atStartOfDay(defaultZoneId).toInstant()), listNhanVien.get(0), listKhachHang.get(0));
				session.save(thethang);
				tx.commit();
				model.addAttribute("successthethang", "Thành công!");
//				
				Session session2 = factory.getCurrentSession();
				String hql ="FROM TheThang";
				Query query = session2.createQuery(hql);
				List<NhanVien> list = query.list();
				model.addAttribute("listTheThang", list);
				
			 }
			 catch (Exception e) {
			     if (tx!=null) tx.rollback();
			     System.out.println(e);
			     throw e;
			 }
			 finally {
				 session.close();
			 }
		}
		else
		{
			model.addAttribute("errthethang", "Đã hết phiên đăng nhập, vui lòng đăng nhập lại!");

		}
		return "thethang";
	}
	
	

	@RequestMapping(value="quanlithethang-update/{id}.htm")
	public String suaTheThang(ModelMap model ,@PathVariable("id") int id) {
		Session session = factory.getCurrentSession();
		String hql = "FROM TheThang WHERE id = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		List<TheThang> list = query.list();
		model.addAttribute("thethang",list.get(0));
		return "suathethang";
	}
	
	@RequestMapping( value = "quanlithethang-update/{id}.htm",method = RequestMethod.POST)
	public String updateTheThang2(ModelMap model,HttpServletRequest request,HttpSession ss, @PathVariable("id") int id) throws Exception{
		String username = (String) ss.getAttribute("username");
		System.out.println(username);
		if (username != null)
		{
			Session session = factory.openSession();
			Transaction tx = session.beginTransaction();
			try {
				String bsx = request.getParameter("bsx");
				String xe = request.getParameter("xe");
				System.out.println(xe.equals("option2"));
				System.out.println(xe);
				System.out.println(bsx);
				if (bsx == null || xe == null || bsx == "" || xe == "")
				{
					model.addAttribute("errthethang", "Không được nhập rỗng!");
					return "suathethang";
				}
				
				List<Xe> listKhachHang = getXe(bsx);
				
				if (listKhachHang.size() == 0)
				{
					Xe kh = new Xe(bsx,xe.equals("option2") ? "XETAYGA" : "XEMAYSO");
					listKhachHang.add(kh);
					session.save(kh);
					tx.commit();
				}
				
//				else
//				{
//					List<TheThang> listTheThang = getTheThang(listKhachHang.get(0));
//					if (listTheThang.size() != 0)
//					{
//						LocalDate localDate = LocalDate.now();
//						if (listTheThang.get(0).getNgayHetHan().compareTo(Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant())) > 0)
//						{
//							model.addAttribute("errthethang", "Đã tồn tại thẻ tháng!");
//							return "redirect:/quanlithethang.htm";
//						}
//					}
//				}
				System.out.println(id);
				List<TheThang> listTheThang = getTheThangByID(id);
				
				if (listTheThang.size() == 0)
				{
					model.addAttribute("errthethang", "Không tìm thấy thẻ tháng!");
					return "suathethang";
				} 
				
				String hql = "UPDATE TheThang SET xe = :xe WHERE id = :id";
				Query query = session.createQuery(hql);
				query.setParameter("id", listTheThang.get(0).getId());
				query.setParameter("xe", listKhachHang.get(0));
				int result = query.executeUpdate();
				tx.commit();
				System.out.println(result);
			 }
			 catch (Exception e) {
			     if (tx!=null) tx.rollback();
			     System.out.println(e);
			     throw e;
			 }
			 finally {
				 session.close();
			 }
		}
		else
		{
			model.addAttribute("errthethang", "Đã hết phiên đăng nhập, vui lòng đăng nhập lại!");
		}
		return "redirect:/quanlithethang.htm";
	}
	
	
	public List<NhanVien> getNhanVien(String username) {
		Session session = factory.getCurrentSession();
		String hql ="FROM NhanVien where maNv = :username";
		Query query = session.createQuery(hql);
		query.setParameter("username", username);
		List<NhanVien> list = query.list();
		return list;
	}
	
	public List<Xe> getXe(String bsx) {
		Session session = factory.getCurrentSession();
		String hql1 ="FROM Xe where bienSoXe = :bsx";
		Query query = session.createQuery(hql1);
		query.setParameter("bsx", bsx);
		List<Xe> list = query.list();
		return list;
	}
	
	public List<TheThang> getTheThang(Xe xe) {
		Session session = factory.getCurrentSession();
		String hql1 ="FROM TheThang where ngayHetHan = (select max(ngayHetHan) from TheThang where xe = :xe) and  xe = :xe";
		Query query = session.createQuery(hql1);
		query.setParameter("xe", xe);
		List<TheThang> list = query.list();
		return list;
	}
	
	public List<TheThang> getTheThangByID(int id) {
		Session session = factory.getCurrentSession();
		String hql1 ="FROM TheThang where id = :id";
		Query query = session.createQuery(hql1);
		query.setParameter("id", id);
		List<TheThang> list = query.list();
		return list;
	}
	public List<TheThang> getTheThang(int page, int pageSize, String bsx) {
		Session session = factory.getCurrentSession();
		String hql;
		Query query;
		List<TheThang> list;
		if (bsx.length() == 0 )
		{
			hql ="FROM TheThang t ORDER BY t.id DESC";
			query = session.createQuery(hql);
			int offset = page * pageSize;
			list = query.setFirstResult(offset).setMaxResults(pageSize).list();
		} else
		{
			hql ="FROM TheThang t where t.xe.bienSoXe = :bsx ORDER BY t.id DESC";
			query = session.createQuery(hql);
			int offset = page * pageSize;
			query.setParameter("bsx", bsx);
			list = query.setFirstResult(offset).setMaxResults(pageSize).list();
		}
		return list;
	}
	
	
	public int  getSize(String bsx) {
		Session session = factory.getCurrentSession();
		String hql;
		Query query;
		List<TheThang> list;
		if (bsx.length() == 0)
		{
			hql = "FROM TheThang";
			query = session.createQuery(hql);
			list = query.list();
		} else
		{
			hql = "FROM TheThang t where t.xe.bienSoXe = :bsx";
			query = session.createQuery(hql);
			query.setParameter("bsx", bsx);
			list = query.list();
		}
		return list.size();
	}
	
}
