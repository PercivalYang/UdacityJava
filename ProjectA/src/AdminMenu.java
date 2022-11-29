import api.AdminResource;
import api.HotelResource;
import model.*;

import javax.lang.model.element.AnnotationMirror;
import java.net.http.HttpClient;
import java.util.Collection;
import java.util.Scanner;

public class AdminMenu {
    public static AdminResource adminResource = AdminResource.getInstance();
    public static Scanner scanner;

    public static void setAdminResource(AdminResource adminResource) {
        AdminMenu.adminResource = adminResource;
    }

    public static void startAdminMenu() {
        scanner = new Scanner(System.in);
        try {
            boolean exit = false;
            while (!exit) {
                String selection = showAdminMenu();
                switch (selection) {
                    case "1" -> SeeAllCustomers();
                    case "2" -> SeeAllrooms();
                    case "3" -> SeeAllReservations();
                    case "4" -> AddARoom();
                    case "5" -> MainMenu.main(new String[]{""});
                    default -> showAdminMenu();
                }
            }
        } catch (Exception e) {
            e.getLocalizedMessage();
        } finally {
            scanner.close();
        }
    }

    private static void SeeAllCustomers() {
        Collection<Customer> customers = adminResource.getAllCustomers();
        System.out.println("Customers:");
        for (Customer customer:customers){
            System.out.println(" "+customer);
        }
        waitBackMenu();
    }

    private static void waitBackMenu(){
        System.out.println("Enter any key to back menu!");
        if (scanner.hasNext())
            startAdminMenu();
    }

    private static void SeeAllrooms() {
        Collection<IRoom> rooms = adminResource.getAllRooms();
        System.out.println("Rooms:");
        for (IRoom room:rooms){
            System.out.println("  "+room);
        }
        waitBackMenu();
    }

    private static void SeeAllReservations() {
        adminResource.displayAllReservations();
        System.out.println("Enter any key to back menu");
        if (scanner.hasNext())
            startAdminMenu();
        waitBackMenu();
    }

    private static void AddARoom() {
        IRoom room;
        System.out.println("Enter the number of room");
        String roomNumber = scanner.nextLine();
        System.out.println("Enter the type of room 1: SINGLE 2: DOUBLE");
        RoomType roomType = scanner.nextLine().equals("1") ? RoomType.SINGLE : RoomType.DOUBLE;
        System.out.println("Enter the price of room");
        double roomPrice = scanner.nextDouble();
        if (roomPrice == 0.0){
            room = new FreeRoom(roomNumber, roomType);
        }else {
            room = new Room(roomNumber,roomPrice,roomType);
        }
        adminResource.addRoom(room);
        System.out.println(room + "\nRoom added successfully!");
        waitBackMenu();
    }

    private static String showAdminMenu() {
        System.out.println("__________________________________________________");
        System.out.println("   ADMIN MENU");
        System.out.println("1. See all Customers");
        System.out.println("2. See all Rooms");
        System.out.println("3. See all Reservations");
        System.out.println("4. Add a Room");
        System.out.println("5. Back to Main Menu");
        System.out.println("__________________________________________________");
        System.out.println("Enter menu:");
        return scanner.nextLine();
    }

}
