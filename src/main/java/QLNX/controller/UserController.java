package QLNX.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import entity.TaiKhoan;

@Transactional
@Controller
public class UserController {
	
	@Autowired
	SessionFactory factory;
	
	@RequestMapping("/login")
	public String login(ModelMap model ,HttpServletRequest request) {
		String username = request.getParameter("username");
		String password =	request.getParameter("password");
		return "index";
	}
	
	@RequestMapping("/thongke")
	public String thongKe(ModelMap model) {
		List<TaiKhoan> accounts = this.getTaiKhoan();
		model.addAttribute("accounts",accounts);
		
		return "thongketk";
	}
	public List<TaiKhoan> getTaiKhoan() {
		Session session = factory.getCurrentSession();
		String hql ="FROM TaiKhoan";
		Query query = session.createQuery(hql);
		List<TaiKhoan> list = query.list();
		
		return list;
	}
	
}
