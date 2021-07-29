package org.academiadecodigo.shellmurais;

public class Room {

    private String clientName;
    private final int roomNumber;
    private boolean roomOccupied;
    private boolean roomKey;

    public Room (int roomNumber, String clientName, boolean roomOccupied, boolean roomKey) {
        this.roomNumber = roomNumber;
        this.clientName = clientName;
        this.roomOccupied = roomOccupied;
        this.roomKey = roomKey;

    }

    // getters && setters
    public int getRoomNumber() {
        return this.roomNumber;

    }

    public String getClientName() {
        return this.clientName;

    }
    public void setClientName(String clientName) {
        this.clientName = clientName;

    }

    public boolean isRoomEmpty() {
        return !roomOccupied;

    }
    public void setRoomOccupied(boolean roomOccupied) {
        this.roomOccupied = roomOccupied;
    }

    public boolean getRoomkey() {
        return roomKey;

    }
    public void setRoomKey(boolean roomKey) {
        this.roomKey = roomKey;

    }


}
