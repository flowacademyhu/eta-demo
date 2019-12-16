package hu.flowacademy.eta.demo.funwithbeans;

public class RequestScopeBean {

    private static int counter = 0;

    public RequestScopeBean() {
        counter++;
    }

    public static int getCounter() {
        return counter;
    }
}
