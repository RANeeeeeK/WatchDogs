package kr.watchdogs.service;

import java.util.List;

import org.hibernate.annotations.SQLInsert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.watchdogs.entity.Member;
import kr.watchdogs.repository.WD_Repository;

@Service
public class WD_Service {
	
	@Autowired
	private WD_Repository WD_Repository;
	
	// 회원가입
		@SQLInsert(sql="insert into member(id,pw,name,birth) values(#{id},#{pw},#{name},#{birth}")
		public void memberInsert(Member vo) {
			WD_Repository.save(vo);
		}
	
	public List<Member> getregister(){
		List<Member> register = WD_Repository.findAll();
		return register;
	}
	
	public List<Member> getIndex(){
		List<Member> index = WD_Repository.findAll();
		return index;
	}
	
	public List<Member> getG_FDS(){
		List<Member> G_FDS = WD_Repository.findAll();
		return G_FDS;
	}
	
	public List<Member> getBlockChain(){
		List<Member> BlockChain = WD_Repository.findAll();
		return BlockChain;
	}
	
	public List<Member> getintroduce(){
		List<Member> introduce = WD_Repository.findAll();
		return introduce;
	}
	
	public List<Member> getforgot_password(){
		List<Member> forgot_password = WD_Repository.findAll();
		return forgot_password;
	}
	
	public List<Member> getlogin(){
		List<Member> login = WD_Repository.findAll();
		return login;
	}
	
	
	
	public List<Member> getreset_password(){
		List<Member> reset_password = WD_Repository.findAll();
		return reset_password;
	}
	
	

}
