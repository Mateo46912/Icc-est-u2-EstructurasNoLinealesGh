package Materia.Models;

public class Nodo {
    private int value;
    private Nodo refIzquierda;
    private Nodo refDerecha;

    public Nodo(int value) {
        this.value = value;
        this.refIzquierda = null;
        this.refDerecha = null;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int nodo) {
        value = nodo;
    }

    public Nodo getRefIzquierda() {
        return refIzquierda;
    }

    public void setRefIzquierda(Nodo refIzquierda) {
        this.refIzquierda = refIzquierda;
    }

    public Nodo getRefDerecha() {
        return refDerecha;
    }

    public void setRefDerecha(Nodo refDerecha) {
        this.refDerecha = refDerecha;
    }

    @Override
    public String toString() {
        return "Nodo [value=" + value + "]";
    }

    

}
