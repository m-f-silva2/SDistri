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
        int numrecib;
        Remote stub = UnicastRemoteObject.exportObject(new IPicasFijas() {
           

            @Override
            public String respuesta(int num) throws RemoteException {
               
                
                int contPicas=0,contFijas=0;
                int numAux=0,cont=4;
                int[] claveNum = new int[5];
                int numguardado=num;
                Random rnd = new Random();
                
                
                for (int i = 1; i <= 4; i++) {
                    claveNum[i] = rnd.nextInt(9) + 1;
                    System.out.print(claveNum[i]);
                }
                
                //Calcular suma de multiplicaciones
                int[] numJug = new int[5];
                while (cont != 0){
                    //Obtener ultimo valor
                    numAux = num % 10;
                    num = num/10;
                    numJug[cont] = numAux;
                    cont--;
                } 
                
                
                for (int i=1; i<claveNum.length; i++){
                    for (int j=1; j<numJug.length; j++){
                         if (claveNum[i]==numJug[j]){
                             //Picas: Solo el valor coincide
                             contPicas++;
                         }
                         if(claveNum[i]==numJug[j] && i == j){
                             //Fijas: mismo valor y misma posicion
                             contFijas++;
                         }
                    }
                }
                
                String var=" Numero clave: ";
                
                  for (int i = 1; i <= 4; i++) {
                    var+=""+claveNum[i];
                }
                  var+=" Numero Jugado: "+numguardado+""+" Fijas: "+contFijas+" Picas: "+contPicas;
                
                
                  return var;
                
            }

        }, 0);
        System.out.println("Servidor iniciado...");
        Registry registry = LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
        registry.bind("RMI-PicasFijas", stub);
    }
}
