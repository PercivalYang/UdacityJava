import api.AdminResource;
import api.HotelResource;
import model.Customer;
import model.IRoom;
import model.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Scanner;

public class MainMenu {
    public static AdminResource adminResource = AdminResource.getInstance();
    public static HotelResource hotelResource = HotelResource.getInstance();
    public static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        try {
            boolean exit = false;
            while (!exit) {
                String selection = showMenu();
                switch (selection) {
                    case "1" -> FindAndReserveARoom();
                    case "2" -> SeeMyReservations();
                    case "3" -> CreateAAccount();
                    case "4" -> {
                        AdminMenu.setAdminResource(adminResource);
                        AdminMenu.startAdminMenu();
                    }
                    case "5" -> exit = true;
                    default -> showMenu();
                }
            }
            System.exit(0);
        } catch (Exception e) {
            e.getLocalizedMessage();
        } finally {
            scanner.close();
        }
    }

    private static void FindAndReserveARoom() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        System.out.println("Enter checkInDate example 2022/11/29");
        Date checkInDate = dateFormat.parse(scanner.nextLine());
        System.out.println("Enter checkOutDate example 2022/11/29");
        Date checkOutDate = dateFormat.parse(scanner.nextLine());
        if (!checkDate(checkInDate,checkOutDate)){
            System.out.println("Invalid Date! Enter any key to back menu...");
            if (scanner.hasNext())
                main(new String[] {""});
        }
        Collection<IRoom> rooms = hotelResource.findARoom(checkInDate, checkOutDate);
        if (rooms.isEmpty()) {
            System.out.println("No rooms left, choose other date");
            return;
        }
        for (IRoom room : rooms) {
            System.out.println(room);
        }
        System.out.println("Choose a number of room");
        String roomNumber = scanner.nextLine();
        IRoom room = hotelResource.getRoom(roomNumber);
        System.out.println("Enter your Email name@domain.com:");
        String email = scanner.nextLine();
        hotelResource.bookARoom(email, room, checkInDate, checkOutDate);
        System.out.println("Book successfully!");
        waitBackMenu();
    }

    private static void SeeMyReservations() {
        System.out.println("Enter your Email name@domain.com:");
        String email = scanner.nextLine();
        Collection<Reservation> reservations = hotelResource.getCustomersReservations(email);
        for (Reservation reservation : reservations) {
            System.out.println(reservation);
        }
        waitBackMenu();
    }

    private static void CreateAAccount() {
        System.out.println("Enter firstName:");
        String firstName = scanner.nextLine();
        System.out.println("Enter lastName:");
        String lastName = scanner.nextLine();
        System.out.println("Enter your Email name@domain.com:");
        String email = scanner.nextLine();
        hotelResource.createACustomer(email, firstName, lastName);
        System.out.println(new Customer(firstName,lastName,email) + "  Create successfully!");
        waitBackMenu();
    }

    private static String showMenu() {
        System.out.println("__________________________________________________");
        System.out.println("   MAIN MENU");
        System.out.println("1. Find and reserve a room");
        System.out.println("2. See my reservations");
        System.out.println("3. Create an Account");
        System.out.println("4. Admin");
        System.out.println("5. Exit");
        System.out.println("__________________________________________________");
        System.out.println("Enter menu:");
        return scanner.nextLine();
    }

    private static boolean checkDate(Date cInDate, Date cOutDate){
        if (cInDate.after(cOutDate)) {
            return false;
        }
        return true;
    }

    private static void waitBackMenu(){
        System.out.println("Enter any key to back menu!");
        if (scanner.hasNext())
            main(new String[] {""});
    }
}
