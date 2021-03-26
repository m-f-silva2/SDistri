package rmi_picasfijas_cristianbravo_manuelsilva;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * RMI calculadora. Cristian Bravo - Manuel Silva
 */
public interface IPicasFijas extends Remote {
    int suma(int num1, int num2) throws RemoteException;
}
