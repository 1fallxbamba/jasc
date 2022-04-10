import brain.JASCer;
import services.JASCService;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Home {
    public static void main(String[] args) {

        try {

            JASCService server = new JASCer();

            JASCService jascServiceStub = (JASCService) UnicastRemoteObject.exportObject(server, 0);

            Registry registry = LocateRegistry.createRegistry(5555);

            registry.rebind("jasc/calculate", jascServiceStub);

            System.out.println("JASC is listening...");
        } catch (Exception e) {
            System.err.println("Ooops " + e.getMessage());
        }

    }
}
