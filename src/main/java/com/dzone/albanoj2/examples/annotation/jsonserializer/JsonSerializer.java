package com.dzone.albanoj2.examples.annotation.jsonserializer;

import static java.util.stream.Collectors.joining;

import java.util.List;

public class JsonSerializer {
	
	private final JsonSerializableFieldExtractor extractor;
	
	public JsonSerializer(JsonSerializableFieldExtractor extractor) {
		this.extractor = extractor;
	}

	public String serialize(Object object) throws JsonSerializeException {
		List<SerializableField> fields = extractor.getSerializableFields(object);
		return toJsonString(fields);
	}

	private String toJsonString(List<SerializableField> fields) {
		String elementsString = fields
		        .stream()
		        .map(field -> "\""  + field.getName() + "\":\"" + field.getValue() + "\"")
		        .collect(joining(","));
		return "{" + elementsString + "}";
	}
}
