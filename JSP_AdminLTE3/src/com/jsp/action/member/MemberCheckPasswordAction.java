package com.jsp.action.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.action.Action;
import com.jsp.dto.MemberVO;
import com.jsp.service.MemberService;
import com.jsp.service.MemberServiceImpl;

public class MemberCheckPasswordAction implements Action {

	private MemberService memberService = MemberServiceImpl.getInstance();
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String result=null;
		
		String pwd=request.getParameter("pwd");
		
		HttpSession session = request.getSession();				
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		if(loginUser.getPwd().equals(pwd)) {
			result="SUCCESS";
		}
		
		response.getWriter().print(result);
		
		return null;

	}

}
