package com.us.app.entity;

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
 * @author rvashishth
 *
 */
@Entity @Table(name="user_image")
@Getter @Setter @ToString @NoArgsConstructor
@EqualsAndHashCode(callSuper=false, of={"id"})
public class UserImage implements Serializable{

	private static final long serialVersionUID = 1427647527403755876L;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "img_seq")
	@SequenceGenerator(allocationSize = 1, name = "img_seq", sequenceName = "img_seq")
	private long id;
	
	@Column(name="front_image")
	private String frontImage;
	
	@Column(name="back_image")
	private String backImage;

}
