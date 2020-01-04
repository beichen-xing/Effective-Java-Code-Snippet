import jdk.jfr.AnnotationElement;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class rule33 {
    private Map<Class<?>, Object> favorites = new HashMap<>();

    public <T> void putFavorites(Class<T> type, T instance) {
        favorites.put(Objects.requireNonNull(type), instance);
    }

    public <T> T getFavorite(Class<T> type){
        return type.cast(favorites.get(type));
    }

    static Annotation getAnnotation(AnnotationElement element, String annotationTypeName){
        Class<?> annotationType = null;

        try {
            annotationType = Class.forName(annotationTypeName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return element.getAnnotation(annotationType.asSubclass(Annotation.class));
    }
}
