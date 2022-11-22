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
	
	public void member_Insert(Member vo) {
		WD_Repository.save(vo);
	}

}
