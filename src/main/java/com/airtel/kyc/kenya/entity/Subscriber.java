package com.airtel.kyc.kenya.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.airtel.kyc.kenya.constants.SubscriberIDType;
import com.airtel.kyc.kenya.constants.SubscriberType;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * This class contains sim subscriber details
 * 
 * @author b0202777
 */
@Entity @Table(name="subscriber")
@Getter @Setter @ToString @NoArgsConstructor
@EqualsAndHashCode(callSuper=false, of={"id","idNumber","msisdn"})
public class Subscriber extends Base{

	private static final long serialVersionUID = -2038582556247241433L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "subscriber_seq")
	@SequenceGenerator(allocationSize = 1, name = "subscriber_seq", sequenceName = "subscriber_seq")
	private long id;
	
	@Enumerated(EnumType.STRING)
	@Column(name="id_type")
	private SubscriberIDType idType;
	
	/* max 10 msisdn can be issued against one id */
	@Column(name="id_number")
	private String idNumber;
	
	@Column(name="msisdn")
	private String msisdn;
	
	@Column(name="sim_serial_num")
	private String simSerialNumber;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="dob")
	private Date dob;
	
	@Column(name="gender")
	private String gender;
	
	//TODO: Replace this with county/territory entity mapping
	@Column(name="county")
	private String county;
	
	//TODO: Check how address is captured on UI, change this with Address entity
	@Column(name="physical_address")
	private String physicalAddress;
	
	@Column(name="postal_address")
	private String postalAddress;
	
	@Column(name="create_am_account")
	private boolean createAmAccount;
	
	@Column(name="occupation")
	private String occupation;
	
	@Column(name="subscriber_img")
	private UserImage subscriberImage;
	
	@Column(name="id_img_front")
	private UserImage idImageFront;
	
	@Column(name="id_img_back")
	private UserImage idImageBack;
	
	@Column(name="signature_image")
	private UserImage signatureImage;
	
	@Column(name="minor")
	private boolean minor;
	
	@Column(name="birth_certificate_number")
	private String birthCertificateNumber;
	
	@Column(name="birth_certificate_img")
	private UserImage birthCertificateImage;
	
	@Column(name="mnp_status")
	private String mnpStatus;
	
	@Column(name="mnp_req_number")
	private String mnpReqNumber;
	
	@Column(name="cell_id")
	private String cellId;
	
	@Column(name="latitude")
	private String latitude;
	
	@Column(name="longitude")
	private String longitude;
	
	/* this field contains value such as USSD, APP, WebPortal*/
	@Column(name="registered_mode")
	private String registeredMode;
	
	/*this field contains Kenya citizens, East African Nationals
	 and Foreigner*/
	@Enumerated(EnumType.STRING)
	@Column(name="subscriber_type")
	private SubscriberType subscriberType;
	
}
