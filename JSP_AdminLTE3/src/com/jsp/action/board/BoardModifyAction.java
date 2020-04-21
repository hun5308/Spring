package com.jsp.action.board;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.action.Action;
import com.jsp.dto.BoardVO;
import com.jsp.dto.MemberVO;
import com.jsp.request.BoardRegistRequest;
import com.jsp.request.MemberRegistRequest;
import com.jsp.service.BoardService;
import com.jsp.service.BoardServiceImpl;
import com.jsp.service.MemberService;
import com.jsp.service.MemberServiceImpl;
import com.jsp.utils.GetUploadPath;

public class BoardModifyAction implements Action {

	private BoardService boardService = BoardServiceImpl.getInstance();
	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}
	
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url="board/modify_success";
		
		String num = request.getParameter("bno");		
		String title = request.getParameter("title");
		String writer = request.getParameter("writer"); 
		String content = request.getParameter("content");
		int bno = Integer.parseInt(num);
		
		BoardRegistRequest boardReq = new BoardRegistRequest(title, writer, content, bno);		
		BoardVO board = boardReq.toBoardVO();
		
		try {

		boardService.modify(board);
		
		} catch (SQLException e) {		
			e.printStackTrace();
			url="member/modify_fail";			
		}	
		request.setAttribute("bno", bno);
		
		return url;
	}

}
