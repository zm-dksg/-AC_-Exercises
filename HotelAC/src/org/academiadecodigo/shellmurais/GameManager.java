package org.academiadecodigo.shellmurais;

import java.util.Scanner;

public class GameManager {

    public static void gameStart(Person[] personArray) {

        Scanner scan = new Scanner(System.in);

        boolean gameRunning = true;

        while (gameRunning) {

            // printing the player menu
            System.out.println();
            System.out.println("01. Play as Ze");
            System.out.println("02. Play as Sara");
            System.out.println("03. Play as Bento");
            System.out.println("04. Play as Xico");
            System.out.println("05. Play as Bertolo");
            System.out.println("06. Play as Paulo");
            System.out.println("07. Play as Catarina");
            System.out.println("08. Play as Hadassa");
            System.out.println("09. Play as Carneiro");
            System.out.println("10. Play as Rodrigo");
            System.out.println("11. Play as Mariana");
            System.out.println("12. Exit");
            System.out.print("> ");

            switch (scan.nextLine()) {
                case "1":       GameManager.gameStartHotel(personArray[0]);
                                break;
                case "2":       GameManager.gameStartHotel(personArray[1]);
                                break;
                case "3":       GameManager.gameStartHotel(personArray[2]);
                                break;
                case "4":       GameManager.gameStartHotel(personArray[3]);
                                break;
                case "5":       GameManager.gameStartHotel(personArray[4]);
                                break;
                case "6":       GameManager.gameStartHotel(personArray[5]);
                                break;
                case "7":       GameManager.gameStartHotel(personArray[6]);
                                break;
                case "8":       GameManager.gameStartHotel(personArray[7]);
                                break;
                case "9":       GameManager.gameStartHotel(personArray[8]);
                                break;
                case "10":      GameManager.gameStartHotel(personArray[9]);
                                break;
                case "11":      GameManager.gameStartHotel(personArray[10]);
                                break;

                case "12":      gameRunning = false;

                default:        System.out.println(Messages.GAME_ERROR);
                                break;

            }

        }

    }


    public static void gameStartHotel(Person person) {

        Scanner scan = new Scanner(System.in);

        boolean gameRunning = true;

        while (gameRunning) {

            // printing the hotel menu
            System.out.println();
            System.out.println("1. Check-In");
            System.out.println("2. Check-Out");
            System.out.println("3. Hotel Details");
            System.out.println("4. My Details");
            System.out.println("5. Exit");
            System.out.print("> ");

            switch (scan.nextLine()) {
                case "1":
                case "check in":
                case "Check In":
                case "CHECK IN":
                case "check-in":
                case "Check-In":
                case "CHECK-IN":        person.myCheckIn();
                                        break;

                case "2":
                case "check out":
                case "Check Out":
                case "CHECK OUT":
                case "check-out":
                case "Check-Out":
                case "CHECK-OUT":       person.myCheckOut();
                                        break;

                // display the hotel room list and their occupant
                case "3":
                case "hotel details":
                case "Hotel Details":
                case "HOTEL DETAILS":   System.out.println("Hotel Name: " + person.myHotelName());
                                        person.myHotelRoomList();
                                        break;

                // display my details
                case "4":
                case "my details":
                case "My Details":
                case "MY DETAILS":      System.out.println("My Name: " + person.getPersonName());
                                        System.out.println("My Room: " + person.myRoomNumber());
                                        break;

                // leave the hotel
                case "5":
                case "exit":
                case "Exit":
                case "EXIT":            gameRunning = false;

                default:                System.out.println(Messages.GAME_ERROR);
                                        break;

            }

        }

    }

}
