package com.gontuseries.hellocontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;


/**
 * This is a controller. It is because it extends AbstractController.
 * An instance of this controller is created because it is defined in the xml file as follows:
 *     <bean name="/welcome" class = "com.gontuseries.hellocontroller.HelloController"/>
 * When "/welcome" is requested, spring maps it to this controller, and executes method handleRequestInternal.
 * 
 *
 */
public class HelloController extends AbstractController{

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		
		/**
		 * "HelloPage" is the name of the view to render. Assume the prefix is "WEB-INF", 
		 * and suffix is ".jsp" (See spring-dispatcher-servlet.xml), then spring will find the view
		 * with uri "WEB-INF/HelloPage.jsp".
		 */
		ModelAndView modelAndView = new ModelAndView("HelloPage");
		modelAndView.addObject("welcomeMessage","Hi there. Welcome to Spring MVC.");
		
		
		
		return modelAndView;
	}

}
