public class Node {
    State state;
    Node parent;
    int depth;
    int cost;

    Node(State state, Node parent, int depth, int cost) {
        this.state = state;
        this.parent = parent;
        this.depth = depth;
        this.cost = cost;
    }
}
