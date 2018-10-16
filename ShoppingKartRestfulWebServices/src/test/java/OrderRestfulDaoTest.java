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
import org.mockito.runners.MockitoJUnitRunner;

import com.restful.dao.OrderRestfulDao;
import com.restful.model.Order;

@RunWith(MockitoJUnitRunner.class)
public class OrderRestfulDaoTest {
	
	@InjectMocks
	OrderRestfulDao orderRestfulDao;
	
	  @Mock
      EntityManager entityManager;
      
      @Mock
      Order order;
      
      @Mock
      TypedQuery<Order> query;
      

      @Test
      public void shouldplaceOrder() {
                      doNothing().when(entityManager).persist(order);
                      
                      Assert.assertEquals(order, orderRestfulDao.createOrder(order));
                      
                      verify(entityManager).persist(order);
      }
       
      @Test
      public void shouldfindByIdReturnOrder() {
      	
      	
                      when(entityManager.find(Order.class, 1)).thenReturn(order);
                      
                      Assert.assertEquals(order, orderRestfulDao.findById(1));
                      
                      verify(entityManager).find(Order.class, 1);
      }
      
      @Test
      public void shouldUpdateOrder() {
                  when(entityManager.merge(order)).thenReturn(order);
                  orderRestfulDao.updateOrder(order);
                  verify(entityManager).merge(order);
      }
      
      @Test
      public void shouldDeleteMethodDeleteOrder() {
                      when(entityManager.find(Order.class, 1)).thenReturn(order);
                      doNothing().when(entityManager).remove(order);
                      
                      orderRestfulDao.deleteOrder(1);
                      
                      verify(entityManager).find(Order.class, 1);
                      verify(entityManager).remove(order);
      }

}
