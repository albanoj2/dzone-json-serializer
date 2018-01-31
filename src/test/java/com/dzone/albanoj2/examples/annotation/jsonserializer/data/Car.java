package com.dzone.albanoj2.examples.annotation.jsonserializer.data;

import com.dzone.albanoj2.examples.annotation.jsonserializer.JsonField;

public class Car {

	@JsonField("manufacturer")
	private final String make;
	
	@JsonField
	private final String model;
	
	private final String year;
	
	public Car(String make, String model, String year) {
		this.make = make;
		this.model = model;
		this.year = year;
	}
	
	public String getMake() {
		return make;
	}

	public String getModel() {
		return model;
	}
	
	public String getYear() {
		return year;
	}

	@Override
	public String toString() {
		return year + " " + make + " " + model;
	}
}
