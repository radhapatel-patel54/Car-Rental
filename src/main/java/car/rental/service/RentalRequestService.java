package car.rental.service;

import java.util.Optional;

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

	Vehicle vehicle;
	CityDistance cityDistance;
	
	double basefare = 15;
	double extraPassCharges=1;
	double acCharges =2;
	String result;

	public String calculateExpense(TripInfo tripInfo) throws Exception {
		
		vehicle=carRentalRepo.getVehicle(tripInfo.getVehicleId());
		cityDistance=carRentalRepo.getDistance(tripInfo.getFromCity(), tripInfo.getToCity());
		
		if(tripInfo.isRoundTrip()) 
			cityDistance.setDistance(cityDistance.getDistance()*2);
		if(tripInfo.getFuel().equals("Diesel"))
			basefare -=1;
		result = "Total Km "+cityDistance.getDistance()+", Basefare : "+cityDistance.getDistance()*basefare;
		
		if(tripInfo.isAC()) {
			basefare +=2;
			result = result +", AC Charges : "+ cityDistance.getDistance()*2;
		}
		
		if(tripInfo.getNoOfPassanger()> vehicle.getLimit()) {
			basefare = basefare + (tripInfo.getNoOfPassanger()- vehicle.getLimit());
			result = result +", Extra Passanger Charges : "+ cityDistance.getDistance()*(tripInfo.getNoOfPassanger()- vehicle.getLimit());
		}
		
		result =result+" , ------ Total : "+ basefare*cityDistance.getDistance();
		//return String.valueOf(basefare*cityDistance.getDistance());
		return result;
		
	
	}
	
	

}
