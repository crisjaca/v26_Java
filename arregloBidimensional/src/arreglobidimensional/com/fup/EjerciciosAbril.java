/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arreglobidimensional.com.fup;

import javax.swing.JOptionPane;

/**
 *
 * @author 1002964060
 */
public class EjerciciosAbril {
    
    private int matriz [][] = new int[2][2];

    public void Ejercicio1(){
        
        //INSERTAR DATOS EN LA MATRIZ
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                matriz[i][j] = Integer.parseInt(JOptionPane.showInputDialog("Digite un valor para o posición ["+i+"] ["+j+"]: "));
            }
        }
        
        
        // RECORRER LA MATRIZ
        String txt = "Matriz: ";
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                System.out.println(txt+"\n"+"Columna ["+i+"]"+"["+j+"]"+matriz[i][j]+"\n");
            }
        }
        
        
        //BUSCA
        boolean encontrado = false;
        int buscar_numero = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el numero a buscar: "));
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                if (matriz[i][j] == buscar_numero) {
                    JOptionPane.showMessageDialog(null,"Resultado:\nEl número buscado sí se encontró en la posición: " + i + ", " + j + "\n","Resultado",JOptionPane.PLAIN_MESSAGE);
                    encontrado =true;
                    int nuevo_numero = Integer.parseInt(JOptionPane.showInputDialog("Ingresa un nuevo valor para remplazar en la posicion: [" + i + "], [" + j + "] :"));
                    matriz[i][j] = nuevo_numero;
                }
            }
        }
        
        if (!encontrado) {
            JOptionPane.showMessageDialog(null,"El numero "+buscar_numero+"no existe en la matriz");
        }
        // segundo recorrido ala matriz
        String txt2 = "Matriz: ";
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                System.out.println(txt+"\n"+"Columna ["+i+"]"+"["+j+"]"+matriz[i][j]+"\n");
            }
        }
        

    }
}
