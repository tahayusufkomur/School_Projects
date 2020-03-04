//Taha Yusuf Kömür  150114064        Furkan Can Ercan  150316044
//Gui parts of level5
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;


public class Level5 extends Application {
    
 public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Group layout = new Group();
        Circle circle1 = new Circle(200, 400, 25);
        circle1.setStroke(Color.BLACK);
        circle1.setFill(Color.BLACK);
        Circle circle2 = new Circle(100, 300, 25);
        circle2.setStroke(Color.BLACK);
        circle2.setFill(Color.BLACK);
        Circle circle3 = new Circle(200, 300, 25);
        circle3.setStroke(Color.BLACK);
        circle3.setFill(Color.WHITE);
        Rectangle rect1 = new Rectangle(125, 299, 50, 2);
        rect1.setFill(Color.LIGHTGRAY);
        Rectangle rect2 = new Rectangle(199, 325, 2, 50);
        rect2.setFill(Color.LIGHTGRAY);
        Rectangle rect3 = new Rectangle(175, 299, 50, 2);
        rect3.setFill(Color.LIGHTGRAY);
        Rectangle rect4 = new Rectangle(199, 250, 2, 25);
        rect4.setFill(Color.LIGHTGRAY);
        Circle circle4 = new Circle(200, 225, 25);
        circle4.setStroke(Color.BLACK);
        circle4.setFill(Color.WHITE);
        Circle circle5 = new Circle(100, 225, 25);
        circle5.setStroke(Color.BLACK);
        circle5.setFill(Color.BLACK);
        Rectangle rect5 = new Rectangle(125, 225, 50, 2);
        rect5.setFill(Color.LIGHTGRAY);
        Rectangle rect6 = new Rectangle(199, 200, 2, 50);
        rect6.setFill(Color.LIGHTGRAY);
        Rectangle rect7 = new Rectangle(199, 75, 2, 125);
        rect7.setFill(Color.LIGHTGRAY);
        Arc arc = new Arc(211, 77, 12, 12, 180,-90);
        Circle circleARC = new Circle(211, 77, 10);
        Shape shape = Shape.subtract(arc, circleARC);
        shape.setFill(Color.LIGHTGRAY);
        Rectangle rect8 = new Rectangle(209, 65, 10,2);
        rect8.setFill(Color.LIGHTGRAY);
        Rectangle rect9 = new Rectangle(219, 50, 5, 30);
        rect9.setFill(Color.BLACK);
        Rectangle rect10 = new Rectangle(219, 62.5, 75, 5);
        rect10.setFill(Color.BLACK);
        Rectangle rect11 = new Rectangle(364, 62.5, 100, 5);
        Arc arc2 = new Arc(329, 62.5, 40, 40, 0, 180);
        Circle circleARC2 = new Circle(329, 62.5, 35);
        Shape shape2 = Shape.subtract(arc2,circleARC2 );
        shape2.setFill(Color.BLACK);
        Rectangle rect12 = new Rectangle(225, 299,217 , 2);
        rect12.setFill(Color.LIGHTGRAY);
        Arc arc3 = new Arc(440, 289, 12, 12, 270,90);
        Circle circleARC3 = new Circle(440, 289, 10);
        Shape shape3 = Shape.subtract(arc3, circleARC3);
        shape3.setFill(Color.LIGHTGRAY);
        Rectangle rect13 = new Rectangle(450, 281,2,11);
        rect13.setFill(Color.LIGHTGRAY);//225
        Rectangle rect14 = new Rectangle(436, 281,30,5);
        rect14.setFill(Color.BLACK);
        Rectangle rect15 = new Rectangle(447.5, 97.5,5,183.5);
        rect15.setFill(Color.BLACK);
        Arc arc4 = new Arc(450, 62.5, 40, 40, 270,180);
        Circle circleARC4 = new Circle(450, 62.5, 35);
        Shape shape4 = Shape.subtract(arc4, circleARC4);
        Circle circle6 = new Circle(350, 400, 25);
        circle6.setFill(Color.BLACK);
        Rectangle rect16 = new Rectangle(350, 140, 2,235);
        rect16.setFill(Color.LIGHTGRAY);
        Rectangle rect17 = new Rectangle(225, 225, 75,2);
        rect17.setFill(Color.LIGHTGRAY);
        
        Arc arc5 = new Arc(298, 215, 12, 12, 0,-90);
        Circle circleARC5 = new Circle(298, 215, 10);
        Shape shape5 = Shape.subtract(arc5, circleARC5);
        shape5.setFill(Color.LIGHTGRAY);
        
        Rectangle rect18 = new Rectangle(294, 210, 30,5);
        rect18.setFill(Color.BLACK);
        
        Rectangle rect19 = new Rectangle(305.5, 160, 5,50);
        rect19.setFill(Color.BLACK);
        
        Arc arc6 = new Arc(310.5, 130, 30, 30,90,180);
        Circle circleARC6 = new Circle(310.5, 130, 25);
        Shape shape6 = Shape.subtract(arc6, circleARC6);
        shape6.setFill(Color.BLACK);
        
          
        Arc arc7 = new Arc(340, 142, 12, 12,0,90);
        Circle circleARC7 = new Circle(340, 142, 10);
        Shape shape7 = Shape.subtract(arc7, circleARC7);
        shape7.setFill(Color.LIGHTGRAY);
        
        Rectangle rect20 = new Rectangle(336, 118, 5,30);
        rect20.setFill(Color.BLACK);
        
        Rectangle rect21 = new Rectangle(300, 128, 40,5);
        rect21.setFill(Color.BLACK);
        
        Rectangle rect22 = new Rectangle(450, 10, 5,15);
        rect22.setFill(Color.BLACK);  
      
        
        Scene scene = new Scene(layout, 600, 450);
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setTitle("Level 5");
        layout.getChildren().add(circle1);
        layout.getChildren().add(circle2);
        layout.getChildren().add(circle3);
        layout.getChildren().add(circle4);
        layout.getChildren().add(circle5); 
        layout.getChildren().add(rect1);
        layout.getChildren().add(rect2);
        layout.getChildren().add(rect3);
        layout.getChildren().add(rect4);
        layout.getChildren().add(rect5);
        layout.getChildren().add(rect6);
        layout.getChildren().add(rect7);
        layout.getChildren().add(shape);
        layout.getChildren().add(rect8);
        layout.getChildren().add(rect9);
        layout.getChildren().add(rect10);
        layout.getChildren().add(shape2);
        layout.getChildren().add(rect11);
        layout.getChildren().add(rect12);
        layout.getChildren().add(shape3);
        layout.getChildren().add(rect13);
        layout.getChildren().add(rect14);
        layout.getChildren().add(rect15);
        layout.getChildren().add(shape4);
        layout.getChildren().add(circle6);
        layout.getChildren().add(rect16);
        layout.getChildren().add(rect17);
        layout.getChildren().add(shape5);
        layout.getChildren().add(rect18);
        layout.getChildren().add(rect19);
        layout.getChildren().add(shape6);
        layout.getChildren().add(rect20);
        layout.getChildren().add(shape7);
        layout.getChildren().add(rect21);
        layout.getChildren().add(rect22);
    }







}
