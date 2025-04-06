/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcial2_estructurasdedatos;

/**
 * @author subke
 */
public class Node {
    
    // Amacenamiento 
    private int data;
    
    // Apuntador
    private Node next;
    
    public Node(int data){
        this.data = data;
        this.next = null;
        
       
    }

    
    /*ode(int data) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }*/

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    
    
    
}
