package hu.flowacademy.eta.demo.builder;

public class Usage {

    public static void main(String[] args) {
        Computer build =
                Computer.builder().processor(true)
                        .storage(5).otherAdapters(1).build();
    }
}
