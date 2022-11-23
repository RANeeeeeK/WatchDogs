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
