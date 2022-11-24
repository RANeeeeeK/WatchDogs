package kr.watchdogs.service;

import java.util.List;

import org.hibernate.annotations.SQLInsert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import kr.watchdogs.entity.WD_Member;
import kr.watchdogs.repository.WD_Repository;

@Service
public class WD_Service {

	@Autowired
	private WD_Repository WD_Repository;

	// 회원가입

	public void memberInsert(WD_Member vo) {
		WD_Repository.save(vo);
	}
	//로그인
	public WD_Member getlogin(WD_Member vo) {
		return WD_Repository.login(vo.getUser_id(), vo.getUser_pw());
	}
	
	//창 이동 
	public String register() {
		return "register";
	}
	public String Index() {
		return "index";
	}
	public String G_FDS() {
		return "G_FDS";
	}
	public String BlockChain() {
		return "BlockChain";
	}
	public String introduce() {
		return "introduce";
	}
	public String forgot_password() {
		return "forgot_password";
	}
	public String login() {
		return "login";
	}
	public String reset_password() {
		return "reset_password";
	}

}
