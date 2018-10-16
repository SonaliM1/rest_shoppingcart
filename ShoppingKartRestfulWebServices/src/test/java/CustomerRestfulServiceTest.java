import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.doNothing;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.restful.daointerface.CustomerRestfulDaoInterface;
import com.restful.model.Customer;
import com.restful.service.CustomerRestfulService;

@RunWith(MockitoJUnitRunner.class)
public class CustomerRestfulServiceTest {
	
	@InjectMocks
	CustomerRestfulService customerRestfulService;
	
	@Mock
	CustomerRestfulDaoInterface  customerRestfulDaoInterface;
	
	@Mock
	Customer customer;
	  
	@Test
	public void shouldaddCustomer(){
		when(customerRestfulDaoInterface.addCustomer(customer)).thenReturn(customer);
		customerRestfulService.addCustomer(customer);
		verify(customerRestfulDaoInterface).addCustomer(customer);
	}
	
	@Test
	public void shouldfindById(){
		when(customerRestfulDaoInterface.findById(Mockito.anyInt())).thenReturn(customer);
		customerRestfulService.findById(Mockito.anyInt());
		verify(customerRestfulDaoInterface).findById(Mockito.anyInt());
	}
	
	@Test
	public void shouldDeleteCustomer(){
		Mockito.doNothing().when(customerRestfulDaoInterface).delete(Mockito.anyInt());
		customerRestfulService.delete(Mockito.anyInt());
		verify(customerRestfulDaoInterface).delete(Mockito.anyInt());
	}
	
	@Test
	public void shouldUpdateCustomer(){
		when(customerRestfulDaoInterface.update(customer)).thenReturn(customer);
		customerRestfulService.update(customer);
		verify(customerRestfulDaoInterface).update(customer);
	}
	 
	@Test
	public void shouldgetAllCustomers(){
		List<Customer> customerList = new ArrayList<>();
		when(customerRestfulDaoInterface.getAllCustomers()).thenReturn(customerList);
		customerRestfulService.getAllCustomers();
		verify(customerRestfulDaoInterface).getAllCustomers();
	}
	
}
