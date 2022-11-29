package model;

import javax.swing.plaf.PanelUI;
import java.util.Date;

public class Reservation {
    private Customer customer;
    private IRoom room;
    private Date checkInDate;
    private Date checkOutDate;

    public Reservation(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {
        this.customer = customer;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    public IRoom getRoom(){
        return room;
    }
    public Customer getCustomer(){
        return customer;
    }
    public Date getCheckInDate(){
        return checkInDate;
    }
    public Date getCheckOutDate(){
        return checkOutDate;
    }

    public boolean checkFree(Date cInDate, Date cOutDate){
        if (cInDate.after(checkOutDate) || cOutDate.before(checkInDate)){
            return true;
        }
        return false;
    }
    @Override
    public String toString() {
        return "Customer: " + customer.getName() +
                "\n  Room: " + room.getRoomNumber() + "\n  checkIn: " + checkInDate + "\n  checkOut: " + checkOutDate;
    }
}
