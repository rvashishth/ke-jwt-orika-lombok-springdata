package com.us.app.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;

import com.us.app.constants.SubscriberIDType;
import com.us.app.constants.SubscriberType;

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
@Getter @Setter @ToString @NoArgsConstructor
@EqualsAndHashCode(callSuper=false, of={"id","idNumber","msisdn"})
public class SubscriberModel implements Serializable{

	private static final long serialVersionUID = 6714239176939272344L;

	private boolean isNew;
	
	private long id;
	
	private SubscriberIDType idType;
	
	/* max 10 msisdn can be issued against one id */
	private String idNumber;
	
	private String msisdn;
	
	private String simSerialNumber;
	
	private String firstName;
	
	private String lastName;
	
	private Date dob;
	
	private String gender;

	private String county;
	
	private String physicalAddress;
	
	private String postalAddress;
	
	private boolean createAmAccount;
	
	private String occupation;
	
	private boolean minor;
	
	private String birthCertificateNumber;

	private String mnpStatus;
	
	private String mnpReqNumber;
	
	private String cellId;
	
	private String latitude;
	
	private String longitude;
	
	/* this field contains value such as USSD, APP, WebPortal*/
	private String registeredMode;
	
	/*this field contains Kenya citizens, East African Nationals
	 and Foreigner*/
	private SubscriberType subscriberType;
}
