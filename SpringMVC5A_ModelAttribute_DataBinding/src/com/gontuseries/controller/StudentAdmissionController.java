package com.gontuseries.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gontuseries.model.Student;

@Controller
public class StudentAdmissionController {
 /**
  * This simply redirects the /admission to the AdmissionForm.jsp located inside WEB-INF	
  * @return
  */
 @RequestMapping(value="/admission", method=RequestMethod.GET)	
 public ModelAndView getAdmissionForm(){
	 ModelAndView mv = new ModelAndView("AdmissionForm");
	 return mv;
 }
 
 
 /**
  * DATA BINDING!
  * 
  * This is practically the same as in the previous tutorial. However, the Student class
  * has more fields of different types now: Long, Date, ArrayList<String>.
  * Spring can still capture all those and automatically bind the input params to
  * the properties of the Student class. Check the Student class to see the new properties.
  * 
  * Also, BindingResult is added to handle errors in the form. See the comment inside the method.
  * 
  * The Errors or BindingResult parameters have to follow the model object that is being 
  * bound immediately as the method signature might have more that one model object and 
  * Spring will create a separate BindingResult instance for each of them so the following sample won’t work:
  * 
  * See: http://docs.spring.io/spring/docs/current/spring-framework-reference/html/mvc.html#mvc-ann-arguments
  * 
  */
 @RequestMapping(value="/submitInfoUsingModelAttribute", method=RequestMethod.POST)
 public ModelAndView submitInfoUsingModelAttribute(@ModelAttribute("stud") Student student,
		 											BindingResult result){
	 /**
	  * If there is an error in the filled form (such as casting "abc" to a number, spring
	  * will add an error to BindingResult. In this case, we just return the original form as a view.
	  * If we want to display the error in the page, add the following to the AdmissionForm.jsp:
	  * 
	  *       <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	  *       <form:errors path="stud.*"/>  
	  */
	 if(result.hasErrors()){
		 ModelAndView form = new ModelAndView("AdmissionForm");
		 return form;
	 }
	 
	 ModelAndView mv = new ModelAndView("AdmissionSuccess");
	 return mv;
 }
 
 /**
  * Pay attention to this method.
  * This is just an arbitrary method. However, it as an annotation @ModelAttribute.
  * This annotation tells spring to run this method before any method of this controller.
  * As a result, "welcomeMessage" is added to all the ModelAndView in all the methods for any requests
  * of this controller. Therefore, we can use this object (attribute) in any jsp page that methods of this
  * controller redirect to.
  * Check the AdmissionSuccess.jsp for details.
  */
 @ModelAttribute
 public void addCommonObjectsToAllModelsOfThisController(Model model){
	 model.addAttribute("welcomeMessage", "Hello! Welcome to USC!");
 }
}






































