package rmi_picasfijas_cristianbravo_manuelsilva;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Random;
import java.util.Scanner;

/**
 * RMI calculadora. Cristian Bravo - Manuel Silva
 */
public class Client {
    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry();
        IPicasFijas calculadora = (IPicasFijas) registry.lookup("RMI-PicasFijas");
        Scanner teclado = new Scanner(System.in);
        int num1,num2,opera=0;
        
        int  Clave = 0;
        Random rnd = new Random();
        for(int i = 1; i<=4; i++)
            Clave=rnd.nextInt(9)+1;
         System.out.println("*******  Juego de Picas Y Fijas  *******");
        System.out.println("El numero clave ha sido generado "+Clave);
        
        
    }
}
