package com.dzone.albanoj2.examples.annotation.jsonserializer;

import static java.util.Objects.requireNonNull;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class JsonSerializableFieldExtractor {

	public List<SerializableField> getSerializableFields(Object object) throws JsonSerializeException {
		try {
			Class<?> objectClass = requireNonNull(object).getClass();
			List<SerializableField> fields = new ArrayList<>();
			
			for (Field field: objectClass.getDeclaredFields()) {
				field.setAccessible(true);
				if (field.isAnnotationPresent(JsonField.class)) {
					fields.add(new SerializableField(getSerializedKey(field), (String) field.get(object)));
				}
			}
			
			return fields;
		}
		catch (IllegalAccessException e) {
			throw new JsonSerializeException(e.getMessage());
		}
	}
	
	private static String getSerializedKey(Field field) {
		String annotationValue = field.getAnnotation(JsonField.class).value();
		
		if (annotationValue.isEmpty()) {
			return field.getName();
		}
		else {
			return annotationValue;
		}
	}
}
