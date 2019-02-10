package recipe_lab.dataAccessObject;

import java.util.List;

import recipe_lab.dto.Recipe;
/*
 * Create Data Access Object for Recipe Entity or Table
 * Check Implementation of Following Method in dataAccessObjectImpl.RecipeDaoImpl
 * */
public interface RecipeDao {
	public boolean add(Recipe recipe);   //Add Recipe Detail into Database

	public boolean update(Recipe recipe);  //Update Recipe Detail in Database

	public boolean delete(Recipe Recipe);   //Delete Recipe Detail From Database

	public Recipe getRecipeById(Long recipe_id);  //Retrive Recipe Detail By their Id 
	
	public List <Recipe> getRecipeByUserId(Long user_id); //List Of Recipe Detail for Particular user

	public List <Recipe> searchRecipe(String search);  //Search Recipe By their Name And Ingredients
	
	public List <Recipe> recipelist();     //Get List of  All Recipe  From database
	
	public List <Recipe> homepageRandomly();  //This Method get Randomly 9 Recipe from database for HomePage So User Get Different Recipe Each Time 
	
	public List <Recipe> recipeChangesYouMake(Long Id); //Retrive Edit  History  of Recipe When Recipe Get Edit and Edited Recipe As well
	
	public List <Recipe> ForUserSortByName(Long Id);  //Sort the recipe By name
	
	public List <Recipe> ForUserSortByIngredients(Long Id); //Sort the recipe By Ingredients
	
	public List <Recipe> ForSortByDate(Long Id); //Sort the Recipe By Date Of Created
}
