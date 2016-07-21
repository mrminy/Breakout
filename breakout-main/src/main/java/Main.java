import controller.Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import utils.Utils;

/**
 * Created by mikkel on 21-Jul-16.
 */
public class Main extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("graphics/graphics.fxml"));
		primaryStage.setTitle("Breakout");
		primaryStage.setScene(new Scene(root, Utils.G_WIDTH, Utils.G_HEIGHT + Utils.MENU_HEIGHT));
		primaryStage.show();
	}
}
