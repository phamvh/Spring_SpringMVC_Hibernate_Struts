package com.tutorialspoint;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 *  This is a controller advice class, annotated with @ControllerAdvice.
 *  It can have the same exception handler methods as in StudentController.
 *  The only difference is that the exception handler method in this class applies to ALL
 *  controllers of the application, while the exception handler methods inside StudentController only
 *  apply to that controller.
 *
 */
@ControllerAdvice
public class ControllerAdviceForCity {
	  @ExceptionHandler(CityException.class)
	  public ModelAndView handleCityException(CityException ex){
		  ModelAndView mv = new ModelAndView("cityError");
		  mv.addObject("exceptionMsg", "@ControllerAdvice from ControllerAdviceForCity: "+ex.getExceptionMsg());
		  return mv;
	  }
}
