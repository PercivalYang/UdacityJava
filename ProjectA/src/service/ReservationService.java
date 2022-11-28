package service;

import model.Customer;
import model.IRoom;
import model.Reservation;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ReservationService {

    private Map<String, IRoom> reservations;
    private static ReservationService reservationService = null;
    public static ReservationService getInstance(){
        if (reservationService == null){
            reservationService = new ReservationService();
        }
        return reservationService;
    }
    private ReservationService(){
        reservations = new HashMap<>();
    }
    public void addRoom(IRoom room){
        reservations.put(room.getRoomNumber(),room);
    }
    public IRoom getARoom(String roomId){
        return reservations.get(roomId);
    }
    public Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate){

    }
    public Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate){

    }
    public Collection<Reservation> getCustomersReservation(Customer customer){

    }
    public void printAllReservation(){

    }
}
