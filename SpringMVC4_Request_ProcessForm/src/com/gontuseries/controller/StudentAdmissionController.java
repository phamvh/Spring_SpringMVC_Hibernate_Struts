package com.gontuseries.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
  * This handles data that is sent to /submitInfo as POST request.
  * It retrieves the form data (using syntax 
  *      @RequestParam("student_name") String name
  * Sometimes, if a param is missing from the sent data, we can set a default value as follows:
  *      @RequestParam(value = "student_major", defaultValue="General Major") String major
  *
  *Note that if there are A LOT of params, we can use map - the same way as in the previous tutorial:
  *      submitInfo(@RequestParam Map<String, String> requestParams){...}
  *        Key is param name, and Value if the value of the param.
  */
 @RequestMapping(value="/submitInfo", method=RequestMethod.POST)
 public ModelAndView submitInfo(@RequestParam("student_name") String name,
		                        @RequestParam(value = "student_major", defaultValue="General Major") String major){
	 ModelAndView mv = new ModelAndView("AdmissionSuccess");
	 mv.addObject("info", "Hello! " + name+", you have been admitted to major "+major+"!");
	 return mv;
 }
}






































