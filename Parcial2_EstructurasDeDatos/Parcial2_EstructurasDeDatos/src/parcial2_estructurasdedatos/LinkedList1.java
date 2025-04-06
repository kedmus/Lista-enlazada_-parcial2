/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcial2_estructurasdedatos;

/**
 *
 * @author subke
 */
public class LinkedList1 {

    private Node inicio;
    private int size;

    public LinkedList1() {
        this.inicio = null;
        this.size = 0;
    }

    // getter and setters
    public Node getInicio() {
        return inicio;
    }

    public void setInicio(Node inicio) {
        this.inicio = inicio;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    // métodos agregar nuevo nodo al final de la lista
    public void add(int data) {
        Node nuevoNodo = new Node(data);

        if (this.getInicio() == null) {
            this.setInicio(nuevoNodo);
            this.setSize(this.getSize() + 1);
        } else {
            Node nodoActual = this.getInicio();
            while (nodoActual.getNext() != null) {
                //System.out.println("Estoy en el nodo con elemento: " + nodoActual.getElemento());

                // se avanza al siguiente nodo
                nodoActual = nodoActual.getNext();
            }
            // agregar el nuevo elemento al final
            nodoActual.setNext(nuevoNodo);
            this.setSize(this.getSize() + 1);
        }
    }

    // Método para agregar un nuevo nodo al inicio de la lista
    public void addFirst(int data) {
        Node nuevoNodo = new Node(data);

        // apunta al nodo que esta al incio de la lista
        nuevoNodo.setNext(this.getInicio());
        this.setInicio(nuevoNodo); // actualiza 

        // Incrementar el tamaño de la lista
        this.setSize(this.getSize() + 1);
    }

    public void addMiddle(int data, int position) {
        if (position < 0 || position > this.getSize()) {
            System.out.println("Posición inválida. Debe estar entre 0 y " + this.getSize());
            return;
        }

        Node nuevoNodo = new Node(data);

        // en caso de Insertar al inicio (posición 0)
        if (position == 0) {
            this.addFirst(data);
        } else {
            Node nodoActual = this.getInicio();
            int contador = 0;

            // Recorrer la lista hasta encontrar la posición anterior a la deseada
            while (contador < position - 1) {
                nodoActual = nodoActual.getNext();
                contador++;
            }

            // Enlazar el nuevo nodo al siguiente nodo en la lista
            nuevoNodo.setNext(nodoActual.getNext());

            // Enlazar el nodo actual al nuevo nodo
            nodoActual.setNext(nuevoNodo);

            // Incrementar el tamaño de la lista
            this.setSize(this.getSize() + 1);
        }
    }

    public Node remove(int data) { // Permite remover el valor buscado, si este existe
        // en caso la lista esté vacía
        if (this.getSize() == 0) {
            System.out.println("La lista está vacía, no es posible eliminar un elemento.");
        } else {
            // Si solo hay un elemento, se verifica si el elemento coincide
            if (this.getSize() == 1) {
                if (this.getInicio().getData() == data) {
                    // Si el elemento coincide, se almacena el nodo que guarda dicho dato
                    Node nodoSecundario = this.getInicio();
                    
                    // Se establece el inicio como vacio (null)
                    this.setInicio(null);
                    
                    // Se reduce el tamaño de la lista
                    this.setSize(this.getSize() - 1);
                    
                    // Se retorna el nodo encontrado, para posteriores usos
                    return nodoSecundario;
                }
            } else {
                // Si hay más de un elemento, se requiere recorrer la lista desde el inicio
                // para comparar con cada elemento
                Node nodoActual = this.getInicio();
                
                // Si el dato coincide con el primer nodo, se remueve ese nodo de la lista
                if (nodoActual.getData() == data) {
                    // Se guarda el nodo de la coincidencia
                    Node nodoSecundario = nodoActual;
                    
                    // Se establece el nuevo inicio de la lista
                    this.setInicio(nodoActual.getNext());
                    
                    // Se reduce el tamaño de la lista
                    this.setSize(this.getSize() - 1);
                    
                    // Se retorna el nodo encontrado, para otros usos que se le quiera dar
                    return nodoSecundario;
                }
                
                // Si la coincidencia no está en el primer nodo, se recorre para verificar en los
                // demás nodos. Se verifica cada nodo, a partir del nodo previo a él, para facilitar
                // la desconexión de algún nodo que coincida
                while (nodoActual.getNext() != null) {
                    if (nodoActual.getNext().getData() == data) {
                        // Se guarda el nodo de la coincidencia
                        Node nodoSecundario = nodoActual.getNext();
                        
                        // Se actualizan los enlaces, para remover el nodo de la coincidencia
                        nodoActual.setNext(nodoActual.getNext().getNext());
                        
                        // Se reduce el tamaño de la lista
                        this.setSize(this.getSize() - 1);
                        
                        // Se retorna el nodo encontrado, para otros usos que se le quiera dar
                        return nodoSecundario;
                    }
                    // Si no hubo coincidencia, se avanza al siguiente nodo
                    nodoActual = nodoActual.getNext();
                }
            }

        }
        // Si no se encontró coincidencia en toda la lista, se muestra un mensaje y se retorna null
        System.out.println("Valor " + data + " no encontrado");
        return null;
    }

    public Node removeLast() { // Esta función remueve el último nodo de la lista y lo retorna
        if (this.getSize() > 0) { // Si hay elementos, se puede remover algún nodo

            if (this.getSize() == 1) { // Si hay solo un nodo, ese será el nodo a remover
                // Se almacena de forma temporal el nodo inicial
                Node nodoSecundario = this.getInicio();

                // Como se removerá el nodo inicial, ahora el inicio quedará vacío (nulo)
                this.setInicio(null);

                // Al remover un elemento, se reduce la cantidad de elementos en una unidad
                this.setSize(this.getSize() - 1);

                // Se retorna el nodo que se removió de la lista, para que pueda usarse en alguna
                // otra parte de la aplicación si se necesita
                return nodoSecundario;
            }

            // Si hay más de un elemento en la lista, es necesario recorrer los nodos hasta
            // encontrar el último nodo
            // Se inicia el recorrido desde el inicio
            Node nodoActual = this.getInicio();

            // Se usa para ir avanzando de nodo en nodo
            while (nodoActual.getNext() != null) {
                // si el nodo siguiente al nodo siguiente del nodo donde se encuentra actualmente
                // es nulo, significa que el nodo actual es el penúltimo y se detiene el recorrido
                if (nodoActual.getNext().getNext() == null) {
                    break;
                }
                // Si aún quedan nodos por recorrer, se actualiza el nodo actual avanzando al
                // siguiente nodo
                nodoActual = nodoActual.getNext();
            }

            // Se almacena de forma temporal el último nodo
            Node nodoSecundario = nodoActual.getNext();

            // El penúltimo nodo tendrá un null en su siguiente, por lo que a partir de ahora
            // se convertirá en el último nodo de la lista
            nodoActual.setNext(null);

            // Se reduce en una unidad la cantidad de elementos
            this.setSize(this.getSize() - 1);

            // Se retorna el nodo que se removió
            return nodoSecundario;

        }

        // En caso de que no hayan elementos en la lista, se retorna null
        return null;

    }

    public void printValues() {
        Node actual = this.getInicio();

        if (actual == null) {
            System.out.println("La lista se encuentra vacía.");
            return;
        }

        // Recorremos la lista e imprimimos los valores de los nodos
        System.out.print("Valores de la lista: ");
        while (actual != null) {
            System.out.print(actual.getData() + " -> ");
            // Avanzar al siguiente nodo
            actual = actual.getNext();
        }
        System.out.println("final de la lista");
    }

    public void reverse() {

        if (this.getSize() == 0) { // Si no hay elementos, no se puede revertir el orden
            System.out.println("No hay valores para revertir su orden");
        }

        Node nuevoNodo = removeLast();

        // Este contador servirá para almacenar la cantidad de elementos removidos y se usa para
        // definir el tamaño de la lista revertida
        int contador = 1;

        // Mientras queden elementos por remover, se usa el bucle while para remover los últimos nodos
        while (this.getSize() > 0) {
            Node extraido = removeLast(); // Se extrae el último nodo de la lista

            // Se inicia a recorrer la nueva lista revertida, para encontrar el último nodo, para
            // insertar el nodo que se acaba de remover e insertarlo al final de la nueva lista
            Node nodoActual = nuevoNodo;
            while (nodoActual.getNext() != null) {
                nodoActual = nodoActual.getNext();
            }

            // Una vez encontrado el último nodo, se añade el nodo extraido, al final de la nueva lista
            nodoActual.setNext(extraido);

            // Se actualiza el contador de elementos insertados
            contador++;
        }

        // El nodo que se extrajo inicialmente se convierte en el nuevo inicio. Acá ya tiene enlazados
        // todos los demás nodos, en su posición correcta
        this.setInicio(nuevoNodo);

        // Dado que el tamaño de la lista original se redujo a 0, ahora se vuelve a establecer su tamaño
        // original, con el valor almacenado en el contador
        this.setSize(contador);
    }

    public boolean contains(int data) {
        if (this.getSize() == 0) { // Si no hay elementos, no se puede buscar el elemento dado
            System.out.println("No hay valores para realizar una busqueda");
        } else {
            // Si hay elementos, se puede realizar la búsqueda

            // Se inicia la búsqueda con un recorrido desde el inicio
            Node nodoActual = this.getInicio();

            while (nodoActual != null) {
                if (nodoActual.getData() == data) {
                    // Si el dato coincide con el dato del nodo actual, se retorna true
                    return true;
                }
                // Si el dato no coincide con el dato del nodo actual, se avanza al siguiente nodo
                nodoActual = nodoActual.getNext();
            }
        }

        // Si no se encontró el valor dado, se retorna false
        return false;
    }

}
