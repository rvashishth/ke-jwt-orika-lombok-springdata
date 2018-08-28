package com.us.app.model;

import java.io.Serializable;
import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author rvashishth
 *
 */
@Getter @Setter @ToString @NoArgsConstructor
@EqualsAndHashCode(callSuper=false, of={"rolename","subroles"})
public class RoleModel implements Serializable{

	private static final long serialVersionUID = -8226777435227813572L;
	
	private String rolename;
	
	private List<String> subroles;
	
	private long id;
	
}
