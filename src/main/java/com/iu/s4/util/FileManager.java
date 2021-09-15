package com.iu.s4.util;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManager {
	@Autowired
	private ServletContext servletContext;
	
	//파일삭제
	public void fileDelete() throws Exception {
		
	}
	
	//fileSave 
	//파일 저장
	public String fileSave(MultipartFile multipartFile, File file) throws Exception {
		if(!file.exists()) {
			file.mkdir();
		}
		
		//파일명 생성
		String fileName = UUID.randomUUID().toString();
		//확장자 추가
		fileName = fileName+"_"+multipartFile.getOriginalFilename();
		
		file = new File(file, fileName);
		
		//저장 1, 2 중 아무거나
		//1. FileCopyUtils
		//FileCopyUtils.copy(multipartFile.getBytes(),file);
		//2. MultipartFile
		multipartFile.transferTo(file);
		
		return fileName;
		
	}
	
	
	

}
