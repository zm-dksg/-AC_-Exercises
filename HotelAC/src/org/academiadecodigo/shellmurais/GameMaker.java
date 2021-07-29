package org.academiadecodigo.shellmurais;

// class that creates the instances
public class GameMaker {

    public static Person createPerson(String name, Hotel hotel) {
        return new Person(name,hotel);

    }

    public static Hotel createHotel() {
        return new Hotel();

    }

    public static Room createRoom(int roomNumber, String clientName, boolean roomOccupied, boolean roomKey) {
        return new Room(roomNumber, clientName, roomOccupied, roomKey);

    }

}
