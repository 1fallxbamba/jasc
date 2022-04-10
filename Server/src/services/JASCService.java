package services;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface JASCService extends Remote {
    double calculate(String type, double a, double b) throws RemoteException;
}
