import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.restful.dao.ProductRestfulDao;
import com.restful.model.Customer;
import com.restful.model.Product;

@RunWith(MockitoJUnitRunner.class)
public class ProductRestfulDaoTest {
	
	
	@InjectMocks
	ProductRestfulDao productRestfulDao;
	
	@Mock
	EntityManager entityManager;
	
	@Mock
	Product product;
	
	  @Mock
      TypedQuery<Product> query;
	  
	 /* @Mock
	  Query query;*/
	
	@Test
	public void shouldReturnProduct(){
		Mockito.doNothing().when(entityManager).persist(product);
		productRestfulDao.addproduct(product);
		verify(entityManager).persist(product);
	} 
	 
	@Test
	public void shouldReturnProductFindById(){
		when(entityManager.find(Product.class, 1)).thenReturn(product);
		productRestfulDao.findById(1);
		Mockito.verify(entityManager).find(Product.class, 1);
	}
	
	@Test
	public void shouldUpdateProductById(){
		  when(entityManager.find(Product.class, 0)).thenReturn(product);
		  when(entityManager.createQuery(Mockito.anyString())).thenReturn(query);
          when(query.executeUpdate()).thenReturn(1);
          productRestfulDao.updateProductById(product);
          
          verify(entityManager).find(Product.class, 0);
          verify(query).executeUpdate();
		 
	} 
	 
	@Test
	public void shouldReturndeleteProductById(){
		 when(entityManager.find(Product.class, 1)).thenReturn(product);
		  doNothing().when(entityManager).remove(product);
		  productRestfulDao.deleteProductById(1);
          
          verify(entityManager).find(Product.class, 1);
          verify(entityManager).remove(product);
	} 
	
/*	@Test
	public void shouldReturnAll(){
		Product product = new Product();
		product.setProductId(1);product.setProductName("mobile");
		List<Product> productList =new ArrayList<>();
		 productList.add(product);
		 when(entityManager.createQuery(Mockito.anyString(),Product.class)).thenReturn(Mockito.any(TypedQuery.class));
		 when(Mockito.any(TypedQuery.class).getResultList()).thenReturn(productList);
		 productRestfulDao.findAllProduct();
	}*/
	
 
}
