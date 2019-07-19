package car.rental;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import car.rental.model.CityDistance;
import car.rental.model.TripInfo;
import car.rental.model.Vehicle;
import car.rental.repository.CarRentalRepo;
import car.rental.service.RentalRequestService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RentalRequestServiceTest {

	@Autowired
	RentalRequestService rentalRequestService;

	@MockBean
	CarRentalRepo carRentalRepo;

	@Test
	public void calculateExpense() throws Exception {
		CityDistance cityDistance = new CityDistance(2, "Pune", "Mumbai", 200);
		Vehicle vehicle = new Vehicle(2, "Car", "Car", 4, "small");
		TripInfo tripInfo = new TripInfo(1001, 1, "Petrol", true, "Pune", "Mumbai", true, 5);
		String expense = "Total Km 400.0, Basefare : 6000.0, AC Charges : 800.0, Extra Passanger Charges : 400.0 , ------ Total : 7200.0";
		Mockito.when(carRentalRepo.getDistance(Mockito.anyString(), Mockito.anyString())).thenReturn(cityDistance);
		Mockito.when(carRentalRepo.getVehicle(Mockito.anyLong())).thenReturn(vehicle);
		assertThat(rentalRequestService.calculateExpense(tripInfo)).isEqualTo(expense);

	}

}
