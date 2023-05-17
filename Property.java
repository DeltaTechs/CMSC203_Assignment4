public class Property {
	
	private String propertyName, city, owner;
	private double rentalAmnt;
	private Plot otherPlot;
	
	public Property() {
		this.propertyName = "";
		this.city = "";
		this.owner = "";
		this.rentalAmnt = 0;
		this.otherPlot = new Plot(0,0,1,1);
	}
	
	public Property(String propertyName, String city, double rentalAmnt, String owner) {
		this.propertyName = propertyName;
		this.city = city;
		this.owner = owner;
		this.rentalAmnt = rentalAmnt;
		this.otherPlot = new Plot(0,0,1,1);
	}
	
	public Property(String propertyName, String city, double rentalAmnt, String owner, int x, int y, int width, int depth) {
		this.otherPlot = new Plot(x, y, width, depth);
		this.propertyName = propertyName;
		this.city = city;
		this.owner = owner;
		this.rentalAmnt = rentalAmnt;
	}
	
	public Property(Property otherProperty) {
		this.propertyName = otherProperty.getPropertyName();
		this.city = otherProperty.getCity();
		this.owner = otherProperty.getOwner();
		this.rentalAmnt = otherProperty.getRentAmount();
		this.otherPlot = new Plot(otherProperty.getPlot());
	}
	
	public Plot getPlot() {
		return otherPlot;
	}
	
	public String getPropertyName() {
		return this.propertyName;
	}
	
	public String getCity() {
		return this.city;
	}

	public double getRentAmount() {
		return this.rentalAmnt;
	}

	public String getOwner() {
		return this.owner;
	}
	
	public String toString() {
		return this.propertyName+this.city+this.owner+this.rentalAmnt;
	}
	
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	
	public void setCity(String city) {
		this.city = city;
	}

	public void setRentAmount(double rentalAmnt) {
		this.rentalAmnt = rentalAmnt;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}
}