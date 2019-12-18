package hu.flowacademy.eta.demo.spacexstatus;

public class Rocket {

    private int id;

    private String rocket_name;

    private String rocket_type;

    private Engine engines;

    @Override
    public String toString() {
        return "Rocket{" +
                "id=" + id +
                ", rocket_name='" + rocket_name + '\'' +
                ", rocket_type='" + rocket_type + '\'' +
                ", engines=" + engines +
                '}';
    }
}
