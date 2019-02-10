package recipe_lab.dataAccessObjectImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.hibernate.envers.query.AuditEntity;
import org.hibernate.envers.query.AuditQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import recipe_lab.dataAccessObject.RecipeDao;
import recipe_lab.dto.Recipe;
@Repository("recipeDao")
@Transactional
public class RecipeDaoImpl implements RecipeDao {

	@Autowired(required = true)
	private SessionFactory sessionFactory;
	@PersistenceContext 
	private EntityManager emf;
	@Override
	public boolean add(Recipe recipe) {
		try {
			sessionFactory.getCurrentSession().persist(recipe);
			return true;
			}catch(Exception msg) {
				msg.printStackTrace();
				System.out.println("Something error occured during Add "+msg);
				return false;
			}
	}

	@Override
	public boolean update(Recipe recipe) {
		try {
			sessionFactory.getCurrentSession().update(recipe);
			return true;
		}catch(Exception msg) {
			msg.printStackTrace();
			System.out.println("Something error occured during Update "+msg);
			return false;
		}
	}

	@Override
	public boolean delete(Recipe Recipe) {
		try {
				sessionFactory.getCurrentSession().delete(Recipe);
				 return true;}
				catch(Exception msg) {
					System.out.println("Something Went Wrong During deletion of object"+msg);
					return false;
				}
	}

	@Override
	public Recipe getRecipeById(Long recipe_id) {
		return sessionFactory.getCurrentSession().get(Recipe.class, Long.valueOf(recipe_id));
	}

	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Recipe> searchRecipe(String search) {
		String command="from Recipe where recipe_name like:name or ingredients like:ingredient";
		Query query=sessionFactory.getCurrentSession().createQuery(command);
		query.setParameter("name","%"+ search+ "%");
		query.setParameter("ingredient","%"+ search.toUpperCase()+ "%");
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Recipe> recipelist() {
		String command="from Recipe";
		@SuppressWarnings("rawtypes")
		Query query=sessionFactory.getCurrentSession().createQuery(command);
		return query.getResultList();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Recipe> getRecipeByUserId(Long user_id) {
		String command="from Recipe where user_id=:parameter";
		Query query=sessionFactory.getCurrentSession().createQuery(command);
		query.setParameter("parameter",user_id);
		return query.getResultList();
	}

	@SuppressWarnings({ "rawtypes", "deprecation", "unchecked" })
	@Override
	public List<Recipe> homepageRandomly() {
		Session session = sessionFactory.openSession();
		Criteria cr = session.createCriteria(Recipe.class);
		cr.add(Restrictions.sqlRestriction("1=1 order by rand()"));
		cr.setMaxResults(9);
		List results = cr.list();
		return results;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Recipe> recipeChangesYouMake(Long Id) {
		
		EntityManager entityManager=emf.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		AuditReader auditReader = AuditReaderFactory.get(entityManager);
		AuditQuery q = auditReader.createQuery().forRevisionsOfEntity(Recipe.class, true,true);
		q.add(AuditEntity.id().eq(Id));
		return q.getResultList();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Recipe> ForUserSortByName(Long Id) {
		String command="from Recipe  recipe where recipe.user_id=:Id Order BY recipe.recipe_name";
		Query query=sessionFactory.getCurrentSession().createQuery(command);
		query.setParameter("Id",Id);
		return query.getResultList();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Recipe> ForUserSortByIngredients(Long Id) {
		String command="from Recipe  recipe where recipe.user_id=:Id Order BY recipe.ingredients";
		Query query=sessionFactory.getCurrentSession().createQuery(command);
		query.setParameter("Id",Id);
		return query.getResultList();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Recipe> ForSortByDate(Long Id) {
		String command="from Recipe  recipe where recipe.user_id=:Id Order BY recipe.date";
		Query query=sessionFactory.getCurrentSession().createQuery(command);
		query.setParameter("Id",Id);
		return query.getResultList();
	}

}
