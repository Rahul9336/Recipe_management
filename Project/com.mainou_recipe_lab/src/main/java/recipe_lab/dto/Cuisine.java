package recipe_lab.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotBlank;
/*
 * for Creation of Table Cusine With Following Attribute
 * 
 * */
@Entity
public class Cuisine implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long cuisine_id;
	@NotBlank(message="Cuisine Name Can not be Blank")
	private String cuisine_name;
	
	private String cuisine_detail;

	public Long getCuisine_id() {
		return cuisine_id;
	}

	public void setCuisine_id(Long cuisine_id) {
		this.cuisine_id = cuisine_id;
	}

	public String getCuisine_name() {
		return cuisine_name;
	}

	public void setCuisine_name(String cuisine_name) {
		this.cuisine_name = cuisine_name;
	}

	public String getCuisine_detail() {
		return cuisine_detail;
	}

	public void setCuisine_detail(String cuisine_detail) {
		this.cuisine_detail = cuisine_detail;
	}

	@Override
	public String toString() {
		return "Cuisine [cuisine_id=" + cuisine_id + ", cuisine_name=" + cuisine_name + ", cuisine_detail="
				+ cuisine_detail + "]";
	}
	
	
	
}
