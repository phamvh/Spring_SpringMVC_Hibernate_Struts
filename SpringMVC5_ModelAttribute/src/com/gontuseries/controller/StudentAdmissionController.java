package com.gontuseries.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
  * Compared this same example in the previous tutorial, this one adds an object of a Model class,
  * instead of type String. Therefore, in the JSP view, we can access this by:
  *    ${stud.studentName}
  *    ${stud.studentMajor}
  */
 @RequestMapping(value="/submitInfo", method=RequestMethod.POST)
 public ModelAndView submitInfo(@RequestParam("studentName") String name,
		                        @RequestParam(value = "studentMajor", defaultValue="General Major") String major){
	 ModelAndView mv = new ModelAndView("AdmissionSuccess");
	 
	 Student student = new Student();
	 student.setStudentName(name);
	 student.setStudentMajor(major);
	 
	 mv.addObject("stud",student);
	 return mv;
 }
 
 /**
  * Doing the same thing compared to the above method.
  * However, this one uses Model Attribute, which is much shorter and cleaner.
  * The names of the properties of the Student class HAVE to match the names of the inputs in the html form.
  * Spring automatically matches and assigns the input params to the properties of Student class.
  * It also automatically adds this instance to the ModelAndView as if we would have done manually 
  * like this: mv.addObject("stud", student) -->> This step is no longer needed when using model attribute.
  * 
  * Quote from spring documentation: 
  *   An @ModelAttribute on a method argument indicates the argument should be retrieved from the model. 
  *   If not present in the model, the argument should be instantiated first and then added to the model. 
  *   Once present in the model, the argument’s fields should be populated from all request parameters 
  *   that have matching names. This is known as data binding in Spring MVC, a very useful mechanism 
  *   that saves you from having to parse each form field individually.
  * 
  */
 @RequestMapping(value="/submitInfoUsingModelAttribute", method=RequestMethod.POST)
 public ModelAndView submitInfoUsingModelAttribute(@ModelAttribute("stud") Student student){
	 ModelAndView mv = new ModelAndView("AdmissionSuccess");
	 return mv;
 }
 
 /**
  * Pay attention to this method's syntax. @ModelAttribute is used for method, NOT for method's argument.
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






































