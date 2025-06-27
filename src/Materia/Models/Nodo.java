package Materia.Models;

public class Nodo {
    private int value;
    private Nodo refIzquierda;
    private Nodo refDerecha;
    private int height;

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
    
    public int getHeight() {
        return height;
    }
    
    public void setHeight(int height) {
        this.height = height;
    }
    
    @Override
    public String toString() {
        return "Nodo [value=" + value + "]";
    }

    

}
