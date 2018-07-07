package com.wolftechnica.app.entity;

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

@Entity @Table(name="subroles")
@Getter @Setter @ToString @NoArgsConstructor
@EqualsAndHashCode(callSuper=false, of={"id","name"})
public class SubRole extends Base{

	private static final long serialVersionUID = 1781796824787424440L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "subrole_seq")
	@SequenceGenerator(allocationSize = 1, name = "subrole_seq", sequenceName = "subrole_seq")
	private long id;
	
	@Column(name = "name",unique=true,nullable=false)
	private String name;
	
	@Column(name = "web_access",nullable=false)
	private boolean webAccess;
	
	@Column(name = "mobile_access",nullable=false)
	private boolean mobileAccess;
	
	@Column(name="description",nullable=false)
	private String description; 
}
