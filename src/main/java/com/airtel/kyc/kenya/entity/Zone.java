package com.airtel.kyc.kenya.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Zone is same a province
 * 
 * @author rvashishth
 */
@Entity @Table(name="zone")
@Getter @Setter @ToString @NoArgsConstructor
@EqualsAndHashCode(callSuper=false, of={"id","zoneName"})
public class Zone implements Serializable{

	private static final long serialVersionUID = 867616090308589971L;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "img_seq")
	@SequenceGenerator(allocationSize = 1, name = "img_seq", sequenceName = "img_seq")
	private long id;
	
	@Column(name="zone_name",nullable=false,unique=true)
	private String zoneName;
	
}
