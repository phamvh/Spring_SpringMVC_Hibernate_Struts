package com.tutorialspoint;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentController {
	   
	  @RequestMapping(value = "/student", method = RequestMethod.GET)
	   public ModelAndView student() {
	      return new ModelAndView("student", "command", new Student());
	   }
	  
	  @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
	  /**
	   * Here you need to annotate a service method using @ExceptionHandler 
	   * where you can specify one or more exceptions to be handled. 
	   * If you are specifying more than one exceptions then you can use comma separated values.
	   * 
	   * The @ExceptionHandler annotation here is somehow similar to the declaration syntax
	   *      throws NameException, AgeException
	   * in a method, before braces {}. When an exception happens, spring will catch it.
	   * 
	   * See other necessary configuration in the xml file for exceptions.
	   */
	  @ExceptionHandler({NameException.class, AgeException.class})
	  public String addStudent(@ModelAttribute("stud") Student student, ModelMap model){
		  if(student.getName().length() < 5){
			  throw new NameException("Name is too short");
		  }else{
			  model.addAttribute("name", student.getName());
		  }
		  
		  if( student.getAge() < 10 ){
		         throw new AgeException("Given age is too low");
		  }else{
		       model.addAttribute("age", student.getAge());
		  }
		      
		  model.addAttribute("id", student.getId());
		      return "result";
	  }
	  
	 

}
