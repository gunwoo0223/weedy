package com.toy.weedy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) //Entity가 늦게 초기화되고, Serialization이 먼저 일어나서 발생한 문제. 해당 annotation으로 해결.
public class Boards {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String title;
	
	@Column
	private String content;
	
	@Column
	private String type;
	
	@Column(name="enroll_time")
	private String enrollTime;
	
	@Column(name="update_time")
	private String updateTime;
	
	@Column(name="read_count")
	private int readCount;
	
	@Column(name="users_id")
	private Long usersId;
}
