package car.rental.model;

public class CityDistance {
	
	private long id;
	private String fromCity;
	private String toCity;
	private double distance;
	
		public CityDistance() {
		super();
	}
	public CityDistance(long id, String fromCity, String toCity, double distance) {
		super();
		this.id = id;
		this.fromCity = fromCity;
		this.toCity = toCity;
		this.distance = distance;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	
	

}
