package com.gontuseries.hellocontroller;



import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
public class HelloController {
	/**
	 * Path vars are put in braces, such as {country}. They can be accessed inside the method by 
	 * declaring the variable in the argument as follows:
	 *    function(@PathVariable("country") String str)
	 * The argument str will hold the value of {country}. 
	 * 
	 * Or if the URI template variable name matches the method argument name you can omit that detail.
	 * For example, we can define method as follows: 
	 * 
	 *    ModelAndView welcomeController(@PathVariable String username, @PathVariable String country)
	 *   
	 * This still works, because the names of the path variables match the names of the arguments, and
	 * spring bind them automatically.
	 * 
	 * Note that Path variables can also come from the annotation at the class level, and they are
	 * accessible at the method level. Example, we can move @RequestMapping("/welcome/{country}) to the
	 * class level, and only leave @RequestMapping("/{username}") at this method, we can still have access
	 * to {country} here.
	 * 
	 * We can also specify regular expression here as well. See:
	 *   http://docs.spring.io/spring/docs/current/spring-framework-reference/html/mvc.html#mvc-ann-requestmapping-uri-templates-regex
	 */
    @RequestMapping("/welcome/{country}/{username}")
	public ModelAndView welcomeController(@PathVariable("username") String user, @PathVariable("country") String country){
	
		ModelAndView modelAndView = new ModelAndView("HelloPage");
		modelAndView.addObject("welcomeMessage","Welcome "+user+" from "+country+", to Spring MVC.");
		
		return modelAndView;
	}
  
    /**
     * Another method. In this case, we can use a Map to retrieve all the path variables.
	 * This method is much easier and neater.
	 * 
	 * However, note that for this Map type of @PathVariable to work, we need to add and declare several things in the
	 * xml file:
	 *   1)  Add to namespace: xmlns:mvc="http://www.springframework.org/schema/mvc
	 *   2)  Add to schemaLocation: 
	 *        http://www.springframework.org/schema/mvc 
   			  http://www.springframework.org/schema/mvc/spring-mvc.xsd 
	 *   3) Add this tag to the xml body:
	 *        <mvc:annotation-driven/>   
	 *        
	 *   See the xml file for details.     
     */
    @RequestMapping("/hi/{country}/{username}")
 	public ModelAndView hiController(@PathVariable Map<String, String> pathVars){
 		String user = pathVars.get("username");
 		String country = pathVars.get("country");
		ModelAndView modelAndView = new ModelAndView("HelloPage");
		modelAndView.addObject("welcomeMessage","Hi "+user+" from "+country+", to Spring MVC.");
		
		return modelAndView;
 	}
}
