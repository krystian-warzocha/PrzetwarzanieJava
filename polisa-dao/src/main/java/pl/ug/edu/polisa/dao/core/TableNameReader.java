package pl.ug.edu.polisa.dao.core;

import java.lang.annotation.Annotation;
import pl.ug.edu.polisa.domain.core.BaseEntity;
import pl.ug.edu.polisa.domain.core.Entity;

public class TableNameReader {

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
