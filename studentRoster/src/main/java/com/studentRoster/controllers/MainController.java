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
import com.studentRoster.models.Student;
import com.studentRoster.services.ContactService;
import com.studentRoster.services.StudentService;

@Controller
public class MainController {
	//dependency injection
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private ContactService contactService;
	
	//ROUTES - same as the APIcontroller
//	@RequestMapping("/", method=RequestMethod.GET)
//	@RequestMapping("/")
	@GetMapping("/")
	public String index() {
		return "redirect:/dashboard";
	}
	
	@GetMapping("/students/new")
	public String newStudent(@ModelAttribute("student") Student student) {//need model to display to frontend from DB
//		List<Student> allDLs = this.DLService.getAllDLs();//store everything in a list
//		viewModel.addAttribute("allDLs", allDLs);
		
		return "add.jsp";
	}
	
	@GetMapping("/contacts/new")
	public String newContact(@ModelAttribute("contact") Contact contact, Model viewModel) {//need model to display to frontend from DB
		List<Student> allStudents = this.studentService.getAllStudents();//store everything in a list
		viewModel.addAttribute("allStudents", allStudents);
		
		return "addContact.jsp";
	}
	
	@GetMapping("/dashboard")
	public String dashboard(Model viewModel) {//need model to display to frontend from DB
		List<Student> allStudents = this.studentService.getAllStudents();//store everything in a list
		viewModel.addAttribute("allStudents", allStudents);
		
		return "dashboard.jsp";
	}
	
	
	//Create new student
	//Have a method handler in the controller for the following example url: /students/create?firstName=John&lastName=Doe&age=35
	@PostMapping("/students/create")
	public String addStudent(@RequestParam(value="firstName", required=false) String firstName, @RequestParam(value="lastName", required=false) String lastName,@RequestParam(value="age", required=false) int age) {
		//the @Valid will check against the validations created in DL.java
		//BindingResult is if something goes wrong in the validation from the DLs, BindingResult will catch it
		// if(result.hasErrors()) {
		// 	return "add.jsp";//re-render the page if there are errors
		// }
		Student newStudent = new Student();
		newStudent.setFirstName(firstName);
		newStudent.setLastName(lastName);
		newStudent.setAge(age);

		this.studentService.createStudent(newStudent);
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

	//delete
	@GetMapping("/delete/{id}")
	public String deleteStudent(@PathVariable("id") Long id) {
		this.studentService.deleteStudent(id);
		
		return "redirect:/dashboard";
	}

	
}
