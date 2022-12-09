package kr.watchdogs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import kr.watchdogs.entity.WD_Member;

@Repository
public interface WD_Repository extends JpaRepository<WD_Member, String> {

	// 아이디 중복체크, 이용횟수 조회
	@Query(value="Select * from wd_member where user_id=?", nativeQuery=true)
	WD_Member check_id(String check_id);
	
	// 로그인
	@Query(value="Select * from wd_member where user_id=? and user_pw=?", nativeQuery=true)
	WD_Member login(String user_id, String user_pw);
	
	// 이용횟수 업데이트
	@Transactional
	@Modifying
	@Query(value="Update wd_member set cnt=cnt+1 where user_id=?", nativeQuery=true)
	int cnt_update(String user_id);

}

