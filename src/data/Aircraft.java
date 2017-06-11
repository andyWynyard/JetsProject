package data;

public class Aircraft {

	private String manufacturer;
	private String model;
	private String modelVariant;
	private double price;
	private int maxSpeed;
	private int serviceCeiling;
	private int maxRange;
	private int dryWeight;
	private int maxTakeOffWeight;
	private int fuelCapacity;
	private int yearIntroduced;

	public Aircraft(String manufacturer, String model, String modelVariant, double price, int maxSpeed,
			int serviceCeiling, int maxRange, int dryWeight, int maxTakeOffWeight, int fuelCapacity,
			int yearIntroduced) {
		this.manufacturer = manufacturer;
		this.model = model;
		this.modelVariant = modelVariant;
		this.price = price;
		this.maxSpeed = maxSpeed;
		this.serviceCeiling = serviceCeiling;
		this.maxRange = maxRange;
		this.dryWeight = dryWeight;
		this.maxTakeOffWeight = maxTakeOffWeight;
		this.fuelCapacity = fuelCapacity;
		this.yearIntroduced = yearIntroduced;
	}

	public double calcMachFromMph(int mph) {
		double roundOff = Math.round((mph / 660) * 100) / 100.D;
		return roundOff;
	}

	@Override
	public String toString() {
		return "\nAircraft Manufacturer: \t" + manufacturer + "\nModel: \t\t\t" + model + "\nCommon Name: \t\t"
				+ modelVariant + "\nPrice (mUSD): \t\t" + price + "\nMax Speed (Mach): \t" + calcMachFromMph(maxSpeed)
				+ "\nService Ceiling (ft): \t" + serviceCeiling + "\nMax Range (miles): \t" + maxRange
				+ "\nDry Weight (lbs): \t" + dryWeight + "\nMax T/O Weight (lbs): \t" + maxTakeOffWeight
				+ "\nFuel Capacity (lbs): \t" + fuelCapacity + "\nYear into service:\t" + yearIntroduced + "\n\n";
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getModelVariant() {
		return modelVariant;
	}

	public void setModelVariant(String modelVariant) {
		this.modelVariant = modelVariant;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public int getServiceCeiling() {
		return serviceCeiling;
	}

	public void setServiceCeiling(int serviceCeiling) {
		this.serviceCeiling = serviceCeiling;
	}

	public int getMaxRange() {
		return maxRange;
	}

	public void setMaxRange(int maxRange) {
		this.maxRange = maxRange;
	}

	public int getDryWeight() {
		return dryWeight;
	}

	public void setDryWeight(int dryWeight) {
		this.dryWeight = dryWeight;
	}

	public int getMaxTakeOffWeight() {
		return maxTakeOffWeight;
	}

	public void setMaxTakeOffWeight(int maxTakeOffWeight) {
		this.maxTakeOffWeight = maxTakeOffWeight;
	}

	public int getFuelCapacity() {
		return fuelCapacity;
	}

	public void setFuelCapacity(int fuelCapacity) {
		this.fuelCapacity = fuelCapacity;
	}

	public int getYearIntriduced() {
		return yearIntroduced;
	}

	public void setHistory(int yearIntroduced) {
		this.yearIntroduced = yearIntroduced;
	}

}
