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
public class DoanhThuController {
	@Autowired
	SessionFactory factory;

	@RequestMapping("doanhthu")
	public String xemDoanhThu(ModelMap model, HttpSession ss, @RequestParam(defaultValue = "") String tungay,
			@RequestParam(defaultValue = "") String denngay) {
		System.out.println("doanhthu");
		String username = (String) ss.getAttribute("username");
		if (username != null) {
			 long c_so_ngay = countDoanhThu("NGAY","XEMAYSO", tungay, denngay);
			 System.out.println(c_so_ngay);
			 long c_ga_ngay = countDoanhThu("NGAY","XETAYGA", tungay, denngay);
			 System.out.println(c_ga_ngay);
			 long c_so_dem = countDoanhThu("DEM","XEMAYSO", tungay, denngay);
			 System.out.println(c_so_dem);
			 long c_ga_dem = countDoanhThu("DEM","XETAYGA", tungay, denngay);
			 System.out.println(c_ga_dem);
			 long c_so_thang = countDoanhThu("THANG","XEMAYSO", tungay, denngay);
			 System.out.println(c_so_thang);
			 long c_ga_thang = countDoanhThu("THANG","XETAYGA", tungay, denngay);
			 System.out.println(c_ga_thang);
			 BigDecimal s_so_ngay = sumDoanhThu("NGAY","XEMAYSO", tungay, denngay);
			 System.out.println(s_so_ngay);
			 BigDecimal s_ga_ngay = sumDoanhThu("NGAY","XETAYGA", tungay, denngay);
			 System.out.println(s_ga_ngay);
			 BigDecimal s_so_dem = sumDoanhThu("DEM","XEMAYSO", tungay, denngay);
			 System.out.println(s_so_dem);
			 BigDecimal s_ga_dem = sumDoanhThu("DEM","XETAYGA", tungay, denngay);
			 System.out.println(s_ga_dem);
			 BigDecimal s_so_thang = sumDoanhThu("THANG","XEMAYSO", tungay, denngay);
			 System.out.println(s_so_thang);
			 BigDecimal s_ga_thang = sumDoanhThu("THANG","XETAYGA", tungay, denngay);
			 System.out.println(s_ga_thang);

			 model.addAttribute("c_so_ngay", c_so_ngay);
			 model.addAttribute("c_ga_ngay", c_ga_ngay);
			 model.addAttribute("c_so_dem", c_so_dem);
			 model.addAttribute("c_ga_dem", c_ga_dem);
			 model.addAttribute("c_so_thang", c_so_thang);
			 model.addAttribute("c_ga_thang", c_ga_thang);
			 model.addAttribute("s_so_ngay", s_so_ngay);
			 model.addAttribute("s_ga_ngay", s_ga_ngay);
			 model.addAttribute("s_so_dem", s_so_dem);
			 model.addAttribute("s_ga_dem", s_ga_dem);
			 model.addAttribute("s_so_thang", s_so_thang);
			 model.addAttribute("s_ga_thang", s_ga_thang);			 
		}
		return "doanhthu";
	}

	public long countDoanhThu(String hinhthuc, String loaixe, String tungay, String denngay) {
		Session session = factory.getCurrentSession();
		Query query = null;
		String hql1 = "";
		
		if (tungay.length() !=0 && denngay.length() !=0)
		{
			LocalDate localDate1 = LocalDate.parse(tungay, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			Date date1 = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());
			LocalDate localDate2 = LocalDate.parse(denngay, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			Date date2 = Date.from(localDate2.atStartOfDay(ZoneId.systemDefault()).toInstant());
			hql1 = "Select count(*) FROM LichSuPhi  where ((phi.hinhThuc = :hinhthuc and phi.loaiXe = :loaixe) and thoiGianTao >= :date1) and thoiGianTao <= :date2";
			query = session.createQuery(hql1);
			query.setParameter("hinhthuc", hinhthuc);
			query.setParameter("loaixe", loaixe);
			query.setParameter("date1", date1);
			query.setParameter("date2", date2);
		}
		
		else if (tungay.length() !=0)
		{
			LocalDate localDate1 = LocalDate.parse(tungay, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			Date date1 = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());
			hql1 = "Select count(*) FROM LichSuPhi  where (phi.hinhThuc = :hinhthuc and phi.loaiXe = :loaixe) and thoiGianTao >= :date1";
			query = session.createQuery(hql1);
			query.setParameter("date1", date1);
			query.setParameter("loaixe", loaixe);
			query.setParameter("hinhthuc", hinhthuc);
		}
		
		else if (denngay.length() !=0)
		{
			LocalDate localDate2 = LocalDate.parse(denngay, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			Date date2 = Date.from(localDate2.atStartOfDay(ZoneId.systemDefault()).toInstant());
			hql1 = "Select count(*) FROM LichSuPhi  where (phi.hinhThuc = :hinhthuc and phi.loaiXe = :loaixe) and thoiGianTao <= :date2";
			query = session.createQuery(hql1);
			query.setParameter("date2", date2);
			query.setParameter("loaixe", loaixe);
			query.setParameter("hinhthuc", hinhthuc);
		}
		else
		{
			hql1 = "Select count(*) FROM LichSuPhi  where (phi.hinhThuc = :hinhthuc and phi.loaiXe = :loaixe)";
			query = session.createQuery(hql1);
			query.setParameter("loaixe", loaixe);
			query.setParameter("hinhthuc", hinhthuc);
		}
		
		long total = (Long) query.uniqueResult();
		return total;
	}
	
	public BigDecimal sumDoanhThu(String hinhthuc, String loaixe, String tungay, String denngay) {
		Session session = factory.getCurrentSession();
		Query query = null;
		String hql1 = "";
		
		if (tungay.length() !=0 && denngay.length() !=0)
		{
			LocalDate localDate1 = LocalDate.parse(tungay, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			Date date1 = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());
			LocalDate localDate2 = LocalDate.parse(denngay, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			Date date2 = Date.from(localDate2.atStartOfDay(ZoneId.systemDefault()).toInstant());
			hql1 = "Select sum(phi.hinhThuc.mucPhi) FROM LichSuPhi  where ((phi.hinhThuc = :hinhthuc and phi.loaiXe = :loaixe) and thoiGianTao >= :date1) and thoiGianTao <= :date2";
			query = session.createQuery(hql1);
			query.setParameter("hinhthuc", hinhthuc);
			query.setParameter("date1", date1);
			query.setParameter("date2", date2);
			query.setParameter("loaixe", loaixe);
		}
		
		else if (tungay.length() !=0)
		{
			LocalDate localDate1 = LocalDate.parse(tungay, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			Date date1 = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());
			hql1 = "Select sum(phi.hinhThuc.mucPhi) FROM LichSuPhi  where (phi.hinhThuc = :hinhthuc and phi.loaiXe = :loaixe) and thoiGianTao >= :date1";
			query = session.createQuery(hql1);
			query.setParameter("date1", date1);
			query.setParameter("hinhthuc", hinhthuc);
			query.setParameter("loaixe", loaixe);

		}
		
		else if (denngay.length() !=0)
		{
			LocalDate localDate2 = LocalDate.parse(denngay, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			Date date2 = Date.from(localDate2.atStartOfDay(ZoneId.systemDefault()).toInstant());
			hql1 = "Select sum(phi.hinhThuc.mucPhi) FROM LichSuPhi  where (phi.hinhThuc = :hinhthuc and phi.loaiXe = :loaixe) and thoiGianTao <= :date2";
			query = session.createQuery(hql1);
			query.setParameter("date2", date2);
			query.setParameter("hinhthuc", hinhthuc);
			query.setParameter("loaixe", loaixe);

		}
		else
		{
			hql1 = "Select sum(phi.hinhThuc.mucPhi) FROM LichSuPhi  where phi.hinhThuc = :hinhthuc and phi.loaiXe = :loaixe";
			query = session.createQuery(hql1);
			query.setParameter("loaixe", loaixe);
			query.setParameter("hinhthuc", hinhthuc);
		}
		BigDecimal total = (BigDecimal) query.uniqueResult();
		if (total == null) total = new BigDecimal(0);
		return total;
	}
}
