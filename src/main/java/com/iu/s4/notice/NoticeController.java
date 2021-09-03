package com.iu.s4.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/board/*")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public void insert() {
		
	}
	
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insert(NoticeDTO noticeDTO) {
		int result = noticeService.setInsert(noticeDTO);
		return "redirect:./list";
	}
	
	
	@RequestMapping("list")
	public ModelAndView list(ModelAndView mv) {
		
		List<NoticeDTO> ar = noticeService.getList();
		mv.addObject("list",ar);
		mv.setViewName("board/list");
		
		return mv;
	}//list
	
	@RequestMapping("select")
	public void select(NoticeDTO noticeDTO, Model model) {
		noticeDTO = noticeService.getSelect(noticeDTO);
		
		model.addAttribute("dto",noticeDTO);
	}
}
