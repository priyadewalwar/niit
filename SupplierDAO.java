package com.niit.shoppingcart.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.model.Supplier;

@Repository
public interface SupplierDAO {

public List<Supplier> list();
	
	public Supplier get(int id);
	
	public List getAllSuppliers();
	
	public Supplier getSingleSupplier(int id);
	
	public void update(Supplier supplier);
	
	public void saveOrUpdate(Supplier supplier);
	
	public void delete(int id);
	
	

}
