import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import org.mockito.runners.MockitoJUnitRunner;

import com.restful.dao.CustomerRestfulDao;
import com.restful.dao.ProductRestfulDao;
import com.restful.daointerface.OrderRestfulDaoInterface;
import com.restful.model.Customer;
import com.restful.model.Order;
import com.restful.model.Product;
import com.restful.service.OrderRestfulService;

@RunWith(MockitoJUnitRunner.class)
public class OrderRestfulServiceTest {
	
	@InjectMocks
	OrderRestfulService orderRestfulService;
	
	@Mock
	ProductRestfulDao productRestfulDao;
	
	@Mock
	CustomerRestfulDao customerRestfulDao;
	@Mock
	OrderRestfulDaoInterface orderRestfulDaoInterface;
	
	@Mock
	Order order;
	
	@Test
	public void shouldReturnWithCreateOrder() {
		
		Mockito.when(orderRestfulDaoInterface.createOrder(order)).thenReturn(order);
		orderRestfulService.createOrder(order);
		verify(orderRestfulDaoInterface).createOrder(order);
		
	}
	
	@Test
	public void shouldReturnupdateOrder() {
		
		Mockito.when(orderRestfulDaoInterface.updateOrder(order)).thenReturn(order);
		orderRestfulService.updateOrder(order);
		verify(orderRestfulDaoInterface).updateOrder(order);
		
	}
	
	@Test
	public void shouldReturnDeleteOrder(){
		Mockito.doNothing().when(orderRestfulDaoInterface).deleteOrder(Mockito.anyInt());;
		orderRestfulService.deleteOrder(Mockito.anyInt());
		verify(orderRestfulDaoInterface).deleteOrder(Mockito.anyInt());
	}
	
	@Test
	public void shouldReturnFindById(){
		Customer customer = new Customer();
		Product product = new Product();
		when(orderRestfulDaoInterface.findById(Mockito.anyInt())).thenReturn(order);
		when(customerRestfulDao.findById(order.getCustomerId())).thenReturn(customer);
		when(productRestfulDao.findById(order.getProductId())).thenReturn(product);
		Mockito.doNothing().when(order).setCustomer(customer);
		Mockito.doNothing().when(order).setProduct(product);
		
		orderRestfulService.findById(Mockito.anyInt());
		verify(orderRestfulDaoInterface).findById(Mockito.anyInt());
	} 

}
