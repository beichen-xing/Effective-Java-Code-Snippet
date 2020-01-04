public class rule31 {

    class Stack<E>{
        public Stack(){};
        public void push(E e){};

        public void pushAll(Iterable<? extends E> src){
            for(E e: src)
                push(e);
        }
    }

}


