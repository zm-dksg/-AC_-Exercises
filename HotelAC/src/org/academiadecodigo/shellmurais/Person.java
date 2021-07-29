package org.academiadecodigo.shellmurais;

public class Person {

    private final String name;
    private int myRoomIndex = 100;
    private boolean myKey = false;

    private final Hotel hotel;

    public Person(String name, Hotel hotel) {
        this.name = name;
        this.hotel = hotel;

    }


    public void myCheckIn() {
        if (myRoomIndex != 100 && myKey) {
            System.out.println(Messages.ROOM_CHECK_IN_FAILED_TWO);

        } else {
            myRoomIndex = hotel.hotelCheckIn(name);
            myKey = true;

        }

    }

    public void myCheckOut() {
        if (myRoomIndex == 100 && !myKey) {
            System.out.println(Messages.ROOM_CHECK_OUT_FAILED);

        } else {
            myRoomIndex = hotel.hotelCheckOut(myRoomIndex);
            myKey = false;

        }

    }

    public String myRoomNumber() {
        if (myRoomIndex == 100 || !myKey) {
            return "---";

        } else {
            return hotel.printRoomNumber(myRoomIndex);

        }

    }

    public String myHotelName() {
        return hotel.getHotelName();

    }

    public void myHotelRoomList() {
        hotel.printHotelRoomList();

    }


    // getters && setters
    public String getPersonName() { return this.name; }

}
