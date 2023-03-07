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
			   
		}
		return "doanhthu";
	}

	public long countDoanhThu(String hinhthuc) {

		Session session = factory.getCurrentSession();
		String hql1 = "Select count(*) FROM LichSuPhi  where phi.hinhThuc = :hinhthuc";
		Query query = session.createQuery(hql1);
		query.setParameter("hinhthuc", hinhthuc);
		long total = query.getMaxResults();
		return total;
	}

	public BigDecimal sumDoanhThu(String hinhthuc) {

		Session session = factory.getCurrentSession();
		String hql1 = "Select sum(phi.hinhThuc.mucPhi) FROM LichSuPhi  where phi.hinhThuc = :hinhthuc";
		Query query = session.createQuery(hql1);
		query.setParameter("hinhthuc", hinhthuc);
		BigDecimal total = BigDecimal.valueOf(query.getMaxResults());
		return total;
	}

}
