package QLNX.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import QLNX.entity.TaiKhoan;

@Transactional
@Controller
public class UserController {
	
	@Autowired
	SessionFactory factory;
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String showLoginForm() {
        return "login";
    }
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String login(ModelMap model ,HttpServletRequest request,HttpSession session) {
		String username = request.getParameter("username");
		String password =	request.getParameter("password");
		int check = isValidUser(username, password);
		if ( check == 1) {
            session.setAttribute("username", username);
            return "redirect:/home.htm";
        } else {
        	if(check == 0) {
        		model.addAttribute("error","Tài khoản không tồn tại!");
        		return "login";
        	} else {
        		model.addAttribute("error","Mật khẩu không chính xác!");
        		return "login";
        	}
        }
	}
	@RequestMapping(value="/home", method = RequestMethod.GET)
    public String home(HttpSession session) {
        // Kiểm tra xem người dùng đã đăng nhập chưa
        if (session.getAttribute("username") != null) {
            return "home";
        } else {
            return "redirect:/login.htm";
        }
    }
	@RequestMapping(value="/logout",method = RequestMethod.GET)
    public String logout(HttpSession session) {
        // Xóa thông tin người dùng khỏi phiên làm việc và kết thúc phiên
        session.removeAttribute("username");
        session.invalidate();
        return "redirect:/login.htm";
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
	public List<TaiKhoan> searchTK(String username) {
		Session session = factory.getCurrentSession();
		String hql ="FROM TaiKhoan where username = :username";
		Query query = session.createQuery(hql);
		query.setParameter("username", username);
		List<TaiKhoan> list = query.list();
		
		return list;
	}
	private int isValidUser(String username, String password) {
		List<TaiKhoan> check = this.searchTK(username);
		if(check.size() == 0) {
	        return 0;
		} else if (password.equals(check.get(0).getPassword())) {
			return 1;
		} else {
	        return 2;
		}
    }
}
