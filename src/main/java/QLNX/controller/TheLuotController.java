package QLNX.controller;

import java.math.BigDecimal;
import java.time.LocalDateTime;
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
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import QLNX.entity.TheLuot;
import QLNX.entity.Xe;
import QLNX.entity.NhanVien;
import QLNX.entity.TaiKhoan;
import QLNX.entity.TheLuot;

@Controller
@Transactional 
public class TheLuotController {
    @Autowired
    SessionFactory factory;
    
	@RequestMapping("thevao")
	public String theVao() {
		System.out.println("thevao");
		return "thevao";
	}
	@RequestMapping(value = "thevao", method = RequestMethod.POST)
	public String saveTheVao(ModelMap model,HttpServletRequest request,HttpSession ss) throws Exception{
		String username = (String) ss.getAttribute("username");
		System.out.println(username);
		Session session = factory.openSession();
		if (username != null)
		{
			Transaction tx = session.beginTransaction();
			try {
				String mathe = request.getParameter("mathe");
				String bsx =	request.getParameter("bsx");
				String xe =	request.getParameter("xe");
				/// chua check bsx
				System.out.println(xe);
				System.out.println(mathe);
				System.out.println(bsx);
				System.out.println(request);
				List<NhanVien> listNhanVien = getNhanVien(username);
				List<TheLuot> listTheLuot = getTheLuot(mathe);
				List<Xe> listKhachHang = getKhachHang(bsx);
				if (listKhachHang.size() == 0)
				{
					Xe kh = new Xe(bsx, xe == "option1" ? "XETAYGA" : "XEMAYSO");
					listKhachHang.add(kh);
					session.save(kh);
				}
				System.out.println(listNhanVien.get(0).getMaNv());
				System.out.println(listTheLuot.get(0).getMaThe());
				System.out.println(listKhachHang.get(0).getBienSoXe());
				TheLuot cttl = new TheLuot(listTheLuot.get(0), listKhachHang.get(0), new Date(System.currentTimeMillis()),null, listNhanVien.get(0), null);
			    session.save(cttl);
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
			System.out.println("nhapthevao");
		}
		return "thevao";
	}
	
	
	@RequestMapping("thera")
	public String theRa() {
		System.out.println("thevao");
		return "thera";
	}
	
	public List<NhanVien> getNhanVien(String username) {
		Session session = factory.getCurrentSession();
		String hql ="FROM NhanVien where maNv = :username";
		Query query = session.createQuery(hql);
		query.setParameter("username", username);
		List<NhanVien> list = query.list();
		return list;
	}
	public List<TheLuot> getTheLuot(String mathe) {
		Session session = factory.getCurrentSession();
		String hql1 ="FROM TheLuot where maThe = :mathe";
		Query query = session.createQuery(hql1);
		query.setParameter("mathe", mathe);
		List<TheLuot> list = query.list();
		return list;
	}
	public List<Xe> getKhachHang(String bsx) {
		Session session = factory.getCurrentSession();
		String hql1 ="FROM KhachHang where bienSoXe = :bsx";
		Query query = session.createQuery(hql1);
		query.setParameter("bsx", bsx);
		List<Xe> list = query.list();
		return list;
	}
}