import Materia.Controllers.BinaryTree;

public class App {
    public static void main(String[] args) throws Exception {
        BinaryTree ab = new BinaryTree();
        ab.insert(50);
        ab.insert(17);
        ab.insert(76);
        ab.insert(9);
        ab.insert(23);
        ab.insert(54);
        ab.insert(14);
        ab.insert(19);
        System.out.println("--Pre-Order--");
        ab.printPreorder();
        System.out.println();
        System.out.println("--Pos-Order--");
        ab.printPosOrder();
        System.out.println();
        System.out.println("--In-Order--");
        ab.printInOrder();
        System.out.println();

    }
}
