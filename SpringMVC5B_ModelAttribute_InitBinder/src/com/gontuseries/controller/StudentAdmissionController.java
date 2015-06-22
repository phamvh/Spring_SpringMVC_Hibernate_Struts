package com.gontuseries.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gontuseries.model.CustomNameEditor;
import com.gontuseries.model.Student;

@Controller
public class StudentAdmissionController {
 
 @RequestMapping(value="/admission", method=RequestMethod.GET)	
 public ModelAndView getAdmissionForm(){
	 ModelAndView mv = new ModelAndView("AdmissionForm");
	 return mv;
 }
 
 /**
  * In short, this method gets called before any request gets processed.
  * It tells spring what fields to process, and how to process each field.
  * Below is the quote from javadoc of @InitBinder.
  * 
 * Annotation @InitBinder identifies methods which initialize the
 * {@link org.springframework.web.bind.WebDataBinder} which
 * will be used for populating command and form object arguments
 * of annotated handler methods.
 * 
 * This method can have any name, which does not matter. The annotation is the only thing important.
 *
  */
 @InitBinder
 public void initBinder(WebDataBinder binder){
	 /**
	  * This will tell spring not to bind the given field ("studentPhone") to the student object
	  * when @ModelAttribute is used as in method submitInfoUsingModelAttribute().
	  */
	 binder.setDisallowedFields(new String[] {"studentPhone"});
	 
	 /**
	  * This specifies a requirement for the format for the field "studentDOB" that is of type Date.
	  * For any other format rather than "yyyy-mm-dd", spring will say error, which is added to BindingResult
	  */
	 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
	 binder.registerCustomEditor(Date.class, "studentDOB", new CustomDateEditor(dateFormat, false));
	 
	 /**
	  * This shows an example of a customized class that I created by myself. Check CustomNameEditor class for info.
	  * This simply checks the input string if it has gender information. If not, add "Ms." to it.
	  * The first argument of registerCustomEditor is the actual TYPE of the PROPERTY of the model class.
	  */
	 binder.registerCustomEditor(String.class, "studentName", new CustomNameEditor());
 }
 
 /**
  See previous tutorial for comments about this method.
  * 
  */
 @RequestMapping(value="/submitInfoUsingModelAttribute", method=RequestMethod.POST)
 public ModelAndView submitInfoUsingModelAttribute(@ModelAttribute("stud") Student student,
		 											BindingResult result){
	 
	 if(result.hasErrors()){
		 ModelAndView form = new ModelAndView("AdmissionForm");
		 return form;
	 }
	 
	 ModelAndView mv = new ModelAndView("AdmissionSuccess");
	 return mv;
 }
 
 /**
 See previous tutorial for comments about this method.
 * 
 */
 @ModelAttribute
 public void addCommonObjectsToAllModelsOfThisController(Model model){
	 model.addAttribute("welcomeMessage", "Hello! Welcome to USC!");
 }
}






































