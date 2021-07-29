package org.academiadecodigo.shellmurais;

public class HotelAC {
    public static void main(String[] args) {

        Hotel hotel = GameMaker.createHotel();

        Person[] personArray = {
            GameMaker.createPerson("Ze",hotel),         // person #01
            GameMaker.createPerson("Sara", hotel),      // person #02
            GameMaker.createPerson("Bento", hotel),     // person #03
            GameMaker.createPerson("Xico",hotel),       // person #04
            GameMaker.createPerson("Bertolo",hotel),    // person #05
            GameMaker.createPerson("Paulo",hotel),      // person #06
            GameMaker.createPerson("Catarina",hotel),   // person #07
            GameMaker.createPerson("Hadassa",hotel),    // person #08
            GameMaker.createPerson("Carneiro",hotel),   // person #09
            GameMaker.createPerson("Rodrigo",hotel),    // person #10
            GameMaker.createPerson("Mariana",hotel)     // person #11

        };

        System.out.println(Messages.GAME_WELCOME);

        // GameManager.gameStart(person);
        GameManager.gameStart(personArray);

        System.out.println(Messages.GAME_END);

    }

}
