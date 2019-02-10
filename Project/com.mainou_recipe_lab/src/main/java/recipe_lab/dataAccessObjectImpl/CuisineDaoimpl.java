package recipe_lab.dataAccessObjectImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import recipe_lab.dataAccessObject.CuisineDao;
import recipe_lab.dto.Cuisine;
@Repository("cuisineDao")
@Transactional
public class CuisineDaoimpl implements CuisineDao {

	@Autowired(required = true)
	private SessionFactory sessionFactory;
	
	//Method for Add Cuisine In Database
	@Override
	public boolean add(Cuisine cuisine) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(cuisine); 
			return true;
			}catch(Exception msg) {
				msg.printStackTrace();
				System.out.println("Something error occured during Add "+msg);
				return false;
			}
	}
	//Method For Update Cuisine
	@Override
	public boolean update(Cuisine cuisine) {
		try {
			sessionFactory.getCurrentSession().update(cuisine);
			return true;
		}catch(Exception msg) {
			msg.printStackTrace();
			System.out.println("Something error occured during Update "+msg);
			return false;
		}
	}

	@Override
	public boolean delete(Cuisine cuisine) {
		try {
			sessionFactory.getCurrentSession().delete(cuisine);
			 return true;}
			catch(Exception msg) {
				System.out.println("Something Went Wrong During deletion of object"+msg);
				return false;
			}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cuisine> getCuisine() {
		String command="from Cuisine";
		@SuppressWarnings("rawtypes")
		Query query=sessionFactory.getCurrentSession().createQuery(command);
		return query.getResultList();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Cuisine> getCuisineByname(String name) {
		String command="from Cuisine where cuisine_name=:name";
		Query query=sessionFactory.getCurrentSession().createQuery(command);
		query.setParameter("name",name);
		return query.getResultList();
	}

}
