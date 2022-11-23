package kr.watchdogs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.watchdogs.entity.Member;
import kr.watchdogs.service.WD_Service;

@Controller
public class WD_Controller {
	
	@Autowired
	WD_Service WD_Service;
	
	@RequestMapping("/index")
	public String index(Model model) {
		List<Member> index = WD_Service.getIndex();
		model.addAttribute("index", index);
		return "index"; // index.jsp
	}
	
	@RequestMapping("/G_FDS")
	public String G_FDS(Model model) {
		List<Member> G_FDS = WD_Service.getG_FDS();
		model.addAttribute("G_FDS", G_FDS);
		return "G_FDS"; // G_FDS.jsp
	}
	
	@RequestMapping("/BlockChain")
	public String BlockChain(Model model) {
		List<Member> BlockChain = WD_Service.getBlockChain();
		model.addAttribute("BlockChain", BlockChain);
		return "BlockChain"; // BlockChain.jsp
	}
	
	@RequestMapping("/introduce")
	public String introduce(Model model) {
		List<Member> introduce = WD_Service.getintroduce();
		model.addAttribute("introduce", introduce);
		return "introduce"; // introduce.jsp
	}
	
	@RequestMapping("/forgot_password")
	public String forgot_password(Model model) {
		List<Member> forgot_password = WD_Service.getforgot_password();
		model.addAttribute("forgot_password", forgot_password);
		return "forgot_password"; // forgot_password.jsp
	}
	
	@RequestMapping("/login")
	public String login(Model model) {
		List<Member> login = WD_Service.getlogin();
		model.addAttribute("login", login);
		return "login"; // login.jsp
	}
	
	@RequestMapping("/register")
	public String register(Model model) {
		List<Member> register = WD_Service.getregister();
		model.addAttribute("register", register);
		return "register"; // register.jsp
	}
	
	@RequestMapping("/reset_password")
	public String reset_password(Model model) {
		List<Member> reset_password = WD_Service.getreset_password();
		model.addAttribute("reset_password", reset_password);
		return "reset_password"; // reset_password.jsp
	}
	
	@PostMapping("/join")
	public String join(Member vo) {
		WD_Service.member_Insert(vo);
		return "redirect:/join";
	}
	
//	@RequestMapping("/list")
//	public String list(Model model) {
//		List<Member> list = WD_Service.getList();
//		model.addAttribute("list", list);
//		return "list"; // list.jsp
//	}
//	
//	@GetMapping("/register")
//	public String register() {
//		return "register";
//	}


}
