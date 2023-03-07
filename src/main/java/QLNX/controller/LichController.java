package QLNX.controller;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
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
import QLNX.entity.Ca;
import QLNX.entity.LichLamViec;
import QLNX.entity.LichSuPhi;
import QLNX.entity.NhanVien;
import QLNX.entity.PhiGuiXe;
import QLNX.entity.TaiKhoan;
import QLNX.entity.TheLuot;

@Controller
@Transactional 
public class LichController {
    @Autowired
    SessionFactory factory;
		
	
	@RequestMapping("quanlilich")
	public String lichSuGui(ModelMap model, @RequestParam(defaultValue = "0") int page) {
		System.out.println("quanlilich");
		
		Session session = factory.getCurrentSession();
		
		
		String hqlCa ="FROM Ca";
		Query queryCa = session.createQuery(hqlCa);
		List<Ca> listCa = queryCa.list();
		
		String hqlNhanVien ="FROM NhanVien";
		Query queryNhanVien = session.createQuery(hqlNhanVien);
		List<NhanVien> listNhanVien = queryNhanVien.list();


		int pageSize = 12;
		List<LichLamViec> listLich = getLichLamViec(page, pageSize);
		int size = getSize();
	    int totalPages = (int) Math.ceil((double) size / pageSize);
	    model.addAttribute("totalPages", totalPages);
	    model.addAttribute("currentPage", page);
		
		model.addAttribute("listLich", listLich);
		model.addAttribute("listNhanVien", listNhanVien);
		model.addAttribute("listCa", listCa);
		return "quanlilich";
	}
	
	
	@RequestMapping(value = "quanlilich", method = RequestMethod.POST)
	public String saveLich(ModelMap model,HttpServletRequest request,HttpSession ss) throws Exception{
		String username = (String) ss.getAttribute("username");
		System.out.println(username);
		Session session = factory.openSession();
		if (username != null)
		{
			Transaction tx = session.beginTransaction();
			try {
				String ngay = request.getParameter("chonngay");
				String maca = request.getParameter("chonca");
				String manhanvien = request.getParameter("chonnhanvien");

				System.out.println(ngay);
				System.out.println(maca);
				System.out.println(manhanvien);
				
				if (ngay == null)
				{
					model.addAttribute("errlich", "Chọn ngày là null!");
					return "quanlilich";
				}
				
				LocalDate localDate = LocalDate.parse(ngay,  DateTimeFormatter.ofPattern("yyyy-MM-dd"));
				Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
				List<NhanVien> listNhanVien = getNhanVien(manhanvien);
				List<Ca> listCa = getCa(maca);
				
				if (listNhanVien.size() == 0)
				{
					model.addAttribute("errlich", "Không tìm thấy nhân viên!");
					return "quanlilich";
				}
				
				if (listCa.size() == 0)
				{
					model.addAttribute("errlich", "Không tìm thấy ca!");
					return "quanlilich";
				}
				
				LichLamViec lich = new LichLamViec(listNhanVien.get(0), listCa.get(0), date);
				session.save(lich);

				tx.commit();
							
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
			model.addAttribute("errlich", "Đã hết phiên đăng nhập, vui lòng đăng nhập lại!");
		}
		System.out.println("them lich");

		return "redirect:/quanlilich.htm";
	}
	
	
	@RequestMapping( value = "quanlilich/{id}.htm",method = RequestMethod.GET)
	public String updateLich(ModelMap model,HttpServletRequest request,HttpSession ss, @PathVariable("id") int id) throws Exception{
		String username = (String) ss.getAttribute("username");
		System.out.println(username);
		if (username != null)
		{
			Session session = factory.openSession();
			Transaction tx = session.beginTransaction();
			try {
				
				 String hql = "delete from LichLamViec where idLichLamViec= :id";
				 Query query = session.createQuery(hql);
			 	 query.setParameter("id", id);
				 System.out.println(query.executeUpdate());
				 tx.commit();
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
			model.addAttribute("errlich", "Đã hết phiên đăng nhập, vui lòng đăng nhập lại!");
			return "quanlilich";
		}
		return "redirect:/quanlilich.htm";
	}
	public List<NhanVien> getNhanVien(String username) {
		Session session = factory.getCurrentSession();
		String hql ="FROM NhanVien where maNv = :username";
		Query query = session.createQuery(hql);
		query.setParameter("username", username);
		List<NhanVien> list = query.list();
		return list;
	}
	
	public List<Ca> getCa(String maCa) {
		Session session = factory.getCurrentSession();
		String hql ="FROM Ca where maCa = :maCa";
		Query query = session.createQuery(hql);
		query.setParameter("maCa", maCa);
		List<Ca> list = query.list();
		return list;
	}
	
	public List<LichLamViec> getLichLamViec(int page, int pageSize) {
		Session session = factory.getCurrentSession();
		String hql ="FROM LichLamViec l ORDER BY l.ngay DESC, l.ca.maCa DESC";
		Query query = session.createQuery(hql);
		int offset = page * pageSize;
		List<LichLamViec> list = query.setFirstResult(offset).setMaxResults(pageSize).list();
		return list;
	}
	
	public int  getSize() {
		Session session = factory.getCurrentSession();
		String hql = "FROM LichLamViec";
		Query query = session.createQuery(hql);
		List<NhanVien> list = query.list();
		return list.size();
	}
}
