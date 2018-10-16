package com.restful.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.restful.model.Product;
import com.restful.serviceinterface.ProductRestfulServiceInterface;

@RestController
@CrossOrigin(origins="*")
public class ProductController {
	
	@Autowired
	private ProductRestfulServiceInterface productRestfulServiceInterface;
	
	
	@PostMapping(value="/products", consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Product createProduct(@RequestBody Product product){
		
		Product productObj = productRestfulServiceInterface.addproduct(product);
		return productObj;
	}  
	
	@GetMapping(value = "/product/{productId}",produces={"application/xml", "aplication/json"},headers = {"Accept=application/json"})
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody Product getProduct(@PathVariable Integer productId) throws Exception {
		System.out.println("finding product by id ");
		Product productObj = productRestfulServiceInterface.findById(productId);
		return productObj;
	}
	
	@PutMapping(value="/updateproduct",produces={"application/xml","application/json"},headers={"Accept=application/json"})
	@ResponseStatus(value=HttpStatus.OK)
	public @ResponseBody Product updateProduct(@RequestBody Product product){
		System.out.println("updating product");
		return productRestfulServiceInterface.updateProductById(product);
	}
		
	@DeleteMapping(value="/deleteproduct/{productId}",produces={"application/xml","application/json"},headers={"Accept=application/json"})
	@ResponseStatus(value=HttpStatus.OK)
	public @ResponseBody void deleteproduct(@PathVariable("productId") Integer productId) throws Exception{
		System.out.println("deleting product");
		 productRestfulServiceInterface.deleteProductById(productId);
	}
	
	
	@GetMapping(value = "/findallproducts",produces={"application/xml", "aplication/json"},headers = {"Accept=application/json"})
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody List<Product> getAllProduct()  {
		System.out.println("finding all product ");
		return productRestfulServiceInterface.findAllProduct();
	}

}
