package sn.jasc.jasc_client;

import java.net.URL;
import java.rmi.*;
import java.rmi.registry.*;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.control.*;
import services.JASCService;
import utils.Alerter;


public class JASCController implements Initializable {

    @FXML
    private TextField firstOperand;

    @FXML
    private TextField secondOperand;

    @FXML
    private Label jascResult;

    @FXML
    private ComboBox operatorBox;

    private String operator;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        operatorBox.getItems().addAll('+', '-', '*', '/', '%', "**");
    }

    public void operandSelected(ActionEvent event) {
        operator = operatorBox.getValue().toString();
    }

    public void runJASC() throws NotBoundException {

        try {

            Registry registry = LocateRegistry.getRegistry(5555);
            JASCService server = (JASCService) registry.lookup("jasc/calculate");

            if (firstOperand.getText().isEmpty() || secondOperand.getText().isEmpty()) {
                Alerter.showMessage("No digits given", "Please provide the digits in the fields", "Can you do a calculation on nothing ?");
            } else {

                double result = server.calculate(operator, Integer.valueOf(firstOperand.getText()), Integer.valueOf(secondOperand.getText()));

                jascResult.setText(String.valueOf(result));

            }

        } catch (RemoteException e) {
            Alerter.showMessage("Oops...", "Could not reach the server, more details below", e.getMessage());
        } catch (NullPointerException e) {
            Alerter.showMessage("No operator chosen", "Please choose an operation in the list", "How do you expect us to perfom the calculation ?");
        } catch (NumberFormatException e) {
            Alerter.showMessage("Invalid format", "Please provide valid NUMBERS", "Don't tryna do stupid stuff...");
        }
    }
}