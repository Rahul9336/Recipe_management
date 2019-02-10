package recipe_lab.dataAccessObject;

import java.util.List;

import recipe_lab.dto.Cuisine;
/*
 * Create Data Access Object for Cuisine Entity or Table
 * Check Implementation of Following Method in dataAccessObjectImpl.CuisineDaoImpl
 * */
public interface CuisineDao {
	public boolean add(Cuisine cuisine);  //method to add cuisine in Database

	public boolean update(Cuisine cuisine);  //update Existing Cuisine Detail

	public boolean delete(Cuisine cuisine);  //delete Cuisine from database
	
	public List<Cuisine> getCuisine();     //get List of Cuisine
	
	public List<Cuisine> getCuisineByname(String name); //List of Cuisine By name

}
