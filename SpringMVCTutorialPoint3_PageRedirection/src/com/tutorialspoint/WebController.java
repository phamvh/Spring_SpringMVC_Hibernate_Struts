package com.tutorialspoint;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WebController {

	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String index(){
		return "index";
	}
	@RequestMapping(value="/redirect", method = RequestMethod.GET)
	public String redirect(){
		/**
		 * Normally, the string here indicates the name of a PHYSICAL URL (a jsp page).
		 * However, the redirect, followed by a colon, tells spring that this is just
		 * a redirection to a LOGICAL URL, for which, spring should find a mathod for it, 
		 * instead of finding a physical jsp page.
		 * 
		 * Without "redirect:", spring will assume there there is a jsp page in WEB-INF/jsp/finalPage.jsp,
		 * and it will return:
		 *      HTTP Status 404 - /SpringMVCTutorialPoint3_PageRedirection/WEB-INF/jsp/finalPage.jsp
		 */
		return "redirect:finalPage";
	}
	@RequestMapping(value = "/finalPage", method = RequestMethod.GET)
	public String finalPage(){
		return "final";
	}
}
