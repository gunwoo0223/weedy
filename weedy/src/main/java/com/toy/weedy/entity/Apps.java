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
public class Apps {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String name;
	
	@Column
	private String url;
	
	@Column(name="short_description")
	private String shortDescription;
	
	@Column
	private String description;
	
	@Column
	private String company;
	
	@Column
	private String category;
	
	@Column
	private String language;
	
	@Column
	private int age;
	
	@Column
	private String copyright;
	
	@Column(name="private_info_policy")
	private String privateInfoPolicy;
	
	@Column(name="comment_user")
	private String commentUser;
	
	@Column(name="comment_admin")
	private String commentAdmin;
	
	@Column(name="request_state")
	private String requestState;
	
	@Column(name="admin_flag")
	private String adminFlag;
	
	@Column(name="read_count")
	private int readCount;
	
	@Column(name="enroll_time")
	private String enrollTime;
	
	@Column(name="update_time")
	private String updateTime;
	
	@Column
	private String deleted;
	
	@Column(name="users_id")
	private Long usersId;
}

















