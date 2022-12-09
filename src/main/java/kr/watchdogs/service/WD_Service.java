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
	
	// 아이디 중복체크, 이용횟수 조회
	public WD_Member getcheck_id(String check_id) {
		return WD_Repository.check_id(check_id);
	}
	
	// 로그인
	public WD_Member getlogin(WD_Member login) {
		return WD_Repository.login(login.getUser_id(), login.getUser_pw());
	}
	
	// 이용횟수 업데이트
	public int getcnt_update(String user_id) {
		return WD_Repository.cnt_update(user_id);
	}
	
	
	//창 이동 
	public String Dashboard() {
		return "Dashboard";
	}
	public String G_FDS() {
		return "G_FDS";
	}
	public String Address() {
		return "Address";
	}
	public String Report() {
		return "Report";
	}
	public String Diagnosis() {
		return "Diagnosis";
	}
	
	public String login() {
		return "login";
	}
	public String register() {
		return "register";
	}

}
