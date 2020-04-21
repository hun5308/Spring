package com.jsp.action.board;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.action.Action;
import com.jsp.dto.BoardVO;
import com.jsp.dto.MemberVO;
import com.jsp.service.BoardService;
import com.jsp.service.BoardServiceImpl;
import com.jsp.service.MemberServiceImpl;

public class BoardRemoveAction implements Action {
	
	private BoardService boardService = BoardServiceImpl.getInstance();
	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String url="board/remove_success";
		try {
		
		
		int bno= Integer.parseInt(request.getParameter("bno"));

		boardService.remove(bno);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return url;
	}

}
