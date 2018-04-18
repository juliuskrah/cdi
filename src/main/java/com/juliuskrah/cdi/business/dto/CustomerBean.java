package com.juliuskrah.cdi.business.dto;

import java.io.Serializable;
import java.util.UUID;

import javax.inject.Named;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.ws.rs.FormParam;

@Named("customer")
public class CustomerBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private UUID id;
	@NotNull
	@Size(min = 3, max = 100)
	@FormParam("firstName")
	private String firstName;
	@NotNull
	@Size(min = 3, max = 100)
	@FormParam("lastName")
	private String lastName;
	@Size(max = 25)
	@FormParam("middleInitial")
	private String middleInitial;
	@Size(max = 100)
	@FormParam("street")
	private String street;
	@Size(max = 100)
	@FormParam("city")
	private String city;
	@Size(max = 100)
	@FormParam("state")
	private String state;
	@FormParam("zip")
	private Integer zip;
	@Size(max = 10)
	@FormParam("telephone")
	private String telephone;
	@Size(max = 100)
	@FormParam("email")
	private String email;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
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

	public String getMiddleInitial() {
		return middleInitial;
	}

	public void setMiddleInitial(String middleInitial) {
		this.middleInitial = middleInitial;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getZip() {
		return zip;
	}

	public void setZip(Integer zip) {
		this.zip = zip;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "CustomerBean [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", middleInitial="
				+ middleInitial + ", street=" + street + ", city=" + city + ", state=" + state + ", zip=" + zip
				+ ", telephone=" + telephone + ", email=" + email + "]";
	}
}
