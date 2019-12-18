package hu.flowacademy.eta.demo.builder;

public class Computer {

    private final int ramCount;
    private final int pcieSlots;
    private final boolean processor;
    private final int storage;
    private final int otherAdapters;

    private Computer(Computer.Builder builder) {
        this.ramCount = builder.ramCount;
        this.pcieSlots = builder.pcieSlots;
        this.processor = builder.processor;
        this.storage = builder.storage;
        this.otherAdapters = builder.otherAdapters;
    }

    public static Computer.Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private int ramCount;
        private int pcieSlots;
        private boolean processor;
        private int storage;
        private int otherAdapters;

        private Builder() {}

        public Computer build() {
            return new Computer(this);
        }

        public Builder ramCount(int ramCount) {
            this.ramCount = ramCount;
            return this;
        }

        public Builder pcieSlots(int pcieSlots) {
            this.pcieSlots = pcieSlots;
            return this;
        }

        public Builder processor(boolean processor) {
            this.processor = processor;
            return this;
        }
        public Builder storage(int storage) {
            this.storage = storage;
            return this;
        }
        public Builder otherAdapters(int otherAdapters) {
            this.otherAdapters = otherAdapters;
            return this;
        }
    }

}
