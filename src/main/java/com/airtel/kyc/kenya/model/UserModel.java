package com.airtel.kyc.kenya.model;

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
@EqualsAndHashCode(callSuper=false, of={"id","email","msisdn"})
public class UserModel extends BaseModel {

	private static final long serialVersionUID = -5512236047463586687L;

	private long id;

	private String firstName;

	private String lastName;

	private String msisdn;

	private String email;

	private String password;

	private RoleModel role;
	
	private String username;
}
