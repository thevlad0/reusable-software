package mobile.vehicle;

public record Car(
        String brand,
        String model,
        int price,
        Boolean isManual
) implements Vehicle {

    @Override
    public String toString() {
        return model;
    }
}
