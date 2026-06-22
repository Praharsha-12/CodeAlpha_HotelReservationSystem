import java.util.*;

class Room {

    int roomNumber;
    String category;
    boolean booked;

    Room(int roomNumber, String category) {
        this.roomNumber = roomNumber;
        this.category = category;
        this.booked = false;
    }
}

public class HotelReservationSystem {

    static ArrayList<Room> rooms = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        rooms.add(new Room(101, "Standard"));
        rooms.add(new Room(102, "Standard"));
        rooms.add(new Room(201, "Deluxe"));
        rooms.add(new Room(202, "Deluxe"));
        rooms.add(new Room(301, "Suite"));

        while (true) {

            System.out.println("\n1. View Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. Cancel Booking");
            System.out.println("4. Exit");

            System.out.print("Choose option: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    viewRooms();
                    break;

                case 2:
                    System.out.print("Enter room number: ");
                    int roomNo = sc.nextInt();
                    bookRoom(roomNo);
                    break;

                case 3:
                    System.out.print("Enter room number: ");
                    roomNo = sc.nextInt();
                    cancelRoom(roomNo);
                    break;

                case 4:
                    System.out.println("Thank You");
                    return;

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }

    static void viewRooms() {

        System.out.println("\nAvailable Rooms:");

        for (Room r : rooms) {

            String status;

            if (r.booked)
                status = "Booked";
            else
                status = "Available";

            System.out.println(
                    r.roomNumber + " | " +
                    r.category + " | " +
                    status);
        }
    }

    static void bookRoom(int roomNo) {

        for (Room r : rooms) {

            if (r.roomNumber == roomNo) {

                if (!r.booked) {

                    System.out.println("Payment Successful");
                    r.booked = true;

                    System.out.println("Room Booked Successfully");
                }
                else {
                    System.out.println("Room Already Booked");
                }

                return;
            }
        }

        System.out.println("Room Not Found");
    }

    static void cancelRoom(int roomNo) {

        for (Room r : rooms) {

            if (r.roomNumber == roomNo) {

                if (r.booked) {

                    r.booked = false;
                    System.out.println("Booking Cancelled");
                }
                else {
                    System.out.println("Room Not Booked");
                }

                return;
            }
        }

        System.out.println("Room Not Found");
    }
}