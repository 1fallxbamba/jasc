package brain;

import services.JASCService;

import java.rmi.RemoteException;

public class JASCer implements JASCService {
    @Override
    public double calculate(String type, double a, double b) throws RemoteException {
        double result = 0;
        switch (type) {
            case "+":
                result = a +b;
                break;
            case "-":
                result = a -b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                result = a / b;
                break;
            case "%":
                result = a %b;
                break;
            default:
                result =  0;
        }

        return result;
    }
}
