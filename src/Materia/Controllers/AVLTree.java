package Materia.Controllers;



import Materia.Models.Nodo;

public class AVLTree {
    private Nodo root;

    public AVLTree() {
        this.root = null;

    }

    public void insert(int value) {
        root = insertRec(root, value);
    }

private Nodo insertRec(Nodo node, int Value){
        if(node == null){
            Nodo newNode = new Nodo(Value);
            newNode. setHeight(1);
            System.out.println("Nodo insertado -> "+ Value + " con balance " + getBalance(newNode));
            return newNode;
        }
        if (Value <= node.getValue()) {
            //Me voy a la izquierda
            Nodo newNode = insertRec(node.getRefIzquierda(), Value);
            node.setRefIzquierda(newNode);
        } else if (Value > node.getValue()) {
            node.setRefDerecha(insertRec(node.getRefDerecha(), Value));
        }else{
            return node;
        }

        System.out.println("Nodo actual -> " + node.getValue());
        int altura =Math.max(height(node.getRefIzquierda()), height(node.getRefDerecha())) + 1;
        node. setHeight(altura);
        System.out.println("\tAltura -> "+ altura);

        //Obetener el balance del nodo
        
        int balance = getBalance(node);
        System.out.println("\tBalance -> "+ balance);
        //Caso Izquierda - Izquierda
// Izquierda - Izquierda
        if (balance > 1 && node.getRefIzquierda() != null && Value < node.getRefIzquierda().getValue()) {
            System.out.println("Rotacion simple a la Derecha");
            return rightRotation(node);
        }

        // Derecha - Derecha
        if (balance < -1 && node.getRefDerecha() != null && Value > node.getRefDerecha().getValue()) {
            System.out.println("Rotacion simple a la Izquierda");
            return leftRotation(node);
        }

        // Izquierda - Derecha
        if (balance > 1 && node.getRefIzquierda() != null && Value > node.getRefIzquierda().getValue()) {
            System.out.println("Cambio (Izquierda-Derecha)");
            node.setRefIzquierda(leftRotation(node.getRefIzquierda()));
            return rightRotation(node);
        }

        // Derecha - Izquierda
        if (balance < -1 && node.getRefDerecha() != null && Value < node.getRefDerecha().getValue()) {
            System.out.println("Cambio (Derecha-Izquierda)");
            node.setRefDerecha(rightRotation(node.getRefDerecha()));
            return leftRotation(node);
        }
        return node;
    }

    public int height(Nodo nodo) {
        if (nodo == null) {
            return 0;
        }
        return nodo.getHeight();
    }

    public int getBalance(Nodo nodo) {
        if (nodo == null) {
            return 0;
        }
        return height(nodo.getRefIzquierda()) - height(nodo.getRefDerecha());
    }

    private Nodo leftRotation(Nodo x) {
        Nodo y = x.getRefDerecha();
        Nodo temp = y.getRefIzquierda();

        // Imprimir informacion antes de la rotacion
        System.out.println("Rotacion IZQ en nodo: " + x.getValue()
                + ", con balance = " + getBalance(x));

        // Realizar la rotacion
        y.setRefIzquierda(x);
        x.setRefDerecha(temp);

        // Actualizar alturas
        x.setHeight(Math.max(height(x.getRefIzquierda()), height(x.getRefDerecha())));
        y.setHeight(Math.max(height(y.getRefIzquierda()), height(y.getRefDerecha())));

        // Imprimir informacion despues de la rotacion

        System.out.println("Nueva raiz despues de la rotacion " + y.getValue());

        // Devolver la nueva raiz
        return y;
    }

    private Nodo rightRotation(Nodo y) {
        Nodo x = y.getRefIzquierda();
        Nodo temp = x.getRefDerecha();

        // Imprimir antes de la rotación
        System.out.println("Rotación DER en nodo: " + y.getValue() + ", con balance = " + getBalance(y));

        // Realizar rotación
        x.setRefDerecha(y);
        y.setRefIzquierda(temp);

        // Actualizar alturas
        y.setHeight(Math.max(height(y.getRefIzquierda()), height(y.getRefDerecha())) + 1);
        x.setHeight(Math.max(height(x.getRefIzquierda()), height(x.getRefDerecha())) + 1);

        // Imprimir información después de la rotación
        System.out.println("Nueva raíz después de la rotación: " + x.getValue());
        System.out.println("Rotacion simple izquierda");

        return x;

    }

}
