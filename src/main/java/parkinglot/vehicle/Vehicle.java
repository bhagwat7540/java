package parkinglot.vehicle;

public abstract class Vehicle {
    private final int id;
    private final VehicleSize size;

    public Vehicle(final int id, final VehicleSize size) {
        this.id = id;
        this.size = size;
    }

    public int getId() {
        return id;
    }

    public VehicleSize getSize() {
        return size;
    }
}
