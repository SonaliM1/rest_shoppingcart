

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.restful.dao.CustomerRestfulDao;
import com.restful.model.Customer;


@RunWith(MockitoJUnitRunner.class)
public class CustomerRestfulDaoTest {
                
                @InjectMocks
                CustomerRestfulDao customerRestfulDao;
                
                @Mock
                EntityManager entityManager;
                
                @Mock
                Customer customer;
                
                @Mock
                TypedQuery<Customer> query;
                 
                @Test
                public void shouldAddCustomerAddTheCustomerAndReturnCustomer() {
                                doNothing().when(entityManager).persist(customer);
                                
                                Assert.assertEquals(customer, customerRestfulDao.addCustomer(customer));
                                
                                verify(entityManager).persist(customer);
                }
                 
                @Test
                public void shouldfindByIdReturnCustomer() {
                	
                	
                                when(entityManager.find(Customer.class, 1)).thenReturn(customer);
                                
                                Assert.assertEquals(customer, customerRestfulDao.findById(1));
                                
                                verify(entityManager).find(Customer.class, 1);
                }
 
                @Test
                public void shouldDeleteMethodDeleteCutomer() {
                                when(entityManager.find(Customer.class, 1)).thenReturn(customer);
                                doNothing().when(entityManager).remove(customer);
                                
                                customerRestfulDao.delete(1);
                                
                                verify(entityManager).find(Customer.class, 1);
                                verify(entityManager).remove(customer);
                }
                   
                @Test 
                public void shouldUpdateMethodUpadateCutomer() {
                	Customer customer =new Customer();
                                when(entityManager.find(Customer.class, 0)).thenReturn(customer);
                                when(entityManager.createQuery(Mockito.anyString())).thenReturn(query);
                                when(query.executeUpdate()).thenReturn(1);

                                customerRestfulDao.update(customer);
                                 
                                verify(entityManager).find(Customer.class, 0);
                                verify(query).executeUpdate();
                }
  
}
