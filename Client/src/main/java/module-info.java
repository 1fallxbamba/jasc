module sn.jasc.jasc_client {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires java.rmi;

    opens sn.jasc.jasc_client to javafx.fxml;
   // opens sn.jasc.jasc_client.services to java.rmi;
    //exports sn.jasc.jasc_client.services;
    exports sn.jasc.jasc_client;
}