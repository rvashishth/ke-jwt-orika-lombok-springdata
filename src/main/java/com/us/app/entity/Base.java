package com.us.app.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author rvashishth
 *
 */
@MappedSuperclass
@Getter @Setter @NoArgsConstructor
public abstract class Base implements Serializable{

	private static final long serialVersionUID = 7004186297882637488L;

	@Column(name = "CREATED_BY",nullable=false)
	private String createdBy;
	
	@Column(name = "CREATED_ON",nullable=false)
	private Timestamp createdOn = new Timestamp(System.currentTimeMillis());
	
	@Column(name = "UPDATED_ON",nullable=false)
	private Timestamp updatedOn;
	
	@Column(name = "UPDATED_BY",nullable=false)
	private String updatedBy;
	
	@PrePersist
	public void prePersist(){
		System.out.println("==========prePersist======");
		createdOn = new Timestamp(System.currentTimeMillis());
	}
	
	@PreUpdate
	public void preUpdate(){
		System.out.println("==========preUpdate======");
		updatedOn = new Timestamp(System.currentTimeMillis());
	}
	
}
