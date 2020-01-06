import java.util.Collection;
import java.util.List;

public class rule31 {

    class Stack<E>{
        public Stack(){};
        public void push(E e){};
        public void pop(E e){};

        public void pushAll(Iterable<? extends E> src){
            for(E e: src)
                push(e);
        }

        public void popAll(Collection<? super E> dst){
            return;
        }

    }

    // Two possible declarations for the swap method
    public static <E> void swap(List<E> list, int i, int j){};
    public static void swapnew(List<?> list, int i, int j){};

}


