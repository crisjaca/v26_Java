/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fup.java.vectores;

import javax.swing.JOptionPane;

/**
 *
 * @author 1002964060
 */
public class funciones {
    public static void numBuscar(){
        
    int[] vect = {5,8,12,20};
    int cont= 4;
    int buscar = Integer.parseInt(JOptionPane.showInputDialog("Digita el numero a encontrar"));
    boolean quest = false;
    
        for (int i = 0; i < cont; i++) {
            if (vect[i] == buscar) {
                JOptionPane.showMessageDialog(null, "El numero buscado estaba en la posicion: "+i);
                quest= true;
                break;
            }else if(!quest){
                JOptionPane.showMessageDialog(null,"No encontrado");
            }
        }
    }
    
    public static void insertNum(){
        //int tam = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el tamaño del vector: "));
        int[] vect = new int[5];
        int cont=0;
        do {
            try{
                if (cont <= vect.length){
                vect[cont] = Integer.parseInt(JOptionPane.showInputDialog("Digita el "+(cont+1)+" valor"));
                cont++;
                }
                if(cont==vect.length){
                JOptionPane.showMessageDialog(null, "El vector se encuentra lleno");
                }
            }catch(ArithmeticException e){
                JOptionPane.showMessageDialog(null, "Error: Valor erroneo");
            }
        } while (cont < vect.length);
    }
    
    public static void positivoNum(){
        //int tam = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el tamaño del vector: "));
        int[] vect = new int[5];
        int cont=0;
        do {
            try{
                if (cont <= vect.length){
                vect[cont] = Integer.parseInt(JOptionPane.showInputDialog("Digita el "+(cont+1)+" valor"));
                    if(vect[cont] >= 0 ){
                        cont++;
                    }else{
                        JOptionPane.showMessageDialog(null, "Error: No se permite un numero menor a cero");
                    }
                }
                if(cont==vect.length){
                JOptionPane.showMessageDialog(null, "El vector se encuentra lleno");
                }
            }catch(ArithmeticException e){
                JOptionPane.showMessageDialog(null, "Error: Valor erroneo");
            }
        } while (cont < vect.length);
    }
    
    
    
    public static void duplicados(){
        int[] vect = new int[5];
        int cont=0, buscar=0;
        do {
            try{
                boolean validar = false;

                if (cont <= vect.length){
                    int num = Integer.parseInt(JOptionPane.showInputDialog("Digita el "+(cont+1)+" valor"));
                    if(num >= 0 ){
                        for (int i = 0; i < vect.length; i++) {
                            System.out.println("buscador-- "+cont+" "+num);
                            if (num== vect[i]){
                                validar=true;
                                break;
                            }
                        }
                        if(validar){
                            JOptionPane.showMessageDialog(null, "El numero "+num+" ya esta en el arreglo");
                        }else{
                            vect[cont]=num;
                            cont++;
                        }
                        
                    }else{
                        JOptionPane.showMessageDialog(null, "Error: No se permite un numero menor a cero");
                    }
                }
                if(cont==vect.length){
                JOptionPane.showMessageDialog(null, "El vector se encuentra lleno");
                }
            }catch(ArithmeticException e){
                JOptionPane.showMessageDialog(null, "Error: Valor erroneo");
            }
        } while (cont < vect.length);
        
    
    }
    
    public static void listarVec(){
        int[] num = new int[5];
        int cont= 0;
        String lista = "";
        while(cont < 5){
            num[cont]= Integer.parseInt(JOptionPane.showInputDialog("Ingresa el "+(cont+1)+" valor: "));
            lista = lista +num[cont]+", ";
            cont++;
        }
        JOptionPane.showMessageDialog(null,"Los valores del vector son: "+ lista);
    }
    
    public static void listarPar(){
        int[] num = new int[8];
        int cont= 0;
        String lista = "";
        while(cont < num.length){
            num[cont]= Integer.parseInt(JOptionPane.showInputDialog("Ingresa el "+(cont+1)+" valor: "));
            if(num[cont]%2==0){
                            lista = lista +num[cont]+", ";
            }
            cont++;
        }
        JOptionPane.showMessageDialog(null,"Los numeros pares del vector son: "+ lista);
    }
    
    public static void posicion(){
      int[] num = new int[6];  
        String lista = " ";
        for (int i = 0; i < num.length; i++) {
            num[i]= Integer.parseInt(JOptionPane.showInputDialog("Ingresa el "+(i+1)+" valor: "));
            lista = lista+"Posicion --> "+i+" : "+num[i]+". \n";
        }
        
        JOptionPane.showMessageDialog(null,"Lista de Valores: \n"+ lista);
    }
    
    public static void actualizar(){
        int[] vector ={10,20,30,40,50};
        int tamaño = 4;
        
        int pos = Integer.parseInt(JOptionPane.showInputDialog("Posición Actualizar"));
        
        if (pos >= 0 && pos < tamaño) {
            vector[pos] = Integer.parseInt("Nuevo valor: ");
            
        }
        
        for (int i = 0; i < tamaño; i++) {
            System.out.println(vector[i]);
        }
        
    }
    
    public static void eliminar() {
        int[] vector = {10, 30, 30, 20};
        int tamaño = 4;

        int eliminar = 20;

        for (int i = 0; i < tamaño; i++) {
            if (vector[i] == eliminar) {

                for (int j = i; j < tamaño+1; j++) {
                    vector[j] = vector[j + 1];
                    System.out.println("jjj"+i);

                }
                System.out.println("no pasa");
                tamaño--;
                break;
            }
        }

        for (int i = 0; i < tamaño; i++) {
            System.out.println(vector[i]);
        }
    }
}
