package main.java.com.worldline.interview;

public abstract class Engine {
	
	protected boolean running;
	protected int fuelLevel;
	protected FuelType requiredFuelType;
	protected FuelType fuelType;
	protected int batchSize;
	
	protected Engine() {
		running = false;
		fuelLevel = 0;
	}
	
	public void start() {
		if (fuelLevel > 0 && requiredFuelType.equals(fuelType)) {
			running = true;
		} else {
			throw new IllegalStateException("Not able to start engine.");
		}
	}

	public void stop() {
		running = false;
	}

	public boolean isRunning() {
		return running;
	}
	
	public FuelType getFuelType() {
		return requiredFuelType;
	}

	public int getBatchSize() {
		return this.batchSize;
	}

	public abstract void fill(FuelType fuelType, int fuelLevel);

	public abstract double getCostPerBatch();
	


}
