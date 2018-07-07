package com.wolftechnica.app.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * @author rvashishth
 *
 */
@Getter
@Setter
public abstract class BaseModel implements Serializable{

	private static final long serialVersionUID = -2584034690789022798L;

	private String createdBy;
	
	private long createdOn;

	private long updatedOn;

	private String updatedBy;
}
