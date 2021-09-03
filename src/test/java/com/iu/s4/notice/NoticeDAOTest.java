package com.iu.s4.notice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s4.MyJunitTest;

public class NoticeDAOTest extends MyJunitTest{
	
	@Autowired
	private NoticeDAO noticeDAO;
	
	//@Test
	public void setInsertTest() {
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setTitle("t4");
		noticeDTO.setWriter("w4");
		noticeDTO.setContents("c4");
		
		int result = noticeDAO.setInsert(noticeDTO);
		assertEquals(1, result);
		
	}
	
	
	//@Test
	public void getSelectTest() {
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setNum(1L);
		
		noticeDTO = noticeDAO.getSelect(noticeDTO);
		assertNotNull(noticeDTO);;
	}
	
	
	//@Test
	public void getListTest() {
		List<NoticeDTO> ar = noticeDAO.getList();
		assertNotEquals(0, ar.size());
		
	}

}
