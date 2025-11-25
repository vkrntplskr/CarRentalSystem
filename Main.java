public class Main {
    public static void main(String[] args) {

        RentalManager manager = new RentalManager();

        manager.addVehicle(new Vehicle("CR101", "Toyota", "Glanza", 1000));
        manager.addVehicle(new Vehicle("CR102", "Hyundai", "i20", 1200));
        manager.addVehicle(new Vehicle("CR103", "Mahindra", "Thar", 3000));

        manager.menu();
    }
}
