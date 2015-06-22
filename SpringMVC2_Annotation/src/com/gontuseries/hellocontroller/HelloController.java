package com.gontuseries.hellocontroller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * This annotation tells spring that this is a controller.
 * A tag in the xml file tells spring to scan a given package for all classes with this annotations
 * and make them as controllers - store in memory.
 * 
 *    <context:component-scan base-package="com.gontuseries.hellocontroller"></context:component-scan>
 *
 */
@Controller
/**
 * This is the class level uri. Without this, you could call the welcome page by
 *     http://localhost:8080/SpringMVC2_Annotation/welcome
 * However, if this  @RequestMapping("/greet") is present at the class level, then one needs to call 
 * the welcome page by
 *     http://localhost:8080/SpringMVC2_Annotation/greet/welcome   
 *  Note that "/greet" is added in the URL   
 */
@RequestMapping("/greet")
public class HelloController {
    @RequestMapping("/welcome")
	public ModelAndView welcomeController(){
		
		/**
		 * "HelloPage" is the name of the view to render. Assume the prefix is "WEB-INF", 
		 * and suffix is ".jsp" (See spring-dispatcher-servlet.xml), then spring will find the view
		 * with uri "WEB-INF/HelloPage.jsp".
		 */
		ModelAndView modelAndView = new ModelAndView("HelloPage");
		modelAndView.addObject("welcomeMessage","Welcome, Spring MVC.");
		
		return modelAndView;
	}
    
    /**
     * Just another method to demonstrate one controller with many actions.
     * @return
     */
    @RequestMapping("/hi")
 	public ModelAndView hiController(){
 		
 		/**
 		 * "HelloPage" is the name of the view to render. Assume the prefix is "WEB-INF", 
 		 * and suffix is ".jsp" (See spring-dispatcher-servlet.xml), then spring will find the view
 		 * with uri "WEB-INF/HelloPage.jsp".
 		 */
 		ModelAndView modelAndView = new ModelAndView("HelloPage");
 		modelAndView.addObject("welcomeMessage","Hi, Spring MVC.");
 		
 		return modelAndView;
 	}
}
