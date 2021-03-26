package rmi_picasfijas_cristianbravo_manuelsilva;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * RMI calculadora. Cristian Bravo - Manuel Silva
 */
public interface ICalculadora extends Remote {
    int suma(int num1, int num2) throws RemoteException;
    int resta(int num1, int num2) throws RemoteException;
    int multiplicacion(int num1, int num2) throws RemoteException;
    float division(int num1, int num2) throws RemoteException;
}
