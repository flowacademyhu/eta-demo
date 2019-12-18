package hu.flowacademy.eta.demo.spacexstatus;

public class Engine {

    private int number;

    private String type;

    private String propellant_1;

    private String propellant_2;

    @Override
    public String toString() {
        return "Engine{" +
                "number=" + number +
                ", type='" + type + '\'' +
                ", propellant_1='" + propellant_1 + '\'' +
                ", propellant_2='" + propellant_2 + '\'' +
                '}';
    }
}
