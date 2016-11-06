package com.niit.shoppingcart.dao;

import java.util.List;


import com.niit.shoppingcart.model.UserDetails;

public interface UserDAO {

	public List<UserDetails> list();
	
	
	public UserDetails get(int id);
	
	
	public void save(UserDetails userDetails);
	
	public void update(UserDetails userDetails);
	
	public void delete(int id);
	
	
}
