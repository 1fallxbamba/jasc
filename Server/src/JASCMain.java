import brain.JASCBrain;
import services.JASCService;

import java.rmi.registry.*;
import java.rmi.server.UnicastRemoteObject;

public class JASCMain {
    public static void main(String[] args) {

        try {

            JASCService server = new JASCBrain();

            JASCService jascServiceStub = (JASCService) UnicastRemoteObject.exportObject(server, 0);

            Registry registry = LocateRegistry.createRegistry(5555);

            registry.rebind("jasc/calculate", jascServiceStub);

            System.out.println("JASC is listening...");
        } catch (Exception e) {
            System.err.println("Ooops " + e.getMessage());
        }

    }
}
