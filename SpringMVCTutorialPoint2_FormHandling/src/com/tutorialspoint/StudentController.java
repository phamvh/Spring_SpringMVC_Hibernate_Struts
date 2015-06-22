package com.tutorialspoint;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentController {
	@RequestMapping(value="/student", method=RequestMethod.GET)
	public ModelAndView student(){
		/**
		 * Here the first service method student(), we have passed a blank Student object 
		 * in the ModelAndView object with name "command" because the spring framework expects 
		 * an object with name "command" if you are using <form:form> tags in your JSP file. 
		 * So when student() method is called it returns student.jsp view.
		 * 
		 * "student" =  view's name, "command" = model object's name , and corresponding model object's value.
		 */
		return new ModelAndView("student", "command", new Student());
	}
	
	/**
	 * 
		Second service method addStudent() will be called against a POST method 
		on the HelloWeb/addStudent URL. You will prepare your model object based 
		on the submitted information. Finally a "result" view will be returned 
		from the service method, which will result in rendering result.jsp
		
		NOTE!: @ModelAttribute An @ModelAttribute on a method argument indicates 
		the argument should be retrieved from the model. If not present in the model, 
		the argument should be instantiated first and then added to the model. 
		Once present in the model, the argument’s fields should be populated from 
		all request parameters that have matching names. This is known as data binding 
		in Spring MVC, a very useful mechanism that saves you from having to parse
		each form field individually.
		
		"SpringWeb" is a name given to the model object. It can be anything. If a model
		object with that name is found in the model, it will be retrieved, and its fields
		will be populated with input params. Otherwise, it will be created. In either case, the 
		object is assigned to the {Student student} object - the argument next to it in the method.
		
		 JSPs can access
		this object using this name later.
	 */
	@RequestMapping(value="/addStudent", method=RequestMethod.POST)
	public String addStudent(@ModelAttribute("SpringWeb") Student student, ModelMap model){
		
		  /**
		   * This code below from the tutorial is redundant, thus commented out. A model object of type Student, 
		   * named SpringWeb, will be accessible automatically to the result.jsp, through ${SpringWeb.name},
             ${SpringWeb.age}, etc.
		   */
	      /*model.addAttribute("name", student.getName());
	      model.addAttribute("age", student.getAge());
	      model.addAttribute("id", student.getId());*/
	      
	      return "result"; //name of the view
	}
}
