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
            public int[] generarNumero() throws RemoteException {
                int[] claveNum = new int[4];
                Random rnd = new Random();
                
                //Generar numero random
                for (int i = 0; i < 4; i++) {
                    claveNum[i] = rnd.nextInt(9) + 1;
                }
                
                //Validar digitos repetidos
                for (int c=0; c<claveNum.length; c++){
                    for (int j=0; j<claveNum.length; j++){
                        if (claveNum[c]==claveNum[j] && c!=j){
                            //validar digitos de 1 a 9, si es 9 se inicia a 1.
                            claveNum[j] = (claveNum[j]==9)?claveNum[j]=1:claveNum[j]+1;
                            c = j = 0;//Se reinicia la validacion
                        }
                    }
                }
                return claveNum;  //retornar numero sin digitos repetidos
            }
            @Override
            public boolean validarNumero(int num) throws RemoteException {
                boolean valid = true;
                int[] numJug = new int[4];
                int numAux=0;
                
                //Guardar numero jugado en array
                for (int c = 0; c<4;c++){
                    numAux = num % 10;
                    num = num/10;
                    numJug[c] = numAux;                 
                }
                
                //Validar longitud del numero
                if(4 == numJug.length){
                    //validar digitos repetidos
                    for (int c=0; c<numJug.length; c++){
                        for (int j=0; j<numJug.length; j++){
                            if (numJug[c]==numJug[j] && c!=j){
                                c = j = numJug.length;//finalizar ciclo for
                                valid = false;//numero no es valido.
                            }
                        }
                    }
                }
                return valid;//retorna true: numero valido, false: numero no valido.
            }
            @Override
            public int[] respuesta(int num, int[] claveNum) throws RemoteException {
                int contPicas=0,contFijas=0;
                int[] numJug = new int[4];
                int[] picasFijas = new int[2];
                int numAux=0;
                
                //Guardar digitos en array
                for (int c = 3; c > -1;c--){
                    numAux = num % 10;
                    num = num/10;
                    numJug[c] = numAux;                 
                }
                
                //validar cada digito del numero clave con el de numero jugado
                for (int i=0; i < claveNum.length; i++){
                    for (int j=0; j < numJug.length; j++){
                         if (claveNum[i] == numJug[j] && i == j){
                             //Fijas: mismo valor y misma posicion
                             contFijas++;
                         }
                         if(claveNum[i] == numJug[j] && i != j){
                             //Picas: Solo el valor coincide
                             contPicas++;
                         }
                    }
                }
                //Guardar valores de picas y fijas
                picasFijas[0]=contPicas;
                picasFijas[1]=contFijas;
                return picasFijas;  //retornar picas y fijas
            }
        }, 0);
        System.out.println("Servidor iniciado...");
        Registry registry = LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
        registry.bind("RMI-PicasFijas", stub);
    }
}