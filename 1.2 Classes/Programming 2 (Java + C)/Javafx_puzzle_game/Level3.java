
//Taha Yusuf Kömür  150114064        Furkan Can Ercan  150316044
//Gui parts of level3

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

public class Level3 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
         Group layout = new Group();

        Circle circle1 = new Circle(150,300,30);
        Circle circle2 = new Circle(250,360,30);
        Circle circle3 = new Circle(370,450,30);

        Rectangle recty1 = new Rectangle(180,300,330,5);
        Rectangle recty2 = new Rectangle(280,360,70,5);
        Rectangle recty3 = new Rectangle(370,100,5,320);
        Rectangle recty4 = new Rectangle(430,190,5,170);

        Rectangle rect1 = new Rectangle(390,37.5,90,5);
        Rectangle rect2 = new Rectangle(540,97,40,5);
        Rectangle rect3 = new Rectangle(450,190,70,5);






        Scene scene = new Scene(layout, 600, 500);
        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.show();

        layout.getChildren().add(circle1);
        layout.getChildren().add(circle2);
        layout.getChildren().add(circle2);
        layout.getChildren().add(recty1);
        layout.getChildren().add(recty2);
        layout.getChildren().add(recty3);
        layout.getChildren().add(recty4);
        layout.getChildren().add(rect1);
        layout.getChildren().add(rect2);
        layout.getChildren().add(rect3);


        scene = new Scene(layout, 600, 500);
        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.show();
    }

    
}
