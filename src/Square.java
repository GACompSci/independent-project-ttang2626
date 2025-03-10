public class Square extends Board{
    boolean hasShip;
    boolean tried;
    int shipID;

    public Square(boolean hasShip){
        hasShip = false;
        tried = false;
    }

    public Square(){
        hasShip = false;
        tried = false;
    }

    public String toString(){
        return "TRIED?: " + tried + " HAS SHIP?: " + hasShip + "SHIP ID: " + shipID;
    }

    public void markTried(){
        tried = true;
    }

    public boolean hasShip(){
        return hasShip;
    }

    public boolean tried(){
        return tried;
    }

    public int getSubShipID(){
        return shipID;
    }

    public void placeShipPart(Ship ship){
        hasShip = true;
        shipID = ship.getID();
    }
    }




