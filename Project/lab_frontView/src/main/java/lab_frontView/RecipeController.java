package lab_frontView;

import java.io.File;
import java.security.Principal;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import recipe_lab.dataAccessObject.CuisineDao;
import recipe_lab.dataAccessObject.RecipeDao;
import recipe_lab.dataAccessObject.UserDao;
import recipe_lab.dto.Recipe;
import recipe_lab.dto.User;

@Controller
public class RecipeController {

	@Autowired
	HttpServletRequest request;
	@Autowired
	RecipeDao recipeDao;
	@Autowired
	CuisineDao cuisineDao;
	@Autowired
	UserDao userDao;
	User user;
	Recipe recipe;
	
	@RequestMapping(value="/user/addRecipeSuccess")
	public ModelAndView AddRecipeToBook(@Valid @ModelAttribute("recipe") Recipe recipe, BindingResult result,
			Map<String, Object> map, Map<String, String> message,Principal principal) {
		recipe.setDate(new Date());
		if (result.hasErrors()) {
			ModelAndView model = new ModelAndView("user/Recipe");
			map.put("cuisine", cuisineDao.getCuisine());
			try {
			map.put("user", userDao.getUserByUsername(principal.getName()));
			}catch(Exception ex){
				
			}
			return model;
		}else if (!(recipe.getFile().getOriginalFilename().equals(""))) {			//get image file from jsp page and store into database
			recipe.setProductImg_url(uploadImage(recipe.getFile(), recipe)); //and overwrite the file name with recipe name
		}
		ModelAndView model = new ModelAndView("user/Recipe");
		System.out.println("Image uploaded");
		recipeDao.add(recipe);
		message.put("message", "Your Recipe Added To Your Recipe Book");
		map.put("cuisine", cuisineDao.getCuisine());
		map.put("user", userDao.getUserByUsername(principal.getName()));
		return model;
	}
	//supprotive method for get file from device and save it to the project folder
	//file handling method
	public String uploadImage(MultipartFile multipart, Recipe recipe) {
		System.out.println("MultiPart1");
		String folderToUpload = "/resources/images/";
		String fileName = multipart.getOriginalFilename();
		System.out.println("MultiPart2");
		//String realPath = "C://Eclipse2//lab_frontView//src//main//webapp//resources//images//recipe_images";";
		String realPath="C://Eclipse2//lab_frontView//src//main//webapp//resources//images//recipe_images"; // website running on localhost so the file will be tranfer to 
		//to local project folder change the path according to Your local machine.
		System.out.println(realPath);
		if (!new File(realPath).exists()) {
			System.out.println("MultiPart4");
			new File(realPath).mkdirs();
		}
		System.out.println("MultiPart5");
		String filePath = realPath+"/"+ recipe.getRecipe_name() + ".jpg";
		File destination = new File(filePath);
		try {
			System.out.println("MultiPart6");
			multipart.transferTo(destination);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(fileName);
		System.out.println(folderToUpload);
		System.out.println(destination);
		return fileName;
	}
	
	@RequestMapping(value="/admin/recipelist", method = RequestMethod.GET)
	public ModelAndView recipelist(Map<String, Object> list,Principal principal) {
		ModelAndView model = new ModelAndView("RecipeList");
		try {
			if(principal.getName()!=null) 
			{
				user=userDao.getUserByUsername(principal.getName());
				list.put("user", user);
				list.put("username", user);
			}
			}catch(Exception ex){ }
		list.put("recipelist", recipeDao.recipelist());
		list.put("cuisine", cuisineDao.getCuisine());
		return model;
	}
	
	@RequestMapping(value="/user/myrecipe")
	public ModelAndView myRecipe(Map<String,Object>list,Principal principal) {
		if(principal.getName().isEmpty()) {
			return new ModelAndView("signup");
			
		}
		else {
		ModelAndView model=new ModelAndView("user/myRecipe");
		String email=principal.getName();
		user=userDao.getUserByUsername(email);
		list.put("myRecipe",recipeDao.getRecipeByUserId(user.getUser_id()) );
		list.put("cuisine", cuisineDao.getCuisine());
		list.put("user", user);
		return model;
	}
}
	@RequestMapping(value="/user/editRecipe")
	public ModelAndView editRecip(@Valid @ModelAttribute Recipe recipe, BindingResult result,
			@RequestParam(value = "action") String action,
			Map<String,Object>map,Map<String,String>message,Principal principal) {
		recipe.setDate(new Date());
		String update="UPDATE";
				user=userDao.getUserByUsername(principal.getName());
				map.put("user", user);
				map.put("username", user);
		if(result.hasErrors()) {
			ModelAndView model1 = new ModelAndView("user/recipeEdit");
			return model1;
		}
		else
		{
		if (action.equalsIgnoreCase(update)) {
			if (!(recipe.getFile().getOriginalFilename().equals(""))) {
				recipe.setProductImg_url(uploadImage(recipe.getFile(), recipe));
			}
				recipeDao.update(recipe);
				ModelAndView model1 = new ModelAndView("user/myRecipe");
				message.put("message", "Update Success");
				String email=principal.getName();
				user=userDao.getUserByUsername(email);
				map.put("myRecipe",recipeDao.getRecipeByUserId(user.getUser_id()) );
				map.put("cuisine", cuisineDao.getCuisine());
				return model1;
			}else {
				message.put("message", "Something Error occured During update");
				ModelAndView model1 = new ModelAndView("user/myRecipe");
				return model1;
			}
	}
	}
	@RequestMapping(value = "/user/recipeEditorDelete/{id}", method = RequestMethod.GET)
	public ModelAndView productAddSuccess(@RequestParam(value = "action") String action,
			@PathVariable(value = "id") Long id, Map<String, Object> map,Map<String, String> message,Principal principal) {
		String edit = "EDIT";
		String delete = "DELETE";
		if (action.equalsIgnoreCase(edit)) {
			recipe=recipeDao.getRecipeById(id);
			map.put("recipe", recipe);
			map.put("user", userDao.getUserByUsername(principal.getName()));
			ModelAndView model1 = new ModelAndView("user/recipeEdit");
			return model1;
		} else {
			if (action.equalsIgnoreCase(delete)) {
				recipe = recipeDao.getRecipeById(id);
				recipeDao.delete(recipe);
				ModelAndView model1 = new ModelAndView("user/myRecipe");
				message.put("message", "Delete Success");
				map.put("user", userDao.getUserByUsername(principal.getName()));
				return model1;
			}  else {
					ModelAndView model1 = new ModelAndView("Home");
					return model1;
				}
			}
		}

}
