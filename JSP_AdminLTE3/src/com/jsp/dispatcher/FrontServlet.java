package com.jsp.dispatcher;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.action.Action;
import com.jsp.dispatcher.ViewResolver;
import com.jsp.dto.MemberVO;
import com.jsp.exception.InvalidPasswordException;
import com.jsp.exception.NotFoundIDException;
import com.jsp.service.MemberService;
import com.jsp.service.MemberServiceImpl;



public class FrontServlet extends HttpServlet {

   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestPro(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		requestPro(request, response);
	}


	private void requestPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
			String command = request.getRequestURI(); //contextPath 포함.
			
			if(command.indexOf(request.getContextPath())==0) {
				command = command.substring(request.getContextPath().length());
			}
			
			Action act = null;
			String view = null;
			
			act = HandlerMapper.getAction(command);
			
			if(act==null) {
				System.out.println("!! not found : " + command);
			}else {
				view=act.execute(request, response);
				
				if(view != null)
					ViewResolver.view(request, response, view);
			}
	}
}
