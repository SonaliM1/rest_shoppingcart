import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;

import org.mockito.runners.MockitoJUnitRunner;

import com.restful.controller.ProductController;
import com.restful.model.Product;
import com.restful.serviceinterface.ProductRestfulServiceInterface;

@RunWith(MockitoJUnitRunner.class)
public class ProductControllerTest {
	
	@InjectMocks
	ProductController productController;
	
	@Mock
	ProductRestfulServiceInterface productRestfulServiceInterface;
	
	@Mock
	Product product;
  
	@Test
	public void shouldCreateProduct() {
		Product product = new Product(); 
		when(productRestfulServiceInterface.addproduct(product)).thenReturn(product);
		productController.createProduct(product);
		verify(productRestfulServiceInterface).addproduct(product);
	}
	
	@Test
	public void shouldReturnById() throws Exception{
		when(productRestfulServiceInterface.findById(Mockito.anyInt())).thenReturn(product);
		productController.getProduct(Mockito.anyInt());
		verify(productRestfulServiceInterface).findById(Mockito.anyInt());
	}
	
	@Test
	public void shouldUpdate(){
		when(productRestfulServiceInterface.updateProductById(product)).thenReturn(product);
		productController.updateProduct(product);
		verify(productRestfulServiceInterface).updateProductById(product);
		
	}
	
	@Test
	public void shouldDelete() throws Exception {
		Mockito.doNothing().when(productRestfulServiceInterface).deleteProductById(Mockito.anyInt());
		productController.deleteproduct(Mockito.anyInt());
		verify(productRestfulServiceInterface).deleteProductById(Mockito.anyInt());
	}
	
	@Test
	public void shouldFetchAllProducts(){
		
		List<Product> productList = new ArrayList<>();
		when(productRestfulServiceInterface.findAllProduct()).thenReturn(productList);
		productController.getAllProduct();
		verify(productRestfulServiceInterface).findAllProduct();
	}
 
}
