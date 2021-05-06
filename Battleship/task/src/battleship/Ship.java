package battleship;

public enum Ship {
    PRINSWILLIM(5, "De Prins Willim (5 cells)"), ZEVENPROVINCIEN(4, "Zeven Provincien (4 cells)"),
    EENDRAGT(3, "Eendracht (3 cells)"), AEMILIA(3, "Aemilia (3 cells)"),
    BREDERODE(2, "Brederode (2cells)");

    int size;
    private String discription;
    private String[] position;

    Ship(int SIZE, String discription) {
        this.size= SIZE;
        this.discription = discription;


    }

    public String getDiscription() {
        return discription;
    }

    public int getSize(){
        return size;
    }

    public boolean isValid(String coordinatesStart,String coordinatesEnd){
        boolean valid = false;

        try {
            int begin = Integer.parseInt(coordinatesStart.substring(1));
            int end = Integer.parseInt(coordinatesEnd.substring(1));
                if (coordinatesStart.charAt(0)>= 'A' && coordinatesEnd.charAt(0)<= 'J' && begin >= 1 && end <=10 ){
                        if ((end - begin) +1 == size && coordinatesStart.charAt(0) == coordinatesEnd.charAt(0)  ||
                            begin == end && coordinatesEnd.charAt(0) - coordinatesStart.charAt(0) == size -1 ||
                                (begin - end) +1 == size && coordinatesStart.charAt(0) == coordinatesEnd.charAt(0)  ||
                                begin == end && coordinatesStart.charAt(0) - coordinatesEnd.charAt(0) == size -1){
                valid = true;
            }
        }}catch (Exception e){
            System.out.println(e);
        }
        return valid;
    }
}
