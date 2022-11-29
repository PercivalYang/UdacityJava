package api;

import model.Customer;
import model.IRoom;
import model.Reservation;
import service.CustomerService;
import service.ReservationService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class HotelResource {
    private ReservationService reservationService = ReservationService.getInstance();
    private CustomerService customerService = CustomerService.getInstance();
    private static HotelResource hotelResource = null;

    public static HotelResource getInstance() {
        if (hotelResource == null)
            hotelResource = new HotelResource();
        return hotelResource;
    }

    private HotelResource() {
    }

    public Customer getCustomer(String email) {
        Customer customer = customerService.getCustomer(email);
        if (customer==null)
            System.out.println("Not found!");
        return null;
    }

    public void createACustomer(String email, String firstName, String lastName) {
        customerService.addCustomer(email,firstName,lastName);
    }

    public IRoom getRoom(String roomNumber) {
        IRoom room = reservationService.getARoom(roomNumber);
        if (room == null)
            System.out.println("Not found!");
        return room;
    }

    public Reservation bookARoom(String customerEmail, IRoom room, Date checkInDate, Date CheckOutDate){
        Customer customer = customerService.getCustomer(customerEmail);
        Reservation reservation = reservationService.reserveARoom(customer,room,checkInDate,CheckOutDate);
        return reservation;
    }

    public Collection<Reservation> getCustomersReservations(String customerEmail){
        Customer customer = customerService.getCustomer(customerEmail);
        Collection<Reservation> reservations = reservationService.getCustomersReservation(customer);
        return reservations;
    }

    public Collection<IRoom> findARoom(Date checkIn, Date checkOut){
        return reservationService.findRooms(checkIn,checkOut);
    }

}
