package kr.watchdogs.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.watchdogs.entity.WD_Member;
import kr.watchdogs.service.WD_Service;

@Controller
public class WD_Controller {

	@Autowired
	WD_Service WD_Service;

	@RequestMapping("/register")
	public String register(Model model) {
		String register = WD_Service.register();
		model.addAttribute("register", register);
		return "register"; // register.jsp
	}

	// 회원가입
	@PostMapping("/register")
	public String register(WD_Member vo) {
		WD_Service.memberInsert(vo);
		return "redirect:/login";
	}

//	 로그인
	@PostMapping("/login")
	public String login(WD_Member member, HttpSession session) {
		WD_Member vo = WD_Service.getlogin(member);
		session.setAttribute("vo", vo);
		if (vo != null) {
			return "redirect:/index";
		} else {
			return "redirect:/login";
		}
	}

	@RequestMapping("/index")
	public String index(Model model) {
		String index = WD_Service.Index();
		model.addAttribute("index", index);
		return "index"; // index.jsp
	}

	@RequestMapping("/G_FDS")
	public String G_FDS(Model model) {
		String G_FDS = WD_Service.G_FDS();
		model.addAttribute("G_FDS", G_FDS);
		return "G_FDS"; // G_FDS.jsp
	}

	@RequestMapping("/BlockChain")
	public String BlockChain(Model model) {
		String BlockChain = WD_Service.BlockChain();
		model.addAttribute("BlockChain", BlockChain);
		return "BlockChain"; // BlockChain.jsp
	}

	@RequestMapping("/introduce")
	public String introduce(Model model) {
		String introduce = WD_Service.introduce();
		model.addAttribute("introduce", introduce);
		return "introduce"; // introduce.jsp
	}

	@RequestMapping("/forgot_password")
	public String forgot_password(Model model) {
		String forgot_password = WD_Service.forgot_password();
		model.addAttribute("forgot_password", forgot_password);
		return "forgot_password"; // forgot_password.jsp
	}

	@RequestMapping("/login")
	public String login(Model model) {
		String login = WD_Service.login();
		model.addAttribute("login", login);
		return "login"; // login.jsp
	}

	@RequestMapping("/reset_password")
	public String reset_password(Model model) {
		String reset_password = WD_Service.reset_password();
		model.addAttribute("reset_password", reset_password);
		return "reset_password"; // reset_password.jsp
	}

//	@GetMapping("/register")
//	public String register() {
//		return "register";
//	}

}
