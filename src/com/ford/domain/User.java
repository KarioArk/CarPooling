package com.ford.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {

	private String gender;
    private String cdsid;
    private String mobileNumber;
    
    public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCdsid() {
		return cdsid;
	}
	public void setCdsid(String cdsid) {
		this.cdsid = cdsid;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
}