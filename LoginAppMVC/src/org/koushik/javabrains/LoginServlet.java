package org.koushik.javabrains;

//THIS IS A CONTROLLER

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.koushik.javabrains.dto.User;
import org.koushik.javabrains.service.LoginService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
       
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId, password;
		userId = request.getParameter("userId");
		password = request.getParameter("password");
		
		LoginService loginService = new LoginService();
		boolean result = loginService.authenticate(userId, password);
		
		if(result){
			User user = loginService.getUserDetails(userId);
			//======== odd way via response.sendRedirect
			/**
			 * This is used if we use response.sendRedirect() because we have to store data in the session
			 */
			//request.getSession().setAttribute("user", user);
			/**
			 * This redirection happens on the BROWSER's side (CLIENT's side), which is not always good.
			 */
			//response.sendRedirect("success.jsp");
			
			//=========clever way via dispatcher
			
			/**
			 * Now, if we use dispatcher, then the future jsp/servlet will have the same request and response
			 * So we can store the data in the request itself and no need to store data in the session
			 */
			request.setAttribute("user", user);
			
			
			
			/**
			 * This redirection happens on the SERVER's side
			 * This causes the future jsp/servlet to have the same request/response as the ones of the original servlet
			 */
			RequestDispatcher dispatcher = request.getRequestDispatcher("success.jsp");
			dispatcher.forward(request, response);
			
			return;
		}else{
			response.sendRedirect("login.jsp");
			return;
		}
	}

}









