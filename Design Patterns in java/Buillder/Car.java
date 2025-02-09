class Car {
    private String engine;
    private int wheels;
    private boolean sunroof;

    private Car(CarBuilder builder) {
        this.engine = builder.engine;
        this.wheels = builder.wheels;
        this.sunroof = builder.sunroof;
    }

    public void showCarDetails() {
        System.out.println("Car with engine: " + engine + ", wheels: " + wheels + ", sunroof: " + sunroof);
    }

    public static class CarBuilder {
        private String engine;
        private int wheels;
        private boolean sunroof;

        public CarBuilder setEngine(String engine) {
            this.engine = engine;
            return this;
        }

        public CarBuilder setWheels(int wheels) {
            this.wheels = wheels;
            return this;
        }

        public CarBuilder setSunroof(boolean sunroof) {
            this.sunroof = sunroof;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }

    public static void main(String[] args) {
        Car car = new Car.CarBuilder()
                .setEngine("V8")
                .setWheels(4)
                .setSunroof(true)
                .build();

        car.showCarDetails();
    }
}
