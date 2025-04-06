/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package parcial2_estructurasdedatos;

/**
 *
 * @author subke
 */
public class Parcial2_EstructurasDeDatos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        LinkedList1 numeros = new LinkedList1();
         
        
        /*for (int i = 0; i < 20; i++) {
            // Metodo add
             numeros.add(i*3);
        }*/
        
        numeros.add(30);
        numeros.add(40);
        numeros.add(32);
        numeros.add(78);
        numeros.add(61);
        numeros.add(0);
        numeros.add(10);
        
        // Metodo reverse
        numeros.reverse();
        
        // Metodo printValues
        numeros.printValues();
        
        // Funcion contains
        //System.out.println(numeros.contains(60));
        
        // Funcion remove
        numeros.remove(40);
        
        // Metodo addMiddle
        //numeros.addMiddle(17, 4);
        
        // Mostrar la lista actualizada
        //numeros.printValues();
        
        // Metodo addFirst
        numeros.addFirst(500);
        
        // Mostrar la lista actualizada
        numeros.printValues();
    }
    
}
