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
	
	public List<WD_Member> getregister(){
		List<WD_Member> register = WD_Repository.findAll();
		return register;
	}
	
	public List<WD_Member> getIndex(){
		List<WD_Member> index = WD_Repository.findAll();
		return index;
	}
	
	public List<WD_Member> getG_FDS(){
		List<WD_Member> G_FDS = WD_Repository.findAll();
		return G_FDS;
	}
	
	public List<WD_Member> getBlockChain(){
		List<WD_Member> BlockChain = WD_Repository.findAll();
		return BlockChain;
	}
	
	public List<WD_Member> getintroduce(){
		List<WD_Member> introduce = WD_Repository.findAll();
		return introduce;
	}
	
	public List<WD_Member> getforgot_password(){
		List<WD_Member> forgot_password = WD_Repository.findAll();
		return forgot_password;
	}
	
	public List<WD_Member> getlogin(){
		List<WD_Member> login = WD_Repository.findAll();
		return login;
	}
	
	
	
	public List<WD_Member> getreset_password(){
		List<WD_Member> reset_password = WD_Repository.findAll();
		return reset_password;
	}
	
	

}
