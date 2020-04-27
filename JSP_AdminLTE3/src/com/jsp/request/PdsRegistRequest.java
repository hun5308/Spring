package com.jsp.request;

import java.util.Date;

import com.jsp.dto.BoardVO;
import com.jsp.dto.PdsVO;

public class PdsRegistRequest {

	private String title;	  // 게시글 제목
	private String writer;    // 작성자
	private String content;   // 내용
	private int pno;

	
	
	
	
	public PdsRegistRequest() {}
	public PdsRegistRequest(String title, String writer, String content, int pno) {
		super();
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.pno = pno;

	}


	public int getBno() {
		return pno;
	}
	
	public void setBno(int pno) {
		this.pno = pno;
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


	@Override
	public String toString() {
		return "BoardRegistRequest [title=" + title + ", writer=" + writer + ", content=" + content + ", pno=" + pno
				+ "]";
	}
	public PdsVO toPdsVO() {
		PdsVO pds = new PdsVO();

		pds.setTitle(title);
		pds.setWriter(writer);
		pds.setContent(content);
		pds.setPno(pno);
				
		return pds;
	}
}
