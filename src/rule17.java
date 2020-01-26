import java.util.LinkedList;
import java.util.List;

public class rule17 {

    public static void main(String[] args) {
        List<Integer> ls = new LinkedList<>();
    }
}

final class Complex{
    private final double re;
    private final double im;

    public Complex(double re, double im){
        this.re = re;
        this.im = im;
    }

    public double realPart(){
        return re;
    }
    public double imaginaryPart(){
        return im;
    }



}
