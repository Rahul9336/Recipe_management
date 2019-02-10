package recipe_lab;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.BeforeClass;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import recipe_lab.dataAccessObject.RecipeDao;
import recipe_lab.dataAccessObject.UserDao;
import recipe_lab.dto.Recipe;
import recipe_lab.dto.User;
/*
 * Class for testing Backend That every Method Working Properly
 * 
 * */
public class App 
{
	private static AnnotationConfigApplicationContext context;
	static UserDao userDao;
	static RecipeDao recipeDao;
	static User user;
	static Recipe recipe;
	@BeforeClass
	static public void init() { //Create Bean for Every Entity
		context = new AnnotationConfigApplicationContext();
		context.scan("recipe_lab");
		context.refresh();
		userDao=(UserDao) context.getBean("userDao");
		recipeDao=(RecipeDao) context.getBean("recipeDao");
	}
	//@Test
	public void testUser() { //Method to Check UserMethods
		user=new User();
		user.setName("Rahul Gupta");
		user.setEmail("rahulgupta9336@gmail.com");
		user.setContact("9560796526");
		user.setPassword("12345");
		user.setAddress("Delhi");
		assertEquals("Successfully Add Data in User Table", true, userDao.add(user));
	}
	//@Test //uncomment @Test Before Testing
	public void testrecipe() { //Method to check RecipeMethods
		recipe=new Recipe();
		recipe.setCook_time("30 min");
		recipe.setRecipe_name("Chiken kikka");
		recipe.setTaste("Tangy");
		recipe.setIngredients("Chicken 1/2 Kg, 1/2 Kg Onion");
		recipe.setCuisine("Indian");
		recipe.setMain_ingredients("chicken,onion");
		recipe.setRecipe_title("Chicken Fry Tikka");
		recipe.setServe("main course");
		recipe.setDetail("Hindi: murgh\r\n" + 
				"Be a kid or a teenage or an adult or an oldie, chicken lovers trend all over the world at all times! One meat that is a favourite of all beyond belief! When cooked, it can be presented in many guises. Sauté it, fry it, toss it, bake it, steam it – eat it the way you want to. Whatever its form may be upon being cooked, its flavour may change but its flesh remains high in protein, low in fat and can be digested easily.");
		recipe.setPrep_time("30 min");
		recipe.setAuthor_name("Rahul");
		recipe.setMethod("Step 1\r\n" + 
				"Marinate chicken pieces with red chilli paste, salt, ginger-garlic paste, yogurt, garam masala powder and juice of lemon and mix. Add 2 tbsps extra virgin olive oil and mix and marinate for a few hours in the refrigerator.\r\n" + 
				"Step 2\r\n" + 
				"Heat a non stick pan and pour orange juice into it. String the chicken pieces and capsicum pieces alternately onto skewers. Heat a non stick tawa, drizzle a little oil and place the skewers on it. Pack rice into a mould, unmould it on a serving plate and drizzle 1 tbsp extra virgin oil over it. Add salt, pepper powder and sugar to the orange juice and cook.\r\n" + 
				"Step 3\r\n" + 
				"Turn the skewers so that the chicken gets cooked evenly all around. When the sauce thickens a little, take it off the heat. Add butter and mix well. Place the skewers over the rice, drizzle the sauce over the chicken and rice and serve immediately. Use up the remaining chicken and rice similarly.");
		recipe.setUser_id(new Long(1));
		recipe.setNutiration_value("Calories : 460 Kcal\r\n" + 
				"Carbohydrates : 14.9 gm\r\n" + 
				"Protein : 19.2 gm\r\n" + 
				"Fat : 76.5 gm\r\n" + 
				"Other : 0");
		recipeDao.add(recipe);
		List<Recipe> l=recipeDao.recipeChangesYouMake(new Long(2));
		for(Recipe recipe:l) {
			System.out.println(recipe.getRecipe_name()+" "+"Date"+recipe.getDate()+" "+recipe.getRecipe_id()+" "+recipe.getRecipe_title()+" "+recipe.getAuthor_name()+" "+recipe.getIngredients()+" "+recipe.getMain_ingredients());
		}
	}
}
