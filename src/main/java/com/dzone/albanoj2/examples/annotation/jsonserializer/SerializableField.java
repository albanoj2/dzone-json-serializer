package com.dzone.albanoj2.examples.annotation.jsonserializer;

public class SerializableField {

	private final String name;
	private final String value;
	
	public SerializableField(String name, String value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public String getValue() {
		return value;
	}
}
