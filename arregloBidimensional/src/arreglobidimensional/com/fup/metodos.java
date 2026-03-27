/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arreglobidimensional.com.fup;

import java.util.Scanner;

/**
 *
 * @author 1002964060
 */
public class metodos {
    
    
    public static void MatrizA(){
    Scanner sc = new Scanner(System.in);
        int[][] matrizA = new int[2][2];
        int[][] matrizB = new int[2][2];
        int[][] matrizC = new int[2][2];

        
        System.out.println("Ingrese Matriz A");
        
        for (int i = 0; i < matrizA.length ; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.println("Ingresa el valor de la fila "+i+" clumna "+j);
                matrizA[i][j] = sc.nextInt();
            }
        }
        
        System.out.println("Ingrese Matriz B");
        
        for (int i = 0; i < matrizB.length ; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.println("Ingresa el valor de la fila "+i+" clumna "+j);
                matrizB[i][j] = sc.nextInt();
            }
        }
        
//        System.out.println("Ingrese Matriz C");
//        
//        for (int i = 0; i < matrizA.length ; i++) {
//            for (int j = 0; j < 2; j++) {
//                System.out.println("Ingresa el valor de la fila "+i+" clumna "+j);
//                matrizC[i][j] = sc.nextInt();
//            }
//        }
//        
        //  OPERAMOS SUMA
        
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                matrizC[i][j] = matrizA[i][j] + matrizB[i][j];
            }
        }
        System.out.println("=============\nResultado:\n");
        for (int i = 0; i < matrizA.length ; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.println(matrizC[i][j]);
                
            }
        }
    }
    
    public static void Notas(){
        Scanner sc =new Scanner(System.in);
        double[][] notas = new double[3][4];
        
        for (int i = 0; i < 3; i++) {
            System.out.println("Estudiante "+(i+1));
            for (int j = 0; j < 3; j++) {
                System.out.println("Nota"+(j+1)+": ");
                notas[i][j] = sc.nextDouble();
                
            }
        }
        System.out.println("Tabla");
        for (int j = 0; j < notas.length; j++) {
            double suma = 0;
            for (int i = 0; i < 3; i++) {
                suma+=notas[j][i];
            }
            double promedio = suma /3;
            notas[j][3] = promedio;
        }
        
        
        
    }
}
