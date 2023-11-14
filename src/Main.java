import java.sql.SQLException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {


    public static void main(String[] args)  {
        try {
            HotelReservationSystemApp app = new HotelReservationSystemApp("jdbc:mysql://localhost:3306/hotel_db", "root", "Akanksha1998@");
            app.run();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}