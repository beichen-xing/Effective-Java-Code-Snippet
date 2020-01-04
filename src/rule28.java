import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class rule28 {
    public static void main(String[] args) {
        //List<String>[] stringLists = new List<String>[1];
    }
}

class Chooser{
    private final Object[] choiceArray;

    public Chooser(Collection choices){
        choiceArray = choices.toArray();
    }

    public Object choose(){
        Random rnd = ThreadLocalRandom.current();
        return choiceArray[rnd.nextInt(choiceArray.length)];
    }
}

class ChooserGeneric<T>{
    private final T[] choiceArray;
    @SuppressWarnings("unchecked")
    public ChooserGeneric(Collection<T> choices){
        choiceArray = (T[]) choices.toArray();
    }
}

class ChooserGenericChecked<T>{
    private final List<T> choiceList;

    public ChooserGenericChecked(Collection<T> choices){
        choiceList = new ArrayList<>(choices);
    }

    public T choose(){
        Random rnd = ThreadLocalRandom.current();
        return choiceList.get(rnd.nextInt(choiceList.size()));
    }
}
