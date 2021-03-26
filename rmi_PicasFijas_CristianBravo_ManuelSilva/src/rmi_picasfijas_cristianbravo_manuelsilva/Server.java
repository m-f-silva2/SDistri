package rmi_picasfijas_cristianbravo_manuelsilva;

import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Random;

/**
 * RMI picas y fijas. Cristian Bravo - Manuel Silva
 */
public class Server {

    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        Remote stub = UnicastRemoteObject.exportObject(new IPicasFijas() {

            @Override
            public int suma(int num1) throws RemoteException {

                int[] Clave = new int[5];
                Random rnd = new Random();
                for (int i = 1; i <= 4; i++) {
                    Clave[i] = rnd.nextInt(9) + 1;
                    System.out.print(Clave[i]);}
                
                 
                return (num1);

            }

        }, 0);
        System.out.println("Servidor iniciado...");
        Registry registry = LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
        registry.bind("RMI-PicasFijas", stub);
    }
}
