package org.escuelaIng;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        bst.insert(90);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(80);

        System.out.println("In-order traversal:");
        bst.inOrderTraversal();
        System.out.println();

        System.out.println("Buscar 80: " + bst.search(80));
        System.out.println("Buscar 50: " + bst.search(50));

        System.out.println("Pre-order traversal:");
        bst.preOrderTraversal();
        System.out.println();


        System.out.println("Post-order traversal:");
        bst.postOrderTraversal();
        System.out.println();

        System.out.println("Valor mínimo: " + bst.findMin());
        System.out.println("Valor máximo: " + bst.findMax());

        System.out.println("Eliminar el nodo 30:");
        bst.delete(30);
        System.out.println("In-order traversal después de eliminar 30:");
        bst.inOrderTraversal();
        System.out.println();


        System.out.println("Altura del árbol: " + bst.height());


        System.out.println("¿El árbol está balanceado?: " + bst.isBalanced());


        System.out.println("Recorrido por niveles (Level-order):");
        bst.levelOrderTraversal();
        System.out.println();


        System.out.println("Número de nodos en el árbol: " + bst.countNodes());

        bst.clear();
        System.out.println("Árbol después de limpiarlo:");
        System.out.println("Número de nodos en el árbol: " + bst.countNodes());
        bst.inOrderTraversal();
    }
}
