import java.sql.*;
import java.util.Scanner;
public class DeleteReservation {
    private final Connection connection;
    private final Scanner scanner;
    private final ReservationExistsChecker existsChecker;

    public DeleteReservation(Connection connection, Scanner scanner) {
        this.connection = connection;
        this.scanner = scanner;
        this.existsChecker = new ReservationExistsChecker(connection);
    }

    public void execute() {
        try {
            System.out.print("Enter reservation ID to delete: ");
            int reservationId = scanner.nextInt();

            if (!existsChecker.exists(reservationId)) {
                System.out.println("Reservation not found for the given ID.");
                return;
            }

            String sql = "DELETE FROM reservations WHERE reservation_id = " + reservationId;

            try (Statement statement = connection.createStatement()) {
                int affectedRows = statement.executeUpdate(sql);

                if (affectedRows > 0) {
                    System.out.println("Reservation deleted successfully!");
                } else {
                    System.out.println("Reservation deletion failed.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
