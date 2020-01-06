import java.util.Arrays;
import java.util.Comparator;

public class rule14 {
    private static final Comparator<PhoneNumber> COMPARATOR =
            Comparator.comparingInt((PhoneNumber pn) -> pn.areaCode)
            .thenComparingInt(pn -> pn.prefix)
            .thenComparingInt(pn -> pn.lineNum);
}
