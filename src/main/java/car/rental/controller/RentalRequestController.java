package car.rental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import car.rental.model.TripInfo;
import car.rental.service.RentalRequestService;

@RestController
public class RentalRequestController {

	@Autowired
	RentalRequestService rentalRequestService;

	public static long count = 1001;

	@RequestMapping(value = "/calculateTotalExpense", method = RequestMethod.GET)
	public String calculateTotalExpense(@RequestParam("from") String from, @RequestParam("to") String to,
			@RequestParam("vehicleId") long vehicleId, @RequestParam("fuel") String fuel,
			@RequestParam("isAc") boolean isAc, @RequestParam("noOfPass") int noOfPass,@RequestParam("isRoundTrip") boolean isRoundTrip) throws Exception {

		
		TripInfo tripInfo = new TripInfo(count++,vehicleId,fuel,isAc,from,to,isRoundTrip,noOfPass);
		if (!tripInfo.getFromCity().equals("Pune"))
			return "Trip will start from Pune only";
		return rentalRequestService.calculateExpense(tripInfo);
	}

}
