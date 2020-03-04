//Taha Yusuf Kömür  150114064        Furkan Can Ercan  150316044
//Gui parts of level4
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

public class Level4 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Group layout = new Group();
        Circle circle1 = new Circle(250, 400, 25);
        circle1.setStroke(Color.BLACK);
        circle1.setFill(Color.BLACK);
        Circle circle2 = new Circle(150, 300, 25);
        circle2.setStroke(Color.BLACK);
        circle2.setFill(Color.BLACK);
        Circle circle3 = new Circle(250, 300, 25);
        circle3.setStroke(Color.BLACK);
        circle3.setFill(Color.WHITE);
        Rectangle rect1 = new Rectangle(175, 299, 50, 2);
        rect1.setFill(Color.LIGHTGRAY);
        Rectangle rect2 = new Rectangle(249, 325, 2, 50);
        rect2.setFill(Color.LIGHTGRAY);
        Rectangle rect3 = new Rectangle(249, 275, 2, 50);
        rect3.setFill(Color.LIGHTGRAY);
        Rectangle rect4 = new Rectangle(249, 125, 2, 150);
        rect4.setFill(Color.LIGHTGRAY);
        Arc arc1 = new Arc(261, 127, 12, 12, 180, -90);
        Circle circle4 = new Circle(261, 127, 10);
        Shape shape1 = Shape.subtract(arc1, circle4);
        shape1.setFill(Color.LIGHTGRAY);
        Rectangle rect5 = new Rectangle(260, 115, 25, 2);
        rect5.setFill(Color.LIGHTGRAY);
        Rectangle rect6 = new Rectangle(285, 100, 5, 30);
        rect6.setFill(Color.BLACK);
        Rectangle rect7 = new Rectangle(285, 112.5, 200, 5);
        rect7.setFill(Color.BLACK);
        Arc arc2 = new Arc(520, 112.5, 40, 40, 0, 180);
        Circle circle5 = new Circle(520, 112.5, 35);
        Shape shape2 = Shape.subtract(arc2, circle5);
        shape2.setFill(Color.BLACK);
        Rectangle rect8 = new Rectangle(555, 112.5, 40, 5);
        rect8.setFill(Color.BLACK);
        Rectangle rect9 = new Rectangle(275, 299, 240, 2);
        Arc arc3 = new Arc(513, 289, 12, 12, 270, 90);
        Circle circle6 = new Circle(513, 289, 10);
        Shape shape3 = Shape.subtract(arc3, circle6);
        shape3.setFill(Color.LIGHTGRAY);
        rect9.setFill(Color.LIGHTGRAY);
        Rectangle rect10 = new Rectangle(523, 270, 2, 21);//289 - 20 = 269 to it is showed more beatiful made it 270 and made 20 to 21
        rect10.setFill(Color.LIGHTGRAY);
        Rectangle rect11 = new Rectangle(509, 270, 30, 5);
        rect11.setFill(Color.BLACK);
        Rectangle rect12 = new Rectangle(521.5, 100, 5, 175);
        rect12.setFill(Color.BLACK);
        
        Scene scene = new Scene(layout, 600, 450);
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setTitle("Level 4");
        layout.getChildren().add(circle1);
        layout.getChildren().add(circle2);
        layout.getChildren().add(circle3);
        layout.getChildren().add(rect1);
        layout.getChildren().add(rect2);
        layout.getChildren().add(rect3);
        layout.getChildren().add(rect4);
        layout.getChildren().add(shape1);
        layout.getChildren().add(rect5);
        layout.getChildren().add(rect6);
        layout.getChildren().add(rect7);
        layout.getChildren().add(shape2);
        layout.getChildren().add(rect8);
        layout.getChildren().add(rect9);
        layout.getChildren().add(shape3);
        layout.getChildren().add(rect10);
        layout.getChildren().add(rect11);
        layout.getChildren().add(rect12);
        
    }
}
