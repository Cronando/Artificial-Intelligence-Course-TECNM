public class Node {
    State state;
    Node parent;

    Node(State state, Node parent) {
        this.state = state;
        this.parent = parent;
    }
}
