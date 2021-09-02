package loveproject.commonService;

import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class CommonService {
    public static void Msg(String contentText) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("알림");
        alert.setHeaderText("정보 알림");
        alert.setContentText(contentText);
        alert.show();
    }

    public static void WindowClose(ActionEvent event) {
        Parent form = (Parent)event.getSource();
        WindowClose(form);
    }
    public static void WindowClose(Parent form) {
        Stage stage = (Stage)form.getScene().getWindow();
        stage.close();
    }
}
