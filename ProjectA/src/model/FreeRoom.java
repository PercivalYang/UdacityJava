package model;

public class FreeRoom extends Room {
    public FreeRoom(String number, RoomType type) {
        super(number, 0, type);
    }


    @Override
    public String toString() {
        String roomType = null;
        if (getRoomType().equals(RoomType.SINGLE)) {
            roomType = "Single";
        } else if (getRoomType().equals(RoomType.DOUBLE)) {
            roomType = "Double";
        }
        return "Number: " + getRoomNumber() + " Type: " + roomType + " Free!!";
    }

    public static void main(String[] args) {
        FreeRoom a = new FreeRoom("003", RoomType.SINGLE);
        System.out.println(a);
    }
}
