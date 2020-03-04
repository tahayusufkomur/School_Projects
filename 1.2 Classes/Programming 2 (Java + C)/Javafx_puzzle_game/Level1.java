

//Taha Yusuf Kömür  150114064        Furkan Can Ercan  150316044
//Gui parts of level1

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Level1 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Group layout = new Group();
        Circle circle1 = new Circle(500, 275, 25 );
        Circle circle2 = new Circle( 403, 350, 25);
        Rectangle rect1 = new Rectangle(5, 175.5);
        rect1.setX(400);
        rect1.setY(75);
        Arc arc1;
        arc1 = new Arc(400,87.5,40,40,0,180);
        Circle circle3 = new Circle(400,87.5,35);
        arc1.setCenterX(400);
        Rectangle rect2 = new Rectangle(187.5, 5);
        rect2.setY(87.5);
        rect2.setX(177.5);
        Rectangle rect3 = new Rectangle(87.5, 5);
        rect3.setY(87.5);
        rect3.setX(435);
        Rectangle rect4 = new Rectangle(5, 20);
        rect4.setX(172.5);
        rect4.setY(80);
        Rectangle rect5 = new Rectangle(20, 5);
        rect5.setX(392.5);
        rect5.setY(250);
        Rectangle rectcizgi = new Rectangle(312.5,2);
        rectcizgi.setY(275);
        rectcizgi.setX(162.5);
        rectcizgi.setFill(Color.LIGHTGRAY);
        Shape shape1 = Shape.subtract(arc1, circle3 );
        shape1.setFill(Color.BLACK);


        Arc Arc2 = new Arc(165,265,12,12,180,90);
        Circle circleARC = new Circle(165,265,10);
        arc1.setCenterX(400);
        Shape shape2 = Shape.subtract(Arc2, circleARC);
        shape2.setFill(Color.LIGHTGRAY);
        Rectangle rect6 = new Rectangle(2, 168, Color.LIGHTGRAY);
        rect6.setX(152.5);
        rect6.setY(98);

        Arc Arc3 = new Arc(165,101,12,12,90,90);
        Circle circleARC2 = new Circle(165,101,10);
        arc1.setCenterX(400);
        Shape shape3 = Shape.subtract(Arc3, circleARC2);
        shape3.setFill(Color.LIGHTGRAY);

        Rectangle rect7;
        rect7 = new Rectangle(10, 2, Color.LIGHTGRAY);
        rect7.setY(89);
        rect7.setX(162.5);

        Rectangle rect8 = new Rectangle(2, 70, Color.LIGHTGRAY);
        rect8.setX(401.5);
        rect8.setY(255);

        Scene scene = new Scene(layout, 600, 450);
        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.show();
        primaryStage.setTitle("Hello World");
        layout.getChildren().add(circle1);
        layout.getChildren().add(circle2);
        layout.getChildren().add(rect1);
        layout.getChildren().add(shape1);
        layout.getChildren().add(rect2);
        layout.getChildren().add(rect3);
        layout.getChildren().add(rect4);
        layout.getChildren().add(rect5);
        layout.getChildren().add(rectcizgi);
        layout.getChildren().add(shape2);
        layout.getChildren().add(rect6);
        layout.getChildren().add(shape3);
        layout.getChildren().add(rect7);
        layout.getChildren().add(rect8);
    }
}

