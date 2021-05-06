package battleship;


import java.util.Scanner;

public class Field {
    Scanner scanner = new Scanner(System.in);
    private int size;
    private String[][] playField;

    final String fog = "~";
    final String shipCell = "O";
    final String hitShip = "X";
    final String miss = "M";


    public Field(){

    }

    public String[][] makeField(int size){
        this.size = size ;
        playField = new String[size + 1][(size *2) + 1];

        for (int i = 0; i< playField.length; i++){
            for (int j = 0; j < playField[0].length; j++){
                playField[i][j] = " ";
            }
        }

        for (int i = 1; i < playField.length; i++){
            for (int j = 2; j < playField[0].length; j+=2){
                playField[i][j] = fog;
            }
        }

        int number = 1;
        for(int i=2; i< playField[0].length; i+=2){
            playField[0][i]= String.valueOf(number);
            number++;
        }

        char letter = 'A';
        for (int i = 1; i< playField.length; i++){
            playField[i][0] = String.valueOf(letter);
            letter++;
        }
        return playField;
    }

    public void printPlayField(String[][] array2d) {
        for (int i=0; i< array2d.length; i++){
            for (int j = 0; j < array2d[0].length; j++){
                System.out.print(array2d[i][j]);
            }
            System.out.println();
        }
    }

    public String[] orderCoordinates(String[] cooArray){
        int row1 = convertToCoordinate(cooArray[0]), row2 = convertToCoordinate(cooArray[1]);
        int coll1 = (Integer.parseInt(cooArray[0].substring(1))*2), coll2 = (Integer.parseInt(cooArray[1].substring(1))*2);

        if (coll1>coll2){
            int temp = coll1;
            coll1 = coll2;
            coll2 = temp;

            String tempp = cooArray[0];
            cooArray[0] = cooArray[1];
            cooArray[1] = tempp;
        }
        if (row1>row2){
            int temp = row1;
            row1 = row2;
            row2 = temp;

            String tempp = cooArray[0];
            cooArray[0] = cooArray[1];
            cooArray[1] = tempp;
        }
        return cooArray;

    }

    public boolean checkPlacement(String[] cooPoints, String[][] field){

        boolean valid = false;
        int row1 = convertToCoordinate(cooPoints[0]), row2 = convertToCoordinate(cooPoints[1]);
        int coll1 = (Integer.parseInt(cooPoints[0].substring(1))*2), coll2 = (Integer.parseInt(cooPoints[1].substring(1))*2);


        if(row1 == row2){
            for (int i = coll1; i <= coll2; i++){
                if (row1 == 10){
                    if (field[row1][i].equals(shipCell)  || field[row1-1][i].equals(shipCell)){
                        valid = false;
                        break;
                    }else{
                        valid = true;
                    }
                } else if (coll2 == 20){
                    if (field[row1-2][coll1].equals(shipCell)){
                        valid = false;
                        break;
                    } else {
                        valid = true;
                    }
                } else {
                    if (field[row1][i].equals(shipCell) || field[row1 -1][i].equals(shipCell) || field[row1 +1][i].equals(shipCell)){
                        valid = false;
                        break;
                    } else if (field[row1 - 1][coll1].equals(shipCell) || field[row2][coll2].equals(shipCell)){
                        valid = false;
                        break;
                    }else {
                        valid = true;
                    }
                }


            }

        } else if (coll1 == coll2) {
            for (int i= row1; i <= row2; i++) {
                if (coll1 == 20){
                    if (field[i][coll1].equals(shipCell) || field[i - 1][coll1].equals(shipCell)){
                        valid = false;
                        break;
                    }else{
                        valid = true;
                    }
                } else if (row2 == 10){
                    if (field[row2 - 1][coll1].equals(shipCell)){
                        valid = false;
                        break;
                    } else {
                        valid = true;
                    }
                } else {
                    if (field[i][coll1].equals(shipCell) || field[i][coll1 - 1].equals(shipCell) || field[i][coll1 + 1].equals(shipCell)){
                        valid = false;
                        break;
                    } else if (field[row1 - 1][coll1].equals(shipCell) || field[row2 + 1][coll1].equals(shipCell)){
                        valid = false;
                        break;
                    }else {
                        valid = true;
                    }
                }

            }
        }


        return valid;
    }

    public void placeShip(String coordinatesStart, String coordinatesEnd, String[][] field){
        int row1 = convertToCoordinate(coordinatesStart), row2 = convertToCoordinate(coordinatesEnd);
        int coll1 = (Integer.parseInt(coordinatesStart.substring(1))*2);
        int coll2 = (Integer.parseInt(coordinatesEnd.substring(1))*2);


        if (row1 == row2){
            for (int j= coll1; j<=coll2; j+=2){
                field[row1][j] = shipCell;
            }
        } else {
            for (int i= row1; i<=row2; i++){
                field[i][coll1] = shipCell;
            }
        }

    }

    private int convertToCoordinate(String coordinate){
        int number = 0;
        char letter = 'A';
        for (int i = 0; i< this.size+1; i++){
            if (coordinate.charAt(0) == letter){
                number = i + 1;
                break;
            }
            letter++;
        }
        return number;
    }

    public void setAllShips(Player player, String[][] clearField){

        player.placePrinsWillim(player, clearField);
        player.printPlayField(clearField);

        player.placeZevenProvincien(player, clearField);
        player.printPlayField(clearField);

        player.placeEendragt(player, clearField);
        player.printPlayField(clearField);

        player.placeAemilia(player, clearField);
        player.printPlayField(clearField);

        player.placeBrederode(player, clearField);
        player.printPlayField(clearField);

    }

    public boolean attackShip(Player player, String[][] field, String[][] fogField, String[][] ownField){
        String objective = "";
        boolean falseInput = true;
        boolean floating = true;

        //printFogOpposite
        printPlayField(fogField);
        System.out.println("--------------------------------");
        //printOwnField
        printPlayField(ownField);
        System.out.println("\n");
        System.out.println(player.getName() + ", it's your turn: ");


            while (falseInput) {

                objective = scanner.nextLine();
                objective = objective.replace(" ", "");
                int row = convertToCoordinate(objective);
                int coll = Integer.parseInt(objective.substring(1)) * 2;


                if (row > 10 || row < 1 || coll < 1 || coll > 20) {
                    System.out.println("Error! You entered the wrong coordinates! Try again: ");
                } else {
                    if (field[row][coll].equals(shipCell) || field[row][coll].equals(hitShip)) {
                        field[row][coll] = hitShip;
                        fogField[row][coll] = hitShip;
                        if (player.checkIfShipsAreLeft(field)){
                            System.out.println("You sank the last ship. You won. Congratulations!");
                            floating = false;
                        } else if (player.checkIfShipStillFloats(row, coll, field)){
                            System.out.println("\nYou hit a ship!");
                        } else {
                            System.out.println("\nYou sank a ship! Specify a new target: ");
                        }

                    } else {
                        field[row][coll] = miss;
                        fogField[row][coll] = miss;
                        System.out.println("\nYou missed!");
                    }
                    falseInput = false;
                }
            }
            return floating;
    }

    public void setPlacement(String[] shipName, String startCoo, String endCoo){
        int row1 = convertToCoordinate(startCoo);
        int row2 = convertToCoordinate(endCoo);
        int coll1 = (Integer.parseInt(startCoo.substring(1))*2);
        int coll2 = (Integer.parseInt(endCoo.substring(1))*2);
        int counter = 0;


        if (row1 == row2){
            for (int j= coll1; j<=coll2; j+=2){
                shipName[counter] = row1 + " " + j;
                counter++;
            }
        } else {
            for (int i= row1; i<=row2; i++){
                shipName[counter] = i + " " + coll1;
                counter++;
            }
        }
    }

    public boolean checkIfShipStillFloats(int row, int coll, String[][] field){

        boolean valid = false;

        if (coll == 20 && row ==10){
            if (field[row - 1][coll].equals(shipCell) || field[row][coll - 2].equals(shipCell)){
                valid = true;
            }
        }else if (coll == 20){
            if (field[row - 1][coll].equals(shipCell) || field[row + 1][coll].equals(shipCell) || field[row][coll - 2].equals(shipCell)){
                valid = true;
            }
        } else if (row == 10){
            if (field[row - 1][coll].equals(shipCell) || field[row][coll - 2].equals(shipCell) || field[row][coll + 2].equals(shipCell)){
                valid = true;
            }
        } else {
            if (field[row - 1][coll].equals(shipCell) || field[row + 1][coll].equals(shipCell) || field[row][coll - 2].equals(shipCell) || field[row][coll + 2].equals(shipCell)){
                valid = true;
            }
        }



        return valid;
    }

    public boolean checkIfShipsAreLeft( String[][] field){
        int counter = 0 ;
        boolean valid = false;

        for (int i = 0; i < field.length; i++){
            for (int j = 0; j < field[0].length; j++){
                if (field[i][j].equals(shipCell)) {
                    counter++;
                }
            }
        }
        if (counter == 0){
            valid = true;
        }
        return valid;
    }
}
