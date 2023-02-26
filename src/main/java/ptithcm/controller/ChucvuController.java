package ptithcm.controller;

import java.math.BigDecimal;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import ptithcm.bean.Student;
import entity.ChucVuEntity;


@Controller
@RequestMapping("/nhanvien/")
public class ChucvuController {
    @Autowired
    SessionFactory factory;
//	@RequestMapping("query")
//	public String query(ModelMap model) {
//		Session session = factory.getCurrentSession();
//		String hql = "";
//		Query query = session.createQuery(hql);
//		List<Nhanvien> list = query.list();
//		return "student2";
//	}


	@RequestMapping("index")
	public String excute(ModelMap model) throws Exception {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			 ChucVuEntity cv = new ChucVuEntity("TRUC4", "TRUC", 0, "FULLTIME", new BigDecimal(Double.toString(12333)));
		     session.save(cv);
			 tx.commit();
		 }
		 catch (Exception e) {
		     if (tx!=null) tx.rollback();
		     throw e;
		 }
		 finally {
			 session.close();
		 }
	    Student student = new Student("Nguyễn Văn Tèo", 9.5, "WEB");
		model.addAttribute("student", student);
		System.out.println("student/index");
		return "student2";
	}

}