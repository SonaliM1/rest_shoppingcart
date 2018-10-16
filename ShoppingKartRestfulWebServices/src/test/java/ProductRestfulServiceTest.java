

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.restful.daointerface.ProductRestfulDaoInterface;
import com.restful.model.Product;
import com.restful.service.ProductRestfulService;

@RunWith(MockitoJUnitRunner.class)
public class ProductRestfulServiceTest {

       @InjectMocks
       ProductRestfulService productRestfulService;
       
       @Mock
       ProductRestfulDaoInterface productRestfulDao;
       
       @Mock
       Product product;
       
       @Test
       public void shouldAddproductReturnProductObject() {
              Mockito.when(productRestfulDao.addproduct(product)).thenReturn(product);
              
              Assert.assertNotNull(productRestfulService.addproduct(product));
              Mockito.verify(productRestfulDao).addproduct(product);
       }

       @Test
       public void shouldfindByIdReturnProductObject() {
              Mockito.when(productRestfulDao.findById(Mockito.anyInt())).thenReturn(product);
              
              Assert.assertNotNull(productRestfulService.findById(Mockito.anyInt()));
              Mockito.verify(productRestfulDao).findById(Mockito.anyInt());
       }
       
       @Test
       public void shouldupdateProductByIdReturnProductObject() {
              Mockito.when(productRestfulDao.updateProductById(product)).thenReturn(product);
              
              Assert.assertNotNull(productRestfulService.updateProductById(product));
              Mockito.verify(productRestfulDao).updateProductById(product);
       }
       
       @Test
       public void shouldDeleteProductByIdReturnProductObject() {
              Mockito.doNothing().when(productRestfulDao).deleteProductById(Mockito.anyInt());
              
              productRestfulService.deleteProductById(Mockito.anyInt());
              Mockito.verify(productRestfulDao).deleteProductById(Mockito.anyInt());
       }
        
       @Test
       public void shouldfindAllProductReturnProductList() {
              List list = new ArrayList();
              Product p1 = new Product();
              p1.setProductId(1);
              p1.setProductName("pp");
              p1.setProductPrice("price");
              p1.setProductQuantity("131");
              list.add(p1);
              Mockito.when(productRestfulDao.findAllProduct()).thenReturn(list);
              
              Assert.assertEquals(list, productRestfulService.findAllProduct());
              Mockito.verify(productRestfulDao).findAllProduct();
       }
}
