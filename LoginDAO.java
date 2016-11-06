package com.niit.shoppingcart.dao;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.model.User;
@Repository
public interface LoginDAO
{
public List<User> list();
	
	public User get(int id);
	
	public User getSingleUser(int id);
	
	public void save(User user);
	
	public void update(User user);
	
	public List getAllUsers();
	
	public void delete(int id);
}

	
	
	

