package car.rental.model;

public class TripInfo {
	
	private long tripId;
	private long vehicleId;
	private String fuel;
	private boolean isAC;
	private String fromCity;
	private String toCity;
	private boolean isRoundTrip;
	private int noOfPassanger;
	
	public TripInfo() {
		super();
	}
	public TripInfo(long tripId, long vehicleId, String fuel, boolean isAC, String fromCity, String toCity,
			boolean isRoundTrip,int noOfPassanger) {
		super();
		this.tripId = tripId;
		this.vehicleId = vehicleId;
		this.fuel = fuel;
		this.isAC = isAC;
		this.fromCity = fromCity;
		this.toCity = toCity;
		this.isRoundTrip = isRoundTrip;
		this.noOfPassanger=noOfPassanger;
	}
	
	
	
	public int getNoOfPassanger() {
		return noOfPassanger;
	}
	public void setNoOfPassanger(int noOfPassanger) {
		this.noOfPassanger = noOfPassanger;
	}
	public long getTripId() {
		return tripId;
	}
	public void setTripId(long tripId) {
		this.tripId = tripId;
	}
	public long getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(long vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getFuel() {
		return fuel;
	}
	public void setFuel(String fuel) {
		this.fuel = fuel;
	}
	public boolean isAC() {
		return isAC;
	}
	public void setAC(boolean isAC) {
		this.isAC = isAC;
	}
	public String getFromCity() {
		return fromCity;
	}
	public void setFromCity(String fromCity) {
		this.fromCity = fromCity;
	}
	public String getToCity() {
		return toCity;
	}
	public void setToCity(String toCity) {
		this.toCity = toCity;
	}
	public boolean isRoundTrip() {
		return isRoundTrip;
	}
	public void setRoundTrip(boolean isRoundTrip) {
		this.isRoundTrip = isRoundTrip;
	}
	
	
	
	
	

}
