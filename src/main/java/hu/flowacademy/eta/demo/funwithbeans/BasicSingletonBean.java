package hu.flowacademy.eta.demo.funwithbeans;

public class BasicSingletonBean {

    private static int counter = 0;

    public BasicSingletonBean() {
        counter++;
    }

    public static int getCounter() {
        return counter;
    }
}
