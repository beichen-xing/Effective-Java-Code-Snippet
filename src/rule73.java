import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class rule73 {

    List<E> ls = new ArrayList<>();
    public E get(int index){
        ListIterator<E> i = ls.listIterator();
        try{
            return i.next();
        } catch (NoSuchElementException e){
            throw new IndexOutOfBoundsException("Index: " + index);
        }
    }

}

class HigherLevelException extends Exception{
    HigherLevelException(Throwable cause){
        super(cause);
    }
}