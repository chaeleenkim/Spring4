package com.iu.s4.board.notice;

import java.util.List;

import com.iu.s4.board.BoardDTO;
import com.iu.s4.board.BoardFilesDTO;

public class NoticeDTO extends BoardDTO{
	//is a = 상속 -> notice는 게시판이다
	//has a = 멤버변수
	private List<BoardFilesDTO> files;

	public List<BoardFilesDTO> getFiles() {
		return files;
	}

	public void setFiles(List<BoardFilesDTO> files) {
		this.files = files;
	}
	
	
	
	
}	
