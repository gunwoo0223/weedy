package com.toy.weedy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Apps {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column
	private String name;
	
	@Column
	private String url;
	
	@Column
	private String short_description;
	
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
	
	@Column
	private String private_info_policy;
	
	@Column
	private String comment_user;
	
	@Column
	private String comment_admin;
	
	@Column
	private String request_state;
	
	@Column
	private String admin_flag;
	
	@Column
	private int read_count;
	
	@Column
	private String enroll_time;
	
	@Column
	private String update_time;
	
	@Column
	private String deleted;
	
	@Column
	private Long users_id;
}

















