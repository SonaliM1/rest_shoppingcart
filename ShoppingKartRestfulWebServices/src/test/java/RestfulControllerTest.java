import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.web.servlet.ModelAndView;

import com.restful.controller.RestfulController;

@RunWith(MockitoJUnitRunner.class)
public class RestfulControllerTest {

	@InjectMocks
	RestfulController restfulController;
	
	
	@Test
	public void shouldReturnWelcomeView() {
		
	ModelAndView modelAndView = restfulController.welcome();
	Assert.assertEquals("Welcome", modelAndView.getViewName());
	}
 
}
