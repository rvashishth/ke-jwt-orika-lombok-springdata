package com.us.app.model;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author b0202777
 *
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
public class LoginModel implements Serializable{

	private static final long serialVersionUID = -7967837054965675647L;

	@NotEmpty
	private String username;
	
	@NotEmpty
	private String password;
	
	private String role;

}
