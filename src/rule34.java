enum Operations{
    PLUS, MINUS, TIMES, DIVIDE;
    public double apply(double x, double y){
        switch (this){
            case PLUS: return x + y;
            case MINUS: return x - y;
            case TIMES: return x * y;
            case DIVIDE: return x / y;
        }
        throw new AssertionError("unKnown operation");
    }
}

enum OperationsNew{
    PLUS {public double apply(double x, double y){return x + y;}},
    MINUS {public double apply(double x, double y){return x - y;}},
    TIMES {public double apply(double x, double y){return x * y;}},
    DIVIDE {public double apply(double x, double y){return x / y;}};

    public abstract double apply(double x, double y);
}

enum OperationsNewWithSymbol{
    PLUS("+") {public double apply(double x, double y){return x + y;}},
    MINUS("-") {public double apply(double x, double y){return x - y;}},
    TIMES("*") {public double apply(double x, double y){return x * y;}},
    DIVIDE("/") {public double apply(double x, double y){return x / y;}};

    private final String symbol;
    OperationsNewWithSymbol(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString(){
        return symbol;
    }
    public abstract double apply(double x, double y);
}

public class rule34 {
    public static void main(String[] args) {
        Operations op = Operations.PLUS;
        System.out.println(op + "-->" + op.apply(1,1));
        OperationsNew opnew = OperationsNew.MINUS;
        System.out.println(opnew + "-->" + opnew.apply(1,1));
        OperationsNewWithSymbol opNewWithSymbol = OperationsNewWithSymbol.PLUS;
        System.out.println(opNewWithSymbol + "-->" + opNewWithSymbol.apply(1,1));
    }

}
