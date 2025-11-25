public class Booking {
    private String bookingId;
    String customerId;
    String vehicleId;
    int rentedDays;
    boolean returned;
    double totalAmount;

    public Booking(String bookingId, String customerId, String vehicleId, int rentedDays) {
        this.bookingId = bookingId;
        this.customerId = customerId;
        this.vehicleId = vehicleId;
        this.rentedDays = rentedDays;
        this.returned = false;
    }

    public void markReturned(double totalAmount) {
        this.totalAmount = totalAmount;
        this.returned = true;
    }

    @Override
    public String toString() {
        return "Booking ID: " + bookingId +
                " | Customer: " + customerId +
                " | Car: " + vehicleId +
                " | Days: " + rentedDays +
                " | Returned: " + returned +
                " | Bill: ₹" + totalAmount;
    }
}
