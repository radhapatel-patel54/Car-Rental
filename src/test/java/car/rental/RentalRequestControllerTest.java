package car.rental;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import car.rental.controller.RentalRequestController;
import car.rental.model.TripInfo;
import car.rental.service.RentalRequestService;

@RunWith(SpringRunner.class)
@WebMvcTest(value=RentalRequestController.class )
public class RentalRequestControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	RentalRequestService rentalRequestService;
	
	@Test
	public void calculateTotalExpense() throws Exception {
		
		String expense = "Total Km 400.0, Basefare : 6000.0, AC Charges : 800.0, Extra Passanger Charges : 400.0 , ------ Total : 7200.0";
		String URI ="/calculateTotalExpense?from=Pune&to=Mumbai&vehicleId=2&fuel=Petrol&isAc=true&noOfPass=5&isRoundTrip=true";
		Mockito.when(rentalRequestService.calculateExpense(Mockito.any(TripInfo.class))).thenReturn(expense);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON);
		
		MvcResult mockResult = mockMvc.perform(requestBuilder).andReturn();
		String outputExpense=mockResult.getResponse().getContentAsString();
		assertThat(outputExpense).isEqualTo(expense);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
