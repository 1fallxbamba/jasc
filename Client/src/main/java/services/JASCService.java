package services;

import java.rmi.*;

public interface JASCService extends Remote {
    double calculate(String type, double a, double b) throws RemoteException;
}
