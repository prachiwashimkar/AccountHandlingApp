package com.example.AccountHandlingApp.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Customer {
	
	@Id
	@SequenceGenerator(name="custIdGenerator", initialValue=1, allocationSize=1000)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="custIdGenerator")
	private Integer customerId;
	
	@NotEmpty
	private String firstName;

	@NotEmpty
	private String lastName;
	
	@NotEmpty
	private String address;
	
	@NotNull
	private Long phoneNumber;
	
	@NotNull
	private Long amount;
	
	public Customer() {
		
	}
	
	public Customer(Integer customerId, String firstName, String lastName, String address, Long phoneNumber,
			Long amount) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.amount = amount;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
}
