public class Ship extends Square{
    private int length;
    private int orientation;
    private int health;
    private int ID;
    private boolean alive;
    private static int numberOfShips = 0;

    public Ship(int leng, int oren){
        length = leng;
        orientation = oren;
        health = leng;
        alive = true;
        ID = numberOfShips;
    }

    public boolean getState(){
        return alive;
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
        if(health == 0){
            System.out.println(ID + "SUNK");
            alive = false;
        }
    }

    public String toString(){
        return "ID:" + ID + " HP: " + health + " LENGTH: " + length + "ALIVE?: " + alive;
    }
}
