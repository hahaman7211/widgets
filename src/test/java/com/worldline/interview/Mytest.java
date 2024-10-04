package test.java.com.worldline.interview;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import main.java.com.worldline.interview.Engine;
import main.java.com.worldline.interview.FuelType;
import main.java.com.worldline.interview.InternalCombustionEngine;
import main.java.com.worldline.interview.SteamEngine;
import main.java.com.worldline.interview.WidgetMachine;

public class Mytest {

	@Rule
	public ExpectedException exceptions = ExpectedException.none();

	@Test
	public void testCost() {

		Engine engine = new SteamEngine(FuelType.WOOD);
		engine.fill(FuelType.WOOD, 50);

		WidgetMachine widgetMachine = new WidgetMachine(engine);
		double cost = widgetMachine.produceWidgets(1);
		Assert.assertEquals(cost, 4.35, 0.001);

	}

	@Test
	public void testCost2() {
		Engine engine = new SteamEngine(FuelType.COAL);
		engine.fill(FuelType.COAL, 50);
		WidgetMachine widgetMachine = new WidgetMachine(engine);
		double cost = widgetMachine.produceWidgets(3);
		Assert.assertEquals(cost, 5.65*2, 0.001);

	}
	
	@Test
	public void testCost3() {
		Engine engine = new InternalCombustionEngine(FuelType.PETROL);
		WidgetMachine widgetMachine = new WidgetMachine(engine);
		engine.fill(FuelType.PETROL, 50);
		double cost = widgetMachine.produceWidgets(9);
		Assert.assertEquals(cost, 9*2, 0.001);

	}

	@Test
	public void testForException() {
		Engine engine = new SteamEngine(FuelType.COAL);
		engine.fill(FuelType.WOOD, 50);
		WidgetMachine widgetMachine = new WidgetMachine(engine);
		exceptions.expect(Exception.class);
		exceptions.expectMessage("Not able to start engine.");
		double cost = widgetMachine.produceWidgets(2);

	}

	@Test
	public void testForFill() {
		Engine engine = new SteamEngine(FuelType.COAL);
		engine.fill(FuelType.PETROL, 50);
		WidgetMachine widgetMachine = new WidgetMachine(engine);
		exceptions.expect(Exception.class);
		exceptions.expectMessage("Not able to start engine.");
		double cost = widgetMachine.produceWidgets(2);
		

	}

	@Test
	public void testForStart() {
		Engine engine = new SteamEngine(FuelType.COAL);
		engine.fill(FuelType.COAL, 0);
		exceptions.expect(Exception.class);
		exceptions.expectMessage("Not able to start engine.");
		engine.start();

	}

}
