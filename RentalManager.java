import java.util.*;

public class RentalManager {

    private List<Vehicle> vehicles = new ArrayList<>();
    private List<Customer> customers = new ArrayList<>();
    private List<Booking> bookings = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    // Add vehicles
    public void addVehicle(Vehicle v) { vehicles.add(v); }

    // Register customer
    public void registerCustomer() {
        System.out.print("Enter Customer ID: ");
        String id = sc.next();
        sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Phone: ");
        String phone = sc.next();
        customers.add(new Customer(id, name, phone));
        System.out.println("Customer Registered!");
    }

    // List all vehicles
    public void listVehicles() {
        System.out.println("\n--- Vehicle List ---");
        for (Vehicle v : vehicles) System.out.println(v);
    }

    // Search vehicle
    public void searchVehicle() {
        System.out.print("Enter brand or model to search: ");
        String key = sc.next().toLowerCase();

        vehicles.stream()
                .filter(v -> v.getBrand().toLowerCase().contains(key) ||
                             v.getModel().toLowerCase().contains(key))
                .forEach(System.out::println);
    }

    // Rent a car
    public void rentVehicle() {
        System.out.print("Enter Customer ID: ");
        String cid = sc.next();

        System.out.print("Enter Vehicle ID: ");
        String vid = sc.next();

        Vehicle selected = vehicles.stream()
                .filter(v -> v.getId().equalsIgnoreCase(vid))
                .findFirst()
                .orElse(null);

        if (selected == null || !selected.isAvailable()) {
            System.out.println("Vehicle unavailable!");
            return;
        }

        System.out.print("Enter Number of Days: ");
        int days = sc.nextInt();

        Booking booking = new Booking(UUID.randomUUID().toString(), cid, vid, days);
        bookings.add(booking);
        selected.setAvailable(false);

        System.out.println("Vehicle Rented Successfully!");
    }

    // Return a vehicle
    public void returnVehicle() {
        System.out.print("Enter Vehicle ID: ");
        String vid = sc.next();

        Vehicle vehicle = vehicles.stream()
                .filter(v -> v.getId().equalsIgnoreCase(vid))
                .findFirst().orElse(null);

        if (vehicle == null || vehicle.isAvailable()) {
            System.out.println("Invalid return attempt!");
            return;
        }

        Booking booking = bookings.stream()
                .filter(b -> b.vehicleId.equals(vid) && !b.returned)
                .findFirst().orElse(null);

        if (booking == null) {
            System.out.println("Booking not found!");
            return;
        }

        System.out.print("Enter actual days used: ");
        int actualDays = sc.nextInt();

        int extraDays = actualDays - booking.rentedDays;
        double fine = (extraDays > 0) ? extraDays * (vehicle.getDailyRate() * 0.5) : 0;

        double finalAmount = (actualDays * vehicle.getDailyRate()) + fine;

        booking.markReturned(finalAmount);
        vehicle.setAvailable(true);

        System.out.println("Vehicle Returned!");
        System.out.println("Total Amount: ₹" + finalAmount);
    }

    // View booking history
    public void viewHistory() {
        System.out.println("\n--- Booking History ---");
        bookings.forEach(System.out::println);
    }

    // Menu
    public void menu() {
        while (true) {
            System.out.println("\n===== CAR RENTAL SYSTEM =====");
            System.out.println("1. Register Customer");
            System.out.println("2. View All Vehicles");
            System.out.println("3. Search Vehicle");
            System.out.println("4. Rent Vehicle");
            System.out.println("5. Return Vehicle");
            System.out.println("6. View Booking History");
            System.out.println("7. Exit");
            System.out.print("Select Option: ");

            int ch = sc.nextInt();
            switch (ch) {
                case 1 -> registerCustomer();
                case 2 -> listVehicles();
                case 3 -> searchVehicle();
                case 4 -> rentVehicle();
                case 5 -> returnVehicle();
                case 6 -> viewHistory();
                case 7 -> {
                    System.out.println("Thank You!");
                    return;
                }
                default -> System.out.println("Invalid Option!");
            }
        }
    }
}
