package QLNX.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import ptithcm.bean.Major;
import ptithcm.bean.Student;

@Controller
@RequestMapping("/student/")
public class StudentController {
	@RequestMapping("index")
	public String index(ModelMap model) {
		Student student = new Student("Nguyễn Văn Tèo", 9.5, "WEB");
		model.addAttribute("student", student);
		System.out.println("student/index");
		return "student2";
	}

//	@ModelAttribute("majors")
//	public Map<String, String> getMajors(){
//		Map<String , String> mj = new HashMap<>();
//		mj.put("IT", "Information Techology");
//		mj.put("ML", "Multi Media");
//		mj.put("IOS", "IOS");
//		return mj;
//	}
	@ModelAttribute("majors")
	public List<Major> getMajors() {
		List<Major> majors = new ArrayList<Major>();
		majors.add(new Major("APP", "Ứng dụng phần mềm"));
		majors.add(new Major("ML", " Multi Media"));
		return majors;
	}

}