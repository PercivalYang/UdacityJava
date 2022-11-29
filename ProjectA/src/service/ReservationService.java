package service;

import model.Customer;
import model.IRoom;
import model.Reservation;

import java.util.*;

public class ReservationService {

    private List<IRoom> rooms;
    private Map<IRoom, Reservation> reservations;
    private static ReservationService reservationService = null;

    public static ReservationService getInstance() {
        if (reservationService == null) {
            reservationService = new ReservationService();
        }
        return reservationService;
    }

    private ReservationService() {
        rooms = new ArrayList<>();
        reservations = new HashMap<>();
    }

    public void addRoom(IRoom room) {
        if (!rooms.isEmpty()) {
            for (IRoom r : rooms) {
                if (r.getRoomNumber() == room.getRoomNumber() && r.getRoomType() == room.getRoomType())
                    System.out.println("Room already added!");
            }
        }
        rooms.add(room);
    }

    public IRoom getARoom(String roomId) {
        if (!rooms.isEmpty()) {
            for (IRoom room : rooms) {
                if (room.getRoomNumber().equals(roomId)) {
                    return room;
                }
            }
        }
        System.out.println("No room added");
        return null;
    }

    public Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {
        Reservation n_reser = new Reservation(customer, room, checkInDate, checkOutDate);
        reservations.put(room,n_reser);
        return n_reser;
    }

    public Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate) {
        List<IRoom> free_rooms = new ArrayList<>();
        try {
            for (IRoom room : rooms) {
                if (reservations.containsKey(room)) {
                    if (reservations.get(room).checkFree(checkInDate, checkOutDate)) {
                        free_rooms.add(room);
                    }
                }else {
                    free_rooms.add(room);
                }
            }
        } catch (Exception e) {
            if (reservations.isEmpty()) return null;
        }
        return free_rooms;
    }

    public Collection<Reservation> getCustomersReservation(Customer customer) {
        List<Reservation> cust_reser = new ArrayList<>();
        try {
            for (Reservation reservation : reservations.values()) {
                if (reservation.getCustomer().equals(customer)) {
                    cust_reser.add(reservation);
                }
            }
        } catch (Exception e) {
            if (reservations.isEmpty()) return null;
        }
        return cust_reser;
    }

    public void printAllReservation() {
        for (Reservation reservation : reservations.values()) {
            System.out.println(reservation);
        }
    }

    public Collection<IRoom> getAllRooms() {
        return rooms;
    }
}
