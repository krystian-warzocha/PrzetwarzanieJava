package pl.ug.edu.polisa.dao.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pl.ug.edu.polisa.domain.core.BaseEntity;
import pl.ug.edu.polisa.domain.core.Column;
import pl.ug.edu.polisa.domain.core.Entity;

public class TableNameReader {

	/**
	 * Czyta liste kolumn dla encji.
	 * @param object Z niego odcztywana jest lista kolumn.
	 * @return lista nazw kolumn
	 */
	public static <T extends BaseEntity> Map<String, String> readColumns(T object) {
		Map<String, String> columns = new HashMap<String, String>();
		
		Class<T> obj = (Class<T>) object.getClass();
		for(Field f : obj.getDeclaredFields()) {
			if(f.isAnnotationPresent(Column.class)) {
				Annotation annotation = f.getAnnotation(Column.class);
				Column column = (Column) annotation;
				columns.put(column.columnName(), f.getName());
			}
		}
		return columns;
	}

	/**
	 * Odczytuje nazwe tableli z adnotacji.
	 * @param object obiekt z ktorego odczytujemy nazwe tabeli.
	 * @return nazwa tabeli
	 */
	@SuppressWarnings("unchecked")
	public static <T extends BaseEntity> String read(T object) {
		Class<T> obj = (Class<T>) object.getClass();
		if(obj.isAnnotationPresent(Entity.class)) {
			Annotation annotation = obj.getAnnotation(Entity.class);
			Entity entity = (Entity)annotation;
			return entity.tableName();
		}
		return null;
	}
}
