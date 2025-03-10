public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        Board board1 = new Board(8,8);
        Ship ship1 = new Ship(3,0);
        board1.placeShip(ship1, 3, 3);
        board1.displayBoard();
        board1.fireCannon(3,3);
        System.out.println(ship1);
    }
}
