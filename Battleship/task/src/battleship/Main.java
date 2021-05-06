package battleship;


import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean notMyTurn = false, goodInput = false, allFloating = true;
        Scanner scanner = new Scanner(System.in);

        //make Field + print Field
        Player playerOne = new Player("Renee");
        String[][] clearField = playerOne.makeField(10);
        String[][] fogField = playerOne.makeField(10); //wisselVelden van spelers

        Player playerTwo = new Player("Kevin");
        String[][]  clearField2 = playerTwo.makeField(10);
        String[][] fogField2 = playerTwo.makeField(10);



        System.out.println("Player 1, place your ships on the game field");
        playerOne.printPlayField(clearField);

        playerOne.setAllShips(playerOne, clearField);

        playerOne.passToNextPlayer();

        System.out.println("Player 2, place your ships to the game field");
        playerTwo.printPlayField(clearField2);

        playerTwo.setAllShips(playerTwo, clearField2);

        playerTwo.passToNextPlayer();


            while (allFloating){
                allFloating = playerOne.attackShip(playerOne, clearField2, fogField2, clearField);

                playerOne.passToNextPlayer();

                allFloating = playerTwo.attackShip(playerTwo, clearField, fogField, clearField2);

                playerTwo.passToNextPlayer();
            }

    }




}
