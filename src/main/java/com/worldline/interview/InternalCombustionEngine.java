package main.java.com.worldline.interview;

public class InternalCombustionEngine extends Engine {

	public InternalCombustionEngine(FuelType requiredFuelType) {
		super();
		if (requiredFuelType == FuelType.PETROL || requiredFuelType == FuelType.DIESEL) {
			this.requiredFuelType = requiredFuelType;
		} 
		else {
			throw new IllegalStateException("Wrong FuelType");
		}
		this.batchSize = 8;
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

		if (this.fuelType == FuelType.PETROL) {
			return 9;
		} else {
			return 12;
		}
	}


}
