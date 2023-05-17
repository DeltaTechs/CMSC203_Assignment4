public class ManagementCompany {

	private String mngmntCompanyName, taxID;
	private double mngmentFeePercentage;
	
	static final int MAX_PROPERTY = 5;
	public static final int MGMT_WIDTH = 10;
	public static final int MGMT_DEPTH = 10;
	
	private Property[]properties; 
	private Plot otherPlot;
	
	public ManagementCompany() {
		this.mngmntCompanyName = "";
		this.taxID = "";
		this.otherPlot = new Plot(0,0,MGMT_WIDTH,MGMT_DEPTH);
		this.properties = new Property[MAX_PROPERTY];
	}
	
	public ManagementCompany(String mngmntCompanyName, String taxID, double mngmentFeePercentage) {
		this.mngmntCompanyName = mngmntCompanyName; 
		this.taxID = taxID; 
		this.mngmentFeePercentage = mngmentFeePercentage; 
		this.otherPlot = new Plot(0,0,MGMT_WIDTH,MGMT_DEPTH);
		this.properties = new Property[MAX_PROPERTY];
	}
	
	public ManagementCompany(String mngmntCompanyName, String taxID, double mngmentFeePercentage, int x, int y, int width, int depth) {
		this.mngmntCompanyName = mngmntCompanyName;
		this.taxID = taxID; 
		this.mngmentFeePercentage = mngmentFeePercentage; 
		this.otherPlot = new Plot(x,y,width,depth);
		this.properties = new Property[MAX_PROPERTY];
	}

	public ManagementCompany(ManagementCompany otherCompany) {
		this.properties = new Property[MAX_PROPERTY];
		this.mngmntCompanyName = otherCompany.mngmntCompanyName;
		this.taxID = otherCompany.taxID;
		this.mngmentFeePercentage = otherCompany.mngmentFeePercentage;
		this.otherPlot = otherCompany.otherPlot;
	}
	
	public int addProperty(String name, String city, double rent, String owner) {
		return addProperty(new Property(name, city, rent, owner));
	}
	
	public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) {
		return addProperty(new Property(name, city, rent, owner, x, y, width, depth));
	}
	
	public int addProperty(Property property) {
		if (property == null)
	        return -2;
	    else if (!this.otherPlot.encompasses(property.getPlot()))
	        return -3;
	    for (int i = 0; i < MAX_PROPERTY; i++)
	    	if (properties[i] != null)
	    		if (property.getPlot().overlaps(properties[i].getPlot()))
	    			return -4;	            
	        else 
	            break;
	    for (int i = 0; i < MAX_PROPERTY; i++)
	    	if (properties[i] == null) {
	    		properties[i] = new Property(property);
	    		return i;
	    	}
	    return -1;
	}
	
	public void removeLastProperty() {
		int temp = 0;
		for(int i = 0; i < 5; i++)
			if(properties[i] == null)
				temp = i;
		properties[temp - 1].setCity(null);
		properties[temp - 1].setRentAmount(0.0);
		properties[temp - 1].setOwner(null);
		properties[temp - 1].setPropertyName(null);
	}

	public boolean isPropertiesFull() {
		int count = 0;
		for(int i = 0; i < MAX_PROPERTY; i++)
			if(!(properties[i] == null))
				count++;
		if(count == MAX_PROPERTY)
			return true;
		else
			return false;
	}
	
	public int getPropertiesCount() {
		int count = 0;
		for(int i = 0; i < properties.length; i++)
			if(properties[i] != null)
				count++;
		return count;
	}

	public double getTotalRent() {
		double total = 0.0;
		for(int i = 0; i < MAX_PROPERTY; i++)
			if(properties[i] != null)
				total += properties[i].getRentAmount();
		return total; 
	}
	
	public Property getHighestRentProperty() {
		int indexOfHighestRent = 0;
		for(int i = 1; i < properties.length; i++)
			if(properties[indexOfHighestRent].getRentAmount() < properties[i].getRentAmount())
				indexOfHighestRent = i;
		return properties[indexOfHighestRent];
	}
	
	public boolean isManagementFeeValid() {
		if(mngmentFeePercentage > 0 && mngmentFeePercentage < 100)
			return true;
		else
			return false;
	}
	
	public String getName() {
		return mngmntCompanyName;
	}
	
	public String getTaxID() {
		return taxID;
	}

	public Property[] getProperties() {
		return properties;
	}

	public double getMgmFeePer() {
		return mngmentFeePercentage;
	}

	public Plot getPlot() {
		return otherPlot;
	}
	
	public String toString() {
		return	"List of the properties for " + getName() + ", taxID: " + getTaxID()  
		+ "\n" + properties[0].toString() + "\n" + properties[1].toString()
				+ "\n" + properties[2].toString() + "\n" + properties[3].toString()
				+ "\n" + properties[4].toString() + "\n\n" + "Total management Fee: " + 
				(getTotalRent() * mngmentFeePercentage) / 100;
	}
}