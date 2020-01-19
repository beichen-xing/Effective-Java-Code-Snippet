import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;
import java.util.function.Predicate;

public class rule21 {
    public static void main(String[] args) {

    }

}

class E{

}
interface collec extends Iterator {

    default boolean removeIf(Predicate<? super E> filter){
        Objects.requireNonNull(filter);
        boolean result = false;
        for(Iterator<E> it = new Iterator<E>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public E next() {
                return null;
            }
        }; it.hasNext();){
            if(filter.test(it.next())){
                it.remove();
                result = true;
            }
        }
        return result;
    }
}
