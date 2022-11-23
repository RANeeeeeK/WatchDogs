package kr.watchdogs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.watchdogs.entity.Member;
import kr.watchdogs.repository.WD_Repository;

@Service
public class WD_Service {
	
	@Autowired
	private WD_Repository WD_Repository;
	
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
	
	public void member_Insert(Member vo) {
		WD_Repository.save(vo);
	}

}
