package kr.watchdogs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.watchdogs.entity.Member;

@Repository
public interface WD_Repository extends JpaRepository<Member, Long> {
	

}
