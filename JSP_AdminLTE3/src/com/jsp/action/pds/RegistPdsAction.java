package com.jsp.action.pds;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.dto.BoardVO;
import com.jsp.dto.PdsVO;
import com.jsp.request.BoardRegistRequest;
import com.jsp.request.PdsRegistRequest;
import com.jsp.service.BoardService;
import com.jsp.service.BoardServiceImpl;
import com.jsp.service.PdsService;


public class RegistPdsAction implements Action {

	private PdsService pdsService;
	public void setBoardService(PdsService pdsService) {
		this.pdsService = pdsService;
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url="pds/regist_success";
		
		try {
			
		int bno = 0;
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");   
		String content = request.getParameter("content");

		

		PdsRegistRequest pdsReq = new PdsRegistRequest(title, writer, content, bno);

		PdsVO pds = pdsReq.toPdsVO();
			
		pdsService.regist(pds);
			
		} catch (SQLException e) {
			e.printStackTrace();
			url = "pds/regist_fail";
		}
		
		return url;
	}
}
