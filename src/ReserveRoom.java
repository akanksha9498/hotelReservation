import java.sql.*;
import java.util.Scanner;
public class ReserveRoom {
    private final Connection connection;
    private final Scanner scanner;

    public ReserveRoom(Connection connection, Scanner scanner) {
        this.connection = connection;
        this.scanner = scanner;
    }

    public void execute() {
        try {
            System.out.print("Enter guest first name: ");

            String guest_fName = scanner.next();
            System.out.print("Enter guest last name: ");
            String guest_lname = scanner.next();
            String guestName = guest_fName+" "+guest_lname;
            scanner.nextLine();
            System.out.print("Enter room number: ");
            int roomNumber = scanner.nextInt();
            System.out.print("Enter contact number: ");
            String contactNumber = scanner.next();

            String sql = "INSERT INTO reservations (guest_name, room_number, contact_number) " +
                    "VALUES ('" + guestName + "', " + roomNumber + ", '" + contactNumber + "')";

            try (Statement statement = connection.createStatement()) {

                int affectedRows = statement.executeUpdate(sql);

                if (affectedRows > 0) {
                    System.out.println("Reservation successful !");

                } else {
                    System.out.println("Reservation failed.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
