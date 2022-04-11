package utils;

import javafx.scene.control.Alert;

public class Alerter {

    public static void showMessage(String title, String header, String content) {
        Alert a = new Alert(Alert.AlertType.WARNING);

        a.setTitle(title);
        a.setHeaderText(header);
        a.setContentText(content);

        a.show();
    }

}
