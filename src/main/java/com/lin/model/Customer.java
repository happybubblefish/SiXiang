package com.lin.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;

@Entity
public class Customer {

	@Id
	@GeneratedValue
	private Long id;
	
//	@NotEmpty
//	@Length(min = 3, max = 20)
	private String firstName;
	
//	@NotEmpty
//	@Length(min = 3, max = 20)
	private String lastName;
	
//	@NotEmpty
//	@Email
	private String email;
	
//	@NotEmpty
//	@Pattern(regexp = "[(][1-0]{3}[)][-][0-9]{3}[-][0-9]{4}", message = "Please enter the right format.")
	private String phone;
	
//	@NotEmpty
	private String address;
	
	private String pic;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="user_id") 
    @OrderColumn(name = "order_index")
	private List<OrderRecord> orders = new ArrayList<OrderRecord>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public List<OrderRecord> getOrders() {
		return orders;
	}

	public void setOrders(List<OrderRecord> orders) {
		this.orders = orders;
	}
}
