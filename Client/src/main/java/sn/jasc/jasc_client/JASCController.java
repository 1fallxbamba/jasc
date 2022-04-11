package sn.jasc.jasc_client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import services.JASCService;


public class JASCController {
    @FXML
    private Label jascResult;

    @FXML
    protected void testJasc() {

        /* if(System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        } This is the 'fix' i found, but  created another issue */

        try {

            Registry registry = LocateRegistry.getRegistry(5555);
            JASCService server = (JASCService) registry.lookup("jasc/calculate");

            double result = server.calculate("*", 3, 4);

            jascResult.setText(String.valueOf(result));

        } catch (Exception e) {
        	e.printStackTrace();
            System.err.println(e.getMessage());
        }
    }
}