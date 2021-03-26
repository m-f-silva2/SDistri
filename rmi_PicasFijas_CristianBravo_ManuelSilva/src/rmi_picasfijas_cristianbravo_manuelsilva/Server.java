package rmi_picasfijas_cristianbravo_manuelsilva;

import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * RMI picas y fijas. Cristian Bravo - Manuel Silva
 */
public class Server {

    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
         Remote stub = UnicastRemoteObject.exportObject(new IPicasFijas() {

             @Override
             public int suma(int num1, int num2) throws RemoteException {
                 return (num1+num2);
             }
             
        }, 0);
        System.out.println("Servidor iniciado...");
        Registry registry = LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
        registry.bind("RMI-PicasFijas", stub);
    }   
}