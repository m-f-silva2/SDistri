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
        ICalculadora calculadora = (ICalculadora) registry.lookup("RMI-Calculadora");
        Scanner teclado = new Scanner(System.in);
        int num1,num2,opera=0;
        
        int  Clave = 0;
        Random rnd = new Random();
        for(int i = 1; i<=4; i++)
            Clave=rnd.nextInt(9)+1;
         System.out.println("*******  Juego de Picas Y Fijas  *******");
        System.out.println("El numero clave ha sido generado "+Clave);
        System.out.println("*******  Calculadora Basica  *******");
        System.out.println("Escriba el primer numero: ");
        num1 = teclado.nextInt();
        System.out.println("Escriba el segundo numero: ");
        num2 = teclado.nextInt();
        
        while(opera != 6){
            System.out.println("\nMenu de operaciones, seleccione una opcion:\n1.Suma  2.Resta  3.Multiplicacion  4.Division  5.Cambiar numeros  0.Salir");
            opera = teclado.nextInt();
            switch(opera){
                case 1:
                    System.out.println(num1+"+"+num2+" = "+calculadora.suma(num1, num2));
                    break;
                case 2:
                    System.out.println(num1+"-"+num2+" = "+calculadora.resta(num1, num2));
                    break;
                case 3:
                    System.out.println(num1+"*"+num2+" = "+calculadora.multiplicacion(num1, num2));
                    break;
                case 4:
                    if(num2>0){
                        System.out.println(num1+"/"+num2+" = "+((float)calculadora.division(num1, num2)));
                    }else{
                        System.out.println("No es posible dividir entre cero, seleccione la opcion: 5.cambiar numero");
                    }
                    break;
                case 5:
                    System.out.println("Escriba el primer numero: ");
                    num1 = teclado.nextInt();
                    System.out.println("Escriba el segundo numero: ");
                    num2 = teclado.nextInt();
                    break;
                default:
                    opera = 6;
                    System.out.println("Fin de ejecucion.");
                    break;
            }
        }
    }
}
