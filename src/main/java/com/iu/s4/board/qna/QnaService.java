package com.iu.s4.board.qna;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.s4.board.BoardDTO;
import com.iu.s4.board.BoardFilesDTO;
import com.iu.s4.board.BoardService;
import com.iu.s4.util.FileManager;
import com.iu.s4.util.Pager;

@Service
public class QnaService implements BoardService {
	
	@Autowired
	private QnaDAO qnaDAO;
	@Autowired
	private ServletContext servletContext;
	@Autowired
	private FileManager fileManager;
	
	public List<BoardFilesDTO> getFiles(BoardDTO boardDTO) throws Exception {
		List<BoardFilesDTO> ar = qnaDAO.getFiles(boardDTO);
		return ar;
	}
	
	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		Long totalCount = qnaDAO.getCount(pager);
		pager.makeNum(totalCount);
		pager.makeRow();
		return qnaDAO.getList(pager);
	}

	@Override
	public BoardDTO getSelect(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		qnaDAO.setHitUpdate(boardDTO);
		return qnaDAO.getSelect(boardDTO);
	}

	@Override
	public int setInsert(BoardDTO boardDTO, MultipartFile[] files) throws Exception {
		// TODO Auto-generated method stub
		String realPath = this.servletContext.getRealPath("/resources/upload/qna/");
		
		File file = new File(realPath);
		
		int result = qnaDAO.setInsert(boardDTO);
		
		for(MultipartFile multipartFile : files) {
			String fileName = fileManager.fileSave(multipartFile, file);
			BoardFilesDTO boardFilesDTO = new BoardFilesDTO();
			boardFilesDTO.setNum(boardDTO.getNum());
			boardFilesDTO.setFileName(fileName);
			boardFilesDTO.setOriName(multipartFile.getOriginalFilename());
			
			result = qnaDAO.setFile(boardFilesDTO);
		}
		
		
		return result; //qnaDAO.setInsert(boardDTO);
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	
	//답글
	public int setReply(QnaDTO qnaDTO) throws Exception {
		//1.부모의 정보 조회
		//QnaDTO로 형변환 필요
		QnaDTO parent = (QnaDTO)qnaDAO.getSelect(qnaDTO);
		qnaDTO.setRef(parent.getRef());
		qnaDTO.setStep(parent.getStep()+1);
		qnaDTO.setDepth(parent.getStep()+1);
		
		//2. update
		int result = qnaDAO.setReplyUpdate(parent);
		
		
		//3. insert
		result = qnaDAO.setReply(qnaDTO);
		
		return result;
	}
	
}
