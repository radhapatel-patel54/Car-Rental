package car.rental.model;

public class Vehicle {
	
	private long id;
	private String name;
	private String model;
	private int limit;
	private String type;
	
	
	
	public Vehicle() {
		super();
	}
	public Vehicle(long id, String name, String model,int limit,String type) {
		super();
		this.id = id;
		this.name = name;
		this.model = model;
		this.limit = limit;
		this.type= type;
	
	}
	
	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	
	
	

}
