package com.iu.s4.member;

import javax.security.auth.login.LoginContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member/**")
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	@PostMapping("update")
	public ModelAndView setUpdate(MemberDTO memberDTO, HttpSession session) throws Exception {
		//수정전 데이터
		MemberDTO sessionDTO = (MemberDTO)session.getAttribute("member");
		
		//수정후 데이터
		memberDTO.setId(sessionDTO.getId());
		int result = memberService.setUpdate(memberDTO);
		
		memberDTO.setName(sessionDTO.getName());
		
		session.setAttribute("member", memberDTO);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:../");
		return mv;
	}
	
	
	@GetMapping("update")
	public ModelAndView setUpdate() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/update");
		return mv;
	}
	
	@GetMapping("delete")
	public ModelAndView setDelete(HttpSession session) throws Exception {
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
		int result = memberService.setDelete(memberDTO);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:../");
		return mv;
		
	}
	
	@GetMapping("mypage")
	public ModelAndView mypage(HttpSession session) throws Exception{
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		MemberFilesDTO memberFilesDTO = memberService.getFile(memberDTO);
		
		ModelAndView mv = new ModelAndView();
		//mv.addObject("files", memberFilesDTO);
		mv.setViewName("member/mypage");
		return mv;
	}
	
	@GetMapping("logout")
	public ModelAndView logout(HttpSession session) throws Exception{
		//1. session의 attribute 삭제
		//session.removeAttribute("member");
		
		//2. session의 시간을 0
		session.invalidate();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:../");
		return mv;
		
	}
	
	
	@PostMapping("login")
	public ModelAndView login(MemberDTO memberDTO, HttpSession session) throws Exception {
		
		//HttpSession session = request.getSession();
		
		ModelAndView mv = new ModelAndView();
		memberDTO = memberService.getLogin(memberDTO);
		
		if(memberDTO!=null) {
			System.out.println("로그인 성공");
			session.setAttribute("member", memberDTO);
		}else {
			System.out.println("로그인 실패");
		}
		
		mv.addObject("dto", memberDTO);
		mv.setViewName("redirect:../");
		
		return mv;
	}
	
	
	@GetMapping("login")
	public ModelAndView login() throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/login");
		return mv;
	}
	
	@GetMapping("idCheckAjax")
	public ModelAndView getIdCheckAjax(MemberDTO memberDTO) throws Exception {
		//중복 검사할 id 출력
		System.out.println(memberDTO.getId());
		memberDTO = memberService.getIdCheck(memberDTO);
		//1이면 사용 가능
		//0이면 사용 불가(중복)
		int result=0;
		if(memberDTO==null) {
			result=1;
		}
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("common/ajaxResult");
		mv.addObject("result", result);
		
		return mv;
	}
	
	
	@GetMapping("idCheck")
	public ModelAndView getIdCheck(MemberDTO memberDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		memberDTO = memberService.getIdCheck(memberDTO);
		System.out.println("id 중복 체크");
		
		mv.addObject("dto", memberDTO);
		mv.setViewName("member/idCheck");
		
		return mv;
	}
	
	@PostMapping("join")
	public ModelAndView join(MemberDTO memberDTO, MultipartFile photo, HttpSession session) throws Exception {
		
		/*
		 * //파일 이름 String original = photo.getOriginalFilename(); //파라미터 이름 String name
		 * = photo.getName(); //파일 사이즈 long size = photo.getSize();
		 * 
		 * 
		 * String contentType = photo.getContentType();
		 * System.out.println("Original : "+original);
		 * System.out.println("Name : "+name); System.out.println("ContentType : " +
		 * contentType);
		 */
		
		ModelAndView mv = new ModelAndView();
		int result = memberService.setJoin(memberDTO, photo, session);
		String message = "회원가입 실패";
		
		if(result>0) {
			message = "회원가입 성공";
		}
		
		mv.addObject("msg", message);
		mv.addObject("url", "../");
		mv.setViewName("common/result");
		return mv;
	}
	
	@GetMapping("join")
	public ModelAndView join() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/join");
		return mv;
	}
	
	@GetMapping("check")
	public ModelAndView check() throws Exception{
		ModelAndView  mv = new ModelAndView();
		mv.setViewName("member/check");
		return mv;
	}
	
	
	
}
