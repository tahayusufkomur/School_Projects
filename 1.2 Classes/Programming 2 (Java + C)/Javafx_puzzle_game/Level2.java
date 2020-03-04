

//Taha Yusuf Kömür  150114064        Furkan Can Ercan  150316044
//Gui parts of level2


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

public class Level2 extends Application {

    public static void main(String[ ] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        Group layout = new Group();

        Circle circle1 = new Circle(68,450,25, Color.DARKSLATEGRAY);
        Circle circle2 = new Circle(200,450,25, Color.DARKSLATEGRAY);
        Circle circle3 = new Circle(300,450,25, Color.DARKSLATEGRAY);
        Circle circle4 = new Circle(500,450,25, Color.DARKSLATEGRAY);

        Rectangle recty1 = new Rectangle(68,124.5,2,300.5);
        Rectangle recty2 = new Rectangle(200,350,2,75);
        Rectangle recty3 = new Rectangle(300,350,2,75);
        Rectangle recty4 = new Rectangle(500,247,2,177.5);
        recty1.setFill(Color.LIGHTGRAY);
        recty2.setFill(Color.LIGHTGRAY);
        recty3.setFill(Color.LIGHTGRAY);
        recty4.setFill(Color.LIGHTGRAY);
        Arc Arcy1 = new Arc(83,125.5,15,15,90,90);
        Circle circleARCY1 = new Circle(83,125.5,13);

        Shape ArcyShape1 = Shape.subtract(Arcy1, circleARCY1);
        ArcyShape1.setFill(Color.LIGHTGRAY);

        Arc Arcy2 = new Arc(487,248,15,15,90,-90);
        Circle circleARCY2 = new Circle(487, 248,13);

        Shape ArcyShape2 = Shape.subtract(Arcy2, circleARCY2);
        ArcyShape2.setFill(Color.LIGHTGRAY);






        Rectangle rect1 = new Rectangle(325,230,160,5);
        Rectangle rect2 = new Rectangle(188,228,86.5,5);
        Rectangle rect3 = new Rectangle(198,135,5,70);
        Rectangle rect4 = new Rectangle(298,220,5,130);
        Rectangle rect5 = new Rectangle(198,255,5,90);
        Rectangle rect6 = new Rectangle(88 ,108,120,5);
        Rectangle rect7 = new Rectangle(198,50,5,35);
        rect1.setFill(Color.DARKSLATEGRAY);
        rect2.setFill(Color.DARKSLATEGRAY);
        rect3.setFill(Color.DARKSLATEGRAY);
        rect4.setFill(Color.DARKSLATEGRAY);
        rect5.setFill(Color.DARKSLATEGRAY);
        rect6.setFill(Color.DARKSLATEGRAY);
        rect7.setFill(Color.DARKSLATEGRAY);


        Rectangle rect5mini = new Rectangle(193,345,15, 5);
        Rectangle rect4mini = new Rectangle(293,345,15, 5);
        Rectangle rect6mini = new Rectangle(83, 103, 5,15);
        Rectangle rect7mini = new Rectangle(485,225,5,15);

        Circle rect4minicircleright = new Circle(308,347.5,2.5);
        Circle rect4minicircleleft = new Circle(293,347.5,2.5);
        Circle rect5minicircleright = new Circle(208,347.5,2.5);
        Circle rect5minicircleleft = new Circle(193,347.5,2.5);
        Circle rect6minicircletop = new Circle(85.5,103,2.5);
        Circle rect6minicirclebottom = new Circle(85.5,118,2.5 );
        Circle rect7minicircletop = new Circle(487.5,225,2.5);
        Circle rect7minicirclebottom = new Circle(487.5,240,2.5);
        rect4mini.setFill(Color.DARKSLATEGRAY);
        rect5mini.setFill(Color.DARKSLATEGRAY);
        rect6mini.setFill(Color.DARKSLATEGRAY);
        rect7mini.setFill(Color.DARKSLATEGRAY);
        rect4minicircleleft.setFill(Color.DARKSLATEGRAY);
        rect4minicircleright.setFill(Color.DARKSLATEGRAY);
        rect5minicircleright.setFill(Color.DARKSLATEGRAY);
        rect5minicircleleft.setFill(Color.DARKSLATEGRAY);
        rect6minicircletop.setFill(Color.DARKSLATEGRAY);
        rect6minicirclebottom.setFill(Color.DARKSLATEGRAY);
        rect7minicircletop.setFill(Color.DARKSLATEGRAY);
        rect7minicirclebottom.setFill(Color.DARKSLATEGRAY);

        Arc Arc1 = new Arc(200,110,30,30,90,-180);
        Circle circleARC1 = new Circle(200,110,25);

        Shape shape1 = Shape.subtract(Arc1, circleARC1);
        shape1.setFill(Color.DARKSLATEGRAY);


        Arc Arc2 = new Arc(200,230,30,30,90,180);
        Circle circleARC2 = new Circle(200,230,25);

        Shape shape2 = Shape.subtract(Arc2, circleARC2);
        shape2.setFill(Color.DARKSLATEGRAY);


        Arc Arc3 = new Arc(300,230,30,30,0,180);
        Circle circleARC3 = new Circle(300,230,25);

        Shape shape3 = Shape.subtract(Arc3, circleARC3);
        shape3.setFill(Color.DARKSLATEGRAY);


        Scene scene = new Scene(layout, 600, 500);
        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.show();



        layout.getChildren().add(circle1);
        layout.getChildren().add(circle2);
        layout.getChildren().add(circle3);
        layout.getChildren().add(circle4);
        layout.getChildren().add(recty1);
        layout.getChildren().add(recty2);
        layout.getChildren().add(recty3);
        layout.getChildren().add(recty4);
        layout.getChildren().add(rect1);
        layout.getChildren().add(rect2);
        layout.getChildren().add(rect3);
        layout.getChildren().add(rect4);
        layout.getChildren().add(rect5);
        layout.getChildren().add(rect6);
        layout.getChildren().add(rect7);
        layout.getChildren().add(shape1);
        layout.getChildren().add(shape2);
        layout.getChildren().add(shape3);
        layout.getChildren().add(rect4mini);
        layout.getChildren().add(rect5mini);
        layout.getChildren().add(rect5minicircleright);
        layout.getChildren().add(rect5minicircleleft);
        layout.getChildren().add(rect4minicircleright);
        layout.getChildren().add(rect4minicircleleft);
        layout.getChildren().add(ArcyShape1);
        layout.getChildren().add(rect6mini);
        layout.getChildren().add(rect6minicircletop);
        layout.getChildren().add(rect6minicirclebottom);
        layout.getChildren().add(ArcyShape2);
        layout.getChildren().add(rect7mini);
        layout.getChildren().add(rect7minicircletop);
        layout.getChildren().add(rect7minicirclebottom);

    }
}

