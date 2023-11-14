import java.sql.*;
import java.util.Properties;
import java.util.Scanner;
public class HotelReservationSystemApp {
    private final Connection connection;
    private final Scanner scanner;

    public HotelReservationSystemApp(String url, String username, String password) throws ClassNotFoundException, SQLException {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        try {
            this.connection = DriverManager.getConnection(url, username, password);
        }catch(SQLException e){
            System.out.println("Error connecting to the database. Check your connection parameters.");
            throw e;
        }
        this.scanner = new Scanner(System.in);
    }

    public void run()  {
        try {
            while (true) {
                displayMenu();
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        new ReserveRoom(connection, scanner).execute();
                        break;
                    case 2:
                        new ViewReservations(connection).execute();
                        break;
                    case 3:
                        new GetRoomNumber(connection, scanner).execute();
                        break;
                    case 4:
                        new UpdateReservation(connection, scanner).execute();
                        break;
                    case 5:
                        new DeleteReservation(connection, scanner).execute();
                        break;
                    case 0:
                        exit();
                        return;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            }
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    private void displayMenu() {
        System.out.println("HOTEL MANAGEMENT SYSTEM");
        System.out.println("1. Reserve a room");
        System.out.println("2. View Reservations");
        System.out.println("3. Get Room Number");
        System.out.println("4. Update Reservations");
        System.out.println("5. Delete Reservations");
        System.out.println("0. Exit");
        System.out.print("Choose an option: ");
    }

    private void exit() throws InterruptedException {
        System.out.print("Exiting System");
        int i = 5;
        while (i != 0) {
            System.out.print(".");
            Thread.sleep(350);
            i--;
        }
        System.out.println();
        System.out.println("Thank You For Using Hotel Reservation System!!!");
    }
}
