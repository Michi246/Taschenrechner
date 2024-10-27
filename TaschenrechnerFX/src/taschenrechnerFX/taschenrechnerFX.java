package taschenrechnerFX;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class taschenrechnerFX extends Application{

	@Override
	public void start(Stage start) throws Exception {
		
		Parent roots = FXMLLoader.load(getClass().getResource("taschenrechnerFX.fxml"));
		
		Scene scene = new Scene(roots);
		start.setScene(scene);
		start.setTitle("TaschenrechnerFX");
		start.setResizable(false);
		start.show();
	}
	
	public static void main(String[] args) {
		launch(args);

	}
}
