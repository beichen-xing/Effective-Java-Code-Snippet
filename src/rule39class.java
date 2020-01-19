import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class rule39class {
    @rule39(ArithmeticException.class) public static void m1(){}
    @rule39(ArithmeticException.class) public static void m3(){
        throw new RuntimeException("Boom");
    }
    @rule39(ArithmeticException.class) public void m5(){}

    public static void main(String[] args) throws ClassNotFoundException {
        int tests = 0;
        int passed = 0;
        Class<?> testClass = Class.forName(args[0]);
        for(Method m : testClass.getDeclaredMethods()){
            if(m.isAnnotationPresent(rule39.class)){
                tests++;
                try{
                    m.invoke(null);
                    passed++;
                } catch (InvocationTargetException | IllegalAccessException wrappedEx) {
                    Throwable exc = wrappedEx.getCause();
                    Class<? extends Throwable> excType = m.getAnnotation(rule39.class).value();
                    if(excType.isInstance(exc))
                        passed++;
                    else{
                        System.out.println("FAILED");
                    }
                }
            }
        }
        System.out.printf("Passed: %d, Failed: %d", passed, tests - passed);
    }
}
