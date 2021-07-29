package org.academiadecodigo.shellmurais;

public class Hotel {

    private final String hotelName = "Codigo Plaza";

    private final Room[] hotelRooms = {
        GameMaker.createRoom(101,"",false,false),     // room #101
        GameMaker.createRoom(102,"",false,false),     // room #102
        GameMaker.createRoom(201,"",false,false),     // room #201
        GameMaker.createRoom(202,"",false,false),     // room #202
        GameMaker.createRoom(301,"",false,false),     // room #301
        GameMaker.createRoom(302,"",false,false),     // room #302
        GameMaker.createRoom(401,"",false,false),     // room #401
        GameMaker.createRoom(402,"",false,false),     // room #402
        GameMaker.createRoom(501,"",false,false),     // room #501
        GameMaker.createRoom(502,"",false,false)      // room #502

    };

    public int hotelCheckIn(String clientName) {
        if (isHotelFull()) {
            System.out.println(Messages.ROOM_CHECK_IN_FAILED_ONE);

        } else {
            // checks for an unoccupied room and assigns it to a client
            for (int i = 0; i < hotelRooms.length; i++) {
                if (!hotelRooms[i].isRoomEmpty()) {
                    hotelRooms[i].setClientName(clientName);
                    hotelRooms[i].setRoomOccupied(true);
                    hotelRooms[i].setRoomKey(true);
                    System.out.println(Messages.ROOM_CHECK_IN_ONE);
                    System.out.println(Messages.ROOM_CHECK_IN_TWO + hotelRooms[i].getRoomNumber());
                    return i;

                }

            }

        }
        return 100;

    }

    public int hotelCheckOut(int i) {
        // removes everything from the hotel room
        hotelRooms[i].setClientName("");
        hotelRooms[i].setRoomOccupied(false);
        hotelRooms[i].setRoomKey(false);
        System.out.println(Messages.ROOM_CHECK_OUT_ONE);
        System.out.println(Messages.ROOM_CHECK_OUT_TWO + hotelRooms[i].getRoomNumber());

        return 100;

    }

    public String printRoomNumber(int i) {
        return "" + hotelRooms[i].getRoomNumber();

    }

    // getters && setters
    public String getHotelName() {
        return this.hotelName;

    }

    public void printHotelRoomList() {
        for (Room hotelRoom : hotelRooms) {
            System.out.println("Room nº" + hotelRoom.getRoomNumber() +
                    " (Occupied: " + hotelRoom.getClientName() + ")");
        }
    }

    private boolean isHotelFull() {
        for (Room hotelRoom : hotelRooms) {
            if (!hotelRoom.isRoomEmpty()) {
                return false;

            }

        }
        return true;
    }

}
