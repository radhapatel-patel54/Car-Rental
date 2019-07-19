package car.rental.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import car.rental.model.CityDistance;
import car.rental.model.TripInfo;
import car.rental.model.Vehicle;
import car.rental.repository.CarRentalRepo;

@Service
public class RentalRequestService {

	@Autowired
	CarRentalRepo carRentalRepo;

	public String calculateExpense(TripInfo tripInfo) throws Exception {

		Vehicle vehicle;
		CityDistance cityDistance;
		double basefare = 15;
		double totalDistance;
		String result;

		vehicle = carRentalRepo.getVehicle(tripInfo.getVehicleId());
		cityDistance = carRentalRepo.getDistance(tripInfo.getFromCity(), tripInfo.getToCity());

		totalDistance = cityDistance.getDistance();

		/* If it is round trip then multiply with 2*/
		if (tripInfo.isRoundTrip())
			totalDistance = totalDistance * 2;
		
		/* If fuel used is diesel than reduce basefare to 1*/
		if (tripInfo.getFuel().equals("Diesel"))
			basefare -= 1;
		result = "Total Km " + totalDistance + ", Basefare : " + totalDistance * basefare;

		/*If customer use AC than increase basefare by 2 rupee */
		if (tripInfo.isAC()) {
			basefare += 2;
			result = result + ", AC Charges : " + totalDistance * 2;
		}

		/*If passangers are more than the max limit than increase the fare by 1 rs/km for each extra passangers*/
		if (tripInfo.getNoOfPassanger() > vehicle.getLimit()) {
			basefare = basefare + (tripInfo.getNoOfPassanger() - vehicle.getLimit());
			result = result + ", Extra Passanger Charges : "
					+ totalDistance * (tripInfo.getNoOfPassanger() - vehicle.getLimit());
		}

		result = result + " , ------ Total : " + basefare * totalDistance;
		
		return result;

	}

}
