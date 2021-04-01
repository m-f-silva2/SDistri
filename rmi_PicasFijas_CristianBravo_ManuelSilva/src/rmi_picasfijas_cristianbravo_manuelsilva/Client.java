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
        DataInputStream in = null;  //flujo de entrada
        Registry registry = LocateRegistry.getRegistry();
        IPicasFijas dato = (IPicasFijas) registry.lookup("RMI-PicasFijas");  
        
        Scanner teclado = new Scanner(System.in);   //Entrada de datos
        int num = 0;    //numero jugado
        boolean validNum; //validar digitos numero jugado
        int[] claveNum = new int[4];  //numero secreto
        int[] picasFijas = new int[2];  //cantidad de picas y fijas
        claveNum = dato.generarNumero();  //generar numero secreto
        
        System.out.println("*******  Juego de Picas Y Fijas  *******");
        for(int i=1; i<=3; i++){
            System.out.println("___________  Intento "+i+" de 3  ___________________");
            //Ingresar numero jugado
            System.out.println("Ingrese un numero de 4 cifras sin repetir digitos:");
            num = teclado.nextInt();
            
            //Validar numero digitado
            validNum = dato.validarNumero(num);
            
            //Si el numero digitado es correcto
            if(validNum){
                //Cantidad de picas y fijas
                picasFijas = dato.respuesta(num, claveNum);
            }else{
                System.out.println("Numero no valido");
            }
            
            //Validar si el numero jugado es igual al numero secreto
            if(picasFijas[1] == 4){
                System.out.println("¡Felicitaciones ganó!");
                i = 3;//finalizar juego
            }else{
                System.out.println("Picas: "+picasFijas[0]+" Fijas: "+picasFijas[1]);
            }
        }
        //Imprimir numero clave o secreto
        System.out.print("El numero clave o secreto es: ");
        for (int i = 0; i < 4; i++) {
            System.out.print(claveNum[i]);
        }
        System.out.println("\n\nFin del juego.");

    }
}