package recipe_lab.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Type;
import org.hibernate.envers.Audited;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;
/*
 * For Creation of Recipe Table With Following Attribute
 * 
 * 
 * */
@Entity
@Table(name = "Recipe", uniqueConstraints = { @UniqueConstraint(columnNames = {  "recipe_title" }) })
@Audited
public class Recipe implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long recipe_id; //Recipe Id which Is Primary Key
	
	@NotBlank(message = "You must Login Before adding")
	private String author_name; 
	
	private Long user_id;
	
	private String recipe_name;
	
	@Transient
	@JsonIgnore
	CamelCaseString camelCaseConversion = new CamelCaseString();

	private String productImg_url;

	@Transient
	@JsonIgnore
	MultipartFile file;

	@NotBlank(message = "Error! Title cannot be Blank")
	private String recipe_title;

	private String main_ingredients;

	private String cuisine;

	private String course;
	
	@Column(columnDefinition = "text")
	@Type(type = "text")
	private String user_rating;
	
	@Column(columnDefinition = "text")
	@Type(type = "text")
	private String detail;

	private String prep_time;

	private String cook_time;

	private String serve;

	private String level_of_cooking;

	private String taste;

	private Date date;
	
	@Column(columnDefinition = "text")
	@Type(type = "text")
	private String ingredients;
	
	@NotBlank(message = "Error! Please Provide Proper Method Of cooking")
	@Column(columnDefinition = "text")
	@Type(type = "text")
	private String method;
	
	@Column(columnDefinition = "text")
	@Type(type = "text")
	private String nutiration_value;
	

	public Long getRecipe_id() {
		return recipe_id;
	}

	public void setRecipe_id(Long recipe_id) {
		this.recipe_id = recipe_id;
	}

	public String getRecipe_name() {
		return recipe_name;
	}

	public void setRecipe_name(String recipe_name) {
		this.recipe_name = camelCaseConversion.toCamelCase(recipe_name);
	}

	public String getRecipe_title() {
		return camelCaseConversion.toCamelCase(recipe_title);
	}

	public void setRecipe_title(String recipe_title) {
		this.recipe_title = recipe_title;
	}

	public String getMain_ingredients() {
		return main_ingredients;
	}

	public void setMain_ingredients(String main_ingredients) {
		this.main_ingredients = main_ingredients;
	}

	public String getCuisine() {
		return camelCaseConversion.toCamelCase(cuisine);
	}

	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}

	public String getCourse() {
		return camelCaseConversion.toCamelCase(course);
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getUser_rating() {
		return user_rating;
	}

	public void setUser_rating(String user_rating) {
		this.user_rating = user_rating;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getPrep_time() {
		return prep_time;
	}

	public void setPrep_time(String prep_time) {
		this.prep_time = prep_time;
	}

	public String getCook_time() {
		return cook_time;
	}

	public void setCook_time(String cook_time) {
		this.cook_time = cook_time;
	}

	public String getServe() {
		return serve;
	}

	public void setServe(String serve) {
		this.serve = serve;
	}

	public String getLevel_of_cooking() {
		return level_of_cooking;
	}

	public void setLevel_of_cooking(String level_of_cooking) {
		this.level_of_cooking = level_of_cooking;
	}

	public String getTaste() {
		return taste;
	}

	public void setTaste(String taste) {
		this.taste = taste;
	}

	public String getMethod() {
		return method;
	}

	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public String getProductImg_url() {
		return productImg_url;
	}

	public void setProductImg_url(String productImg_url) {
		this.productImg_url = productImg_url;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public String getAuthor_name() {
		return camelCaseConversion.toCamelCase(author_name);
	}

	public void setAuthor_name(String author_name) {
		this.author_name = author_name;
	}

	
	public String getNutiration_value() {
		return nutiration_value;
	}

	public void setNutiration_value(String nutiration_value) {
		this.nutiration_value = nutiration_value;
	}

	@Override
	public String toString() {
		return "Recipe [recipe_id=" + recipe_id + ", author_name=" + author_name + ", user_id=" + user_id
				+ ", recipe_name=" + recipe_name + ", camelCaseConversion=" + camelCaseConversion + ", productImg_url="
				+ productImg_url + ", file=" + file + ", recipe_title=" + recipe_title + ", main_ingredients="
				+ main_ingredients + ", cuisine=" + cuisine + ", course=" + course + ", user_rating=" + user_rating
				+ ", detail=" + detail + ", prep_time=" + prep_time + ", cook_time=" + cook_time + ", serve=" + serve
				+ ", level_of_cooking=" + level_of_cooking + ", taste=" + taste + ", date=" + date + ", ingredients="
				+ ingredients + ", method=" + method + ", nutiration_value=" + nutiration_value + "]";
	}



}
