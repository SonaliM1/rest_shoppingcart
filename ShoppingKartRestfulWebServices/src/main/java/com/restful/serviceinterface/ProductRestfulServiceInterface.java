package com.restful.serviceinterface;

import java.util.List;

import com.restful.model.Product;

public interface ProductRestfulServiceInterface {

	

	Product addproduct(Product product);

	Product findById(Integer productId);

	Product updateProductById(Product product);

	void deleteProductById(Integer productId);

	List<Product> findAllProduct();

	

	

	



}
