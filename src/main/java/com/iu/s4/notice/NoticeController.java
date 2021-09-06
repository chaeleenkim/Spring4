package com.iu.s4.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s4.util.Pager;

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
	public ModelAndView list(ModelAndView mv, Pager pager) {
		
		List<NoticeDTO> ar = noticeService.getList(pager);
		mv.addObject("pager", pager);
		mv.addObject("list",ar);
		mv.setViewName("board/list");
		
		return mv;
	}//list
	
	@RequestMapping("select")
	public void select(NoticeDTO noticeDTO, Model model) {
		noticeDTO = noticeService.getSelect(noticeDTO);
		
		model.addAttribute("dto",noticeDTO);
	}//select
	
	@RequestMapping("delete")
	public String delete(NoticeDTO noticeDTO) {
	
		int result = noticeService.setDelete(noticeDTO);
		
		return "redirect:./list";
	}//delete
	
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public ModelAndView update(NoticeDTO noticeDTO) {
		noticeDTO = noticeService.getSelect(noticeDTO);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/update");
		mv.addObject("dto", noticeDTO);
		
		return mv;
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public ModelAndView update(NoticeDTO noticeDTO, ModelAndView mv) {
		int result = noticeService.setUpdate(noticeDTO);
		mv.setViewName("redirect:./list");
		return mv;
	}
}
