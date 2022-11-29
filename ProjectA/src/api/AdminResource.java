package api;

import model.*;
import service.*;

import java.nio.file.spi.FileSystemProvider;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.jar.JarEntry;

public class AdminResource {
    private ReservationService reservationService = ReservationService.getInstance();
    private CustomerService customerService = CustomerService.getInstance();
    private static AdminResource adminResource=null;
    public static AdminResource getInstance(){
        if (adminResource==null){
            adminResource=new AdminResource();
        }
        return adminResource;
    }
    private AdminResource(){

    }
    public void addRoom(IRoom rooms){
        reservationService.addRoom(rooms);
    }
    public Customer getCustomer(String email){
        return customerService.getCustomer(email);
    }
    public Collection<IRoom> getAllRooms(){
        return reservationService.getAllRooms();
    }
    public Collection<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }
    public void displayAllReservations(){
        reservationService.printAllReservation();
    }

}
