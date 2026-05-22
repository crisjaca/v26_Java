/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package v26.listas_enlazadas;

/**
 *
 * @author 1002964060
 */
public class V26Listas_Enlazadas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Lista_Simple lista = new Lista_Simple();
        lista.insertar_Inicio(30);
        lista.insertar_Inicio(20);
        lista.insertar_Inicio(10);
        
        lista.mostrar();
    }
//   Clase estatica dentro de listas enlazadas
    static class Nodo {
        int dato;               // EL valor que guarda este nodo
        Nodo siguiente;   // Referencia al siguinete nodo de la cadena
        
        public Nodo(int dato){
            this.dato = dato;
            this.siguiente = null;      //Inicialmente no apunta a nadie
        }
    }
    
    //clase metodos
    
    static class Lista_Simple{
        Nodo cabeza;
        
        void insertar_Inicio(int d){
            Nodo nuevo = new Nodo(d);           // Instanciando la clase nodo
            nuevo.siguiente = cabeza;               // Al nodo nuevo an siguiente asignamos el nodo cabeza
            cabeza = nuevo;                             // Al nodo cabeza le estamos asignando el nodo nuevo
        }
        
        void mostrar(){
            Nodo aux = cabeza;
            
            while( aux != null){
                System.out.println(aux.dato + "-->");
                aux = aux.siguiente;
            }
            System.out.println("null");
        }
        
    }
    
    
}
