package model;

public class Room implements IRoom {
    private String roomNumber;
    private Double roomPrice;
    private RoomType roomType;

    public Room(String number, double price, RoomType Rtype) {
        roomNumber = number;
        roomPrice = price;
        roomType = Rtype;
    }

    @Override
    public String getRoomNumber() {
        return roomNumber;
    }

    @Override
    public Double getRoomPrice() {
        return roomPrice;
    }

    @Override
    public RoomType getRoomType() {
        return roomType;
    }

    @Override
    public boolean isFree() {
        return false;
    }

    @Override
    public String toString() {
        String roomType = null;
        if (getRoomType().equals(RoomType.SINGLE)) {
            roomType = "Single";
        } else if (getRoomType().equals(RoomType.DOUBLE)) {
            roomType = "Double";
        }
        return "Number: " + roomNumber + "\n  \\_Price: " + roomPrice + "\n  \\_Type: " + roomType;
    }
}
