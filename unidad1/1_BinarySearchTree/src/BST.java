public class BST {
    //  Binary Search Tree
    Node root;

    // Constructor
    BST(){
        root = null;
    }

    //  An utility function to insert a new node with a given key in a BST
    Node insert(Node node, int key){
        if(node == null){
            node = new Node(key);
            return node;
        }
        if(key < node.key)
            node.left = insert(node.left, key);
        else
            node.right = insert(node.right, key);

        return node;
    }

    //  An utility function to search a given key in a BST
    Node search(Node root, int key){
        if(root == null || root.key == key)
            return root;

        if(root.key < key)
            return search(root.right, key);

        return search(root.left, key);
    }
    public void inOrder(Node root) {
        if (root != null) {
            // Visit left child
            inOrder(root.left);
            // Print current node
            System.out.print(root.key + " ");
            // Visit right child
            inOrder(root.right);
        }
    }
}
