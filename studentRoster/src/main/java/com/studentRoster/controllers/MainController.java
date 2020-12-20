package com.studentRoster.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.studentRoster.models.Contact;
import com.studentRoster.models.Dorm;
import com.studentRoster.models.Student;
import com.studentRoster.services.ContactService;
import com.studentRoster.services.DormService;
import com.studentRoster.services.StudentService;

@Controller
public class MainController {
	//dependency injection
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private ContactService contactService;
	
	@Autowired
	private DormService dormService;
	
	//ROUTES
	@GetMapping("/")
	public String index() {
		return "redirect:/dashboard";
	}
	
	//DISPLAYS
	//display dashboard
	@GetMapping("/dashboard")
	public String dashboard(Model viewModel) {//need model to display to frontend from DB
		List<Student> allStudents = this.studentService.getAllStudents();//store everything in a list
		viewModel.addAttribute("allStudents", allStudents);
		
		List<Dorm> allDorms = this.dormService.getAllDorms();//store everything in a list
		viewModel.addAttribute("allDorms", allDorms);
		
		return "dashboard.jsp";
	}

	//display add a new student
	@GetMapping("/students/new")
	public String newStudent(@ModelAttribute("student") Student student, Model viewModel) {//need model to display to frontend from DB
		
		return "addStudent.jsp";
	}

	//display create a contact form
	@GetMapping("/contacts/new")
	public String newContact(@ModelAttribute("contact") Contact contact, Model viewModel) {//need model to display to frontend from DB
		List<Student> allStudents = this.studentService.getAllStudents();//store everything in a list
		viewModel.addAttribute("allStudents", allStudents);

		return "addContact.jsp";
	}

	//display create a dorm form
	//	Have a method handler in the controller for the following example url: /dorms/create?name=Manza. 
	@GetMapping("/dorms/create")
	public String newDorm(@ModelAttribute("dorm") Dorm dorm) {
		
		return "addDorm.jsp";
	}

	//display specific dorm
	//Have a method handler in the controller for the following example url: /dorms/1. Display all the students that belong to the dorm with id 1. This method should work with any dorm as well.
	@GetMapping("/dorms/{id}")
	public String newStudent(Model viewModel, @PathVariable("id") Long id) {//need model to display to frontend from DB
		//in order to grab the list of Students:	
		List<Student> allStudents = this.studentService.getAllStudents();//store everything in a list
		viewModel.addAttribute("allStudents", allStudents);

		Dorm showDorm = this.dormService.getSingleDorm(id);
		viewModel.addAttribute("dorm", showDorm);
		
		return "showDorm.jsp";
	}
	

	

	//POST MAPPING	
	//Create new student
	//Have a method handler in the controller for the following example url: /students/create?firstName=John&lastName=Doe&age=35
	@PostMapping("/students/create")
	public String addStudent(@Valid @ModelAttribute("student") Student student, BindingResult result) {
	     if(result.hasErrors()) {
	         return "addStudent.jsp";//re-render the page if there are errors
	     }    
	     
	    this.studentService.createStudent(student);
	    
	    return "redirect:/dashboard";
	}
	
	//Create new contact
	//Have a method handler in the controller for the following example url: /contacts/create?student=1&address=1234%20Some%20Street&city=Los%20Angeles&state=CA. The student query parameter should be the id of the student in the database. Create the contact info for the students from the previous task. (%20 is the encoding for SPACE in query parameters)
	@PostMapping("/contacts/create")
	public String addContact(@Valid @ModelAttribute("contact") Contact contact, BindingResult result) {
	     if(result.hasErrors()) {
	         return "addContact.jsp";//re-render the page if there are errors
	     }    
	     
	    this.contactService.createContact(contact);
	    
	    return "redirect:/dashboard";
	}

	//create a new dorm
	@PostMapping("/dorms/create")
	public String addDorm(@RequestParam(value="name", required=false) String name) {
		Dorm newDorm = new Dorm();
		newDorm.setName(name);

		this.dormService.createDorm(newDorm);
		
		return "redirect:/dashboard";
	}

	//add student to dorm
	//	Have a method handler in the controller for the following example url: /dorms/3/add?student=1. This method should add student with id 1 to the dorm with id 3. Add multiple student to different dormitories.
	@PostMapping("/dorms/{dorm_id}/add")
	public String addStudentToDorm(@PathVariable("dorm_id") Long dorm_id, @RequestParam(value="student", required=false) Long student_id) {
		Student student = this.studentService.getSingleStudent(student_id);
		Dorm dorm = this.dormService.getSingleDorm(dorm_id);
		
		student.setDorm(dorm);
	     
	    this.studentService.updateStudent(student);
	    
	    return "redirect:/dashboard";
	}



	//DELETIONS
	//delete entire student
	@GetMapping("/delete/{id}")
	public String deleteStudent(@PathVariable("id") Long id) {
		this.studentService.deleteStudent(id);
		
		return "redirect:/dashboard";
	}

	//delete entire dorm - note only works if dorm has no students assigned to it
	@GetMapping("/deleteDorm/{id}")
	public String deleteDorm(@PathVariable("id") Long id) {
		this.dormService.deleteDorm(id);
		
		return "redirect:/dashboard";
	}
	


	//UPDATES
	//remove dorm from student
	//	Have a method handler in the controller for the following example url: /dorms/3/remove?student=1. This method should remove student with id 1 from the dorm with id 3. Remove multiple students from a single dormitory.
	@GetMapping("/dorms/{dorm_id}/remove")
	public String removeStudentromDorm(@PathVariable("dorm_id") Long dorm_id, @RequestParam(value="student", required=false) Long student_id) {
		Student student = this.studentService.getSingleStudent(student_id);
//		Dorm dorm = this.dormService.getSingleDorm(dorm_id); //not used
		
		student.setDorm(null);
	     
	    this.studentService.updateStudent(student);
	    
	    return "redirect:/dashboard";
	}

}
