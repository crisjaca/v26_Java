/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package v26.busquedabinaria.com.fup;

/**
 *
 * @author 1002964060
 */
public class MainBusqueda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int[] lista_num = {10,20,30,40,50};
        
        int resultado = busqueda_binaria(lista_num,30);
        System.out.println("El resultado es: "+resultado);
    }
    
    public static int busqueda_binaria(int[] numeros, int objetivo){
        int izquierda = 0;
        int derecha = numeros.length - 1;
        
        while(izquierda<=derecha){
            // Halla la posicion y mitad del vector
            int medio = (izquierda+derecha)/2;
            // compara si el numero en la posicion medio es igual al objetivo
            if (numeros[medio]==objetivo) {
                return medio;
            }else if(numeros[medio]<objetivo){
//                buscar a la izquierda
                izquierda = medio +1;
            }else{
//                buscar a la derecha
                derecha = medio-1;
            }
        }
        return -1;//no encontrado
    }
    
}
