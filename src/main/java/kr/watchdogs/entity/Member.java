package kr.watchdogs.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

// ORM(Object<-->Table)
@Entity
@Data
public class Member {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idx; // PK, 자동증가컬럼
	private String id;
	private String pw;
	private String name;
	
	@Column(columnDefinition = "datetime default now()")
	private Date birth; // now()
	@Column(columnDefinition = "int default 0")
	private Long cnt;

}
