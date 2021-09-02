package loveproject.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../firstMain/FirstMainForm.fxml"));
        Parent mainForm = loader.load();

        Controller ctrl = new Controller();
        ctrl.setFirstMainCtrl(loader.getController());
        ctrl.getFirstMainCtrl().setMainForm(mainForm);

        primaryStage.setTitle("Love Project");
        primaryStage.setScene(new Scene(mainForm));
        primaryStage.show();
    }
}
