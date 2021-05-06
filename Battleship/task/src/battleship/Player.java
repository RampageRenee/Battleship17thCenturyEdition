package battleship;

import java.util.Scanner;

public class Player extends Field {
    private String name;
    boolean turn;


    Scanner scanner = new Scanner(System.in);
    private boolean goodInput = false;
    private String coordinates_input, cooStart, cooEnd;
    private String[] cooPionts;



    private final String[] prinsWillim = new String[Ship.PRINSWILLIM.getSize()];
    private final String[] zevenProvincien = new String[Ship.ZEVENPROVINCIEN.getSize()];
    private final String[] eendragt = new String[Ship.EENDRAGT.getSize()];
    private final String[] aemilia = new String[Ship.AEMILIA.getSize()];
    private final String[] brederode = new String[Ship.BREDERODE.getSize()];



    public Player(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }


    public void placePrinsWillim(Player player, String[][] field){
        while (!goodInput) {

            System.out.println("enter the coordinates of the " + Ship.PRINSWILLIM.getDiscription() +  " :");
            coordinates_input = scanner.nextLine();

            cooPionts = coordinates_input.split(" ");
            cooPionts = player.orderCoordinates(cooPionts);
            cooStart = cooPionts[0]; cooEnd = cooPionts[1];


            if (Ship.PRINSWILLIM.isValid(cooStart, cooEnd)) {
                if (player.checkPlacement(cooPionts, field)) {
                    player.placeShip(cooStart, cooEnd, field);
                    player.setPlacement(prinsWillim,cooStart,cooEnd);
                    goodInput = true;
                } else {
                    System.out.println("Error! Wrong ship location! Try again:");
                }
            } else {
                System.out.println("Error! Wrong length of the " + Ship.PRINSWILLIM.getDiscription() + "! Try again: ");
            }
        } //Aircraft Carrier
        goodInput = false;
    }

    public void placeZevenProvincien(Player player, String[][] field){
        while (!goodInput) {

            System.out.println("enter the coordinates of the " + Ship.ZEVENPROVINCIEN.getDiscription() + " :");
            coordinates_input = scanner.nextLine();

            cooPionts = coordinates_input.split(" ");
            cooPionts = player.orderCoordinates(cooPionts);
            cooStart = cooPionts[0];
            cooEnd = cooPionts[1];


            if (Ship.ZEVENPROVINCIEN.isValid(cooStart, cooEnd)) {
                if (player.checkPlacement(cooPionts, field)) {
                    player.placeShip(cooStart, cooEnd, field);
                    player.setPlacement(zevenProvincien,cooStart,cooEnd);
                    goodInput = true;
                } else {
                    System.out.println("Error! Wrong ship location! Try again:");
                }
            } else {
                System.out.println("Error! Wrong length of the " + Ship.ZEVENPROVINCIEN.getDiscription() + "! Try again: ");
            }
        } // Battleship
        goodInput = false;
    }

    public void placeEendragt(Player player, String[][] field){
        while (!goodInput) {
            System.out.println("enter the coordinates of the " + Ship.EENDRAGT.getDiscription() + " :");
            coordinates_input = scanner.nextLine();

            cooPionts = coordinates_input.split(" ");
            cooPionts = player.orderCoordinates(cooPionts);
            cooStart = cooPionts[0];
            cooEnd = cooPionts[1];


            if (Ship.EENDRAGT.isValid(cooStart, cooEnd)) {
                if (player.checkPlacement(cooPionts, field)) {
                    player.placeShip(cooStart, cooEnd, field);
                    player.setPlacement(eendragt,cooStart,cooEnd);
                    goodInput = true;
                } else {
                    System.out.println("Error! Wrong ship location! Try again:");
                }
            } else {
                System.out.println("Error! Wrong length of the " + Ship.EENDRAGT.getDiscription() + "! Try again: ");
            }
        } // Submarine
        goodInput = false;
    }

    public void placeAemilia(Player player, String[][] field){
        while (!goodInput) {
            System.out.println("enter the coordinates of the " + Ship.AEMILIA.getDiscription() + " :");
            coordinates_input = scanner.nextLine();

            cooPionts = coordinates_input.split(" ");
            cooPionts = player.orderCoordinates(cooPionts);
            cooStart = cooPionts[0];
            cooEnd = cooPionts[1];

            if (Ship.AEMILIA.isValid(cooStart, cooEnd)) {
                if (player.checkPlacement(cooPionts, field)) {
                    player.placeShip(cooStart, cooEnd, field);
                    player.setPlacement(aemilia,cooStart,cooEnd);
                    goodInput = true;
                } else {
                    System.out.println("Error! Wrong ship location! Try again:");
                }
            } else {
                System.out.println("Error! Wrong length of the " + Ship.AEMILIA.getDiscription() + "! Try again: ");
            }
        } // Cruiser
        goodInput = false;
    }

    public void placeBrederode(Player player, String[][] field){
        while (!goodInput) {
            System.out.println("enter the coordinates of the " + Ship.BREDERODE.getDiscription() + " :");
            coordinates_input = scanner.nextLine();

            cooPionts = coordinates_input.split(" ");
            cooPionts = player.orderCoordinates(cooPionts);
            cooStart = cooPionts[0];
            cooEnd = cooPionts[1];

            if (Ship.BREDERODE.isValid(cooStart, cooEnd)) {
                if (player.checkPlacement(cooPionts, field)) {
                    player.placeShip(cooStart, cooEnd, field);
                    player.setPlacement(brederode,cooStart,cooEnd);
                    goodInput = true;
                } else {
                    System.out.println("Error! Wrong ship location! Try again:");
                }
            } else {
                System.out.println("Error! Wrong length of the " + Ship.BREDERODE.getDiscription() + "! Try again: ");
            }
        } // Destroyer
        goodInput = false;
    }

    public void passToNextPlayer(){
        String empty = "";

        System.out.println("Press Enter and pass the move to another player");
        empty = scanner.nextLine();
        System.out.println(empty + "\n\n\n\n\n");
    }
}
