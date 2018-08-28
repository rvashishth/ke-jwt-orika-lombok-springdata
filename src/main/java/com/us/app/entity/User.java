package com.us.app.entity;

import java.sql.Date;
import java.sql.Timestamp;

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
 * @author rvashishth
 * 
 */
@Entity @Table(name="users")
@Getter @Setter @ToString @NoArgsConstructor
@EqualsAndHashCode(callSuper=false, of={"id","email","msisdn"})
public class User extends Base {
	
	private static final long serialVersionUID = 9219697358618873225L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
	@SequenceGenerator(allocationSize = 1, name = "user_seq", sequenceName = "user_seq")
	private long id;
	
	@Column(name = "first_name",nullable=false)
	private String firstName;
	
	@Column(name = "last_name",nullable=false)
	private String lastName;
	
	@Column(name = "auuid",nullable=false)
	private String auuid;
	
	@Column(name = "msisdn",nullable=false,unique=true)
	private String msisdn;
	
	//DOB
	//@Temporal(TemporalType.DATE)
	@Column(name = "dob")
	private Date dob;
	
	//Gender
	@Column(name = "gender")
	private String gender;
	
	//County
	@Column(name = "county")
	private String county;
	
	//TODO: Have a different entity for address
	//Personal Physical address
	@Column(name = "personal_physical_address")
	private String personalPhysicalAddress;

	//Postal Address
	@Column(name = "postal_address")
	private String postalAddress;
	
	@OneToOne
	@JoinColumn(name = "image_id")
	private UserImage image;

	//Channel enrollment form //TODO? What is it
	
	@OneToOne
	@JoinColumn(name = "role_id")
	private Role role;
	
	@OneToOne
	@JoinColumn(name = "subrole_id")
	private SubRole subRole;
	
	//AM Agent code
	@Column(name = "am_agent_code")
	private String amAgentCode;

	//ID card no
	@Column(name = "id_card_no")
	private String idCardNo;
	
	@Column(name = "email",nullable=false,unique=true)
	private String email;
	
	//Department - TODO: Create an enum
	@Column(name = "department")
	private String department;
	
	//Distributor MSISDN
	@Column(name = "distributor_msisdn",nullable=false,unique=true)
	private String distributorMsisdn;
	
	//Sales outlet address
	@Column(name = "sales_outlet_address")
	private String salesOutletAddress;
	
	//Reporting SE
	@Column(name = "reporting_se")
	private String reportingSE;
	
	//Reporting TSE
	@Column(name = "reporting_tse")
	private String reportingTSE;
	
	/* Airtel handset provided */
	@Column(name = "airtel_handset")
	private boolean airtelHandset ;

	//Handset IMEI
	@Column(name = "handset_imei")
	private String handset_imei ;
	
	//Delivery date
	@Column(name = "delivery_date")
	private Timestamp delivery_date;
	
	//Channel partner site ID
	@Column(name = "cp_siteid")
	private String cpSiteId;
	
	//Channel partner  lat-long
	@Column(name = "cp_latitude")
	private String cpLatitude;
	
	@Column(name = "cp_longitude")
	private String cpLongitude;

	/* Permissible radius for customer registration */
	@Column(name="cust_reg_redius")
	private String customerRegRedius;

	//Zone - TODO: Should come from enum or list
	//@Column(name = "zone")
	//private String zone;
	
	//Territory
	@Column(name = "territory_id")
	private Territory territoryId;
	
	/* Prepaid creation/ edit access? */
	@Column(name = "add_edit_prepaid")
	private boolean addEditPrepaid ;

	/* MNP access? */
	@Column(name = "mnp_access")
	private boolean mnpAccess;

	@Column(name = "password",nullable=false)
	private String password;

	//Is deleted
	@Column(name = "deleted")
	private boolean deleted;
	
	/* delete reasons */
	@Column(name = "delete_desc")
	private String deleteDescription;
}
