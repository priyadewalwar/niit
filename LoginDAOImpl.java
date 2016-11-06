package com.niit.shoppingcart.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.model.Product;
import com.niit.shoppingcart.model.User;

@Repository("loginDAO")
public class LoginDAOImpl implements LoginDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public LoginDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void save(User user) {
		sessionFactory.getCurrentSession().save(user);

	}

	@Transactional
	public void update(User user) {
		sessionFactory.getCurrentSession().update(user);

	}

	@Transactional
	public void delete(int id) {
		User UserToDelete = new User();
		UserToDelete.setId(id);
		sessionFactory.getCurrentSession().delete(UserToDelete);
	}

	@Transactional
	public List getAllUsers() {
		Session session=sessionFactory.openSession();
		List listuser=session.createQuery("from User").list();
		session.close();
		return listuser;
		}


	@Transactional
	public User get(int id) {
		// sessionFactory.getCurrentSession().get(User.class,id);
		String hql = "from User where Id=" + "'" + id + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<User> listUser = query.list();
		if (listUser != null && !listUser.isEmpty()) {
			return listUser.get(0);
		}
		return null;
	}
	@Transactional
	public User getSingleUser(int id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		User user=(User)session.load(User.class, id);
		return user;
		}
	@Transactional
	public List<User> list() {
		@SuppressWarnings("unchecked")
		List<User> list = (List<User>) sessionFactory.getCurrentSession()
				.createCriteria(User.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return list;
	}
}


