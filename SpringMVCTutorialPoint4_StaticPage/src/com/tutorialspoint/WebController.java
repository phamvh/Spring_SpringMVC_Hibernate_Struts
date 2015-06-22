package com.tutorialspoint;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WebController {
	   @RequestMapping(value = "/index", method = RequestMethod.GET)
	   public String index() {
		   return "index";
	   }
	   
	   @RequestMapping(value="/staticPage", method= RequestMethod.GET)
	   public String redirect(){
		   /*
		    * Note how the format is written for a redirection to a static page.
		    * If this is a redirection to a logical, it would be simple, without the back slash, like this: 
		    *       "redirect:finalPage"
		    * Here, it includes the full path to a static page. Prefix and suffix in xml files are only for
		    * dynamic, thus they are not considered here.
		    * 
		    * Note that  <mvc:resources>  and mvc namespace must be added to xml file for this static redirection
		    * to work. Check out the xml file for details.
		    */
		   return "redirect:/pages/final.html";
	   }

}
