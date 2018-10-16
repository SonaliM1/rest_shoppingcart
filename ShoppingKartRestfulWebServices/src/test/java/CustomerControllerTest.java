import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.doNothing;
import org.mockito.runners.MockitoJUnitRunner;

import com.restful.controller.CustomerController;
import com.restful.model.Customer;
import com.restful.serviceinterface.CustomerRestfulServiceInterface;

@RunWith(MockitoJUnitRunner.class)
public class CustomerControllerTest {
	
	
	@InjectMocks
	CustomerController customerController;
	
	@Mock
	CustomerRestfulServiceInterface customerRestfulServiceInterface;
	
	@Mock
	Customer customer;
	
	
	@Test
	public void shouldCreateCustomer(){
		when(customerRestfulServiceInterface.addCustomer(customer)).thenReturn(customer);
		customerController.createCustomer(customer);
		verify(customerRestfulServiceInterface).addCustomer(customer);
	}
	
	@Test
	public void shouldGetCustomerById() throws Exception{
		when(customerRestfulServiceInterface.findById(Mockito.anyInt())).thenReturn(customer);
		customerController.getCustomer(Mockito.anyInt());
		verify(customerRestfulServiceInterface).findById(Mockito.anyInt());
	}
	
	@Test
	public void shouldUpdateCustomer() throws Exception{
		when(customerRestfulServiceInterface.update(customer)).thenReturn(customer);
		customerController.updateCustomer(customer);
		verify(customerRestfulServiceInterface).update(customer);
	}
	 
	@Test
	public void shouldDeleteCustomer() throws Exception{
		doNothing().when(customerRestfulServiceInterface).delete(Mockito.anyInt());
		customerController.deleteCustomer(Mockito.anyInt());
		verify(customerRestfulServiceInterface).delete(Mockito.anyInt());
	}
	
	@Test
	public void shouldGetAllCustomer(){
		List<Customer> customerList=new ArrayList<>();
		when(customerRestfulServiceInterface.getAllCustomers()).thenReturn(customerList);
		customerController.getAllCustomers();
		verify(customerRestfulServiceInterface).getAllCustomers();
		
	}
	

}
