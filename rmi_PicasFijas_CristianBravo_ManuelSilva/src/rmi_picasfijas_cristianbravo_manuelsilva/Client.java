package rmi_picasfijas_cristianbravo_manuelsilva;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
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
        boolean numero;
        int[] claveNum = new int[4];
        int[] picasFijas = new int[2];
        claveNum = dato.generarNumero();
        
        System.out.println("*******  Juego de Picas Y Fijas  *******");
        for(int i=1; i<=3; i++){
            System.out.println("___________  Intento "+i+" de 3  ___________________");
            //Ingresar valor
            System.out.println("Ingrese un numero de 4 cifras sin repetir digitos:");
            num = teclado.nextInt();
            
            //Validar numero digitado
            numero = dato.validarNumero(num);
            
            //Si el numero validado es correcto
            if(numero){
                //Enviar valor ingresado
                picasFijas = dato.respuesta(num, claveNum);
            }else{
                System.out.println("Numero no valido");
            }
            
            //Validar si el numero es igual al de la clave
            if(picasFijas[1] == 4){
                System.out.println("Felicitaciones ganó.");
                i = 3;
            }else{
                System.out.println("Picas: "+picasFijas[0]+" Fijas: "+picasFijas[1]);
            }
        }
        System.out.print("El numero clave es: ");
        for (int i = 0; i < 4; i++) {
            System.out.print(claveNum[i]);
        }
        System.out.println("\n\nFin del juego.");

    }
}