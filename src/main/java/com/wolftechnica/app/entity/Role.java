package com.wolftechnica.app.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author rvashishth
 *
 */
@Entity @Table(name="roles")
@Getter @Setter @ToString @NoArgsConstructor
@EqualsAndHashCode(callSuper=false, of={"id","rolename"})
public class Role extends Base{

	private static final long serialVersionUID = 2864434740955553168L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_seq")
	@SequenceGenerator(allocationSize = 1, name = "role_seq", sequenceName = "role_seq")
	private long id;
	
	@Column(name = "role_name",unique=true,nullable=false)
	private String rolename;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	@JoinColumn(name = "role_id")
	private Set<SubRole> subroles;
	
	@Column(name="description", nullable = false)
	private String description;
	
}
