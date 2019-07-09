package net.codejava;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {

	@Autowired
	private StudentService service;
	
	@RequestMapping("/")
	public String viewHomePage(Model m) {
		List<Student> listStudent = service.listAll();
		m.addAttribute("listStudent",listStudent);		
		return "index";
	}
	
	@RequestMapping("/newStudent")
	public String showNewStudentForm(Model m) {
		Student student=new Student();
		student.setEmail("");
		student.setName("");
		student.setAddress("");
		student.setDepartment("");
		m.addAttribute("student",student);
		return "new_Student";
	}
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String saveStudent(@ModelAttribute("student")Student student ) {
		service.save(student);
		
		return "redirect:/";
		
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditStudentForm(@PathVariable(name="id")Long id) {
		ModelAndView mav = new ModelAndView("edit_student");
		Student student = service.get(id);
		mav.addObject("student",student);
		
		return mav;
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteStudent(@PathVariable(name="id")Long id) {
		
		service.delete(id);
		return "/redirect:/";
		
	}
	  @RequestMapping("/department/{departmentname}")  
	    public String list(@PathVariable String departmentname,Model m){  
	        //List<Emp> list=dao.getEmployees(); 
	       List<Student> b= service.listAll();
	       List<Student> c=new ArrayList<Student>();
	    	for(int i=0;i<b.size();i++) {
	    		if(b.get(i).getDepartment().equals(departmentname)) {
	    			Student student=b.get(i);
	    			c.add(student);
	    		}
	    	}
	        m.addAttribute("department",c);
	        return "department";  
	    } 
	  
		@RequestMapping("/login")
		public String login(HttpServletRequest request) {
			request.setAttribute("mode", "MODE_LOGIN");
			return "login";		
		}
		@RequestMapping("/login-user")
		public String loginUser(@ModelAttribute Student student,HttpServletRequest request,Model m) {
			  List<Student> b= service.listAll();
			  /*    boolean k=false;
			   for(int i=0;i<b.size();i++) {
					if(student.getName().equals(b.get(i).getName()) && student.getPassword().equals(b.get(i).getPassword())) {
						k=true;
					}
			   }
			   if(k) {
				   return "index";	 
			   }else {
				   return "login";
			   }*/
				m.addAttribute("listStudent",b);
			  return "index";	 
		}
}
