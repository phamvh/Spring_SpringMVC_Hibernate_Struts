package com.tutorialspoint;

import java.io.UnsupportedEncodingException;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hello")
public class HelloController {
	@RequestMapping(method = RequestMethod.GET)
	public String printHello(ModelMap model){
		model.addAttribute("message","Hello Spring MVC from Tutorial Point.");
		return "hello";
	}
	
	@RequestMapping(value="/respondBody", method = RequestMethod.GET)
	/**
	 * This annotation indicates that the string "This is the body for the response page" is the whole
	 * response body back to the request "/respondBody". This is just a plain text response. No view required.
	 * 
	 * Similarly, one can use different annotations and/or return types to respond, such as:
	 *    HttpEntity (return type)
	 *    void (return type) if there are arguments of types ServletResponse/HttpServletResponse and simply
	 *    write the response to HttpServletResponse as done usually in a servlet.
	 *    
	 *    See documentation: http://docs.spring.io/spring/docs/current/spring-framework-reference/html/mvc.html
	 */
	@ResponseBody
	public String respondBody(ModelMap model){
		
		return "This is the body for the response page";
	}
	
	/**
	 * 
        Another example showing how to use HttpEntity. It is actually nice if you don't need a jsp. 
        But this will mix controller and view, and possibly model. This it is not pure MVC.
	 */
	@RequestMapping("/useHttpEntiry")
	public ResponseEntity<String> handle(HttpEntity<byte[]> requestEntity) throws UnsupportedEncodingException {
		 // do something with request header and body
		/*
	    String requestHeader = requestEntity.getHeaders().getFirst("MyRequestHeader");
	    byte[] requestBody = requestEntity.getBody();
		*/
	   
		//And here is how to make and return a response.
	    HttpHeaders responseHeaders = new HttpHeaders();
	    responseHeaders.set("MyResponseHeader", "MyValue");
	    return new ResponseEntity<String>("Hello World", responseHeaders, HttpStatus.OK);
	}

}
