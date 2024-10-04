package main.java.com.worldline.interview;

public class SteamEngine extends Engine {

	public SteamEngine(FuelType requiredFuelType) {
		super();
		if (requiredFuelType == FuelType.WOOD || requiredFuelType == FuelType.COAL) {
			this.requiredFuelType = requiredFuelType;
		} 
		else {
			throw new IllegalStateException("Wrong FuelType");
		}
		
		this.batchSize = 2;
		
	}

	@Override
    public void fill(FuelType fuelType, int fuelLevel) {
        if (fuelLevel >= 0 && fuelLevel <= 100) {
            this.fuelLevel = fuelLevel;
        }
        else if (fuelLevel > 100) {
            this.fuelLevel = 100;
        }
        else {
            this.fuelLevel = 0;
        }

        this.fuelType = fuelType;
    }

	@Override
	public double getCostPerBatch() {

		if (this.fuelType == FuelType.WOOD) {
			return 4.35;
		} else {
			return 5.65;
		}
	}
	

}
