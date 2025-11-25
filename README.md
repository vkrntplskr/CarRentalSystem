# Car Rental System (Console-based)

A lightweight, console-based Java application designed to manage car rental operations. This system handles the lifecycle of a vehicle rental, from customer registration to vehicle return and billing calculation.

## 📋 Features

  * **Vehicle Management**: View a list of all available cars or search for specific vehicles by brand or model.
  * **Customer Registration**: Simple onboard system to register new customers with ID, Name, and Phone.
  * **Rental Processing**: Checks vehicle availability and books cars for specific durations.
  * **Return & Billing**:
      * Calculates total bill based on days used.
      * **Fine System**: Automatically calculates fines for late returns (overdue days).
  * **Availability Tracking**: Automatically updates vehicle status (Available/Not Available) upon renting or returning.
  * **Booking History**: View a log of all rental transactions.

## 🛠️ Project Structure

The project consists of 5 Java classes:

  * `Main.java`: The entry point of the application. Pre-loads dummy vehicle data and launches the menu.
  * `RentalManager.java`: The core controller. Handles inputs, manages lists (vehicles, customers, bookings), and executes business logic.
  * `Vehicle.java`: Model class representing a car (ID, Brand, Model, Daily Rate, Availability).
  * `Customer.java`: Model class representing a client (ID, Name, Phone).
  * `Booking.java`: Model class for rental transactions (Tracks rental days, return status, and final bill).

## 🚀 How to Run

### Prerequisites

  * Java Development Kit (JDK) 8 or higher installed.

### Compilation & Execution

1.  Open your terminal or command prompt.
2.  Navigate to the directory containing the `.java` files.
3.  Compile the source code:
    ```bash
    javac *.java
    ```
4.  Run the application:
    ```bash
    java Main
    ```

## 💰 Billing & Fine Policy

The system calculates the final amount in `RentalManager.java` using the following logic:

1.  **Standard Rate**: Calculated as `Actual Days Used * Daily Rate`.
2.  **Late Return Fine**:
      * If the user keeps the car longer than the initially rented days, a fine is applied.
      * **Fine Calculation**: `Extra Days * (Daily Rate * 0.5)`
      * *Effectively, overdue days are charged at 1.5x the normal rate.*

**Example:**

  * **Daily Rate**: ₹1000
  * **Rented For**: 2 Days
  * **Returned After**: 3 Days (1 day late)
  * **Bill**: (3 \* 1000) + (1 \* 500) = **₹3500**

## 📖 Usage Guide

Once the application is running, follow the on-screen numeric menu:

1.  **Register Customer**: Enter a unique ID, Name, and Phone number.
2.  **View All Vehicles**: See the fleet list (e.g., Toyota Glanza, Hyundai i20, Mahindra Thar).
3.  **Search Vehicle**: Type "Toyota" or "Thar" to filter results.
4.  **Rent Vehicle**: Enter the Customer ID and Vehicle ID to book. *Note: You cannot rent a vehicle that is already marked "Not Available".*
5.  **Return Vehicle**: Enter the Vehicle ID and the *actual* number of days the car was used to generate the final bill.
6.  **View History**: See a log of all past and current bookings.

## 🔮 Future Improvements

  * Implement File Handling or Database connectivity to persist data after the program closes.
  * Add input validation (e.g., prevent negative days or duplicate IDs).
  * Create a Graphical User Interface (GUI) using JavaFX or Swing.
