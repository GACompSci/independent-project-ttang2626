import javax.print.DocFlavor.STRING;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {

    private static final int SIZE = 8;
    static Integer turns  = 0;
    static Integer hits = 0;
    @Override
    public void start(Stage primaryStage) {
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setHgap(5);
        grid.setVgap(5);

        Board board1 = new Board(8,8);
        // Ship ship1 = new Ship(3,0);
        // board1.placeShip(ship1, 3, 3);
        // Ship ship2 = new Ship(3,0);
        // board1.placeShip(ship2, 0,0);
        // board1.displayBoard();
        // board1.fireCannon(3,3);
        // System.out.println(ship1);

        String turnstr = ""; 
        Label turnLabel = new Label("Shells fired: " + turnstr);

        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                Button cell = new Button();
                cell.setMinSize(50, 50); // Size of each cell
                int r = row;
                int c = col;

                


                cell.setOnAction(e -> {
                    if(board1.fireCannon(c, r)){
                        cell.setStyle("-fx-background-color: red;");
                        System.out.println("HIT!");
                        hits++;
                    } else {
                        cell.setStyle("-fx-background-color: grey;");
                    }

                    turns++;
                    turnLabel.setText("Shells fired: " + String.valueOf(turns));
                    System.out.println("Fired at: (" + r + ", " + c + ")");
                    // System.out.println(ship1);
                    if(!board1.stillAlive()){
                        endscreen();
                    }
                });

                grid.add(cell, col, row);
            }
        }
        
        Button createShipButton = new Button("Create Ship");
        createShipButton.setOnAction(e -> openShipCreationDialog(board1));

        


        VBox root = new VBox(10, createShipButton, grid, turnLabel);
        root.setPadding(new Insets(10));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
  
        primaryStage.setTitle("Battleship");
        primaryStage.show();

        
    }

    private void endscreen(){
        Stage end = new Stage();
        end.setTitle("GAME OVER!");

        Label text = new Label("ALL SHIPS SUNK");
        double accuracy = (double)hits/turns;
        Label stats = new Label("Total fired: " + String.valueOf(turns) + " Total hit: " + String.valueOf(hits) + " Total accuracy: " + String.valueOf(accuracy));


        VBox endscreen = new VBox(10, text, stats);
        endscreen.setPadding(new Insets(10));
        Scene endScene = new Scene(endscreen, 400, 400);
        end.setScene(endScene);
        end.show();

    }

    private void openShipCreationDialog(Board board) {
    Stage dialog = new Stage();
    dialog.setTitle("Create Ship");

    Label sizeLabel = new Label("Size:");
    TextField sizeField = new TextField();

    Label dirLabel = new Label("Direction (0=Vert. 1=Horiz.):");
    TextField dirField = new TextField();

    Label posLabelx = new Label("Position X:");
    TextField posFieldx = new TextField();

    Label posLabely = new Label("Position Y:");
    TextField posFieldy = new TextField();

    Button createBtn = new Button("Create");
    Label resultLabel = new Label();

    createBtn.setOnAction(e -> {
        
            int size = Integer.parseInt(sizeField.getText());
            int direction = Integer.parseInt(dirField.getText());
            int px = Integer.parseInt(posFieldx.getText());
            int py = Integer.parseInt(posFieldy.getText());

            Ship newShip = new Ship(size, direction);
            resultLabel.setText("Created: " + newShip);

            board.placeShip(newShip, px, py);
            board.displayBoard();
        
    });

    VBox vbox = new VBox(10, sizeLabel, sizeField, dirLabel, dirField, posLabelx, posFieldx, posLabely, posFieldy, createBtn, resultLabel);
    vbox.setPadding(new Insets(10));
    Scene dialogScene = new Scene(vbox, 250, 400);
    dialog.setScene(dialogScene);
    dialog.show();
}


    public static void main(String[] args) {
        launch(args);
    }
}