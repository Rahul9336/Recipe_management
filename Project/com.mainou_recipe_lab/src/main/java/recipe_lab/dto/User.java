package recipe_lab.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity  //Create User Object and Save the Object in Database Using Serializabe Class to Avoid and prevent from any error
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long user_id;
	
	@NotBlank(message="Error! Name cannot be Blank")
	private String name;
	
	@Column(unique = true)
	private String email;
	
	@NotBlank(message="Error! password cannot be Blank")
	private String password;
	
	@NotBlank(message="Error! Address cannot be Blank")
	private String address;
	
	@NotBlank(message = "error! Please enter contact number!")
	@Size(max=10,message="Mobile No upto 10 digit")
	private String contact;
	
	private String role = "ROLE_CUSTOMER"; //Set role variable by default Role_customer Prevent from error and Admin can be only Assign by Database Admin
	
	private boolean enabled = true; //admin can block any user to access the website if this is false
	
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", address=" + address + ", contact=" + contact + ", role=" + role + ", enabled=" + enabled + "]";
	}
}
