package com.airtel.kyc.kenya.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Territory is same as county
 * 
 * @author rvashishth
 */
@Entity @Table(name="territory")
@Getter @Setter @ToString @NoArgsConstructor
@EqualsAndHashCode(callSuper=false, of={"id","territoryName"})
public class Territory implements Serializable{

	private static final long serialVersionUID = 3624319934927817261L;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "img_seq")
	@SequenceGenerator(allocationSize = 1, name = "img_seq", sequenceName = "img_seq")
	private long id;
	
	@Column(name="territory_name",nullable=false,unique=true)
	private String territoryName;
	
	@OneToOne
	@JoinColumn(name = "zone_id")
	private Zone zone;
}
