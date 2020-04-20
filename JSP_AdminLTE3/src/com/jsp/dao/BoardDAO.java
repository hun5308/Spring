package com.jsp.dao;

import java.sql.SQLException;
import java.util.List;


import com.jsp.dto.BoardVO;
import com.jsp.request.SearchCriteria;

public interface BoardDAO {

	List<BoardVO> selectBoardCriteria(SearchCriteria cri) throws SQLException;

	int selectBoardCriteriaTotalCount(SearchCriteria cri) throws SQLException;

	//게시글 상세보기
	BoardVO selectBoardByBno(int bno) throws SQLException;

	//게시글 작성
	void insertBoard(BoardVO board) throws SQLException;

	//게시글 수정
	void updateBoard(BoardVO board) throws SQLException;

	//게시글 삭제
	void deleteBoard(int bno) throws SQLException;

	
	//조회수
	// viewcnt 증가
	void increaseViewCnt(int bno) throws SQLException;

	// 
	// board_seq.nextval 가져오기
	int selectBoardSeqNext() throws SQLException;

}
