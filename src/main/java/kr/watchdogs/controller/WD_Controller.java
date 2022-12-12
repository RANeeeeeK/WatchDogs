package kr.watchdogs.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.watchdogs.entity.WD_Member;
import kr.watchdogs.service.WD_Service;

@Controller
public class WD_Controller {

	@Autowired
	WD_Service WD_Service;

	// 회원가입
	@PostMapping("/register")
	public String register(WD_Member vo) {
		WD_Member row = WD_Service.getcheck_id(vo.getUser_id());
		if(row != null) {
			return "redirect:/register";
		}else {
			WD_Service.getjoin(vo);
			return "redirect:/login";
		}
	}
	
	// 아이디 중복체크
	@ResponseBody
	@PostMapping("/registerAjax")
	public String check_id(String check_id) {
		WD_Member vo = WD_Service.getcheck_id(check_id);
		System.out.println(vo);
		if(vo != null) {
			return "find";
		}
			return null;
	}

	// 로그인
	@PostMapping("/login")
	public String login(WD_Member login, HttpSession session) {
		WD_Member vo = WD_Service.getlogin(login);
		session.setAttribute("vo", vo);
		if (vo != null) {
			return "redirect:/Dashboard";
		} else {
			return "redirect:/login";
		}
	}
	// 로그아웃
	@ResponseBody
	@RequestMapping("/log_out")
	public String logout(HttpSession session) {
		session.invalidate();
		return "success";
	}
	
	// 이용횟수 업데이트
	@PostMapping("/use_cnt")
	@ResponseBody
	public String cnt(HttpSession session){
		WD_Member vo =(WD_Member)session.getAttribute("vo");
		int row = WD_Service.getcnt_update(vo.getUser_id());
		vo = WD_Service.getcheck_id(vo.getUser_id());
		session.setAttribute("vo",vo);
		if(row > 0) {
			return "success";
		}else {
			return "fale";
		}
	}
	
	// cnt 조회
	@PostMapping("/search_cnt")
	@ResponseBody
	public int search_cnt(HttpSession session) {
		WD_Member vo =(WD_Member)session.getAttribute("vo");
		vo = WD_Service.getcheck_id(vo.getUser_id());
		if (vo != null) {
			return vo.getCnt();
		} else {
			return 0;
		}
	}
	

	// 창 이동
	@RequestMapping("/Dashboard")
	public String Dashboard(Model model) {
		String Dashboard = WD_Service.Dashboard();
		model.addAttribute("Dashboard", Dashboard);
		return "Dashboard"; // Dashboard.jsp
	}

	@RequestMapping("/G_FDS")
	public String G_FDS(Model model) {
		String G_FDS = WD_Service.G_FDS();
		model.addAttribute("G_FDS", G_FDS);
		return "G_FDS"; // G_FDS.jsp
	}

	@RequestMapping("/Address")
	public String Address(Model model) {
		String Address = WD_Service.Address();
		model.addAttribute("Address", Address);
		return "Address"; // Address.jsp
	}

	@RequestMapping("/Report")
	public String Report(Model model) {
		String Report = WD_Service.Report();
		model.addAttribute("Report", Report);
		return "Report"; // Report.jsp
	}
	
	@RequestMapping("/Diagnosis")
	public String Diagnosis(Model model) {
		String Diagnosis = WD_Service.Diagnosis();
		model.addAttribute("Diagnosis", Diagnosis);
		return "Diagnosis"; // Diagnosis.jsp
	}
	

	@RequestMapping("/login")
	public String login(Model model) {
		String login = WD_Service.login();
		model.addAttribute("login", login);
		return "login"; // login.jsp
	}
	
	@RequestMapping("/register")
	public String register(Model model) {
		String register = WD_Service.register();
		model.addAttribute("register", register);
		return "register"; // register.jsp
	}
	
	@RequestMapping("/intro")
	public String intro(Model model) {
		String intro = WD_Service.intro();
		model.addAttribute("intro", intro);
		return "intro"; // intro.jsp
	}
	
	@RequestMapping("/Subcribe")
	public String Subcribe(Model model) {
		String Subcribe = WD_Service.Subcribe();
		model.addAttribute("Subcribe", Subcribe);
		return "Subcribe"; // Subcribe.jsp
	}

}
