public class Vehicle {
    private String id;
    private String brand;
    private String model;
    private double dailyRate;
    private boolean available;

    public Vehicle(String id, String brand, String model, double dailyRate) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.dailyRate = dailyRate;
        this.available = true;
    }

    public String getId() { return id; }
    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public double getDailyRate() { return dailyRate; }
    public boolean isAvailable() { return available; }
    public void setAvailable(boolean status) { this.available = status; }

    @Override
    public String toString() {
        return id + " | " + brand + " " + model + " | ₹" + dailyRate + "/Day | " +
                (available ? "Available" : "Not Available");
    }
}
