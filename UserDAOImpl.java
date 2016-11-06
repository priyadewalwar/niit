package com.niit.shoppingcart.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.model.UserDetails;
import com.niit.shoppingcart.model.UserDetails;


@Repository("UserDAO")
public class UserDAOImpl implements UserDAO {
	  
		 
		@Autowired
		private SessionFactory sessionFactory;
		public UserDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
			} 
			
			

		@Transactional
		public List<UserDetails> list() {
			@SuppressWarnings("unchecked")
			List<UserDetails> list = (List<UserDetails>) sessionFactory.getCurrentSession()
					.createCriteria(UserDetails.class)
					.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

			return list;
		}

		@Transactional
		public void save(UserDetails userDetails) {
			sessionFactory.getCurrentSession().save(userDetails);
		}
		
		@Transactional
		public void delete(int id) {
			UserDetails userDetails = new UserDetails();
			userDetails.setId(id);
			sessionFactory.getCurrentSession().delete(userDetails);
		}

		@Transactional
		public UserDetails get(int id) {
			String hql = "from UserDetails where id=" + "'"+ id+"'";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			
			@SuppressWarnings("unchecked")
			List<UserDetails> list = (List<UserDetails>) query.list();
			
			if (list != null && !list.isEmpty()) {
				return list.get(0);
			}
			
			return null;
		}
		
		@Transactional
		public boolean isValidUserDetails(int id, String password) {
			String hql = "from UserDetails where id= '" + id + "' and " + " password ='" + password+"'";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			
			@SuppressWarnings("unchecked")
			List<UserDetails> list = (List<UserDetails>) query.list();
			
			if (list != null && !list.isEmpty()) {
				return true;
			}
			
			return false;
		}

		public void update(UserDetails userDetails) {
			sessionFactory.getCurrentSession().update(userDetails);
			
		}


	}
