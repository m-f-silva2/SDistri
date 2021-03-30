package rmi_picasfijas_cristianbravo_manuelsilva;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * RMI calculadora. Cristian Bravo - Manuel Silva
 */
public interface IPicasFijas extends Remote {
   
    int[] generarNumero() throws RemoteException;
    boolean validarNumero(int num) throws RemoteException;
    int[] respuesta(int num , int[] clave) throws RemoteException;
}
