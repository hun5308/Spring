package com.jsp.request;

import java.util.Date;

import com.jsp.dto.BoardVO;

public class BoardRegistRequest {

	private String title;	  // 게시글 제목
	private String writer;    // 작성자
	private String content;   // 내용
	private int bno;
	
	
	
	public BoardRegistRequest() {}
	public BoardRegistRequest(String title, String writer, String content, int bno) {
		super();
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.bno = bno;
	}




	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getWriter() {
		return writer;
	}



	public void setWriter(String writer) {
		this.writer = writer;
	}



	public String getContent() {
		return content;
	}



	public void setContent(String content) {
		this.content = content;
	}



	public int getBno() {
		return bno;
	}



	public void setBno(int bno) {
		this.bno = bno;
	}



	@Override
	public String toString() {
		return "BoardRegistRequest [title=" + title + ", writer=" + writer + ", content=" + content + ", bno=" + bno
				+ "]";
	}



	public BoardVO toBoardVO() {
		BoardVO board = new BoardVO();

		board.setBno(bno);
		board.setTitle(title);
		board.setWriter(writer);
		board.setContent(content);
		
		return board;
	}
}
