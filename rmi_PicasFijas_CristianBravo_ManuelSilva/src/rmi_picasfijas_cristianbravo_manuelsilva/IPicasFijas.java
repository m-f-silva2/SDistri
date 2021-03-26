package rmi_picasfijas_cristianbravo_manuelsilva;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * RMI calculadora. Cristian Bravo - Manuel Silva
 */
public interface IPicasFijas extends Remote {
   
    String respuesta(int num ) throws RemoteException;
}
