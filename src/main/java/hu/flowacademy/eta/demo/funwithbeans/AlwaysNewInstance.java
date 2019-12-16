package hu.flowacademy.eta.demo.funwithbeans;

public class AlwaysNewInstance {

    private static int counter = 0;

    public AlwaysNewInstance() {
        counter++;
    }

    public static int getCounter() {
        return counter;
    }
}
