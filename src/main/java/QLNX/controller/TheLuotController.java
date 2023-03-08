package QLNX.controller;

import java.math.BigDecimal;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import QLNX.entity.TheLuot;
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
				String bsx = request.getParameter("bsx");
				String xe =	request.getParameter("xe");
				System.out.println(xe.equals("option2"));
				System.out.println(xe);
				System.out.println(bsx);
				System.out.println(request);
				if (bsx == null || xe == null || bsx == "" || xe == "")
				{
					model.addAttribute("errxevao", "Không được nhập rỗng!");
					return "thevao";
				}
				List<NhanVien> listNhanVien = getNhanVien(username);
				List<Xe> listKhachHang = getXe(bsx);
				
				if (listKhachHang.size() == 0)
				{
					Xe kh = new Xe(bsx,xe.equals("option2") ? "XETAYGA" : "XEMAYSO");
					listKhachHang.add(kh);
					session.save(kh);
				}
				
				List<TheLuot> listTheLuot = getTheLuotIn(listKhachHang.get(0));
				
				System.out.println(listNhanVien.get(0).getMaNv());
				System.out.println(listKhachHang.get(0).getBienSoXe());
				if (listTheLuot.size() == 0 || (listTheLuot.get(0).getThoiGianRa() !=  null && listTheLuot.get(0).getNhanVien2() != null))
				{
					TheLuot cttl = new TheLuot(listKhachHang.get(0), new Date(System.currentTimeMillis()),null, listNhanVien.get(0), null, new BigDecimal(Double.toString(0)));
				    session.save(cttl);
					tx.commit();
					model.addAttribute("successxevao", "Thành công!");
				}
				else
				{
					System.out.println(listTheLuot.get(0).getIdTheLuot());
					System.out.println("Lỗi");
					model.addAttribute("errxevao", "Xe chưa ra nên không thể cho vé vào");
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
			System.out.println("nhapthevao");
		}
		else
		{
			model.addAttribute("errxevao", "Đã hết phiên đăng nhập, vui lòng đăng nhập lại!");

		}
		return "thevao";
	}
	
	
	
	
	@RequestMapping("thera")
	public String theRa() {
		System.out.println("thera");
		return "thera";
	}
	
	
	
	@RequestMapping(value = "thera", method = RequestMethod.POST)
	public String saveTheRa(ModelMap model,HttpServletRequest request,HttpSession ss) throws Exception{
		String username = (String) ss.getAttribute("username");
		System.out.println(username);
		Session session = factory.openSession();
		if (username != null)
		{
			Transaction tx = session.beginTransaction();
			try {
				String idthe = request.getParameter("idthe");
				String bsx =	request.getParameter("bsx");
				/// chua check bsx
				System.out.println(idthe);
				System.out.println(bsx);
				
				if (idthe == null || bsx == null || idthe == "" || bsx == "")
				{
					model.addAttribute("errorxera", "Không được nhập rỗng!");
					return "thera";
				}
				
				List<NhanVien> listNhanVien = getNhanVien(username);
				List<Xe> listKhachHang = getXe(bsx);
		
				
				if (listKhachHang.size() == 0)
				{
					model.addAttribute("errorxera", "Không tìm thấy biển số xe ứng với ID!");
					return "thera";
				}
				
				List<TheLuot> listTheLuot = getTheLuotOut(idthe);
				
				System.out.println(listNhanVien.get(0).getMaNv());
				System.out.println(listKhachHang.get(0).getBienSoXe());
				
				if (listTheLuot.size() == 0)
				{
					model.addAttribute("errorxera", "Không tìm thấy biển ID thẻ!");
					return "thera";
					
				}
				else 
				if (listTheLuot.get(0).getThoiGianRa() !=  null && listTheLuot.get(0).getNhanVien2() != null)
				{
					model.addAttribute("errorxera", "Đã nhập thẻ ra này!");
					return "thera";
				}
				else
				{
					String hql = "UPDATE TheLuot SET thoiGianRa = :thoiGianRa, nhanVien2 = :nhanVien2, tongTien = :tongTien WHERE idTheLuot = :idThe";
					Query query = session.createQuery(hql);
					query.setParameter("idThe", Integer.parseInt(idthe) );
					query.setParameter("thoiGianRa",  new Date(System.currentTimeMillis()));
					query.setParameter("nhanVien2", listNhanVien.get(0));
					TheLuot tl = listTheLuot.get(0);			
					
					LocalDateTime timevao = LocalDateTime.ofInstant(tl.getThoiGianVao().toInstant(), ZoneId.systemDefault());
					LocalDateTime timera = LocalDateTime.now();
					LocalDateTime timecmp = timera;
//					LocalDateTime timeCompare = LocalDateTime.of(timevao.getYear(), timevao.getMonth(), timevao.getDayOfMonth(), 6, 0);
					
//					LocalDateTime startOfDay = timevao.atStartOfDay();
					List <PhiGuiXe> listPhiNgay =  getPhiNgay(listKhachHang.get(0));
					List <PhiGuiXe> listPhiDem =  getPhiDem(listKhachHang.get(0));
					System.out.println(listPhiNgay.size());
					System.out.println(listPhiDem.size());
					System.out.println(listKhachHang.get(0).getLoaiXe());
					BigDecimal phingay = (BigDecimal) listPhiNgay.get(0).getMucPhi();
					BigDecimal phidem = (BigDecimal) listPhiDem.get(0).getMucPhi();
					BigDecimal tongphi = new BigDecimal(0);
					System.out.println(phingay);
					System.out.println(phidem);
					System.out.println(listPhiNgay.get(0).getHinhThuc());
					System.out.println(listPhiDem.get(0).getHinhThuc());
					
					while (timecmp.compareTo(timevao) > 0)
					{
						if (timecmp.getHour() < 18 && timecmp.getHour() >= 6 ) {
							tongphi = tongphi.add(phingay);
							LichSuPhi ctphingay = new LichSuPhi(listKhachHang.get(0), listPhiNgay.get(0));
							session.save(ctphingay);
						} else {
							tongphi = tongphi.add(phidem);
							LichSuPhi ctphidem = new LichSuPhi(listKhachHang.get(0), listPhiDem.get(0));
							session.save(ctphidem);
						}

						timecmp = timecmp.plusHours(-12);
					}
					query.setParameter("tongTien", tongphi);
					int result = query.executeUpdate();
					System.out.println(result);
					tx.commit();
					model.addAttribute("successxera", "Cập nhật thành công!. Giá vé: " + tongphi + " Đồng");
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
			System.out.println("nhapthera");
		} else
		{
			model.addAttribute("errorxera", "Đã hết phiên đăng nhập, vui lòng đăng nhập lại!");
		}
		return "thera";
	}
	
	
	@RequestMapping("lichsugui")
	public String lichSuGui(ModelMap model, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "") String timkiem) {
		System.out.println("lichsugui");
		Session session = factory.getCurrentSession();
		int pageSize = 18;
		List<TheLuot> list = getTheLuot(page, pageSize, timkiem);
		int size = getSize(timkiem);
	    int totalPages = (int) Math.ceil((double) size / pageSize);
	    model.addAttribute("totalPages", totalPages);
	    model.addAttribute("currentPage", page);
		model.addAttribute("listTheLuot", list);
		return "lichsugui";
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
	
	public List<TheLuot> getTheLuotIn(Xe xe) {
		Session session = factory.getCurrentSession();
		String hql1 ="FROM TheLuot where thoiGianVao = (select max(thoiGianVao) from TheLuot where xe = :xe) ";
		Query query = session.createQuery(hql1);
		query.setParameter("xe", xe);
		List<TheLuot> list = query.list();
		return list;
	}
	
	public List<TheLuot> getTheLuotOut(String idThe) {
		Session session = factory.getCurrentSession();
		String hql ="FROM TheLuot where idTheLuot = :idThe) ";
		Query query = session.createQuery(hql);
		query.setParameter("idThe", Integer.parseInt(idThe));
		List<TheLuot> list = query.list();
		return list;
	}
	
	public List<PhiGuiXe> getPhiNgay(Xe xe) {
		Session session = factory.getCurrentSession();
		String hql ="FROM PhiGuiXe where thoiGianThayDoi = (select max(thoiGianThayDoi) from PhiGuiXe where loaiXe = :loaiXe and hinhThuc = :hinhThuc) and loaiXe = :loaiXe and hinhThuc = :hinhThuc";
		Query query = session.createQuery(hql);
		query.setParameter("loaiXe", xe.getLoaiXe());
		query.setParameter("hinhThuc","NGAY");
		List<PhiGuiXe> list = query.list();
		return list;
	}
	
	public List<PhiGuiXe> getPhiDem(Xe xe) {
		Session session = factory.getCurrentSession();
		String hql ="FROM PhiGuiXe where thoiGianThayDoi = (select max(thoiGianThayDoi) from PhiGuiXe where hinhThuc = :hinhThuc and loaiXe = :loaiXe) and loaiXe = :loaiXe and hinhThuc = :hinhThuc";
		Query query = session.createQuery(hql);
		query.setParameter("loaiXe", xe.getLoaiXe());
		query.setParameter("hinhThuc","DEM");
		List<PhiGuiXe> list = query.list();
		return list;
	}
	public List<TheLuot> getTheLuot(int page, int pageSize, String bsx) {
		Session session = factory.getCurrentSession();
		
		String hql;
		Query query;
		List<TheLuot> list;
		if (bsx.length() == 0 )
		{
			hql ="FROM TheLuot t ORDER BY t.idTheLuot DESC";
			query = session.createQuery(hql);
			int offset = page * pageSize;
			list = query.setFirstResult(offset).setMaxResults(pageSize).list();
		} else
		{
			hql ="FROM TheLuot t where t.xe.bienSoXe = :bsx ORDER BY t.idTheLuot DESC";
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
		List<TheLuot> list;
		if (bsx.length() == 0)
		{
			hql = "FROM TheLuot";
			query = session.createQuery(hql);
			list = query.list();
		} else
		{
			hql = "FROM TheLuot t where t.xe.bienSoXe = :bsx";
			query = session.createQuery(hql);
			query.setParameter("bsx", bsx);
			list = query.list();
		}
		
		return list.size();
	}
}
//abstract class AgeComparator implements Comparator<TheLuot> {
//    public int compare(TheLuot a, TheLuot b) {
//    	if (a.getThoiGianRa() == null &&  b.getThoiGianRa() == null) return a.getThoiGianVao().compareTo(a.getThoiGianVao()) < 0;
//    	if (a.getThoiGianRa() != null &&  b.getThoiGianRa() != null) return a.getThoiGianRa().compareTo(a.getThoiGianRa()) < 0;
//    	if (a.getThoiGianRa() == null &&  b.getThoiGianRa() != null) return a.getThoiGianVao().compareTo(a.getThoiGianRa()) < 0;
//    	return a.getThoiGianRa().compareTo(a.getThoiGianVao()) < 0;
//    }
//}