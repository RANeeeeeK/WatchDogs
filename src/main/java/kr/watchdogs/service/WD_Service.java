package kr.watchdogs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.watchdogs.entity.WD_Member;
import kr.watchdogs.repository.WD_Repository;

@Service
public class WD_Service {

	@Autowired
	private WD_Repository WD_Repository;

	// 회원가입
	public void getjoin(WD_Member vo) {
		WD_Repository.save(vo);
	}
	
	// 로그인
	public WD_Member getlogin(WD_Member login) {
		return WD_Repository.login(login.getUser_id(), login.getUser_pw());
	}
	
	// 아이디 중복체크
	public WD_Member getcheck_id(String check_id) {
		return WD_Repository.check_id(check_id);
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
		return "diagnosis";
	}
	public String login() {
		return "login";
	}
	public String report() {
		return "report";
	}

}
