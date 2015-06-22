package com.tutorialspoint;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentController {
	   
	  @RequestMapping(value = "/student", method = RequestMethod.GET)
	   public ModelAndView student() {
	      return new ModelAndView("student", "command", new Student());
	   }
	  
	  /**
	   * This method only throws out exception, but it does not specify any exception handler in its annotation.
	   * However, there are other methods that are declared with annotation @ExceptionHandler for each 
	   * type of exception (see method handleNameException(NameException ex)). Due to this annotation, 
	   * whenever an exception is thrown out in ANY controller method (methods annotate with  @RequestMapping) 
	   * of this Controller, spring will pick a method annotated with @ExceptionHandler, which has the 
	   * exception type that matches the type of the thrown exception, and 
	   * delegates the work to that method.
	   * 
	   * Note that four types of exceptions are handled DIFFERENLY:
	   *    1- NameException - just a standard way to return a ModelAndView
	   *    2- AgeException - no handler method provided, but the class AgeException has @ResponseStatus (class level).
	   *    3- IdException  - there is a handler, but it returns void, and it has @ResponseStatus (method level).
	   *    4- CityException - @ControllerAdvice annotation, which has effect on ALL controllers, not just in this StudentController.
	   */
	  @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
	  public String addStudent(@ModelAttribute("stud") Student student, ModelMap model){
		  if(student.getName().length() < 5){
			  throw new NameException("Name is too short");
		  }else{
			  model.addAttribute("name", student.getName());
		  }
		  
		  if( student.getAge() < 5 ){
		         throw new AgeException("Given age is too low");
		  }else{
		       model.addAttribute("age", student.getAge());
		  }
		  
		  if(student.getId() <= 5){
			  throw new IdException("ID is too small.");
		  }else{
			  model.addAttribute("id", student.getId());
		  }
		      
		  if(student.getCity().length() < 5){
			  throw new CityException("City name is too short");
		  }else{
			  model.addAttribute("city", student.getCity());
		  }
		  
		  model.addAttribute("id", student.getId());
		      return "result";
	  }
	  
	  /**
	   * This is an exception handler method. Whenever a NameException is thrown out from a @RequestMapping method
	   * in this controller, this method will be called. It catches the exception via the argument, and create 
	   * a separate ModelAndView to handle this exception.
	   * 
	   * Important Note: the Model may not be a parameter of any @ExceptionHandler method
	   */
	  
	  @ExceptionHandler(NameException.class)
	  public ModelAndView handleNameException(NameException ex){
		  ModelAndView mv = new ModelAndView("nameError");
		  mv.addObject("exceptionMsg", ex.getExceptionMsg());
		  return mv;
	  }
	  
	  /**
       *  COMMENT this out so that there is NO handler for AgeException.
       *  Since AgeException class has an annotation
       *       @ResponseStatus(value= HttpStatus.NOT_FOUND, reason="You're too young, baby")
       *  and there is NO handler for it, which will result in a response 404 with message
       *       "You're too young, baby".
       *  Check out class AgeException for the annotation.
	   */
	  /*
	  @ExceptionHandler(AgeException.class)
	  public ModelAndView handleAgeException(AgeException ex){
		  ModelAndView mv = new ModelAndView("ageError");
		  mv.addObject("exceptionMsg", ex.getExceptionMsg());
		  return mv;
	  }
	  */
	  /**
	   * Since the method returns void, the @ResponseStatus will cause spring to return a standard
	   * 404 (HttpStatus.NOT_FOUND) response with message "You have no ID, babe. Get out of here."
	   * Do this, for example, when you don't have access to change class IdException (third party lib).
	   */
	  @ResponseStatus(value= HttpStatus.NOT_FOUND, reason="You have no ID, babe. Get out of here.")
	  @ExceptionHandler(IdException.class)
	  public void handleIdException(IdException ex){
		 //Do NOTHING in here.
	  }
	  
	  /**
	   *  Commented out and moved to the ControllerAdviceForCity class, which is a @ControllerAdvice class.
	   *  Check it out. Because it is a @ControllerAdvice, it applies to ALL controllers of the app GLOBALLY.
	   */
	  /*
	  @ExceptionHandler(CityException.class)
	  public ModelAndView handleCityException(CityException ex){
		  ModelAndView mv = new ModelAndView("cityError");
		  mv.addObject("exceptionMsg", ex.getExceptionMsg());
		  return mv;
	  }
	  */
	 

}
