import java.util.Scanner;

public class Main {
    private static BST bst = new BST();
    private static int[] nodes = {50, 30, 20 , 40, 70, 60, 80};
    private static int key = 60;
    public static void main(String[] args) {
        System.out.println("|| --- Binary Search Tree --- ||");

        System.out.println("\nInserting Nodes...");

        //  Inserting nodes
        for(int i = 0; i < nodes.length; i++){
            if(i == 0){
                bst.root = bst.insert(bst.root, nodes[i]);
                System.out.println("Root Node Added: " + nodes[i]);
            }
            else{
                bst.insert(bst.root, nodes[i]);
                System.out.println("Node Added: " + nodes[i]);
            }
        }

        //  Print added nodes...
        System.out.print("\nAdded nodes: ");
        bst.inOrder(bst.root);
        System.out.println();

        //  Searching an existing key
        System.out.println("\nKey to search: " + key);
        System.out.println("Searching Key...");
        if(bst.search(bst.root, key) == null)
            System.out.println("Key: " + key + " not found");
        else
            System.out.println("Key: " + key + " found.");

        //  Searching a non-existing key
        key = 10;
        System.out.println("\nKey to search: " + key);
        System.out.println("Searching Key...");
        if(bst.search(bst.root, key) == null)
            System.out.println("Key: " + key + " not found");
        else
            System.out.println("Key: " + key + " found.");
    }
}