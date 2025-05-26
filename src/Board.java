import java.util.ArrayList;
public class Board{

    private int x_length;
    private int y_length;
    private ArrayList<Ship> allShips = new ArrayList<Ship>();

    private Square[][] board; 
    
    public Board(int x, int y){
        
        board = new Square[y][x];
        x_length = x;
        y_length = y;

        for(int r = 0; r < y; r++){
            for(int c = 0; c < x; c++){
                board[r][c] = new Square();
            }
        }

    }


    public Board(){
        
        board = new Square[8][8];
        x_length = 8;
        y_length = 8;

    }

    public void displayBoard(){

        for(Square[] r : board){
            for(Square c: r){
                System.out.println(c.toString());
            }
        }
    }

    public boolean stillAlive(){
        int amountDead = 0;
        for(Ship testShip : allShips){
            if(!testShip.getState()){
                amountDead++;
            } 

        }
        if(amountDead == allShips.size()){
            return false;
        } else {
            return true;
        }

    }

    public boolean fireCannon(int x_crd, int y_crd){
        
        if(board[y_crd][x_crd].hasShip){
            for(Ship testShip : allShips){
                if(board[y_crd][x_crd].getSubShipID() == testShip.getID() && !board[y_crd][x_crd].tried()){
                    testShip.takeHit();
                }
            }
            
            board[y_crd][x_crd].markTried();
            return true;
        } else {
            board[y_crd][x_crd].markTried();
            return false;
        }
    }

    

    public void placeShip(Ship ship, int xc, int yc){

        allShips.add(ship);

        if(ship.getOren() == 0){
            if((yc + ship.getLeng()) <= y_length){
                for(int i = 0; i < ship.getLeng(); i++){
                board[yc + i][xc].placeShipPart(ship);
                }
            }


        }
        
        if(ship.getOren() == 1){
            if((xc + ship.getLeng()) <= x_length){
                for(int i = 0; i < ship.getLeng(); i++){
                board[yc][xc + i].placeShipPart(ship);
                }
            }
            

        }

    }
}