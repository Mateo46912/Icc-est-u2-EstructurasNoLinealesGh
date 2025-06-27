package Materia.Controllers;

import java.util.List;
import java.util.Stack;


import Materia.Models.Nodo;

public class BinaryTree {

    private Nodo root;
    private int heighArbolM;
    private Stack<Nodo> desequilibrados;

    
    public BinaryTree() {
        this.root = null;
        this.heighArbolM = 0; 
        this.desequilibrados = new Stack<>();
    }

    //METODO PARA INSERTAR EN EL ARBOL
    public void insert(int value) {

        root = insertRec(root, value);
        heighArbolM++;
    }

    private Nodo insertRec(Nodo padre, int value) {
        if (padre == null) {
      
            return new Nodo(value); // Retornar un Nodo con el nuevo valor para la raiz
        }

        if (value < padre.getValue()) {
            Nodo newNodo = insertRec(padre.getRefIzquierda(), value);
            padre.setRefIzquierda(newNodo);

        } else if (value > padre.getValue()) {
            padre.setRefDerecha(insertRec(padre.getRefDerecha(), value)); // Lo mismo

        }
        return padre;
    }

    //METODO PARA RECORRER Y MOSTRAR EL ARBOL
    public void printPreorder() {
        printPreorderRec(root);
    }

    public void printPosOrder() {
        printPosOrderRec(root);
    }

    public void printInOrder() {
        printInOrderRec(root);
    }

    public void printInOrderWhitHeight() {
        printInOrderWithHeightRec(root);
    }

    public void printInorderWithEqu() {
        printInorderWithEquRec(root);
    }

    private void printPreorderRec(Nodo node) {
        if (node != null) {
            System.out.print(node.getValue() + ", ");
            printPreorderRec(node.getRefIzquierda());
            printPreorderRec(node.getRefDerecha());
        }
    }

    private void printPosOrderRec(Nodo node) {
        if (node != null) {
            printPosOrderRec(node.getRefIzquierda());
            printPosOrderRec(node.getRefDerecha());
            System.out.print(node.getValue() + ", ");
        }
    }

    private void printInOrderRec(Nodo node) {
        if (node != null) {
            printInOrderRec(node.getRefIzquierda());
            System.out.print(node.getValue() + ", ");
            printInOrderRec(node.getRefDerecha());
        }
    }

    private void printInOrderWithHeightRec(Nodo node) {
        if (node != null) {
            printInOrderWithHeightRec(node.getRefIzquierda());
            System.out.print(node.getValue() + "(h= " + getHeightTreeRec(node) + "), ");
            printInOrderWithHeightRec(node.getRefDerecha());
        }
    }

    private void printInorderWithEquRec(Nodo node) {
        if (node != null) {
            printInorderWithEquRec(node.getRefIzquierda());
            int balance = getBalanceFactor(node);
            if(balance <-1 | balance>1){
                desequilibrados.push(node);
            }
            System.out.print(node.getValue() + "(bF= " + balance + "), ");
            printInorderWithEquRec(node.getRefDerecha());
        }
    }

    //METODO PARA HALLAR EL BALANCE DEL ARBOL
    public int getBalanceFactor(Nodo node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = getHeightTreeRec(node.getRefIzquierda());
        int rightHeight = getHeightTreeRec(node.getRefDerecha());
        return leftHeight - rightHeight;
    }

    public boolean desequilibradosComp(){ 
       if(desequilibrados.isEmpty()){
        return true;
       }else{
           return false;
       } 
    } 



    public int heighArbol() {
        return heighArbolM;
    }

    public boolean findValue(int value) {
        return findValueRec(root, value);
    }

    public boolean findValueRec(Nodo nodo, int value) {
        if (nodo == null) {
            return false;
        }
        if (nodo.getValue() == value) {
            return true;
        }
        if (value < nodo.getValue()) {
            return findValueRec(nodo.getRefIzquierda(), value);
        } else {
            return findValueRec(nodo.getRefDerecha(), value);
        }
    }

    public int getHeightTree() {
        return getHeightTreeRec(root);
    }

    public int getHeightTreeRec(Nodo nodo) {

        if (nodo == null) {
            return 0;
        }
        int leftHeight = getHeightTreeRec(nodo.getRefIzquierda());
        int rightHeight = getHeightTreeRec(nodo.getRefDerecha());
        return Math.max(leftHeight, rightHeight) + 1;
    }

}
