package com.restful.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restful.daointerface.ProductRestfulDaoInterface;
import com.restful.model.Product;
import com.restful.serviceinterface.ProductRestfulServiceInterface;

@Service
@Transactional
public class ProductRestfulService implements ProductRestfulServiceInterface {
	
	@Autowired
	private ProductRestfulDaoInterface productRestfulDaoInterface;

	@Override
	public Product addproduct(Product product) {
		// TODO Auto-generated method stub
		return productRestfulDaoInterface.addproduct(product);
	}

	@Override
	public Product findById(Integer productId) {
		// TODO Auto-generated method stub
		return productRestfulDaoInterface.findById(productId);
	}

	@Override
	public Product updateProductById(Product product) {
		// TODO Auto-generated method stub
		return productRestfulDaoInterface.updateProductById(product);
	}

	@Override
	public void deleteProductById(Integer productId) {
		// TODO Auto-generated method stub
		productRestfulDaoInterface.deleteProductById(productId);
	}

	@Override
	public List<Product> findAllProduct() {
		// TODO Auto-generated method stub
		return productRestfulDaoInterface.findAllProduct();
	}


	}

	

