package QLNX.controller;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
public class PhiGuiXeController {
	@Autowired
	SessionFactory factory;

	
	@RequestMapping("chinhsuaphi")
	public String xemPhi(ModelMap model, HttpSession ss) {
		System.out.println("chinhsuaphi");
		String username = (String) ss.getAttribute("username");
		if (username != null) {
			List<PhiGuiXe> list = new ArrayList<PhiGuiXe>();
			list.add(getPhi("NGAY", "XEMAYSO"));
			list.add(getPhi("NGAY", "XETAYGA"));
			list.add(getPhi("DEM", "XEMAYSO"));
			list.add(getPhi("DEM", "XETAYGA"));
			list.add(getPhi("THANG", "XEMAYSO"));
			list.add(getPhi("THANG", "XETAYGA"));
			if (list.size() == 0)
			{
				model.addAttribute("errphi", "Database sai!");
			}
			else
			{
				model.addAttribute("listPhi", list);	
			}
			
		}
		return "chinhsuaphi";
	}

	@RequestMapping(value = "chinhsuaphi", method =RequestMethod.POST)
	public String savePhi(ModelMap model, HttpServletRequest request,HttpSession ss) throws Exception {
		System.out.println("chinhsuaphi-post");
		String username = (String) ss.getAttribute("username");
		Session session = factory.openSession();
		if (username != null) {
			Transaction tx = session.beginTransaction();
			try {
				String hinhthuc = request.getParameter("chonhinhthuc");
				String loaixe =	request.getParameter("chonloaixe");
				String phi =	request.getParameter("chonphi");
				System.out.println(hinhthuc);
				System.out.println(loaixe);
				System.out.println(phi);
				if (hinhthuc == null || loaixe == null || phi == null || hinhthuc == "" || loaixe == "" || phi == "")
				{
					model.addAttribute("errxephi", "Không được nhập rỗng!");
				}
				
				else
				{
					LocalDateTime ldt = LocalDateTime.now();
					Instant instant = ldt.toInstant(ZoneOffset.UTC);
				    Date date = Date.from(instant);
				    BigDecimal bd = new BigDecimal(phi);
				    NhanVien nv = getNhanVien(username).get(0);
					PhiGuiXe pgx = new PhiGuiXe(hinhthuc, date, loaixe, bd,nv);
				    session.save(pgx);
					tx.commit();
					model.addAttribute("successxevao", "Thành công!");
				}
			 }
			 catch (Exception e) {
			     if (tx!=null) tx.rollback();
			     System.out.println(e);
			     throw e;
			 }
			 finally {
				 session.close();
			 }
			System.out.println("chinhsuaphi-post");
			
		}
		return "redirect:/chinhsuaphi.htm";
	}

	public List<NhanVien> getNhanVien(String username) {
		Session session = factory.getCurrentSession();
		String hql ="FROM NhanVien where maNv = :username";
		Query query = session.createQuery(hql);
		query.setParameter("username", username);
		List<NhanVien> list = query.list();
		return list;
	}
	public PhiGuiXe getPhi(String hinhthuc, String loaixe) {
		Session session = factory.getCurrentSession();

		String hql ="FROM PhiGuiXe where idPhi = (select max(idPhi) from PhiGuiXe where hinhThuc = :hinhThuc and loaiXe = :loaiXe)";
		Query query = session.createQuery(hql);
		query.setParameter("hinhThuc", hinhthuc);
		query.setParameter("loaiXe", loaixe);
		List<PhiGuiXe> list = query.list();
		return list.get(0);
	}
}
