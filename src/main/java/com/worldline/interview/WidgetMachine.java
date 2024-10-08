package main.java.com.worldline.interview;

public class WidgetMachine {
	private Engine engine;

	public WidgetMachine(Engine engine) {
		super();
		this.engine = engine;
	}

	public double produceWidgets(int quantity) {
		engine.start();
		double cost = 0;

		if (engine.isRunning()) {
			cost = produce(quantity);
		}

		engine.stop();

		return cost;
	}

	private double produce(int quantity) {
		int batch = 0;
		int batchCount = 0;
		double costPerBatch = 0;

//        if (engine.getFuelType() == FuelType.PETROL) {
//            costPerBatch = 9;
//        } 
//        else if (engine.getFuelType() == FuelType.DIESEL) {
//            costPerBatch = 12;
//        }

		costPerBatch = engine.getCostPerBatch();

		while (batch < quantity) {
			batch = batch + engine.getBatchSize();
			batchCount++;
		}

		System.out.println("batch:" + batch);

		return batchCount * costPerBatch;
	}

}
