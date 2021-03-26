package rmi_picasfijas_cristianbravo_manuelsilva;

import java.io.DataInputStream;
import java.io.DataOutputStream;
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
        DataOutputStream out = null;  //flujo de salida
        DataInputStream in = null;
        Registry registry = LocateRegistry.getRegistry();
        IPicasFijas dato = (IPicasFijas) registry.lookup("RMI-PicasFijas");  
        
        Scanner teclado = new Scanner(System.in);
        int num = 0;
        
        //Ingresar valor
        System.out.println("Ingrese el Numero de 4 cifras:");
        num = teclado.nextInt();
        //Enviar valor ingresado
        System.out.println(""+dato.respuesta(num));
        //Imprimir resultados
      
        System.out.println("*******  Juego de Picas Y Fijas  *******");
        System.out.println("El numero clave ha sido generado ");

    }
}
