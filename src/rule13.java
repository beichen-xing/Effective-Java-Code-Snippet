import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Map;

public class rule13 {
}

class StackClone implements Cloneable{
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public StackClone(){
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e){
        ensureCapacity();
        elements[size++] = e;
    }

    public Object pop(){
        if(size == 0)
            throw new EmptyStackException();
        Object result = elements[--size];
        elements[size] = null;
        return result;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    private void ensureCapacity(){
        if(elements.length == size)
            elements = Arrays.copyOf(elements, 2 * size + 1);
    }

    @Override
    public StackClone clone() throws CloneNotSupportedException {
        StackClone result = (StackClone) super.clone();
        result.elements = elements.clone();
        return result;
    }
}

class HashTable implements Cloneable{
    private Entry[] buckets;

    private static class Entry{
        final Object key;
        Object value;
        Entry next;

        Entry(Object key, Object value, Entry next){
            this.key = key;
            this.value = value;
            this.next = next;
        }
        /*
        Entry deepCopy(){
            return new Entry(key, value, next == null ? null : next.deepCopy());
        }

         */
        Entry deepCopy(){
            Entry result = new Entry(key, value, next);
            for(Entry p = result; p.next != null; p = p.next)
                p.next = new Entry(p.next.key, p.next.value, p.next.next);
            return result;
        }
    }

    @Override
    public HashTable clone() throws CloneNotSupportedException {
        HashTable result = (HashTable) super.clone();
        result.buckets = new Entry[buckets.length];
        for(int i = 0; i < buckets.length; i++){
            if(buckets[i] != null)
                result.buckets[i] = buckets[i].deepCopy();
        }
        return result;
    }



}
