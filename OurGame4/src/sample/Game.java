package sample;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Game extends Application {

    Sprite girl = new Sprite("image1.png","image2.png","image3.png","image4.png", 170, 0);
    Item bed = new Item("bed", Item.Type.FURNITURE,110,-110, 294, 0, 112, 140, "bed.png",1);
    Item wd = new Item("wardrobe", Item.Type.FURNITURE, -110, -140, 0, 0, 160, 80, "wardrobe.png",1);
    Item letter = new Item("letter", Item.Type.ITEM, 102, 276, 40, 30, 102,276, 40, 30, "letter.png",1);
    Wall rightWall = new Wall(406, -9, 5, 474);
    Wall leftWall = new Wall(-17, -9, 5, 474);
    Wall topWall = new Wall(-17, -9, 423, 5);
    Wall bottomWall = new Wall(-17, 465, 423, 5);
    Room room = new Room(0, "bg.png");
    KeyCode code;

    @Override
    public void start(Stage primaryStage){
        //Game Scene Layout
        Group gameRoot = new Group();
        Scene gameScene = new Scene(gameRoot, 400, 550);
        GridPane gameGP = new GridPane();
        Canvas gameCanvas = new Canvas(400,450);
        GraphicsContext gc = gameCanvas.getGraphicsContext2D();
        Label gameLabel = new Label("Welcome to our game!");
        gameGP.add(gameCanvas,0,0);
        gameGP.add(gameLabel, 0,1);
        gameRoot.getChildren().add(gameGP);

        //Start Scene Layout
        Group startRoot = new Group();
        Scene startScene = new Scene(startRoot, 300, 200, Color.WHITE);
        GridPane startGP = new GridPane();
        Label startLabel = new Label("Welcome to our OOP assignment game.\nClick 'START' to proceed.");
        Button startBtn = new Button("START");
        startBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(gameScene);
            }
        });
        startGP.add(startLabel, 0, 0);
        startGP.add(startBtn, 0, 1);
        startRoot.getChildren().add(startGP);

        room.addSprite(girl);
        room.addFurniture(bed);
        room.addFurniture(wd);
        room.addFurniture(letter);
        room.addWall(topWall);
        room.addWall(bottomWall);
        room.addWall(leftWall);
        room.addWall(rightWall);
        Map map = new Map(room);

        drawAll(gc, map);



        gameScene.setOnKeyPressed(new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent event) {

                if (event.getCode() == KeyCode.RIGHT || event.getCode() == KeyCode.LEFT ||
                        event.getCode() == KeyCode.UP || event.getCode() == KeyCode.DOWN) {
                    girl.keyPressed(event.getCode());
                    code = event.getCode();
                }
            }
        });

        gameScene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                girl.stopMove(event.getCode());
            }
        });

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                drawAll(gc, map);
                for (Rectangle r : map.getRoom(0).getBounds()) {
                    if (girl.checkCollision(r,code)) {
                        girl.stopMove(code);
                        break;
                    }
                }
                girl.move();
                /*int right = girl.getPosition().getX() + girl.getSize().getWidth();
                int left = girl.getPosition().getX();
                int top = girl.getPosition().getY();
                int bottom = girl.getPosition().getY() + girl.getSize().getHeight();
                System.out.println("X : "+right+", Y : "+top);*/

            }
        };
        timer.start();

        primaryStage.setTitle("RPG game");
        primaryStage.setScene(startScene);
        primaryStage.setResizable(false);
        primaryStage.show();
        System.out.println("Start");
    }


    public void drawAll(GraphicsContext gc, Map m) {
        m.drawMap(gc, 0);
    }

    public static void main(String[] args) {
        launch(args);
    }
}


