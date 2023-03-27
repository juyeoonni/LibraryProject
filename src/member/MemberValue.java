package member;

import java.time.LocalDate;
import java.util.*;

public class MemberValue {
	private String memberID;
    private String name;
    private int age;
    private String address;
    private String phoneNumber;
    private String dateOfBirth;
    private String dateOfMembership;
    
    public MemberValue() {
    	
    }
    
    
    public MemberValue(String memberID, String name, int age, String address, String phoneNumber, String dateOfBirth , String dateOfMembership) {
    	this.memberID = memberID;
    	this.name = name;
    	this.address = address;
    	this.age = age;
    	this.phoneNumber = phoneNumber;
    	this.dateOfBirth = dateOfBirth;
    	this.dateOfMembership = dateOfMembership;
    }
    
    public void addMember(String name, String memberID, String address, String phoneNumber,  String dateOfBirth , String dateOfMembership) {
    	this.name = name;
    	this.memberID = memberID;
    	this.address = address;
    	this.phoneNumber = phoneNumber;
    	this.dateOfBirth = dateOfBirth;
    	this.dateOfMembership = dateOfMembership;
    }

    public String getMemberID() {
		return memberID;
	}

	public void setMemberID(String i) {
		this.memberID = i;
	}

    
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getDateOfMembership() {
		return dateOfMembership;
	}

	public void setDateOfMembership(String dateOfMembership) {
		this.dateOfMembership = dateOfMembership;
	}
	
	
	
	
//	public void checkMember(List<MemberValue> memberlist) {
//		for (int i = 0; i < memberlist.size(); i++) {
//			System.out.println(memberlist.get(i));
//		}
//	}
	

	@Override
	public String toString() {
		return "MemberValue [memberID=" + memberID + ", name=" + name + ", age=" + age + ", address=" + address
				+ ", phoneNumber=" + phoneNumber + ", dateOfBirth=" + dateOfBirth + ", dateOfMembership="
				+ dateOfMembership + "]";
	}
	
	

	
	

	
		
		
}

