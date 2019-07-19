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
		CityDistance cityDistance= new CityDistance();
		
		double basefare = 15;
		double totalDistance;
		
		String result;
		vehicle=carRentalRepo.getVehicle(tripInfo.getVehicleId());
		cityDistance=carRentalRepo.getDistance(tripInfo.getFromCity(), tripInfo.getToCity());
		totalDistance=cityDistance.getDistance();
		
		if(tripInfo.isRoundTrip()) 
			totalDistance=totalDistance*2;
		if(tripInfo.getFuel().equals("Diesel"))
			basefare -=1;
		result = "Total Km "+totalDistance+", Basefare : "+totalDistance*basefare;
		
		if(tripInfo.isAC()) {
			basefare +=2;
			result = result +", AC Charges : "+ totalDistance*2;
		}
		
		if(tripInfo.getNoOfPassanger()> vehicle.getLimit()) {
			basefare = basefare + (tripInfo.getNoOfPassanger()- vehicle.getLimit());
			result = result +", Extra Passanger Charges : "+ totalDistance*(tripInfo.getNoOfPassanger()- vehicle.getLimit());
		}
		
		result =result+" , ------ Total : "+ basefare*totalDistance;
		//return String.valueOf(basefare*cityDistance.getDistance());
		return result;
		
	
	}
	
	

}
