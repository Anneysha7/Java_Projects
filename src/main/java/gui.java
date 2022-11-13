import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;import javafx.scene.paint.Color;


public class gui extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Tic Tac Toe");
        Group group = new Group();
        Rectangle rect = new Rectangle();
        rect.setX(20);
        rect.setY(20);
        rect.setWidth(100);
        rect.setHeight(100);
        group.getChildren().addAll(rect);

        Scene scene = new Scene(group, 200, 300, Color.GRAY);

        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
