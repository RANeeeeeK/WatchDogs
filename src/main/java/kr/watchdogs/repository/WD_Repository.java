package kr.watchdogs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import kr.watchdogs.entity.WD_Member;

@Repository
public interface WD_Repository extends JpaRepository<WD_Member, Long> {

	// 아이디 중복체크
	@Query(value="Select * FROM wd_member WHERE user_id=?", nativeQuery=true)
	WD_Member check_id(String check_id);
	
	// 로그인
	@Query(value="Select * FROM wd_member WHERE user_id=? and user_pw=?", nativeQuery=true)
	WD_Member login(String user_id, String user_pw);

}

