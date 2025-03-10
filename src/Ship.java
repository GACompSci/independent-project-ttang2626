public class Ship extends Square{
    private int length;
    private int orientation;
    private int health;
    private int ID;
    private static int numberOfShips = 0;

    public Ship(int leng, int oren){
        length = leng;
        orientation = oren;
        health = leng;
    }

    public int getOren(){
        return orientation;
    }

    public int getLeng(){
        return length;
    }

    public int getID(){
        numberOfShips++;
        return ID;
    }

    public void takeHit(){
        health--;
    }

    public String toString(){
        return "ID:" + ID + " HP: " + health + " LENGTH: " + length;
    }
}
