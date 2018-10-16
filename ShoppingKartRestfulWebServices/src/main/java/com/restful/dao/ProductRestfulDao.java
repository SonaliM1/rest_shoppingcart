package com.restful.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.restful.daointerface.ProductRestfulDaoInterface;
import com.restful.model.Customer;
import com.restful.model.Product;

@Repository
public class ProductRestfulDao implements ProductRestfulDaoInterface {
	
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public Product addproduct(Product product) {
		// TODO Auto-generated method stub
		entityManager.persist(product);
		return product;
	}
  
	@Override
	public Product findById(Integer productId) {
		// TODO Auto-generated method stub
		System.out.println("find by id product..");
		
		return (Product) entityManager.find(Product.class, productId);
	}

	@Override
	public Product updateProductById(Product product) {
		// TODO Auto-generated method stub
		
		Product newProductObj = findById(product.getProductId());
		
		if(newProductObj != null)
		{
			
			Query query= entityManager.createQuery("update Product set productName= '"+product.getProductName()+"' , productPrice='"+product.getProductPrice()+"' , productQuantity = '"+product.getProductQuantity()+"' where productId='"+product.getProductId()+"' ");
			query.executeUpdate();
		}
		
		return product;
		
	}
 
	@Override
	public void deleteProductById(Integer productId) {
		// TODO Auto-generated method stub
		
		Product productObj = findById(productId);
		if(productObj != null)
		{
			entityManager.remove(productObj);
		}
	} 
  
	@Override
	public List<Product> findAllProduct() {
		// TODO Auto-generated method stub
		Query query = entityManager.createQuery("FROM Product",Product.class);
		System.out.println(query);
		List<Product> productList= query.getResultList();
		
		return productList;
	} 
	 
  
} 
