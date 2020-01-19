import java.util.HashMap;

public class rule62 {
}

class ThreadLocal{
    private ThreadLocal(){}

    public static class Key{
        Key(){}
    }

    public static Key getKey(){
        return new Key();
    }

    public static void set(Key key, Object value){}
    public static void get(Key key){}

}