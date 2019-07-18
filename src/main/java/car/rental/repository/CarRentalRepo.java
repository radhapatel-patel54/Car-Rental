package car.rental.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import car.rental.model.CityDistance;
import car.rental.model.Vehicle;

@Component
public class CarRentalRepo {
	
	List<CityDistance> cityDistanceList = new ArrayList<CityDistance>(Arrays.asList(
			new CityDistance(1,"Pune","Pune",0),
			new CityDistance(2,"Pune","Mumbai",200),
			new CityDistance(3,"Pune","Bangalore",1000),
			new CityDistance(4,"Pune","Delhi",2050),
			new CityDistance(5,"Pune","Chennai",1234)));
	
	List<Vehicle> vehicleList = new ArrayList<Vehicle>(Arrays.asList(
			new Vehicle(1,"SUV","SUV",6,"big"),
			new Vehicle(2,"Car","Car",4 ,"small"),
			new Vehicle(3,"Van","Van",6,"big"),
			new Vehicle(4,"Bus","Bus",23,"small")
			));
			
	public CityDistance getDistance(String from,String to) throws Exception {
		Optional<CityDistance> OptionalCityDistance =cityDistanceList.stream().filter(s->s.getFromCity().endsWith(from)).filter(s->s.getToCity().equals(to)).findFirst();
		
		if(OptionalCityDistance.isPresent()) {
			return OptionalCityDistance.get();
		}else
			throw new Exception("Service not available between th city");
	}
	
	public Vehicle getVehicle(long id) throws Exception{
		Optional<Vehicle> optionalVehicle= vehicleList.stream().filter(s->s.getId()==id).findFirst();

		if (optionalVehicle.isPresent()) {
			return optionalVehicle.get();
		}else
			throw new Exception("Vehicle not found");
	}
	
	public List<CityDistance> getAllDistance(){
		return cityDistanceList;
	}

	public List<Vehicle> getAllVehicle(){
		return vehicleList;
	}
}
