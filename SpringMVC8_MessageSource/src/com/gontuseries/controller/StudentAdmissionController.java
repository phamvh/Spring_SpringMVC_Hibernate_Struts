package com.gontuseries.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.validation.Valid;

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
 See comment about this method from the previous tutorial.
  */
 @InitBinder
 public void initBinder(WebDataBinder binder){
	
	 binder.setDisallowedFields(new String[] {"studentPhone"});
	 
	 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
	 binder.registerCustomEditor(Date.class, "studentDOB", new CustomDateEditor(dateFormat, false));
	 
	 binder.registerCustomEditor(String.class, "studentName", new CustomNameEditor());
 }
 
 /**
  See previous tutorial for comments about this method.
  */
 @RequestMapping(value="/submitInfoUsingModelAttribute", method=RequestMethod.POST)
 public ModelAndView submitInfoUsingModelAttribute(@Valid @ModelAttribute("stud") Student student,
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






































