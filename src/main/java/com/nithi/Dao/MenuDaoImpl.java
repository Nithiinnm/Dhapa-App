package com.nithi.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nithi.entity.Menu;
import com.nithi.entity.MenuDetail;

@Repository
@PropertySource(value = "classpath:sqlQueries.xml")
public class MenuDaoImpl implements MenuDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private Environment env;
	
	@Override
	public List<Menu> getMenuItem() {
		System.out.println("Welcome getMenuItem");
		Session session = sessionFactory.openSession();
		Query<Menu> Query = session.createQuery("from Menu", Menu.class);
		System.out.println("Query :"+Query);
		List<Menu> resultList = Query.getResultList();
		return resultList;
	}

	@Override
	@Transactional
	public void saveMenuItems(Menu menu) {

		System.out.println("Menu in DaoImp :"+menu);
		Session session = sessionFactory.getCurrentSession();
	//	MenuDetail menuDetails = menu.getMenuDetails();
	//	session.saveOrUpdate(menuDetails);
		session.saveOrUpdate(menu);
		System.out.println("Menu items Added..");
		
	}

	@Override
	@Transactional
	public void deleteItem(int id) {
		
		System.out.println("Id in DAO IMPL :" + id);
		Session session = sessionFactory.getCurrentSession();
	//	Menu menuobj = session.get(Menu.class, id);
	//	System.out.println("MenuObj :" + menuobj);
	//	session.delete(menuobj);
		

	//	Query deleteQuery = session.createQuery("delete from Menu where id=:deteleitem");
	//	deleteQuery.setParameter("deteleitem", id);
	//	deleteQuery.executeUpdate();
		
		int executeUpdate = session.createQuery("delete from Menu where id="+id).executeUpdate();
		System.out.println("Deleted Id :"+executeUpdate);
		System.out.println("Menu items Added..");
		
	}

	@Override
	@Transactional
	public Menu getMenuById(int id) {
		// TODO Auto-generated method stub
		
	Session session =	sessionFactory.getCurrentSession();
	Menu menu = session.get(Menu.class, id);
	System.out.println("menuDaoImpl :"+menu);
		return menu;
	}

	@Override
	@Transactional
	public List<Menu> searchItem(String itemNameee) {
		
		System.out.println("Welcome to Search item in DAO IMPL  :" + itemNameee);
		String formquery = env.getProperty("searchQuery");
		System.out.println("XML Query :"+formquery);

		Session session = sessionFactory.getCurrentSession();
		Query<Menu> query = null;
		if (itemNameee != null && itemNameee.trim().length() > 0) {
			System.out.println("Inside If Loop");
			//query = session.createQuery("from Menu where itemName like :someItemName", Menu.class);
			query=	session.createQuery(formquery);
			query.setParameter("someItemName", "%" + itemNameee + "%");
		}
		else {
			System.out.println("Inside Else");
			query = session.createQuery("from Menu", Menu.class);
		}
		List<Menu> resultList = query.getResultList();
		return resultList;
	}

}
