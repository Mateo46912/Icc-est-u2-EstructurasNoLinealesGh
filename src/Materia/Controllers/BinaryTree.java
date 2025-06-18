package Materia.Controllers;

import Materia.Models.Nodo;

public class BinaryTree {

    private Nodo root;

    public BinaryTree() {
        this.root = null;
    }

    public void insert(int value) {

        root = insertRec(root, value);

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

    public void printPreorder() {
        printPreorderRec(root);
    }

    public void printPosOrder() {
        printPosOrderRec(root);
    }

    public void printInOrder() {
        printInOrderRec(root);
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
}
