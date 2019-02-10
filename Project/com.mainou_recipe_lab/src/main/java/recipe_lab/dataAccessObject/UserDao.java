package recipe_lab.dataAccessObject;

import java.util.List;

import recipe_lab.dto.User;
/*
 * Create Data Access Object for Recipe Entity or Table
 * Check Implementation of Following Method in dataAccessObjectImpl.UserDaoImpl
 * */
public interface UserDao {
	
	public User getUserByUsername(String email);  //Get User Detail Data BY their Email

	public boolean add(User user);	//Add User Detail Into Database

	public boolean update(User user); //Update User Detail In Database

	public boolean delete(String email); //Delete User Detail From Database

	public User getUserById(Long user_id); // Get User Detail From Database By User Id;

	public boolean getuserByemailAndPassword(String email, String password); //Get User Detail From Database By their Email Id And Password
	
	public List <User> userslist(); //Get list Of Active User Of Website
	
	public boolean getuserByemailAndPasswordadmin(String email, String password); //Admin Verification


}
