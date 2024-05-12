import java.util.*;

public class EightPuzzle {
    static void BFS(State initial) {
        Queue<Node> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        Node initialNode = new Node(initial, null);
        queue.add(initialNode);
        visited.add(Arrays.deepToString(initial.board));

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            State currentState = currentNode.state;
            if (currentState.isGoal()) {
                printSolution(currentNode, visited.size());
                return;
            }
            for (State nextState : currentState.getNextStates()) {
                String nextStateStr = Arrays.deepToString(nextState.board);
                if (!visited.contains(nextStateStr)) {
                    visited.add(nextStateStr);
                    Node nextNode = new Node(nextState, currentNode);
                    queue.add(nextNode);
                }
            }
        }
    }

    // Depth First Search
    static void DFS(State initial) {
        Stack<Node> stack = new Stack<>();
        Set<String> visited = new HashSet<>();
        Node initialNode = new Node(initial, null);
        stack.push(initialNode);
        visited.add(Arrays.deepToString(initial.board));

        while (!stack.isEmpty()) {
            Node currentNode = stack.pop();
            State currentState = currentNode.state;
            if (currentState.isGoal()) {
                printSolution(currentNode, visited.size());
                return;
            }
            for (State nextState : currentState.getNextStates()) {
                String nextStateStr = Arrays.deepToString(nextState.board);
                if (!visited.contains(nextStateStr)) {
                    visited.add(nextStateStr);
                    Node nextNode = new Node(nextState, currentNode);
                    stack.push(nextNode);
                }
            }
        }
    }

    static void printSolution(Node node, int visitedNodes) {
        List<State> path = new ArrayList<>();
        int cost = 0;
        int depth = 0;
        while (node != null) {
            path.add(0, node.state);
            node = node.parent;
        }
        for (State state : path) {
            state.printState();
        }
        System.out.println("Visited Nodes: " + visitedNodes);
    }

}
